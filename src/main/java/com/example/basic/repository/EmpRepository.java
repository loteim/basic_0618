package com.example.basic.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.basic.entity.Emp;

public interface EmpRepository 
    extends JpaRepository<Emp, Integer> {

  public Emp findByEname(String ename);
  public Emp findByEnameLike(String ename);
  public List<Emp> findByEnameLike(String ename, Pageable pageable);
  public List<Emp> findByEnameLikeOrderByEnameAsc(String ename, Pageable pageable);
  public List<Emp> findBySalGreaterThan(Integer sal);
}
