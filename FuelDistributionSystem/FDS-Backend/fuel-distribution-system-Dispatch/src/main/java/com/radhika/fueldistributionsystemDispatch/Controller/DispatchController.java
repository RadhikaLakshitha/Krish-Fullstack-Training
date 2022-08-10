package com.radhika.fueldistributionsystemDispatch.Controller;


import com.radhika.fueldistributionsystemDispatch.Model.Dispatch;
import com.radhika.fueldistributionsystemDispatch.Service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/dispatch")
public class DispatchController {

    @Autowired
    DispatchService dispatchService;


    @GetMapping
    public List<Dispatch>getAllDispatchOrders(){
        return dispatchService.getAllDispatches();
    }
}
