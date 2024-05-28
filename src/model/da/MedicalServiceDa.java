package model.da;

import model.entity.MedicalService;
import model.entity.enums.Status;
import model.tools.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalServiceDa implements AutoCloseable {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public MedicalServiceDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public void save(MedicalService medicalService) throws SQLException {

        medicalService.setServiceId(ConnectionProvider.getConnectionProvider().getNextId("SERVICES_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO SERVICES (id, name, description, service_type, status) VALUES (?, ?, ?, ?, ?)"
        );
        preparedStatement.setInt(1, medicalService.getServiceId());
        preparedStatement.setString(2, medicalService.getServiceName());
        preparedStatement.setString(3, medicalService.getServiceDescription());
        preparedStatement.setString(4, medicalService.getServiceType());
        // اسمی که توی خود کلاس تعریف کردیم
        preparedStatement.setBoolean(5, medicalService.isServiceStatus());

        preparedStatement.execute();
    }

    //Edit Section

    public void edit(MedicalService medicalService) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE SERVICES SET SERVICENAME = ?, ServiceDescription = ?, serviceType = ?, serviceStatus = ? WHERE ID = ?"
        );

        preparedStatement.setString(1, medicalService.getServiceName());
        preparedStatement.setString(2, medicalService.getServiceDescription());
        preparedStatement.setString(3, String.valueOf(medicalService.getServiceType()));
        preparedStatement.setString(4, String.valueOf(medicalService.isServiceStatus()));
        preparedStatement.setInt(5, medicalService.getServiceId());
        preparedStatement.execute();

    }

    //Delete Section
    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM SERVICES WHERE ID = ?"
        );

        preparedStatement.setInt(1, id);
        preparedStatement.execute();

    }


    public List<MedicalService> findAll() throws Exception {
        List<MedicalService> medicalServices = new ArrayList<>();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM SERVICES ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            MedicalService medicalServiceList = MedicalService
                    .builder()
                    .serviceId(resultSet.getInt("ID"))
                    .serviceName(resultSet.getString("NAME"))
                    .serviceDescription(resultSet.getString("DESCRIPTION"))
                    .serviceType(resultSet.getString("SERVICE_TYPE"))
                    .serviceStatus(String.valueOf(resultSet.getInt("STATUS")).isEmpty())
                    .build();
            medicalServices.add(medicalServiceList);
        }
        return medicalServices;
    }

    public MedicalService findById(int id) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM SERVICES WHERE ID = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        MedicalService medicalService = null;
        if (resultSet.next()) {
            medicalService = MedicalService.builder()
                    .serviceId(resultSet.getInt("ID"))
                    .serviceName(resultSet.getString("NAME"))
                    .serviceDescription(resultSet.getString("DESCRIPTION"))
                    .serviceType(resultSet.getString("SERVICE_TYPE"))
                    .serviceStatus(String.valueOf(resultSet.getInt("STATUS")).isEmpty())
                    .build();
        }
        return medicalService;

    }



    public List<MedicalService> findByserviceName(String serviceName) throws Exception {
        List<MedicalService> serviceList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM SERVICES WHERE serviceName = ?");
        preparedStatement.setString(1, serviceName);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {

            MedicalService medicalService = MedicalService
                    .builder()
                    .serviceId(resultSet.getInt("ID"))
                    .serviceName(resultSet.getString("serviceName"))
                    .serviceDescription(resultSet.getString("serviceDescription"))
                    .serviceType(resultSet.getString("servicetype"))
                    .serviceStatus(String.valueOf(resultSet.getInt("STATUS")).isEmpty())
                    .build();

            serviceList.add(medicalService);
        }
        return serviceList;

    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}
