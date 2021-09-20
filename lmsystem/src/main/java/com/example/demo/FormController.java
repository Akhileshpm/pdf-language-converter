package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class FormController {

	@Autowired
	BookRepo repo;
	@RequestMapping("/")
	public String books1() 
	{
		return "lib";																																																																																																																						
	}
	@RequestMapping("/createbook")//will save to db
	public String books(Books books) 
	{	
		repo.save(books);
		return "lib";																																																																																																																						
	}
	
	@RequestMapping("/viewbooks")//display selection option
	public String viewdetails() 
	{	
		return "viewDetails";																																																																																																																						
	}
		
@PostMapping("/viewbooks")
public ModelAndView viewDetails(@RequestParam int id)//@RequestParam is used to get the request parameters from URL
{ 
	ModelAndView mv = new ModelAndView("retrieve");
	Books books = repo.findById(id).orElse(null);
	mv.addObject(books);
	return mv;	
}

@RequestMapping("/viewallbooks")
@ResponseBody
public List<Books> getBooks() 
{
	return repo.findAll();
}

@RequestMapping("/viewallbooks/{id}")
@ResponseBody
public Optional<Books> getBooksbyid(@PathVariable int id) //@PathVariable extracts values from URI.
{
	return repo.findById(id);
}

@PostMapping("/viewallbooks")
@ResponseBody
public Books donateBooks(Books books) 
{
	repo.save(books);
	return books;
}

@PatchMapping("/issueBook/{id}")
public ResponseEntity<Books> updateBookPartially(
@PathVariable(value = "id") int id,
@Valid @RequestBody Books book) throws InvalidConfigurationPropertyValueException {
	Books books = repo.findById(id)
      .orElseThrow();

    books.setStatus(books.getStatus());
    final Books updatedstatus = repo.save(books);
    return ResponseEntity.ok(updatedstatus);
}
}

/*
@GetMapping("/register")
public String books() 
{
	return "lib";																																																																																																																						
}
*/
/*@RequesttMapping("courses")	
public ModelAndView controller(@RequestParam("name")String cname) {
	
	ModelAndView mv = new ModelAndView();
	mv.addObject("name",cname);
	mv.setViewName("courses.jsp");
	return mv;
}*/
