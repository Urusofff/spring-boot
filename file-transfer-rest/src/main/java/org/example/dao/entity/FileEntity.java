package org.example.dao.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FileEntity {
    private FileType type;
    private String name;
    private long size;
    private byte[] content;

    public enum FileType {
        JSON,
        CSV;
    }
}
