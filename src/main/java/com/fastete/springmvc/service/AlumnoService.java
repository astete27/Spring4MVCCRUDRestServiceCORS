package com.fastete.springmvc.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastete.springmvc.dao.AlumnoDao;
import com.fastete.springmvc.model.Alumno;


@Service("alumnoService")
@Transactional
public class AlumnoService {

	
	@Autowired
	private AlumnoDao alumnoDao;
	
	public List<Alumno> retrieveAll(){
		return (List<Alumno>) alumnoDao.findAll();
	}
	
	public Alumno findByCodigo(long codigo){
		return alumnoDao.findOne(codigo);
	}
	
	public Alumno save(Alumno alumno) {
		return alumnoDao.save(alumno);
	}
	
	public List<Alumno> save(List<Alumno> alumnos){
		return alumnoDao.save(alumnos);
	}
	
	public void delete(Serializable id){
		alumnoDao.delete(id);
	}
	
}
