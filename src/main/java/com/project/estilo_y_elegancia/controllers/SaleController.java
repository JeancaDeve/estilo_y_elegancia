package com.project.estilo_y_elegancia.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estilo_y_elegancia.models.MdSale;
import com.project.estilo_y_elegancia.services.implementation.SaleServiceImpl;

@RestController
@RequestMapping("/api/sale")
public class SaleController extends BaseController<MdSale, SaleServiceImpl> {

}
