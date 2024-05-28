package model.bl;


import lombok.Getter;
import model.da.MedicalServiceDa;
import model.entity.MedicalService;
import model.tools.CRUD;

import java.util.ArrayList;
import java.util.List;

public class MedicalServiceBl implements CRUD<MedicalService> {
    @Getter
    private static MedicalServiceBl medicalServiceBl = new MedicalServiceBl();

    private MedicalServiceBl() {
    }

    @Override
    public MedicalService save(MedicalService medicalService) throws Exception {
        try (MedicalServiceDa medicalServiceDa = new MedicalServiceDa()) {
            medicalServiceDa.save(medicalService);
            return medicalService;
        }

    }

    @Override
    public MedicalService edit(MedicalService medicalService) throws Exception {
        return null;
    }

    @Override
    public MedicalService remove(int id) throws Exception {

    }

    @Override
    public List<MedicalService> findAll() throws Exception {
        try (MedicalServiceDa medicalServiceDa = new MedicalServiceDa()) {
            List<MedicalService> medicalServices = medicalServiceDa.findAll();
            if(medicalServices != null){
                return medicalServices;
            }
            else{
                throw new Exception();
            }
        }

    }

    @Override
    public MedicalService findById(int id) throws Exception {
        return null;
    }
}
