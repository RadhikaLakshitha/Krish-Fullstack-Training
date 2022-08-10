package com.radhika.fueldistributionsystemInventory.Repository;

import com.radhika.fueldistributionsystemInventory.Model.ReservedStock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservedStockRepository extends MongoRepository<ReservedStock, String> {
}
