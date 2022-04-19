package com.example.module_javaspringboot_day14_02.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "created_by")
//    @CreatedBy
    private String createdBy;

    @Column(name = "created_date")
//    @CreatedDate
    private Date createdDate;

    @Column(name = "modified_by")
//    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "modified_date")
//    @LastModifiedDate
    private Date modifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy() {
        this.createdBy = "Admin";
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate() {
        this.createdDate = new Date();
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy() {
        this.modifiedBy = "Admin";
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate() {
        this.modifiedDate = new Date();
    }
}
