package com.demo.services;

import org.springframework.stereotype.Service;

import com.demo.models.Product;

@Service
public interface IProductService {
	Product findById(int id);
}
