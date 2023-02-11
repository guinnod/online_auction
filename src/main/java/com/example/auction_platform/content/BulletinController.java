package com.example.auction_platform.content;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
@RequestMapping("bulletin")
@RequiredArgsConstructor
public class BulletinController {
    private final BulletinRepository bulletinRepository;
    @GetMapping
    public String getBulletin() throws IOException {

        return "STATUS CODE: 200";
    }
    @GetMapping( value = "image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    ResponseEntity<ByteArrayResource> getImage(@RequestParam(value = "name", defaultValue = "bulletin") String name) throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(bulletinRepository.findByName(name).getImage());
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }

    @PostMapping("add")
    public String addImage(@RequestParam("image") MultipartFile file) throws IOException {
        Bulletin bulletin = new Bulletin("temp", file.getBytes());
        bulletinRepository.save(bulletin);
        return "Successfully added!";
    }
}
