package com.example.module_javaspringboot_day8.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "time_book_table")
public class TimeBookTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "time_start")
    private Date timeStart;
    @Column(name = "time_end")
    private Date timeEnd;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private TableEntity tableEntity;

    public TimeBookTableEntity() {
    }

    public TimeBookTableEntity(Long id, Date timeStart, Date timeEnd, TableEntity tableEntity) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.tableEntity = tableEntity;
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
}
