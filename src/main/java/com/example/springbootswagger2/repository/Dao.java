package com.example.springbootswagger2.repository;

import com.example.springbootswagger2.model.SeatsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class Dao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<SeatsEntity> getAll() {
        return entityManager.createQuery("from SeatsEntity c order by c. desc", SeatsEntity.class).getResultList();
    }

    public SeatsEntity getById(int id) {
        return entityManager.find(SeatsEntity.class, id);
    }
}