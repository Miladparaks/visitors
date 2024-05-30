package model.bl;

import lombok.Getter;
import model.da.TimingDa;
import model.entity.Timing;
import model.tools.CRUD;

import java.util.Collections;
import java.util.List;

public class TimingBl implements CRUD<Timing> {

    @Getter
    private static TimingBl timingBl = new TimingBl();

    private TimingBl() {
    }

    @Override
    public Timing save(Timing timing) throws Exception {
      try(TimingDa timingDa = new TimingDa()) {
          timingDa.save(timing);
          return timing;
      }
    }

    @Override
    public Timing edit(Timing timing) throws Exception {
        return null;
    }

    @Override
    public Timing remove(int id) throws Exception {
        return null;
    }

    @Override
    public List<Timing> findAll() throws Exception {
        return Collections.emptyList();
    }

    @Override
    public Timing findById(int id) throws Exception {
        return null;
    }
}
