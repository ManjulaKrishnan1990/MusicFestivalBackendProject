package com.infosis.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class Band {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="brand_id")
    private int brand_id;

    @Column(name="brandname")
    private String brandname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="record_id", nullable=false)
    private Record record;

    @OneToMany(mappedBy="band")
    private List<Festival> festivals;

	

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public List<Festival> getFestivals() {
		return festivals;
	}

	public void setFestivals(List<Festival> festivals) {
		this.festivals = festivals;
	}
    
}
