package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("getCustomerByEmail/{emailId}")
	public Customer getUserByEmail(@PathVariable String emailId) {
		return customerDao.getCustomerByEmail(emailId);
	}

	@GetMapping("getCustomers")
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@GetMapping("getCustomerById/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@GetMapping("getCustomerByName/{userName}")
	public Customer getUserByName(@PathVariable String userName) {
		return customerDao.getCustomerByName(userName);
	}

	@PutMapping("updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@DeleteMapping("deleteCustomerById/{customerId}")
	public String deleteCustomerById(@PathVariable int customerId) {
		customerDao.deleteCustomerById(customerId);;
		return "Customer with customerId : " + customerId + " deleted successfully !";
	}
}
