package com.radhika.fueldistributionsystemInventory.Repository;

import com.radhika.fueldistributionsystemInventory.Model.AvailableStock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableStockRepository extends MongoRepository<AvailableStock, Integer> {

    AvailableStock findByFuelType(String fuelType);

}
