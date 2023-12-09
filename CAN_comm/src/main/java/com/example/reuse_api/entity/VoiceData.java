package com.example.reuse_api.entity;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Voice_data")
public class VoiceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "userid")
    private String userid;

    @Column(name = "data", columnDefinition="MEDIUMBLOB")
    @Lob // 이방법이 이미지 파일을 저장할 수 있게 blob방식
    private byte[] data;

    @Column(name = "timestamp")
    private String timestamp;


    public VoiceData(String name, String userid, byte[] data) {
        this.name = name;
        //this.satelliteData = satelliteDat;
        this.data = data;
        this.userid = userid;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = dateFormat.format(new Date());
    }


    public VoiceData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = dateFormat.format(new Date());
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUserid() { return userid; }

    public void setUserid(String userid) { this.userid = userid; }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
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

}
