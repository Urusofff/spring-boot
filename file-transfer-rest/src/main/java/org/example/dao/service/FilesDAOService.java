package org.example.dao.service;

import org.example.dto.FileDTO;
import org.example.mapper.FileEntityDTOMapper;
import org.springframework.stereotype.Service;

@Service
public class FilesDAOService {

    private FileEntityDTOMapper fileEntityDTOMapper;

    public FileDTO upload(FileDTO fileDTO) {
        //мапим поля с дто на энтити для отправки в базу
        fileEntityDTOMapper.toEntity(fileDTO);
        return fileDTO;
    }
}
