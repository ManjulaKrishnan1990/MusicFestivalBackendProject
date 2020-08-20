package com.infosis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="festival")
public class Festival {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="festival_id")
    private int festival_id;

    @Column(name="festivalname")
    private String festivalname;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    private Band  band;

	

	public int getFestival_id() {
		return festival_id;
	}

	public void setFestival_id(int festival_id) {
		this.festival_id = festival_id;
	}

	public String getFestivalname() {
		return festivalname;
	}

	public void setFestivalname(String festivalname) {
		this.festivalname = festivalname;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}
    
    
}
