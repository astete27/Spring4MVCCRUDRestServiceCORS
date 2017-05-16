package com.fastete.springmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fastete.springmvc.model.Alumno;
import com.fastete.springmvc.service.AlumnoService;

@RestController
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
    @RequestMapping(value = "/alumno/", method = RequestMethod.GET)
    public ResponseEntity<List<Alumno>> listAllAlumnos() {
        List<Alumno> alumnos = alumnoService.retrieveAll();
        System.out.println(new Date());
        if(alumnos.isEmpty()){
            return new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);//otra opcion seria HttpStatus.NOT_FOUND
        }
        
        return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/alumno/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> getUser(@PathVariable("codigo") long id) {
        System.out.println("Fetching Alumno con id " + id);
        Alumno user = alumnoService.findByCodigo(id);
        if (user == null) {
            System.out.println("Alumno con id " + id + " not found");
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Alumno>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/alumno/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> createJugador(@RequestBody final Alumno alumno) {
        final Alumno savedAlumno = alumnoService.save(alumno);
        return new ResponseEntity<Alumno>(savedAlumno, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/alumno/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> updateJugador(@RequestBody final Alumno alumno) {
    	alumnoService.save(alumno);
        return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/alumno/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Alumno> deleteJugadores(@PathVariable("id") final Long id) {
    	alumnoService.delete(id);
        return new ResponseEntity<Alumno>(HttpStatus.NO_CONTENT);
    }
}
