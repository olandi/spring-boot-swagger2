package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.model.AircraftsEntity;
import com.example.springbootswagger2.repository.Dao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import javax.validation.Validator;


@Api(value = "AirCraftsEntity", description = "REST Apis related to AirCraftsEntity!!!!")
//@Controller
@RestController
public class GeoController {

    private final Dao dao;

    private final Validator validator;

    @Autowired
    public GeoController(Dao dao, Validator validator) {
        this.dao = dao;
        this.validator = validator;
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
/*
    @ApiOperation(value = "Get Aircraft ", response = AircraftsEntity.class, tags = "getAircraft")
    @RequestMapping(value = "/aircraft/{aircraft_code}")
    public AircraftsEntity getCountryById(@PathVariable("aircraft_code") Long id) {
        return dao.findOne(id);
    }*/

    @ApiOperation(value = "Get Aircraft ", response = AircraftsEntity.class, tags = "getAircraft")
    @GetMapping(value = "/aircraft/{aircraft_code}")
    public ResponseEntity getCountryById(@PathVariable("aircraft_code") Long id) {

        AircraftsEntity entity = dao.findOne(id);
        return entity != null ? ResponseEntity.ok().body(entity) : ResponseEntity.notFound().build();
    }


    @ApiOperation(value = "Put Aircraft ", response = AircraftsEntity.class, tags = "PutAircraft")
    @PutMapping(value = "/aircraft")
    public void create(@RequestBody AircraftsEntity aircraftsEntity) {
        System.out.println("before creating");

        if (!validator.validate(aircraftsEntity).isEmpty()) throw new ValidationException("поля не ок");

        dao.save(aircraftsEntity);
        System.out.println("after creating");
    }


}