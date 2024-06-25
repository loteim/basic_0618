package com.example.basic.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.dao.DemoDao;
import com.example.basic.entity.Course;
import com.example.basic.entity.Dept;
import com.example.basic.entity.Emp;
import com.example.basic.entity.Hospital;
import com.example.basic.entity.Major;
import com.example.basic.entity.Player;
import com.example.basic.entity.ServiceCenter;
import com.example.basic.entity.TableExam1;
import com.example.basic.entity.Team;
import com.example.basic.mapper.DemoMapper;
import com.example.basic.mapper.EmpMapper;
import com.example.basic.repository.CourseRepository;
import com.example.basic.repository.DeptRepository;
import com.example.basic.repository.EmpRepository;
import com.example.basic.repository.HospitalRepository;
import com.example.basic.repository.MajorRepository;
import com.example.basic.repository.PlayerRepository;
import com.example.basic.repository.ServiceCenterRepository;
import com.example.basic.repository.TableExam1Repository;
import com.example.basic.repository.TeamRepository;
import com.example.basic.service.HospitalService;

@RestController
public class DBController {
  @Autowired
  EmpRepository empRepository;

  @Autowired
  DeptRepository deptRepository;

  @GetMapping("/emp")
  public Map<String, Object> emp(@RequestParam(defaultValue = "1") int page) {
    //데이터 3개만 + 정렬
    Map<String, Object> map = new HashMap<>();
    Sort sort = Sort.by("sal","ename");//급여순으로 오름차순 정렬 급여가 같다면 이름순
    //new가 작동하지 않을때는 Static으로 작성된 것일 수도 있으며 .을 이용해야함
    Pageable pageable = PageRequest.of(page-1,3,sort); //몇페이지,페이지당 갯수

    // Page<Emp> p = empRepository.findAll(pageable);
    // List<Emp> list = p.getContent();

    List<Emp> list = empRepository.findByEnameLikeOrderByEnameAsc("%a%", pageable);
    //ename에 a가 들어있는 사람만 나오게 하기

    // int num = p.getNumber(); // 현재 페이지? (0이 첫번째 기준)
    // int num2 = p.getNumberOfElements(); // 현재 요소 갯수?
    // int size = p.getSize(); // 최대 요소 개수?
    // int total = p.getTotalPages(); // 전체 페이지
    // System.out.printf("%s %s %s %s", num,num2,size, total);
    map.put("emp_list", list);
    // map.put("total_page", p.getTotalPages()); //전체 페이지
    // map.put("total_count", p.getTotalElements()); //전체 개수
    // map.put("page1", p.getNumber()); //
    map.put("page2", page);
    return map;
  }

  @GetMapping("/dept")
  public List<Dept> dept() {
    List<Dept> list = deptRepository.findAll();
    return list;
  }

	@Autowired
	MajorRepository majorRepository;
	
  @Autowired
	CourseRepository courseRepository;

  @GetMapping("/major")
  public List<Major> major() {
    return majorRepository.findAll();
  }

  @GetMapping("/course")
  public List<Course> course() {
    return courseRepository.findAll();
  }

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  PlayerRepository playerRepository;

  @GetMapping("/team")
  public List<Team> team() {
    return teamRepository.findAll();
  }
  
  @GetMapping("/player")
  public List<Player> player() {
    return playerRepository.findAll();
  }
  
  // Singleton Pattern
  @Autowired
  HospitalRepository hospitalRepository;
  @Autowired HospitalService hospitalService;
  //@GetMapping("/hospital") // 서비스 안씀
  // public List<Hospital> hospital() {
  //   return hospitalRepository.findAll();
  // }
  @GetMapping("/hospital") // 서비스 씀
  public List<Hospital> hospital() {
    List<Hospital> list = hospitalService.getJson();
    return list;
  }
  @GetMapping("major/list")
  public List<Major> majorList() {
    return majorRepository.findAll();
  }

  @GetMapping("major/add")
  public Major majorAdd(@ModelAttribute Major major) {
    major.setEbtbDate(new Date());

    return majorRepository.save(major);
  }

  @Autowired
  ServiceCenterRepository serviceCenterRepository;

  @GetMapping("/sc/modify")
  @ResponseBody
  public ServiceCenter scModify(@ModelAttribute ServiceCenter sc) {
    sc.setId(1);
    ServiceCenter result = serviceCenterRepository.save(sc);
    return result;
  }

  @GetMapping("/sc/list")
  @ResponseBody
  public List<ServiceCenter> scList() {
    List<ServiceCenter> result = serviceCenterRepository.findAll();
    return result;
  }

  @GetMapping("/sc/add")
  @ResponseBody
  public ServiceCenter scAdd(@ModelAttribute ServiceCenter sc) {
    LocalDateTime localDateTime = LocalDateTime.now();
    sc.setPurDate(localDateTime);

    Date date = new Date();
    sc.setVstDate(date);

    ServiceCenter result = serviceCenterRepository.save(sc);
    return result;
  }

  @Autowired
  TableExam1Repository tableExam1Repository;

  @GetMapping("/table1/{id}")
  public TableExam1 table1Find2(
    @PathVariable int id
  ) {
    Optional<TableExam1> exam1 = tableExam1Repository.findById(id);
    return exam1.get();
  }

  @GetMapping("/table1/list")
  public List<TableExam1> table1Find() {
    List<TableExam1> list = tableExam1Repository.findAll();
    return list;
  }

  @GetMapping("/table1/remove")
  public String table1Remove(@RequestParam int id) {

    tableExam1Repository.deleteById(id);
    
    Optional<TableExam1> t = tableExam1Repository.findById(id);
    tableExam1Repository.delete(t.get());

    return "입력 완료";
  }
  @GetMapping("/table1/add")
  public String table1Add(@RequestParam String title) {
    
    TableExam1 t1 = new TableExam1();
    t1.setId(2);
    t1.setTitle(title);

    tableExam1Repository.save(t1);

    return "입력 완료";
  }

  @Autowired
  DemoDao demoDao;

  @GetMapping("/jdbc/demo")
  public List<Map<String, Object>> jdbcDemo() {
    return demoDao.select();
  }

  @Autowired
  DemoMapper demoMapper;
  
  @Autowired
  EmpMapper empMapper;

  @GetMapping("/mybatis/emp")
  public List<Map<String, Object>> mybatisEmp(@RequestParam("ename") String ename) {
    return empMapper.select(ename);
  }

  @GetMapping("/mybatis/demo/add")
  public String mybatisDemoAdd(@RequestParam Map<String, Object> map) {

    try {
      demoMapper.insert(map);
    } catch(Exception e) {
      return "데이터 추가 실패";
    }
    // int result = demoMapper.insert(map);
    // if(result == 0) {
    //   return "데이터 추가 실패";
    // }
    return "데이터 추가 성공";
  }

  @GetMapping("/mybatis/demo")
  public List<Map<String, Object>> mybatisDemo() {
    return demoMapper.select();
  }
}