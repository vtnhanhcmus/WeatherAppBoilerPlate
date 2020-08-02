package com.oddle.app.models.json;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenWeatherJson implements Serializable {


    @JsonProperty("id")
    private Integer id;

    @JsonProperty("coord")
    private CoordJson coord;

    @JsonProperty("weather")
    private List<WeatherJson> weather = new ArrayList<>();

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    private MainJson main;

    @JsonProperty("visibility")
    private Integer visibility;

    @JsonProperty("wind")
    private WindJson wind;

    @JsonProperty("clouds")
    private CloudsJson clouds;

    @JsonProperty("dt")
    private Long dt;

    @JsonProperty("sys")
    private SysJson sys;

    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}