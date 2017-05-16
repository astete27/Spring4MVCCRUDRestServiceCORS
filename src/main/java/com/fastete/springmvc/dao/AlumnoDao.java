package com.fastete.springmvc.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastete.springmvc.model.Alumno;

@Repository("alumnoDao")
public interface AlumnoDao extends JpaRepository<Alumno, Serializable>{

}
