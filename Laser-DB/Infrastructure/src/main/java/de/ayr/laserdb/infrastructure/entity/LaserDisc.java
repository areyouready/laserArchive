package de.ayr.laserdb.infrastructure.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import de.ayr.laserdb.infrastructure.enums.AgeLimit;
import de.ayr.laserdb.infrastructure.enums.Videoformat;

@Entity
@Table(name = "laserdiscs")
public class LaserDisc extends BaseEntity {

	private String title;
	private Integer year;
	private Videoformat videoformat;
	private AgeLimit agelimit;
	
	public LaserDisc(String title) {
		this.title = title;
	}
	
	public LaserDisc() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		year = year;
	}

	@Enumerated(EnumType.STRING)
	public Videoformat getVideoformat() {
		return videoformat;
	}
	
	public void setVideoformat(Videoformat videoformat) {
		this.videoformat = videoformat;
	}

}
