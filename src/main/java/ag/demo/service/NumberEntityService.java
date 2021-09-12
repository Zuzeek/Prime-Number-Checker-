package ag.demo.service;

import java.util.List;

import ag.demo.model.NumberEntity;

public interface NumberEntityService {
	List<NumberEntity> getAllNumbers();
	List<NumberEntity> addNumbers(NumberEntity num);
	List<NumberEntity> getListOfPrimeNumbers(NumberEntity num);
	void deleteAllNumbers(); 
}
