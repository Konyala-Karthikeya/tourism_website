package com.dao;

import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.model.Customer;
import com.ts.config.TwilioConfig;

@Service
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	 @Autowired
	 private TwilioConfig twilioConfig;
	
	 // Hash the password using BCrypt
	    private String hashPassword(String plainTextPassword) {
	        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	    }
		
		public Customer addCustomer(Customer customer) {
			String otp = generateOtp();
			customer.setOtp(otp);
			sendWelcomeEmail(customer);		// Send a welcome email
			sendOtpViaTwilio(customer);		// Send OTP via Twilio
			customer.setPassword(hashPassword(customer.getPassword()));
			customer.setConfirmPassword(hashPassword(customer.getConfirmPassword()));
			Customer savedCustomer = customerRepository.save(customer);   		// Save the employee
			return savedCustomer;
		}
		

		private void sendWelcomeEmail(Customer customer) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(customer.getEmailId());
			message.setSubject("Welcome to our website");
			message.setText("Dear " + customer.getLastName() + " "
					+ customer.getFirstName() + ",\n\n"
					+ "Thank you for registering ");

			mailSender.send(message);
		}
		
	    private void sendOtpViaTwilio(Customer customer) {
	        String phoneNumber = customer.getPhoneNumber();
	        twilioConfig.sendOtp(phoneNumber, customer.getOtp());
	    }

	    private String generateOtp() {
	        Random random = new Random();
	        int otp = 100000 + random.nextInt(900000);
	        return String.valueOf(otp);
	    }
	    
	    public Customer getCustomerByEmail(String emailId) {
			return customerRepository.findByEmail(emailId);
		}
	    
	    public Customer customerLogin(String emailId, String password) {
			Customer customer = customerRepository.findByEmail(emailId);
			if (customer != null && BCrypt.checkpw(password, customer.getPassword())) {
		        return customer;
		    } else {
		    	Customer product1 = new Customer("User Not Found to Login!!!","","","","","","","","","","");
				return product1;
		    }
		}

}