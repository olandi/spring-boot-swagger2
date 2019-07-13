package com.example.springbootswagger2.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "aircrafts", schema = "public")
public class AircraftsEntity {

    @ApiModelProperty(notes = "aircraftCode", name = "aircraftCode", required = true, value = "test aircraftCode")
    private Long aircraftCode;

    @NotBlank
    @ApiModelProperty(notes = "model of the Aircraft", name = "model", required = true, value = "test model")
    private String model;

    @NotNull
    @ApiModelProperty(notes = "range of the aircraft", name = "range", required = true, value = "test range")
    private Integer range;

    @Id
    @Column(name = "aircraft_code", nullable = false)
/*    @Length(max = 3)
    @NotBlank*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(Long aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    @Basic
    @Column(name = "model", nullable = false, length = -1)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "range", nullable = false)
    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AircraftsEntity)) return false;
        AircraftsEntity entity = (AircraftsEntity) o;
        return range.equals(entity.range) &&
                Objects.equals(aircraftCode, entity.aircraftCode) &&
                Objects.equals(model, entity.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraftCode, model, range);
    }
}
