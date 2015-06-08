package webapp.validator;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import webapp.entity.Car;
import webapp.persistence.service.CarService;

@Component
public class CarValidator implements Validator {

	private CarService carService;
	
	public CarValidator(CarService carService) {
		
		this.carService = carService;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean supports( Class cl) {
		return Car.class.isAssignableFrom(cl);
	}

	@Override
	public void validate(Object target, Errors errors) {
		List<Car> cars = carService.getCars();
		Car newCar = (Car) target;
		for (Car car:cars) {
			if (car.getName().equals(newCar.getName())) {
				errors.rejectValue("name", "name.taken");				
			}			
		}
	}
}