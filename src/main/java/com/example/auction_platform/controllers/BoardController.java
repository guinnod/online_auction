package com.example.auction_platform.controllers;

import com.example.auction_platform.models.Bulletin;
import com.example.auction_platform.services.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Abzal Slamkozha
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Bulletin> getAll() {
        return boardService.getAll();
    }

    @GetMapping("sort")
    public List<Bulletin> getAllProducts(
            @RequestParam(value = "sort", defaultValue = "name") String sort,
            @RequestParam(value = "order", defaultValue = "") String order) {
        return boardService.getAllBySort(sort, order);
    }

    @GetMapping("filter")
    public List<Bulletin> getAllActive(@RequestParam(value = "isActive", defaultValue = "true") String isActive){
        return boardService.getAllByIsActive(isActive);
    }

    @GetMapping("bulletin")
    public Bulletin getProduct(@RequestParam(value = "name", defaultValue = "") String name) {
        return boardService.get(name);
    }

    @GetMapping(value = "bulletin/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    ResponseEntity<ByteArrayResource> getImage(@RequestParam(value = "name", defaultValue = "bulletin") String name) throws IOException {
        Bulletin bulletin = boardService.get(name);
        final ByteArrayResource inputStream = new ByteArrayResource(bulletin.getImage());
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }
}
