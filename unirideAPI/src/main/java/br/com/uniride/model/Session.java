package br.com.uniride.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String auth_key;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date logged_at;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_action_at;

	@Column(nullable = false)
	private String os;

	@OneToOne()
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}

	public Date getLogged_at() {
		return logged_at;
	}

	public void setLogged_at(Date logged_at) {
		this.logged_at = logged_at;
	}

	public Date getLast_action_at() {
		return last_action_at;
	}

	public void setLast_action_at(Date last_action_at) {
		this.last_action_at = last_action_at;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
