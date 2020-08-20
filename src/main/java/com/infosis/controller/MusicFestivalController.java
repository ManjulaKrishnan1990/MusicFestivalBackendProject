package com.infosis.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infosis.model.Record;
import com.infosis.service.MusicFestivalService;

@CrossOrigin(origins = { "http://458386a3f940.ngrok.io"})
@Controller
@RequestMapping(value="/music")
public class MusicFestivalController {
	
	
	MusicFestivalService musicFestivalServce;
	
	@Autowired
	public void setMusicFestivalServce(MusicFestivalService musicFestivalServce) {
		this.musicFestivalServce = musicFestivalServce;
	}

	@RequestMapping(value="/api/v1/festivals", method= RequestMethod.GET)
    public @ResponseBody JSONArray list(ModelMap model){
		JSONArray recordsArray = new JSONArray();
        recordsArray = musicFestivalServce.listAllRecords();
        return recordsArray;  
    }
}
