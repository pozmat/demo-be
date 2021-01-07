package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Calculation;

import java.sql.Array;
import java.util.*;

@Repository("postgres")
public class CalculationDataAccessService implements CalculationDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CalculationDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Integer> logCalculation(String user, Integer total, List<Integer> values, List<Integer> result) {
        Integer[] valuesArray = new Integer[values.size()];
        valuesArray = values.toArray(valuesArray);
        Integer[] resultArray = new Integer[result.size()];
        resultArray = result.toArray(resultArray);
        jdbcTemplate.update("INSERT INTO calculation (userId, total, valuesX, result) VALUES (?, ?, ?, ?)", user, total, valuesArray, resultArray);
        return result;
    }

    @Override
    public List<Calculation> showCalculationHistory() {
        String sqlQuery = "SELECT * FROM calculation";
        return jdbcTemplate.query(sqlQuery, (resultSet, i) -> {
            String user = resultSet.getString("userId");
            Integer total = resultSet.getInt("total");
            Array pgValues = resultSet.getArray("valuesX");
            Integer[] tempValues = (Integer[])pgValues.getArray();
            List<Integer> values = Arrays.asList(tempValues);
            Array pgResult = resultSet.getArray("result");
            Integer[] tempResult = (Integer[])pgResult.getArray();
            List<Integer> result = Arrays.asList(tempResult);
            return new Calculation(user, total, values, result);
        });
    }
}
