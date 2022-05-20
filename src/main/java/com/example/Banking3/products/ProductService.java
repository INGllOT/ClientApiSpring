package com.example.Banking3.products;

import com.example.Banking3.client.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }


    public void addNewClient(Product product) {
        Optional<Product> clientOptional = productRepository.
                findByName(product.getName());
        if(clientOptional.isPresent()){
            throw  new IllegalStateException("product already exist !!!!");
        }
        productRepository.save(product);
    }


    public void deleteProduct(Long productId){
        boolean exist = productRepository.existsById(productId);
        if(!exist) {
            throw new IllegalStateException(
                    "product with id " + productId + " does't exist");
        }
        productRepository.deleteById(productId);
    }
}
