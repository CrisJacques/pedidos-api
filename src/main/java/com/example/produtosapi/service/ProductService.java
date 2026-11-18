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

    public void deleteById(String id){
        findById(id);
        productRepository.deleteById(id);
    }

    public Product update(String id, Product productData){
        return productRepository.save(updateData(id, productData));
    }

    private Product updateData(String id, Product productData){
        Product product = findById(id);

        product.setName(productData.getName());
        product.setPrice(productData.getPrice());
        product.setDescription(productData.getDescription());

        return product;
    }

    public List<Product> findByName(String name){
        return productRepository.findByName(name);
    }

}
