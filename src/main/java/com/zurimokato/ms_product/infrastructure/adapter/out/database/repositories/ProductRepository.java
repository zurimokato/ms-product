package com.zurimokato.ms_product.infrastructure.adapter.out.database.repositories;

import com.zurimokato.ms_product.infrastructure.adapter.out.database.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {


    @Query("{name: '?0'}")
    Optional<ProductEntity> findByName(String name);

}
