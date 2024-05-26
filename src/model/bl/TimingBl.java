package model.bl;

import model.da.PersonDa;
import model.da.TimingDa;
import model.entity.Timing;
import model.tools.CRUD;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

//public class TimingBl implements CRUD<Timing> {
//    @Override
//    public Timing save(Timing timing) throws Exception {
//        try(TimingDa timingDa = new TimingDa()){
//            timingDa.save(timing);
//            return timing;
//        }
//    }

//    @Override
//    public Timing edit(Timing timing) throws SQLException {
//        try(TimingDa timingDa = new TimingDa()){
//            timingDa.edit(timing);
//            return timing;
//    } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        @Override
//    public Timing remove(int id) throws SQLException {
//        return null;
//    }

//    @Override
//    public List<Timing> findAll() throws SQLException {
//        return Collections.emptyList();
//    }

//    @Override
//    public Timing findById(int id) throws Exception {
//        try(TimingDa timingDa = new TimingDa()) {
//            Timing timing = timingDa.findById(id);
//            timing.setDoctor(PersonBl.getPersonBl().findById(timing.getDoctor().getId()));
//            return timing;
//        }
//        return null;
//    }
//}

