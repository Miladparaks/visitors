package model.da;

import model.entity.Person;
import model.entity.Services;
import model.enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicesDa {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public ServicesDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public void save(Services services) throws SQLException {

        services.setServiceId(ConnectionProvider.getConnectionProvider().getNextId("SERVICES_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO SERVICES (ID, serviceName, serviceDescription, serviceType, serviceStatus) VALUES (?, ?, ?, ?, ?)"
        );
        preparedStatement.setInt(1, services.getServiceId());
        preparedStatement.setString(2, services.getServiceName());
        preparedStatement.setString(3, services.getServiceDescription());
        preparedStatement.setString(4, services.getServiceType());
        // اسمی که توی خود کلاس تعریف کردیم
        preparedStatement.setString(5, String.valueOf(services.getServiceStatus()));


    }

    //Edit Section

    public void edit(Services services) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE SERVICES SET SERVICENAME = ?, ServiceDescription = ?, serviceType = ?, serviceStatus = ? WHERE ID = ?"
        );

        preparedStatement.setString(1, services.getServiceName());
        preparedStatement.setString(2, services.getServiceDescription());
        preparedStatement.setString(3, String.valueOf(services.getServiceType()));
        preparedStatement.setString(4, String.valueOf(services.getServiceStatus()));
        preparedStatement.setInt(5, services.getServiceId());
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


    public List<Services> findByserviceName(String serviceName) throws SQLException {
        List<Services> serviceList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM SERVICES WHERE serviceName = ?");
        preparedStatement.setString(1, serviceName);
        ResultSet resultSet = preparedStatement.executeQuery();


        while(resultSet.next()){

            Services services = Services
                    .builder()
                    .serviceId(resultSet.getInt("ID"))
                    .serviceName(resultSet.getString("serviceName"))
                    .serviceDescription(resultSet.getString("serviceDescription"))
                    .serviceType(resultSet.getString("servicetype"))
                    .serviceStatus(Status.valueOf(resultSet.getString("serviceStatus")))
                    .build();

            serviceList.add(services);
        }
        return serviceList;

    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}
