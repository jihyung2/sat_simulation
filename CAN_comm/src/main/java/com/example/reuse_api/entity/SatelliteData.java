package com.example.reuse_api.entity;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "sd1000u")
public class SatelliteData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") // 기존 name을 기본키로 했으나, 참조하여 다른 추가 테이블을 만들때, 센서 값이 게속 들어오는특성상 참조값이 게속 들어올때마다 값이 저장되서 에러가 발생함
    private String name;

    public SatelliteData() {
    }

    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }


    public SatelliteData(String name, String data) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "SatelliteData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    // 생성자, getter 및 setter 메서드 추가
}
