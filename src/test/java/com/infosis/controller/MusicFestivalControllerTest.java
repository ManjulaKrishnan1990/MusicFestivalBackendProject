package com.infosis.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.infosis.model.Festival;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;

import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.infosis.model.Band;
import com.infosis.model.Record;
import com.infosis.service.MusicFestivalService;

public class MusicFestivalControllerTest {
    @Mock
    MusicFestivalService service;

    @Mock
    MessageSource message;

    @InjectMocks
    MusicFestivalController musicFestivalController;

    @Spy
    List<Record> records = new ArrayList<Record>();
    JSONArray recordsArray = new JSONArray();

    @Spy
    ModelMap model;

    @Mock
    BindingResult result;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        records = getRecordList();
    }

    @Test
    public void listRecords(){
        when(service.listAllRecords()).thenReturn(recordsArray);
        Assert.assertNotEquals(musicFestivalController.list(model), "allRecords");
        Assert.assertNotEquals(model.get("records"), records);
        verify(service, atLeastOnce()).listAllRecords();
    }

    public JSONArray getRecordList(){

        JSONArray recordArray = new JSONArray();
        JSONArray banndArray = new JSONArray();
        JSONArray festivalArray = new JSONArray();
        JSONArray musicFestivalArray = new JSONArray();

        Record record = new Record();
        record.setRecord_id(1);
        record.setRecordname("Independent Star Records");
        JSONObject recordObject = new JSONObject();
        recordObject.put("record_id", 1);
        recordObject.put("record_name", "Independent Star Records");
        recordArray.add(recordObject);
        JSONObject recordObject1 = new JSONObject();
        recordObject1.put("record_id", 2);
        recordObject1.put("record_name", "RetroMix Records");
        recordArray.add(recordObject1);

        //bands
        List<Band> bands = new ArrayList<Band>();
        Band band1 = new Band();
        Band band2 = new Band();
        JSONObject bandObject = new JSONObject();
        bandObject.put("band_id", 1);
        bandObject.put("band_name", "Brand Doxzy");
        bandObject.put("record_name", "Independent Star Records");
        bandObject.put("record_id", 1);
        banndArray.add(bandObject);
        JSONObject bandObject1 = new JSONObject();
        bandObject1.put("band_id", 5);
        bandObject1.put("band_name", "Brand Gibson");
        bandObject1.put("record_name", "Independent Star Records");
        bandObject1.put("record_id", 1);
        banndArray.add(bandObject1);

        JSONObject festivalObject = new JSONObject();
        festivalObject.put("festival_id", 1);
        festivalObject.put("festival_name", "Lollapalooza Festival");
        festivalObject.put("band_name", "Brand Doxzy");
        festivalObject.put("band_id", 1);
        festivalArray.add(festivalObject);
        JSONObject festivalObject1 = new JSONObject();
        festivalObject1.put("festival_id", 5);
        festivalObject1.put("festival_name", "Houghton Festival");
        festivalObject1.put("band_name", "Brand Doxzy");
        festivalObject1.put("band_id", 1);
        festivalArray.add(festivalObject1);
        musicFestivalArray.add(recordArray);
        musicFestivalArray.add(banndArray);
        musicFestivalArray.add(festivalArray);

        return musicFestivalArray;
    }
}

