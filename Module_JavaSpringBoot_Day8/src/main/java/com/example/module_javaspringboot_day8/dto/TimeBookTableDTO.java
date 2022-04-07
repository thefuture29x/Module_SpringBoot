package com.example.module_javaspringboot_day8.dto;

import com.example.module_javaspringboot_day8.entities.TableEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class TimeBookTableDTO {
    private Long id;
    private Date timeStart;
    private Date timeEnd;
    private TableEntity tableEntity;

    public TimeBookTableDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public TableEntity getTableEntity() {
        return tableEntity;
    }

    public void setTableEntity(TableEntity tableEntity) {
        this.tableEntity = tableEntity;
    }

    public TimeBookTableDTO(Long id, Date timeStart, Date timeEnd, TableEntity tableEntity) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.tableEntity = tableEntity;
    }
}
