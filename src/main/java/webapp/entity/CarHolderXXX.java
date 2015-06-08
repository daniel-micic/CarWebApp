package webapp.entity;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

public class CarHolderXXX {

	@Valid
	private Car car;
	
	private MultipartFile file;
	
	public CarHolderXXX() {}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
