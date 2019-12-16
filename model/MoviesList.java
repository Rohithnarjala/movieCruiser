package com.cognizant.authenticationservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="movie_item")
public class MoviesList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mv_id")
	private int id;
	
	@Column(name="mv_title")
	private String title;
	
	@Column(name="mv_box_office",columnDefinition = "BIGINT(50)")
	private long boxOffice;
	
	@Column(name="mv_active",columnDefinition = "VARCHAR(3)")
	private boolean active;
	
	@Column(name="mv_date_of_launch")
	private Date dateOfLaunch;
	
	@Column(name="mv_genre")
	private String genre;
	
	@Column(name="mv_has_teaser",columnDefinition = "VARCHAR(3)")
	private boolean hasTeaser;
	
	@Column(name="mv_image")
	private String image;
	
	public MoviesList() {
		super();
	}
	public MoviesList(int id, String title, long boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser, String image) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getBoxOffice() {
		return boxOffice;
	}
	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isHasTeaser() {
		return hasTeaser;
	}
	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "MovieItem [id=" + id + ", title=" + title + ", boxOffice=" + boxOffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", hasTeaser=" + hasTeaser + ", image="
				+ image + "]";
	}

}
