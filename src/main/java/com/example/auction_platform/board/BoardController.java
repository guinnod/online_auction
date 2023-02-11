package com.example.auction_platform.board;

import com.example.auction_platform.product.Product;
import com.example.auction_platform.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    @GetMapping( value = "image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    ResponseEntity<ByteArrayResource> getImage() throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                "C://norm.jpg"
        )));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }
}
