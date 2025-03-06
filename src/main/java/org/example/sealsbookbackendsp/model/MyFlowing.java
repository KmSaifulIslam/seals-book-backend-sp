package org.example.sealsbookbackendsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Entity
public class MyFlowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long storeId;
    private Long userId;
    private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private Timestamp createAt = new Timestamp(System.currentTimeMillis());

    public MyFlowing() {
    }

    public MyFlowing(Long id, Long storeId, Long userId, Timestamp updateTime, Timestamp createAt) {
        this.id = id;
        this.storeId = storeId;
        this.userId = userId;
        this.updateTime = updateTime;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
