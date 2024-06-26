package model.bl;

import lombok.Getter;
import model.controller.exceptions.NoTimingFoundException;
import model.da.TimingDa;
import model.entity.Timing;
import model.tools.CRUD;


import java.util.List;

public class TimingBl implements CRUD<Timing> {

    @Getter
    private static TimingBl timingBl = new TimingBl();

    private TimingBl() {
    }

    @Override
    public Timing save(Timing timing) throws Exception {
        try (TimingDa timingDa = new TimingDa()) {
            timingDa.save(timing);
            return timing;
        }
    }

    @Override
    public Timing edit(Timing timing) throws Exception {
        try(TimingDa timingDa = new TimingDa()) {
            if(timingDa.findById(timing.getTimeId()) != null){
                timingDa.edit(timing);
                return timing;
            }else {
                throw new NoTimingFoundException();
            }
        }
    }

    @Override
    public Timing remove(int id) throws Exception {
        try(TimingDa timingDa = new TimingDa()) {
            Timing timing = timingDa.findById(id);
            if(timing != null) {
                timingDa.remove(id);
                return timing;
            }else {
                throw new NoTimingFoundException();
            }
        }
    }

    @Override
    public List<Timing> findAll() throws Exception {
        try(TimingDa timingDa = new TimingDa()) {
            List<Timing> timingList = timingDa.findAll();
            if(!timingList.isEmpty()) {
                return timingList;
            }else{
                throw new NoTimingFoundException();
            }
        }
    }

    @Override
    public Timing findById(int id) throws Exception {
        try(TimingDa timingDa = new TimingDa()) {
            Timing timing = timingDa.findById(id);
            if(timing != null){
                return timing;
            }else {
                throw new NoTimingFoundException();
            }
        }
    }
}
