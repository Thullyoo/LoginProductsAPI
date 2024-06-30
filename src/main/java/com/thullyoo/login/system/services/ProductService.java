package com.thullyoo.login.system.services;

import com.thullyoo.login.system.DTOs.ProductRequest;
import com.thullyoo.login.system.DTOs.ProductResponse;
import com.thullyoo.login.system.entities.product.Product;
import com.thullyoo.login.system.exceptions.ProductIsPresentException;
import com.thullyoo.login.system.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductResponse registerProduct(ProductRequest productRequest){
        Optional<Product> optionalProduct = productRepository.findByName(productRequest.name());

        if (optionalProduct.isPresent()){
            throw new ProductIsPresentException("Produto já registrado.");
        }

        Product product = new Product();

        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());

        Product productResponse = productRepository.save(product);

        return new ProductResponse(productResponse.getProductId(), productResponse.getName(), productResponse.getQuantity(), productResponse.getPrice());
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
