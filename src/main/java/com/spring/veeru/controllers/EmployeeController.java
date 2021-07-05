package com.spring.veeru.controllers;

import java.net.URI;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.veeru.exceptions.UserNotFoundException;
import com.spring.veeru.models.Employee;
import com.spring.veeru.service.EmployeeService;

//@CrossOrigin(origins = "http://localhost:6364")
/**
 * @author virupaksha.kuruva
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "somevalue");
		Employee emp = empService.saveEmployee(employee);
		return new ResponseEntity<>(emp, headers, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		HttpHeaders headers = new HttpHeaders();
		Employee emp = null;
		headers.add("Custom-Header", "foo");
		emp =  empService.updateById(employee);
		return new ResponseEntity<>(emp, headers, HttpStatus.OK);
	}
	
	
	@GetMapping("/get{empId}")
	public ResponseEntity<?> getEmployee(@PathParam("empId") String empId) throws Exception {
		Employee emp = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		System.out.println("EmpId:"+empId);
		//System.out.println("Emp Id:"+empId +" accessKey: "+accessKey +" secretKey: "+secretKey);
		if (isEmpty(empId) == false) {
			emp = empService.findEmployeeById(Integer.parseInt(empId));
			if(emp != null && emp.getId() >0) {
				return new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
			}else {
				throw new UserNotFoundException(404, "User not found. try with proper data");
				//return new ResponseEntity<Employee>(emp, headers, HttpStatus.NOT_FOUND);
			}
			
		} else {
			return new ResponseEntity<Employee>(emp, headers, HttpStatus.BAD_REQUEST);
		}

		

	}
	
	
	@DeleteMapping("/delete{empId}")
	public ResponseEntity<String> deleteEmployee(@PathParam("empId") String empId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		Employee emp = null;
		if(isEmpty(empId)== false) {
			 emp = new Employee();
			 emp.setId(Integer.parseInt(empId));
			int deteleStatus =  empService.deleteEmployeeById(emp);
			 if(deteleStatus == 1)
				return new ResponseEntity<String >("Deleted successfully.", headers, HttpStatus.OK);
			 else
				 return new ResponseEntity<String >("Deletion failed.", headers, HttpStatus.METHOD_FAILURE);
		}
		
			return new ResponseEntity<>("Pass correct employee id.", headers, HttpStatus.NO_CONTENT);
		
	}
	
	public boolean isEmpty(String text) {
		if(text == null) {
			return true;
		}else if("".equals(text)) {
			return true;
		}else {
			return false;
		}
	}
}

/*@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(RequestEntity<Employee> requestEntity) {
		System.out.println("---------Request hist reached this method----------------s"+requestEntity.getHeaders());
		System.out.println("RequestEntity method {}"+ requestEntity.getMethod());
		System.out.println("RequestEntity URL {}"+ requestEntity.getUrl());
		//System.out.println("RequestEntity URI {}"+ requestEntity.get));
		
		System.out.println("RequestEntity Type {}"+ requestEntity.getType());
		
		Employee emp = empService.saveEmployee(requestEntity.getBody());
		HttpHeaders headers = new HttpHeaders();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();
		headers.add("Custom-Header", "foo");
		//
		return ResponseEntity.created(uri).build();
	}*/
/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getUser(@RequestHeader(value="Access-key") String accessKey,
	                              @RequestHeader(value="Secret-key") String secretKey) {
	    try {
	        // see note 1
	        return ResponseEntity
	            .status(HttpStatus.CREATED)                 
	            .body(this.userService.chkCredentials(accessKey, secretKey, timestamp));
	    }
	    catch(ChekingCredentialsFailedException e) {
	        e.printStackTrace(); // see note 2
	        return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Error Message");
	    }
	}*/
/*@GetMapping("/get{empId}")
	public ResponseEntity<Employee> getEmployee(@RequestHeader(value = "Access-key") String accessKey,
			@RequestHeader(value = "Secret-key") String secretKey, @PathParam("empId") String empId) {
		Employee emp = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		System.out.println("Emp Id:"+empId +" accessKey: "+accessKey +" secretKey: "+secretKey);
		if (isEmpty(empId) == false) {
			emp = empService.findEmployeeById(Integer.parseInt(empId));
			if(emp != null && emp.getId() >0) {
				return new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
			}else {
				return new ResponseEntity<Employee>(emp, headers, HttpStatus.NOT_FOUND);
			}
			
		} else {
			return new ResponseEntity<Employee>(emp, headers, HttpStatus.BAD_REQUEST);
		}*/
/*public ResponseEntity<Employee> updateEmployee(@RequestHeader(value = "Access-key") String accessKey,
			@RequestHeader(value = "Secret-key") String secretKey, @RequestBody Employee employee){
		HttpHeaders headers = new HttpHeaders();
		Employee emp = null;
		headers.add("Custom-Header", "foo");
		emp =  empService.updateById(employee);
		return new ResponseEntity<>(emp, headers, HttpStatus.OK);
	}*/