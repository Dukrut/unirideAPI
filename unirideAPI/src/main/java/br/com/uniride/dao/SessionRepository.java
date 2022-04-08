package br.com.uniride.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.uniride.model.Session;

public interface SessionRepository extends CrudRepository<Session, Integer> {

}
