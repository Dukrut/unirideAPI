package br.com.uniride.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.uniride.model.Brand;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Long>{

}
