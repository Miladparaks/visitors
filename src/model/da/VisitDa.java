package model.da;

import model.entity.Visit;
import model.tools.CRUD;
import model.tools.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class VisitDa implements AutoCloseable, CRUD<Visit> {

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public VisitDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Visit save(Visit visit) throws Exception {
//        visit.setId(ConnectionProvider.getConnectionProvider().getNextId("VISIT_SEQ"));
//        preparedStatement = connection.prepareStatement("Insert Into VISIT (ID,CUSTOMER, TIMING_ID, PAYMENT_ID, STATUS) VALUES (?, ?, ?, ?, ?)");
//        preparedStatement.setInt(1, visit.getId());
//        preparedStatement.setString(2, String.valueOf(visit.getCustomer().getId()));
//        preparedStatement.setString(visit.getTiming().getTimeId());
    return null;
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
        return Collections.emptyList();
    }

    @Override
    public Visit findById(int id) throws Exception {
        return null;
    }

    @Override
    public void close() throws Exception {

        preparedStatement.close();
        connection.close();
    }

}
