package com.example.reuse_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Serialdata {
    private static final String SERIAL_PORT = "/dev/cu.usbserial-A10NLRGZ";
    private static final String REST_API_SERVER = "http://127.0.0.1:8080/sensor";
    private static final int MAX_RETRY_COUNT = 5;
    private static final int RETRY_DELAY_MS = 2000;

    private StringBuilder buffer = new StringBuilder();
    private StringBuilder imagebuffer = new StringBuilder();
    private StringBuilder voicebuffer = new StringBuilder();

    public void readSerialData() {
        int retryCount = 0;
        while (true) {
            try {
                readFromSerialPort();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to connect to the serial port. Retrying...");
                retryCount++;
                if (retryCount > MAX_RETRY_COUNT) {
                    System.out.println("Failed to connect to the serial port after " + MAX_RETRY_COUNT + " attempts. Please check the connection.");
                    break;
                }
                try {
                    Thread.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    private void readFromSerialPort() throws Exception {
        SerialPort serialPort = SerialPort.getCommPort(SERIAL_PORT);
        serialPort.openPort();
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        System.out.println("Serial Communication Success!");

        while (true) {
            if (serialPort.bytesAvailable() > 0) {
                processDataFromSerialPort(serialPort);
            }
        }
    }

    private void processDataFromSerialPort(SerialPort serialPort) throws Exception {
        byte[] data = new byte[serialPort.bytesAvailable()];
        serialPort.readBytes(data, data.length);

        String receivedData = new String(data);

        System.out.println("Serial Received data: " + receivedData);


        buffer.append(receivedData);
        ruleBase(buffer.toString());
        System.out.println("buffer: " + buffer.toString());
    }


    private void ruleBase(String canFrame) {
        System.out.println("ruleBase Received data: " + canFrame);

        int startIndex = buffer.indexOf("$");
        int endIndex = buffer.indexOf("*");
        if (startIndex >= 0 && endIndex > startIndex) {
            String message = buffer.substring(startIndex + 1, endIndex);
            String standardIdBits = message.substring(0, 11);

            if (standardIdBits == "00000010000"){ // 이미지 처리
                System.out.println(message);
                ImageReceiver(message);
                buffer.delete(startIndex, endIndex + 1);
            }

            else if (standardIdBits == "00000011111"){ // 음성 데이터 처리
                VoiceReceiver(message);
                buffer.delete(startIndex, endIndex + 1);
            }
            else {
                SensorparseCANFrame(message);
                buffer.delete(startIndex, endIndex + 1);
            }
        }
    }


    public void SensorparseCANFrame(String canFrame) {
        System.out.println(canFrame);
        // 처음 11비트는 표준 ID (센서 종류)
        String standardIdBits = canFrame.substring(0, 11);
        // 그 다음 18비트는 확장 ID (위성 종류)
        String extendedIdBits = canFrame.substring(11, 29);
        // 그 이후 모든 비트는 데이터
        String dataBits = canFrame.substring(29);

        int intdata = Integer.parseInt(dataBits, 2);
        // 표준 ID와 확장 ID를 비트 문자열에서 정수로 변환

        System.out.println("Standard ID: " + standardIdBits); // 표준 id는 센서 종류
        System.out.println("Extended ID: " + extendedIdBits); // 확장 id는 위성 종류
        System.out.println("Data Field: " + dataBits); // 센서 데이터

        sendToRestApi(standardIdBits, extendedIdBits, String.valueOf(intdata));

    }

    public void ImageReceiver(String data){
        System.out.println(data);
        // 처음 11비트는 표준 ID (센서 종류)
        String standardIdBits = data.substring(0, 11);
        System.out.println("Standard ID: " + standardIdBits);
        // 그 다음 18비트는 확장 ID (위성 종류)
        String extendedIdBits = data.substring(11, 29);
        System.out.println("Extended ID: " + extendedIdBits);
        // 그 이후 모든 비트는 데이터
        String dataBits = data.substring(29);
        System.out.println("Data Field: " + dataBits);

        sendToRestApi(standardIdBits, extendedIdBits, dataBits);
    }

    public void VoiceReceiver(String data){
        System.out.println(data);
        // 처음 11비트는 표준 ID (센서 종류)
        String standardIdBits = data.substring(0, 11);
        // 그 다음 18비트는 확장 ID (위성 종류)
        String extendedIdBits = data.substring(11, 29);
        // 그 이후 모든 비트는 데이터
        String dataBits = data.substring(29);

        int intdata = Integer.parseInt(dataBits, 2);
        // 표준 ID와 확장 ID를 비트 문자열에서 정수로 변환

        System.out.println("Standard ID: " + standardIdBits); // 표준 id는 센서 종류
        System.out.println("Extended ID: " + extendedIdBits); // 확장 id는 위성 종류
        System.out.println("Data Field: " + dataBits); // 센서 데이터

        sendToRestApi(standardIdBits, extendedIdBits, dataBits);

    }


//    public String byteArrayToBinaryString(byte[] bytes) {
//        StringBuilder binaryString = new StringBuilder();
//        for (byte b : bytes) {
//            String binaryByte = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
//            binaryString.append(binaryByte);
//        }
//        return binaryString.toString();
//    }

    private void sendToRestApi(String Sensorname, String Satname, String SensorValue) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("data", SensorValue);
        map.put("sensorname", Sensorname);
        map.put("satname", Satname);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(map);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(REST_API_SERVER, requestEntity, String.class);
        if (response.getStatusCodeValue() == 200) {
            System.out.println("데이터 전송 성공");
        } else {
            System.out.println("데이터 전송 실패");
        }
    }
}
