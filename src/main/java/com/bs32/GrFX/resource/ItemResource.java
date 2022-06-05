package com.bs32.GrFX.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bs32.GrFX.model.Response;
import com.bs32.GrFX.service.implementation.ItemServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Path;
import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemResource {
    private final ItemServiceImpl itemService;

    @GetMapping("/list")
    public ResponseEntity<Response> getItems() {
        return ResponseEntity.ok(
                Response.builder().timeStamp(now())
                        .data(of("Items", itemService.list(30)))
                        .message("Items retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );

    }

    @GetMapping(path = "/image/{filename}", produces = IMAGE_PNG_VALUE)
    public byte[] getImageUrl(@PathVariable String filename) throws IOException {
        return Files.readAllBytes(Paths.get("D:/ImageRes/Grinders/" + filename));
    }

}
