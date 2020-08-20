package com.infosis.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosis.model.Band;
import com.infosis.model.Festival;
import com.infosis.model.Record;

@Repository
public class MusicFestivalDaoImpl implements MusicFestivalDao {
	
	@Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	public ArrayList<Record> listAllRecords() {
        Criteria criteria = getSession().createCriteria(Record.class);
        return (ArrayList<Record>) criteria.list();
    }

    public void saveOrUpdate(Record record) {
        getSession().saveOrUpdate(record);
    }

    public Record findRecordById(int id) {
        Record record = (Record) getSession().get(Record.class, id);
        return record;
    }

    public void deleteRecord(int id) {
        Record record = (Record) getSession().get(Record.class, id);
        getSession().delete(record);
    }

    @SuppressWarnings("rawtypes")
	public List<Band> listAllBands() {
        Criteria criteria = getSession().createCriteria(Band.class);
        return (List<Band>) criteria.list();
    }

    @SuppressWarnings("rawtypes")
	public List<Band> listBrandsByRecordId(Record record) {
        Criteria criteria = getSession().createCriteria(Band.class);
        criteria.add(Restrictions.eq("record",record));
        return (List<Band>) criteria.list();
    }

    public void saveOrUpdate(Band band) {
        getSession().saveOrUpdate(band);
    }

    public Band findBandById(int id) {
        Band band = (Band) getSession().get(Band.class, id);
        return band;
    }

    public void deleteBrand(int id) {
        Band band = (Band) getSession().get(Band.class, id);
        getSession().delete(band);
    }

    @SuppressWarnings("rawtypes")
	public List listAllFestivals() {
        Criteria criteria = getSession().createCriteria(Festival.class);
        return (List) criteria.list();
    }

    @SuppressWarnings("rawtypes")
	public List<Festival> listFestivalsByBandId(Band band) {
        Criteria criteria = getSession().createCriteria(Festival.class);
        criteria.add(Restrictions.eq("band",band));
        return (List<Festival>) criteria.list();
    }

    public void saveOrUpdate(Festival festival) {
        getSession().saveOrUpdate(festival);
    }

    public Festival findFestivalById(int id) {
        Festival festival = (Festival) getSession().get(Festival.class, id);
        return festival;
    }

    public void deleteFestival(int id) {
        Festival festival = (Festival) getSession().get(Festival.class, id);
        getSession().delete(festival);
    }
}
