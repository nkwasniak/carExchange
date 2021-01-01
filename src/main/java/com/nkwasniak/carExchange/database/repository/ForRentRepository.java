package com.nkwasniak.carExchange.database.repository;

import com.nkwasniak.carExchange.database.entity.ForRent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForRentRepository extends CrudRepository<ForRent, Long> {

    @Override
    List<ForRent> findAll();
}
