package model.bl;



import lombok.Getter;
import model.controller.exceptions.NoVisitFoundException;
import model.da.VisitDa;
import model.entity.Visit;
import model.tools.CRUD;

import java.util.Collections;
import java.util.List;

public class VisitBl implements CRUD<Visit> {

    @Getter
    private static VisitBl visitBl = new VisitBl();

    public VisitBl(){

    }

    @Override
    public Visit save(Visit visit) throws Exception {
       try(VisitDa visitDa = new VisitDa()){
           visitDa.save(visit);
           return visit;
       }
    }

    @Override
    public Visit edit(Visit visit) throws Exception {
        return null;
    }

    @Override
    public Visit remove(int id) throws Exception {
        return null;
    }

    @Override
    public List<Visit> findAll() throws Exception {
       try(VisitDa visitDa = new VisitDa()){
           List<Visit> visits = visitDa.findAll();
           if(!visits.isEmpty()){
               return visits;
           }
           else {
               throw new NoVisitFoundException();
           }
       }
    }

    @Override
    public Visit findById(int id) throws Exception {
        try(VisitDa visitDa = new VisitDa()){
            Visit visit = visitDa.findById(id);
            if(visit != null){
                return visit;
            }else{
                throw new NoVisitFoundException();
            }
        }
    }
}
