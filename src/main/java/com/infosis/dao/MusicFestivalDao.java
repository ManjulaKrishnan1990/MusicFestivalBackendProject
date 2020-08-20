package com.infosis.dao;

import java.util.ArrayList;
import java.util.List;

import com.infosis.model.Band;
import com.infosis.model.Festival;
import com.infosis.model.Record;

public interface MusicFestivalDao {
	
	public ArrayList<Record> listAllRecords();

    public void saveOrUpdate(Record record);

    public Record findRecordById(int id);

    public void deleteRecord(int id);

    public List<Band> listAllBands();

    public List<Band> listBrandsByRecordId(Record record);

    public void saveOrUpdate(Band band);

    public Band findBandById(int id);

    public void deleteBrand(int id);

    public List listAllFestivals();

    public List<Festival> listFestivalsByBandId(Band band);

    public void saveOrUpdate(Festival festival);

    public Festival findFestivalById(int id);

    public void deleteFestival(int id);
}
