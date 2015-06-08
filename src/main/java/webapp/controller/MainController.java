package webapp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import webapp.entity.Car;
import webapp.persistence.service.CarService;
import webapp.uploader.FileUploader;
import webapp.validator.CarValidator;

@Controller
public class MainController {

	@Autowired
	private CarService carService;
	
	private FileUploader uploader = new FileUploader();

	@RequestMapping(value={"/cars", "/"}, method=RequestMethod.GET)
	public ModelAndView index() {

		String rootPath = System.getProperty("catalina.home");
		
		System.out.println(rootPath);
		
		ModelAndView mav = new ModelAndView("/cars");
		Car carSelect = new Car();

		List<Car> cars = carService.getCars();
		ArrayList<String> names = new ArrayList<String>();
		for (Car car : cars) {
			names.add(car.getName());
		}

		
		mav.addObject("cars", names);
		mav.addObject("carSelect", carSelect);
		if (cars.size() != 0) { 
			mav.addObject("car", cars.get(0));
		} else {
			mav.addObject("car", new Car());
		}

		return mav;
	}

	@RequestMapping(value="/cars", method = RequestMethod.POST)
	public ModelAndView showCar(@ModelAttribute("carSelect") Car carSelect) {
		ModelAndView mav = new ModelAndView("/cars");
		Car showCar = null;

		List<Car> cars = carService.getCars();
		ArrayList<String> names = new ArrayList<String>();
		for (Car car : cars) {
			names.add(car.getName());
			if (carSelect.getName().equals(car.getName()) ) {
				showCar = car;
			}
		}

		mav.addObject("cars", names);
		mav.addObject("car", showCar);

		return mav;
	}
	/******************************************************************************************************************************** ADD */
	@RequestMapping(value="/admin/addForm", method=RequestMethod.GET)
	public ModelAndView addGet() {
		ModelAndView mav = new ModelAndView("/admin/addForm");
		Car carAdd = new Car();

		mav.addObject("carAdd", carAdd);

		return mav;		
	}



	@RequestMapping(value="/admin/addForm", method=RequestMethod.POST)
	public String addPost(@ModelAttribute("carAdd") @Valid Car carAdd, BindingResult result) {
		
		//Car car = carAdd.getCar();

		//System.out.print(car.getName());
		
		CarValidator validator = new CarValidator(carService);

		validator.validate(carAdd, result);

		if (result.hasErrors()) {
			List<ObjectError> errs = result.getAllErrors();
			for (ObjectError err : errs) {
				System.out.println(err.toString());				
			}
			return "/admin/addForm";		
		} 
		
		carService.addCar(carAdd);

		return "/admin/addPicForm";
	}
	
	@RequestMapping(value="/admin/addPicForm", method=RequestMethod.GET)
	public ModelAndView addPicGet() {
		ModelAndView mav = new ModelAndView("/admin/addPicForm");

		return mav;		
	}
	@RequestMapping(value="/admin/addPicForm", method=RequestMethod.POST)
	public String addPicPost(@ModelAttribute("imageFile") @Valid MultipartFile file, BindingResult result) {
		
		System.out.println(file.getName());

		return "redirect:addForm.html";
	}
	/******************************************************************************************************************************** EDIT */	
	@RequestMapping(value="/admin/editForm", method=RequestMethod.GET)
	public ModelAndView editGet() {
		ModelAndView mav = new ModelAndView("/admin/editForm");
		Car carEdit = new Car();

		List<Car> cars = carService.getCars();
		ArrayList<String> names = new ArrayList<String>();	
		for (Car car : cars) {
			names.add(car.getName());
		}

		mav.addObject("carEdit", carEdit);
		mav.addObject("cars", names);

		return mav;		
	}

	@RequestMapping(value="/admin/editForm", method=RequestMethod.POST)
	public String editPost(@ModelAttribute("carEdit") @Valid Car carEdit, BindingResult result, Map<String, ArrayList<String>> model) {
		Integer index = 0;

		List<Car> cars = carService.getCars();
		ArrayList<String> names = new ArrayList<String>();
		
		for (Car car : cars) {
			names.add(car.getName());
			if (carEdit.getName().equals(car.getName())) {
				index = car.getId();
			}
		}

		if (result.hasErrors()) {

			model.put("cars", names);
			System.out.println("error ?");
			return "/admin/editForm";		
		}

		carEdit.setId(index); 

		carService.editCar(carEdit);

		return "redirect:editForm.html";
	}
	/******************************************************************************************************************************** DELETE */	
	@RequestMapping(value="/admin/deleteForm", method=RequestMethod.GET)
	public ModelAndView deleteGet() {
		ModelAndView mav = new ModelAndView("/admin/deleteForm");
		Car carDelete = new Car();

		List<Car> cars = carService.getCars();
		ArrayList<String> names = new ArrayList<String>();	
		for (Car car : cars) {
			names.add(car.getName());
		}

		mav.addObject("cars", names);
		mav.addObject("carDelete", carDelete);

		return mav;		
	}

	@RequestMapping(value="/admin/deleteForm", method=RequestMethod.POST)
	public String deletePost(@ModelAttribute("carDelete") Car carDelete) {

		List<Car> cars = carService.getCars();

		for (Car car : cars) {
			if (carDelete.getName().equals(car.getName())) {
				carDelete = car;
			}
		}

		carService.deleteCar(carDelete);

		return "redirect:deleteForm.html";
	}

	/******************************************************************************************************************************** LOGIN */

	@RequestMapping(value = "/security/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error) {

		ModelAndView mav = new ModelAndView("/security/login");
		if (error != null) {
			mav.addObject("error", "Invalid username or password!");
		}

		return mav;

	}

	/******************************************************************************************************************************** LOGOUT */	

	@RequestMapping(value="/security/accessDenied")
	public ModelAndView accessDenied() {
		ModelAndView mav = new ModelAndView("/security/accessDenied");
		
		return mav;		
	}
	/******************************************************************************************************************************** LOGOUT */	

	@RequestMapping(value="/security/logout")
	public String logout() {
		return "/security/logout";		
	}
}


