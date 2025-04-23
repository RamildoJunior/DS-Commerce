package com.devspring.dscommerce.services;
import com.devspring.dscommerce.dto.ProductDTO;
import com.devspring.dscommerce.entities.Product;
import com.devspring.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> result = repository.findAll();
        return result.stream().map(x -> new ProductDTO(x)).toList();
    }
}

