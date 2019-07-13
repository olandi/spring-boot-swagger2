package com.example.springbootswagger2.repository;

import com.example.springbootswagger2.model.AircraftsEntity;
import com.example.springbootswagger2.model.SeatsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface Dao extends CrudRepository<AircraftsEntity, Long> {

    AircraftsEntity findByAircraftCode(String tag);

}