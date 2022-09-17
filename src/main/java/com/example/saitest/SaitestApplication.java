package com.example.saitest;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
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
	public ResponseEntity<Object> getMessage()
	{
		return new ResponseEntity<>(empList,HttpStatus.OK);
	}
	public static void main(String[] args) {
		SpringApplication.run(SaitestApplication.class, args);
	}

	@PostMapping("/addemployee")
	public ResponseEntity<Object> postData(@RequestBody Employee employee)
	{
		empList.add(employee);
		return new ResponseEntity(empList, HttpStatus.OK);
	}
}
