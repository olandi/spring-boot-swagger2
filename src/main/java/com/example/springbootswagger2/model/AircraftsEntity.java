package com.example.springbootswagger2.model;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "aircrafts", schema = "bookings", catalog = "demo")
public class AircraftsEntity {
    @ApiModelProperty(notes = "aircraftCode", name = "aircraftCode", required = true, value = "test aircraftCode")
    private String aircraftCode;
    @ApiModelProperty(notes = "model of the Aircraft", name = "model", required = true, value = "test model")
    private String model;
    @ApiModelProperty(notes = "range of the aircraft", name = "range", required = true, value = "test range")
    private int range;

    @Id
    @Column(name = "aircraft_code", nullable = false, length = 3)
    @Length(max = 3)
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
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
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AircraftsEntity that = (AircraftsEntity) o;

        if (range != that.range) return false;
        if (aircraftCode != null ? !aircraftCode.equals(that.aircraftCode) : that.aircraftCode != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aircraftCode != null ? aircraftCode.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + range;
        return result;
    }
}
