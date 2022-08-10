package com.radhika.fueldistributionsystemDispatch.Repository;

import com.radhika.fueldistributionsystemDispatch.Model.Dispatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DispatchRepository extends MongoRepository<Dispatch, String> {
}
