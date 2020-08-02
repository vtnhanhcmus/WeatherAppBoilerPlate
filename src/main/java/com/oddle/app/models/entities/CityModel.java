package com.oddle.app.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "city")
public class CityModel extends BaseModel implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "country_code")
    private String countryCode;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private Set<WeatherModel> weathers = new HashSet<>();

    public CityModel(String name, String country) {
        this.name = name;
        this.countryCode = country;
    }

}
