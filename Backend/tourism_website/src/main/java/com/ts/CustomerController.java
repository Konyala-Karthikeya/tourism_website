package com.ts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDao;
import com.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	
	@PostMapping("addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	    // Validate passwords
	    if (!customer.getPassword().equals(customer.getConfirmPassword())) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    }

	    customerDao.addCustomer(customer);
	    // Return the added customer details in the response body
	    return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	
	@GetMapping("customerLogin/{emailId}/{password}")
    public Customer customerLogin(@PathVariable String emailId, @PathVariable String password) {
    	return customerDao.customerLogin(emailId, password);
    }
}