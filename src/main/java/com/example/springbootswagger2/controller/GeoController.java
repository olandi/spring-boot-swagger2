package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.model.AircraftsEntity;
import com.example.springbootswagger2.model.SeatsEntity;
import com.example.springbootswagger2.repository.Dao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "AirCraftsEntity", description = "REST Apis related to AirCraftsEntity!!!!")
//@Controller
@RestController
public class GeoController {

    private final Dao dao;

    @Autowired
    public GeoController(Dao dao) {
        this.dao = dao;
    }

    @ApiOperation(value = "Get list of AirCraftsEntity ", response = Iterable.class, tags = "AirCraftsEntity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/aircrafts")
    public Iterable<AircraftsEntity> getAllCountries() {
        return dao.findAll();
    }

    @ApiOperation(value = "Get Aircraft ", response = SeatsEntity.class, tags = "getAircraft")
    @RequestMapping(value = "/aircraft/{aircraft_code}")
    public AircraftsEntity getCountryById(@PathVariable("aircraft_code") String id) {
        return dao.findByAircraftCode(id);
    }
}