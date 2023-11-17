package com.example.reuse_api.entity;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "sensor_all_data")
public class AllStoreData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "satellite_name", referencedColumnName = "name")
//    private SatelliteData satelliteData;

    @Column(name = "name")
    private String name;

    @Column(name = "data")
    private String data;

    @Column(name = "timestamp")
    private String timestamp;


    public AllStoreData(String name, String data) {
        this.name = name;
        //this.satelliteData = satelliteDat;
        this.data = data;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = dateFormat.format(new Date());
    }


    public AllStoreData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = dateFormat.format(new Date());
    }
//    public String getName(){return name;}
//    public void setName(String name) {
//        this.name = name;
//    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }
//    public SatelliteData getSatelliteData() {
//        return satelliteData;
//    }
//
//    public void setSatelliteData(SatelliteData satelliteData) {
//        this.satelliteData = satelliteData;
//    }
}
