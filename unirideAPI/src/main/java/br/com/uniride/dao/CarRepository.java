package br.com.uniride.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.uniride.model.Car;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>{

}
