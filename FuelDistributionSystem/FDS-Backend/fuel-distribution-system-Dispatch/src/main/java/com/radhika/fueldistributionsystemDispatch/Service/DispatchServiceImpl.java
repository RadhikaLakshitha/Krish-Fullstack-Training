package com.radhika.fueldistributionsystemDispatch.Service;

import com.radhika.fueldistributionsystemDispatch.Model.Dispatch;
import com.radhika.fueldistributionsystemDispatch.Repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchServiceImpl implements DispatchService{

    @Autowired
    DispatchRepository dispatchRepository;


    public Dispatch saveDispatch(Dispatch dispatch){
        return dispatchRepository.save(dispatch);
    }

    @Override
    public Dispatch dispatchDelivery(String orderNo, String date) {

        Dispatch dispatch = new Dispatch();
        dispatch.setOrderNo(orderNo);
        dispatch.setDate(date);
        return saveDispatch(dispatch);
    }

    @Override
    public List<Dispatch> getAllDispatches() {
        return dispatchRepository.findAll();
    }
}
