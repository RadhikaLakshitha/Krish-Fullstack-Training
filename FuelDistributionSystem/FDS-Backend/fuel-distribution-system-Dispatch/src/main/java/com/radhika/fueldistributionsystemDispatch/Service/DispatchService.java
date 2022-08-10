package com.radhika.fueldistributionsystemDispatch.Service;

import com.radhika.fueldistributionsystemDispatch.Model.Dispatch;

import java.util.List;

public interface DispatchService {

    public Dispatch dispatchDelivery(String orderNo, String date);
    public List<Dispatch>getAllDispatches();
}
