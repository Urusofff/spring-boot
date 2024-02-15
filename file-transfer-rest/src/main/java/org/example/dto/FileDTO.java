package org.example.dto;

import lombok.Builder;
import lombok.Data;
import org.example.dao.entity.FileEntity;
import org.example.dto.model.AbstractDTO;

@Builder
@Data
public class FileDTO extends AbstractDTO {
    private FileEntity.FileType type;
    private String name;
    private byte[] content;

}
