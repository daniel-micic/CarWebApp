package webapp.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webapp.entity.Car;
import webapp.persistence.dao.*;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDAO carDAO;
	
    public List<Car> getCars() {
        return carDAO.getCars();
	}
		
	public void addCar(Car car) {
		carDAO.addCar(car);		
	}
	
	public void editCar(Car car) {
		carDAO.editCar(car);		
	}
	
	public void deleteCar(Car car) {
		carDAO.deleteCar(car);		
	}
}
