
package com.ciclo3.g9.ciclo3.service;

import com.ciclo3.g9.ciclo3.model.Car;
import com.ciclo3.g9.ciclo3.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sesquiveld
 */

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    
    public List<Car> getAll(){
        return carRepository.getAll();
    }
    
    public Optional<Car> getCar(int id){
        return carRepository.getCar(id);
    }
    
    public Car save(Car c){
        if (c.getId()==null){
            return carRepository.save(c);    
        }else{
            Optional<Car> caux = carRepository.getCar(c.getId());
            if(caux.isEmpty()){
                return carRepository.save(c);
            }else{
                return c;
            } 
        } 
        
    }
    
}
