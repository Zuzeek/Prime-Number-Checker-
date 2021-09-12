package ag.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ag.demo.model.NumberEntity;
import ag.demo.service.NumberEntityService;

@RequestMapping(value = "/api")
@RestController
public class NumberEntityController {
	
	@Autowired
	private NumberEntityService numberService; 
	
	@GetMapping(value = "/primeNumbers", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> getPrimeNumbers (@RequestBody NumberEntity number) {
		try {
			List<NumberEntity> primeNumbers = numberService.getListOfPrimeNumbers(number); 
			
			if (primeNumbers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(primeNumbers, HttpStatus.OK); 
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/numbers",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> getAllNumbers () {
		try {
			List<NumberEntity> numbers = numberService.getAllNumbers(); 
			
			if (numbers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(numbers, HttpStatus.OK); 
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/add", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumberEntity>> createNumbers (@RequestBody NumberEntity number) {
		try {
			return new ResponseEntity<>(numberService.addNumbers(number), HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> deleteAllNumbers() {
		try {
			numberService.deleteAllNumbers(); 
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
}
