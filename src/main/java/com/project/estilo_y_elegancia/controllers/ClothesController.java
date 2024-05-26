package com.project.estilo_y_elegancia.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estilo_y_elegancia.models.MdClothes;
import com.project.estilo_y_elegancia.services.implementation.ClothesServiceImpl;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController extends BaseController<MdClothes, ClothesServiceImpl> {

}
