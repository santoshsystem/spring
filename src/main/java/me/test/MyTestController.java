package me.test;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.test.dto.Person;
import me.test.dto.Student;

@RestController
@RequestMapping(value="/my")
public class MyTestController {

//	@RequestMapping(value="/details", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@RequestMapping(value="/details")
	public Person getPersonDetails() {
		Person person = new Person();
		person.setName("Kumar");
		System.out.println(person);
		return person;
	}

	@RequestMapping(value="/json")
	public Student getBlankNullPojo() {
		Student person = new Student();
		person.setName("Kumar");
		System.out.println(person);
		return person;
	}

	@RequestMapping(value="/intercept", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public Student getInterceptorTest(@RequestBody Student student) {
		System.out.println("Input " + student);
		Student person = new Student();
		person.setName("Kumar");
		person.setDob(new Date());
		System.out.println(person);
		System.out.println("Output " + student);
		return person;
	}

}
