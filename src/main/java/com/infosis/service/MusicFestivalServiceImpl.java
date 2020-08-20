package com.infosis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosis.dao.MusicFestivalDao;
import com.infosis.model.Band;
import com.infosis.model.Festival;
import com.infosis.model.Record;

@Service
@Transactional
public class MusicFestivalServiceImpl implements MusicFestivalService {

	MusicFestivalDao musicFestivalDao;

	@Autowired
	public void setMusicFestivalDao(MusicFestivalDao musicFestivalDao) {
		this.musicFestivalDao = musicFestivalDao;
	}
	
	public JSONArray listOfAllFestival() {
	return null;
		
	}

	public JSONArray listAllRecords() {
		List<Record> records = musicFestivalDao.listAllRecords();
		List<Band> bands = musicFestivalDao.listAllBands();
		List<Festival> festivals = musicFestivalDao.listAllFestivals();
		JSONArray recordArray = new JSONArray(); 
		JSONArray banndArray = new JSONArray(); 
		JSONArray festivalArray = new JSONArray(); 
		JSONArray musicFestivalArray = new JSONArray(); 
		for(Record record: records) {
			JSONObject recordObject = new JSONObject();
			recordObject.put("record_id", record.getRecord_id());
			recordObject.put("record_name", record.getRecordname());
			recordArray.add(recordObject);
			}
		for(Band band : bands) {
			JSONObject bandObject = new JSONObject();
				bandObject.put("band_id", band.getBrand_id());
				bandObject.put("band_name", band.getBrandname());
				bandObject.put("record_name", band.getRecord().getRecordname());
				bandObject.put("record_id", band.getRecord().getRecord_id());
			banndArray.add(bandObject);
		}
		for(Festival festival : festivals) {
			JSONObject festivalObject = new JSONObject();
			festivalObject.put("festival_id", festival.getFestival_id());
			festivalObject.put("festival_name", festival.getFestivalname());
			festivalObject.put("band_name", festival.getBand().getBrandname());
			festivalObject.put("band_id", festival.getBand().getBrand_id());
			festivalArray.add(festivalObject);
		}
		
		musicFestivalArray.add(recordArray);
		musicFestivalArray.add(banndArray);
		musicFestivalArray.add(festivalArray);
		/*
		 * array = records.stream().map((record) -> { return
		 * Json.createObjectBuilder().add("record_id", record.getId())
		 * .add("record_name", record.getRecordname()).build();
		 * }).collect(Json::createArrayBuilder, JsonArrayBuilder::add,
		 * JsonArrayBuilder::add).build();
		 */
		/*
		 * JSONArray array = new JSONArray(); for (Record record : records) {
		 * array.add(new JSONObject() .put("record_id", record.getId())
		 * .put("record_name", record.getRecordname())); }
		 */
		return musicFestivalArray;
	}

	public void saveOrUpdate(Record record) {
		musicFestivalDao.saveOrUpdate(record);
	}

	public Record findRecordById(int id) {
		return musicFestivalDao.findRecordById(id);
	}

	public void deleteRecord(int id) {
		musicFestivalDao.deleteRecord(id);
	}

	public List<Band> listAllbands() {
		return musicFestivalDao.listAllBands();
	}

	public List listBandsByRecordId(int recordId) {
		return null;
		//return musicFestivalDao.listBrandsByRecordId(recordId);
	}

	public void saveOrUpdate(Band band) {
		musicFestivalDao.saveOrUpdate(band);
	}

	public Band findBandById(int id) {
		return musicFestivalDao.findBandById(id);
	}

	public void deleteBand(int id) {
		musicFestivalDao.deleteBrand(id);
	}

	public List listAllFestivals() {
		return musicFestivalDao.listAllFestivals();
	}

	public List listFestivalsByBandId(Band band) {
		return null;
		//return musicFestivalDao.listFestivalsByBandId(bandId);
	}

	public void saveOrUpdate(Festival festival) {
		musicFestivalDao.saveOrUpdate(festival);
	}

	public Festival findFestivalById(int id) {
		return musicFestivalDao.findFestivalById(id);
	}

	public void deleteFestival(int id) {
		musicFestivalDao.deleteFestival(id);
	}

	public List listFestivalsByBandId(int bandId) {
		// TODO Auto-generated method stub
		return null;
	}
}
