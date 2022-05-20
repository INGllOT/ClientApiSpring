package com.example.Banking3.products;

import com.example.Banking3.client.Client;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product){

        productService.addNewClient(product);
    }

    @DeleteMapping(path = "/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }
}
