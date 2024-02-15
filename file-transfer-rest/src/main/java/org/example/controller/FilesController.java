package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.FileDTO;
import org.example.service.FileProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/file-system/v1/files")
public class FilesController {

    private final FileProcessingService fileProcessingService;

    @PostMapping(value = "", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> uploadFiles(
            ServerWebExchange serverWebExchange,
            @RequestBody FileDTO file) {

        return ResponseEntity.ok(fileProcessingService.upload(file));
    }
}
