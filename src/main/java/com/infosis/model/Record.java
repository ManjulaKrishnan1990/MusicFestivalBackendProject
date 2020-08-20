package com.infosis.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="record")
public class Record {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="record_id")
	    private int record_id;

	    @Column(name = "recordname")
	    private String recordname;

	    @OneToMany(mappedBy="record", fetch = FetchType.LAZY)
	    private List<Band> bands;

		public int getRecord_id() {
			return record_id;
		}

		public void setRecord_id(int record_id) {
			this.record_id = record_id;
		}

		public String getRecordname() {
			return recordname;
		}

		public void setRecordname(String recordname) {
			this.recordname = recordname;
		}

		public List<Band> getBands() {
			return bands;
		}

		public void setBands(List<Band> bands) {
			this.bands = bands;
		}

		
	    
	    
}
