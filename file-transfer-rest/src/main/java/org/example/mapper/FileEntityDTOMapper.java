package org.example.mapper;

import org.example.dao.entity.FileEntity;
import org.example.dto.FileDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = FileEntityDTOMapper.class)
public interface FileEntityDTOMapper {
    FileDTO toDTO(FileEntity fileEntity);

    FileEntity toEntity(FileDTO fileDTO);
}
