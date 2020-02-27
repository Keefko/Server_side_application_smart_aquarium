package com.bachelor.smartaquarium.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Measuraments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "aquarium_id")
    private int aquariumId;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "data_id")
    private int dataId;

    @Column(name = "create_time")
    private Timestamp createTime;


    public Measuraments() {

    }

    public int getId() {
        return id;
    }

    public int getAquariumId() {
        return aquariumId;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getDataId() {
        return dataId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAquariumId(int aquariumId) {
        this.aquariumId = aquariumId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
