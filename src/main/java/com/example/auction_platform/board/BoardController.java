package com.example.auction_platform.board;

import com.example.auction_platform.product.Product;
import com.example.auction_platform.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class BoardController {
    @Autowired
    private ProductRepository productRepository;
    Logger logger = LoggerFactory.getLogger(BoardController.class);
    @GetMapping
    public List<Product> getAllProducts() {
        logger.info("Have got all products");
        return productRepository.findAll();
    }
    @GetMapping("product")
    public Product getProduct(@RequestParam(value = "name", defaultValue = "null") String name) {
        return productRepository.findByName(name);
    }
    @PostMapping("add")
    public Product addProduct(@RequestBody Product product) {
        productRepository.save(product);
        logger.info("Product added: " + product);
        return product;
    }
}
