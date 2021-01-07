package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class Calculation {

    private List<Integer> result;

    private String user;

    @NotBlank
    private final Integer total;

    private final List<Integer> values;

    public Calculation(@JsonProperty("user") String user,
                       @JsonProperty("total") Integer total,
                       @JsonProperty("values") List<Integer> values,
                       @JsonProperty("result") List<Integer> result){
        this.user = user;
        this.total = total;
        this.values = values;
        this.result = result;
    }

    public String getUser(){
        return user;
    }

    public Integer getTotal(){
        return total;
    }

    public List<Integer> getValues(){
        return values;
    }

    public List<Integer> getResult(){
        return result;
    }

    public void setUser(String id){
        this.user = id;
    }

    public void setResult(List<Integer> result){
        this.result = result;
    }

}
