package com.example.basic;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.basic.entity.Course;
import com.example.basic.entity.Major;
import com.example.basic.repository.CourseRepository;
import com.example.basic.repository.MajorRepository;

@SpringBootTest
class MajorRepositoryTests {
	@Autowired
	MajorRepository majorRepository;
	@Autowired
	CourseRepository courseRepository;

	@Test
	void 데이터입력() {
		Major major = new Major();
		major.setName("IT");
		major.setMaxPrsn(100);
		major.setEbtbDate(new Date());
		majorRepository.save(major);

		Course course = new Course();
		course.setName("Java");
		course.setMajor(major);
		courseRepository.save(course);

		course = new Course();
		course.setName("SpringBoot");
		course.setMajor(major);
		courseRepository.save(course);
	}

	@Test
	void 데이터조회_Major() {
		Optional<Major> opt = 
			majorRepository.findById(1);
		Major major = opt.get();
		System.out.println(major.getName());
		System.out.println(major.getMaxPrsn());
		System.out.println(major.getEbtbDate());
		List<Course> list = major.getCourse_list();
		System.out.println(list);
	}

	@Test @Transactional
	void 데이터조회_Course() {
		Optional<Course> opt = courseRepository.findById(1);
		Course course = opt.get();
		String name = course.getName();
		System.out.println(name);
		int id = course.getId();
		System.out.println(id);
		Major major = course.getMajor();
		System.out.println(major.getName());
	}

}
