package com.reza.ecommerse.model.file;

import com.reza.ecommerse.model.common.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class File extends BaseModel {
    private String fileName;
    private String extension;

    @Column(name = "file_name")
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    @Column(name = "file_ext")
    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }
}
