package org.example.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.dao.service.FilesDAOService;
import org.example.dto.FileDTO;
import org.example.service.FileProcessingService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileProcessingServiceImpl implements FileProcessingService {

    private final FilesDAOService filesDAOService;

    public FileDTO upload(FileDTO fileDTO) {
        System.out.println("File {} was uploaded to system");
        return fileDTO;
    }
}
