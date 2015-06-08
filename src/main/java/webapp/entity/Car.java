package webapp.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="car")
public class Car {
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Size(min=2, max=30)
	@Column(name = "name")
	private String name;
	@NotNull
	@Column(name = "cylinders")
	private Integer cylinders;
	@NotNull
	@Column(name = "capacity")
	private Integer capacity;
	@Size(min=2, max=10)
	@Column(name = "drive")
	private String drive;
	@NotNull
	@Column(name = "power")
	private Integer power;
	@NotNull
	@Column(name = "torque")
	private Integer torque;
	@NotNull
	@Column(name = "weight")
	private Integer weight;
	@NotNull
	@Column(name = "length")
	private Integer length;
	@NotNull
	@Column(name = "width")
	private Integer width;
	@NotNull
	@Column(name = "height")
	private Integer height;
	@Column(name = "url")
	private String url;

	
	/*public Car(String name, Integer cylinders, Integer capacity, String drive,
			Integer power, Integer torque, Integer weight,
			Integer length, Integer width, Integer height) {
		this.name = name;
		this.cylinders = cylinders;
		this.capacity = capacity;
		this.drive = drive;
		this.power = power;
		this.torque = torque;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;		
	}*/

	public Car( ) {
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCylinders() {
		return cylinders;
	}
	public void setCylinders(Integer cylinders) {
		this.cylinders = cylinders;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getTorque() {
		return torque;
	}
	public void setTorque(Integer torque) {
		this.torque = torque;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getUrl() {
		return url;
	}
	public void setImage(String url) {
		this.url = url;
	}
	
							
	
	
	
}
