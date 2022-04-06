package br.com.uniride.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.uniride.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}