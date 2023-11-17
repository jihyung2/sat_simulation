package com.example.reuse_api.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class MyDatabaseComponent {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MyDatabaseComponent(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void ensureTableExists(String satelliteId) {
        if (StringUtils.hasText(satelliteId) && !tableExists(satelliteId)) {
            createTable(satelliteId);
        }
    }

    private boolean tableExists(String tableName) {
        try {
            DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
            ResultSet tables = metaData.getTables(null, null, tableName, null);
            return tables.next();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to check if table exists: " + tableName, e);
        }
    }

    private void createTable(String tableName) {
        jdbcTemplate.execute("CREATE TABLE " + tableName + " (id SERIAL PRIMARY KEY, name VARCHAR(255), data VARCHAR(255), timestamp TIMESTAMP)");
        jdbcTemplate.execute("CREATE TABLE " + tableName+"Image" + " (id SERIAL PRIMARY KEY, name VARCHAR(255), data MEDIUMBLOB, timestamp TIMESTAMP)");
    }

    public void insertSensorData(String tableName, String sensorName, String streamData) {
        String sql = "INSERT INTO " + tableName + " (name, data, timestamp) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, sensorName, streamData, new Date());
    }
    public void insertImageSensorData(String tableName, String sensorName, byte[] streamData) {
        String sql = "INSERT INTO " + tableName+"Image" + " (name, data, timestamp) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, sensorName, streamData, new Date());
    }
}
