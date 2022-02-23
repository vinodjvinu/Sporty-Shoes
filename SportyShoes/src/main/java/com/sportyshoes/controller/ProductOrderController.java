package com.sportyshoes.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.ProductOrder;
import com.sportyshoes.repository.ProductOrderMySQLDAO;

@RestController
public class ProductOrderController {
	@Autowired
	ProductOrderMySQLDAO pDAO;

	@GetMapping("/orders")
	public List<ProductOrder> getPurchaseOrders() {
		
		List<ProductOrder> results = pDAO.getAllPurchaseOrders();
		System.out.println(results.size());
		
		return results;
	}
	
	@GetMapping("/orderFilter")
    public List<ProductOrder> getOrders( @RequestBody Map<String, String> rMap) throws Exception {
        if (rMap == null) {
            return (List<ProductOrder>) ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pDAO.getAllPurchaseOrders());
        } else {
            String date = rMap.get("date");
            String category = rMap.get("category");
            return (pDAO.getFilteredOrders(date, category));
        }
    }

}
