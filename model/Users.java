package com.cognizant.authenticationservice.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;



@Entity
@Table(name="user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="us_id")
	@NotNull
	private int id;
	
	@Column(name="us_title")
	@NotNull
	private String userName;
	
	@Column(name="us_first_name")
	@NotNull
	private String firstName;
	
	@Column(name="us_last_name")
	@NotNull
	private String lastName;
	
	@Column(name="us_password")
	@NotNull
	private String password;
	//private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
    private Set<Role> roleList;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "favorite",
	        joinColumns = @JoinColumn(name = "ft_us_id"), 
	        inverseJoinColumns = @JoinColumn(name = "ft_pr_id"))
	    private Set<MoviesList> movieItemList;
	 
	public Users( int id,  String userName,  String firstName, String lastName,
			 String password, Set<Role> roleList, Set<MoviesList> movieItemList) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.roleList = roleList;
		this.movieItemList = movieItemList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Set<Role> getRoleList() {
		return roleList;
	}


	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}


	public Set<MoviesList> getMovieItemList() {
		return movieItemList;
	}


	public void setMovieItemList(Set<MoviesList> movieItemList) {
		this.movieItemList = movieItemList;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", roleList=" + roleList + ", movieItemList=" + movieItemList + "]";
	}

	public Users() {
		super();
	}
}
