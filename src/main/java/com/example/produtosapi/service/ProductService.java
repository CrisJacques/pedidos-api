package com.example.produtosapi.service;

import com.example.produtosapi.model.Product;
import com.example.produtosapi.repository.ProductRepository;
import com.example.produtosapi.service.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product findById(String id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado"));
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
