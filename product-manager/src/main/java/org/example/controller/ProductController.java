package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.ProductDTO;
import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.create(productDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        return new ResponseEntity<>(productService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping("{/id}")
    public HttpStatus readAll(@PathVariable Long id) {
        productService.delete(id);
        return HttpStatus.OK;
    }
}
