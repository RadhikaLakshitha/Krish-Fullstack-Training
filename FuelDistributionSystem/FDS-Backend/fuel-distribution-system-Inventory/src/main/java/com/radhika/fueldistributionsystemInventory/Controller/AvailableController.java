package com.radhika.fueldistributionsystemInventory.Controller;

import com.radhika.fueldistributionsystemInventory.Model.AvailableStock;
import com.radhika.fueldistributionsystemInventory.Service.AvailableStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailableController {

    @Autowired
    AvailableStockService availableStockService;

    @PostMapping("/saveAvailableStock")
    public ResponseEntity<AvailableStock> saveAvailableFuel(@RequestBody AvailableStock available) {
        return availableStockService.saveAvailableStock(available);
    }

}
