package com.infosis.service;

import java.util.List;

import org.json.simple.JSONArray;

import com.infosis.model.Band;
import com.infosis.model.Festival;
import com.infosis.model.Record;

public interface MusicFestivalService {

	public JSONArray listAllRecords();
	public JSONArray listOfAllFestival();

    public void saveOrUpdate(Record record);

    public Record findRecordById(int id);

    public void deleteRecord(int id);

    public List<Band> listAllbands();

    public List listBandsByRecordId(int recordId);

    public void saveOrUpdate(Band band);

    public Band findBandById(int id);

    public void deleteBand(int id);

    public List listAllFestivals();

    public List listFestivalsByBandId(int bandId);

    public void saveOrUpdate(Festival festival);

    public Festival findFestivalById(int id);

    public void deleteFestival(int id);
}
