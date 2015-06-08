package webapp.persistence.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webapp.entity.Car;

@Repository
public class CarDAOImpl implements CarDAO{
	
	@Autowired
	private SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	public List<Car> getCars() {
		 
		return factory.getCurrentSession().createQuery("FROM Car").list();
	}
	
	public void addCar(Car car) {
		factory.getCurrentSession().save(car);
	}
	
	public void editCar(Car car) {
		factory.getCurrentSession().merge(car);
	}
	
	public void deleteCar(Car car) {
		factory.getCurrentSession().delete(car);
	}
}
