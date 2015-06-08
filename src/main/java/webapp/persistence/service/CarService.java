package webapp.persistence.service;

import java.util.List;

import webapp.entity.Car;

public interface CarService {
	
	public List<Car> getCars();
	public void addCar(Car car);
	public void editCar(Car car);
	public void deleteCar(Car car);
}
