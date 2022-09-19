package com.example.saitest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SaitestApplication {

	Logger log = LogManager.getLogger(SaitestApplication.class);
	 private static List<Employee> empList = new ArrayList<Employee>();
	static
	{
		Employee emp1 = new Employee();

		emp1.setName("Muni");
		emp1.setAge(32);
		emp1.setSalary(1000);
		empList.add(emp1);
	}
	@GetMapping("/getemployees")
	public ResponseEntity<Object> getMessage() throws Exception
	{
		log.info("Get started getMessage getemployees");
		System.out.println("...GETEMPLOYEES....");

		log.info("Get ended getMessage getemployees {}",new ObjectMapper().writeValueAsString(empList));
		return new ResponseEntity<>(empList,HttpStatus.OK);
	}
	public static void main(String[] args) {
		SpringApplication.run(SaitestApplication.class, args);
	}

	@PostMapping("/addemployee")
	public ResponseEntity<Object> postData(@RequestBody Employee employee) throws Exception
	{

		log.info("Get started postData getemployees {}",new ObjectMapper().writeValueAsString(employee));
		System.out.println("...ADDEMPLOYEE...");
		empList.add(employee);
		log.info("Get started postData getemployees {}",new ObjectMapper().writeValueAsString(empList));
		return new ResponseEntity(empList, HttpStatus.OK);
	}
}
