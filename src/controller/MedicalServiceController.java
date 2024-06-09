package controller;

import model.bl.MedicalServiceBl;
import model.da.MedicalServiceDa;
import model.entity.MedicalService;

import static model.tools.Validator.checkNullValidator;

public class MedicalServiceController {
    public static String save(String serviceName, String serviceDescription, String serviceType, boolean serviceStatus) {
        try {
            MedicalService medicalService = new MedicalService();

            medicalService.setServiceName(checkNullValidator(serviceName, "serviceName cannot be null"));
            medicalService.setServiceDescription(checkNullValidator(serviceDescription, "serviceDescription cannot be null"));
            medicalService.setServiceType(serviceType);
            medicalService.setServiceStatus(serviceStatus);
            MedicalServiceBl.getMedicalServiceBl().save(medicalService);
            return "Medical Service saved successfully";

        } catch (Exception e) {
            return e.getMessage();
        }


    }
}
