package com.bachelor.smartaquarium.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Aquarium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aquarium_id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column (name = "type")
    private int type;

    @Column(name = "status")
    private int status;

    public Aquarium(int userId,Timestamp createTime, Timestamp updateTime, int type, int status) {
       this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aquarium{" +
                "id=" + id +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
