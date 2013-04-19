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

	private String Title;
	private Integer Year;
	private Videoformat videoformat;
	private AgeLimit agelimit;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	@Enumerated(EnumType.STRING)
	public Videoformat getVideoformat() {
		return videoformat;
	}
	
	public void setVideoformat(Videoformat videoformat) {
		this.videoformat = videoformat;
	}

}
