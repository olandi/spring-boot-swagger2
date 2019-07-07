package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.model.SeatsEntity;
import com.example.springbootswagger2.model.Student;
import com.example.springbootswagger2.repository.Dao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "GeoController", description = "REST Apis related to Student Entity!!!!")
@RestController
public class GeoController {

    @Autowired
    private Dao dao;

    @ApiOperation(value = "Get list of Seats in the System ", response = Iterable.class, tags = "getSeats")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @RequestMapping("/getSeats")
    public List<SeatsEntity> getAllCountries() {
        return dao.getAll();
    }

    @ApiOperation(value = "Get specific Student in the System ", response = SeatsEntity.class, tags = "getSeat")
    @RequestMapping(value = "/getSeat/{seat_no}")
    public SeatsEntity getCountryById(@PathVariable("seat_no") int id) {
        return dao.getById(id);
    }
}