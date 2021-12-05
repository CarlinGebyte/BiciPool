/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.Bike;
import com.usa.bicipool.service.BikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marco Moreno
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/bikes")
public class BikeController {
    
    /**
     * Atributo bikeService
     */
    @Autowired
    private BikeService bikeService;
    
    /**
     * Metodo para obtener todas las biciletas
     * @return getAllBikes()
     */
    @GetMapping("/all")
    public List<Bike> listarBikes(){
        return bikeService.getAllBikes();
    }
    
    /**
     * Metodo para obtener una bicileta
     * @param id
     * @return findSerial()
     */
    @GetMapping("/{id}")
    public Optional<Bike> findSerial(@PathVariable("id") String id) {
        return bikeService.findSerial(id);
    }
    
    /**
     * Metodo para guardar una bicicleta
     * @param bike
     * @return saveBike() 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike) {
        return bikeService.saveBike(bike);
    }
    /**
     * Actualizar una bicicleta
     * @param bike
     * @return update()
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike) {
        return bikeService.update(bike);
    }
    
    /**
     * Metodo para eliminar una bicileta
     * @param id
     * @return deleteBike()
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id) {
        return bikeService.deleteBike(id);
    } 
    
}
