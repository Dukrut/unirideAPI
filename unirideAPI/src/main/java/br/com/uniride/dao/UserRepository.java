package br.com.uniride.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.uniride.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT * FROM uniride.user AS u"
			+ " WHERE (u.cpf = :teste OR u.mail = :teste) AND u.password = :teste1", nativeQuery = true)
	User authenticate(@Param("teste") String cpf_mail, @Param("teste1") String password);

}