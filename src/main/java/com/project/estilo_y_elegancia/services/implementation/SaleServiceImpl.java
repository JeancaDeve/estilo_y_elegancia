package com.project.estilo_y_elegancia.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.models.MdCustomer;
import com.project.estilo_y_elegancia.models.MdSale;
import com.project.estilo_y_elegancia.repositories.BaseRepository;
import com.project.estilo_y_elegancia.repositories.SaleRepository;
import com.project.estilo_y_elegancia.services.business.SaleServiceBs;

import jakarta.transaction.Transactional;

@Service
public class SaleServiceImpl extends BaseServiceImpl<MdSale, Long> implements SaleServiceBs {

  @Autowired
  protected SaleRepository _SaleRepository;

  public SaleServiceImpl(BaseRepository<Long, MdSale> repository) {
    super(repository);
  }

  private boolean CustomerExists(MdCustomer customer) {
    return _SaleRepository.CustomerExists(customer).isPresent();
  }

  @Override
  @Transactional
  public MdSale generateSale(MdSale sale) throws Exception {

    MdCustomer customer = sale.getCustomer();

    // Si el cliente no existe se asegura que no se cree un cliente con el mismo
    // numero
    if (!CustomerExists(customer))
      CustomerExistsByPhoneNumber(customer.getPhoneNumber());

    List<MdClothes> listClothes = sale.getClothes();

    MdCustomer customerSale = CustomerExists(customer) ? _SaleRepository.CustomerExists(customer).get() : customer;

    sale.setClothes(getClothesByIdForSale(listClothes));
    sale.setTotal(getTotalAmountSale(listClothes));
    sale.setCant(listClothes.size());
    sale.setCustomer(customerSale);
    reduceStock(sale.getClothes());
    return _SaleRepository.save(sale);

  }

  private double getTotalAmountSale(List<MdClothes> clothes) {

    List<MdClothes> clothesList = new ArrayList<>();

    List<Long> idList = clothes.stream().map(MdClothes::getId).toList();

    for (Long id : idList) {
      clothesList.add(_SaleRepository.getClothesById(id));
    }

    return clothesList.stream().mapToDouble(MdClothes::getPrice).sum();
  }

  private List<MdClothes> getClothesByIdForSale(List<MdClothes> clothesList) {

    List<MdClothes> getClothesList = new ArrayList<>();

    for (MdClothes clothes : clothesList) {
      getClothesList.add(_SaleRepository.getClothesById(clothes.getId()));
    }

    return getClothesList;
  }

  private void CustomerExistsByPhoneNumber(String phoneNumber) throws Exception {
    if (_SaleRepository.getCustomerByPhoneNumber(phoneNumber).isPresent()) {
      throw new Exception("El numero " + phoneNumber +
          " ya esta registrado, y no le pertenece.");
    }

  }

  private void reduceStock(List<MdClothes> clothesList) throws Exception {
    for (MdClothes clothes : clothesList) {
      if (clothes.getStock() > 0)
        clothes.setStock(clothes.getStock() - 1);
      else
        throw new Exception(
            "No hay stock suficiente de " + clothes.getDescription());
    }
  }

}
