package com.infosis.service;

import com.infosis.dao.MusicFestivalDao;
import com.infosis.model.Band;
import com.infosis.model.Festival;
import com.infosis.model.Record;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class MusicFestivalServiceTest {
    @Mock
    MusicFestivalDao musicFestivalDao;

    @InjectMocks
    MusicFestivalServiceImpl musicFestivalService;

    @Spy
    List<Band> bands = new ArrayList<Band>();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bands = listAllBands();
    }

    @Test
    public void findAllRecords(){
        Mockito.when(musicFestivalDao.listAllBands()).thenReturn(bands);
        org.testng.Assert.assertEquals(musicFestivalService.listAllbands(), "AllBands");
    }

    public List<Band> listAllBands() {
        Band band1 = new Band();
        Band band2 = new Band();
        band1.setBrand_id(1);
        band1.setBrandname("Brand Doxzy");
        band1.setBrand_id(5);
        band1.setBrandname("Brand Gibson");
        bands.add(band1);
        bands.add(band2);
       return bands;
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
