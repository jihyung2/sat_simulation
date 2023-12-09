package com.example.reuse_api.entity;


public class getsetdata {
    private String sensorname;
    private String data;

    private String satname;


    public getsetdata() {

    }

    public String getSensorname(){return sensorname;}
    public void setSensorname(String sensorname) {
        this.sensorname = sensorname;
    }

    public String getSatname(){return satname;}
    public void setSatname(String satname) {
        this.satname = satname;
    }

    public String getData(){return data;}
    public void setData(String data) {
        this.data = data;
    }

    public getsetdata(String sensorname,String satname,  String data) {
        super();
        this.sensorname = sensorname;
        this.data = data;
        this.satname = satname;
    }
    // 생성자, getter 및 setter 메서드 추가
}
