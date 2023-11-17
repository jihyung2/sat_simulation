package com.example.reuse_api.service;

import com.example.reuse_api.entity.SatelliteData;
import com.example.reuse_api.repository.DBRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private final DBRepository dbRepository;
    private final EntityManager entityManager;
    @Autowired
    public DBService(DBRepository dbRepository, EntityManager entityManager) {
        this.dbRepository = dbRepository;
        this.entityManager = entityManager;
    }
    @Transactional //@Transactional 어노테이션이 없었기 때문에, EntityManager의 merge 메서드가 트랜잭션 외부에서 호출되서 에러가 발생함
    public void saveDB(SatelliteData satelliteData) {
        entityManager.merge(satelliteData);
    }
    @Transactional
    public void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    @Transactional
    public SatelliteData findByNameOrCreate(String sensorName) {
        SatelliteData satelliteData = this.findByName(sensorName);
        if (satelliteData == null) {
            satelliteData = new SatelliteData();
            satelliteData.setName(sensorName);
            this.saveDB(satelliteData);
        }
        return satelliteData;
    }

    public List<SatelliteData> getALLDB() {
        return dbRepository.findAll();
    }

    public List<SatelliteData> getDeleteDB(String satname) { //Request에서 받은 삭제할 문제 이름을
        // 문제 이름에 해당하는 문제를 찾습니다.
        List<SatelliteData> deleteProblems = dbRepository.findByName(satname); // Repository에서 name을 찾기
        //List<Problem> deleteProblems = problemRepository.findAll(); 이렇게하면 모든 문제를 다 지우는 내용임
        // 찾은 문제를 삭제합니다.
        dbRepository.deleteAll(deleteProblems); // 찾은 이름과 연결된 정보를 다 지운다.

        return deleteProblems;
    }

    public SatelliteData findByName(String sensorName) {
        List<SatelliteData> results = dbRepository.findByName(sensorName);
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }
}
