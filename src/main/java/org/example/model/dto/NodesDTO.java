package org.example.model.dto;

import javax.xml.soap.Node;
import java.io.Serializable;
import java.util.Collection;

public class NodesDTO implements Serializable {


    private String id;

    private Integer male;

    private String culture;

    private String house;

    private Double popularity;

    public NodesDTO(String id, Integer male, String culture, String house, Double popularity) {
        this.id = id;
        this.male = male;
        this.culture = culture;
        this.house = house;
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "NodesDTO{" +
                "id='" + id + '\'' +
                ", male=" + male +
                ", culture='" + culture + '\'' +
                ", house='" + house + '\'' +
                ", popularity=" + popularity +
                '}';
    }


}


