package com.oddle.app.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "weather")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class WeatherModel extends BaseModel implements Serializable {

    private static final long serialVersionUID = -451810959705503023L;
    @Column(name = "date")
    private Long date;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "wind_speed")
    private Double windSpeed;

    @Column(name = "humidity")
    private Integer humidity;

    @Column(name = "icon")
    private String icon;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "clouds")
    private Integer clouds;

    @ManyToOne
    @JoinColumn(name = "fk_city")
    @JsonIgnore
    private CityModel city;


}
