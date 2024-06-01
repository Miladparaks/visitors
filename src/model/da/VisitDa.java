package model.da;

import model.entity.Person;
import model.entity.Visit;
import model.tools.CRUD;
import model.tools.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

public class VisitDa implements AutoCloseable, CRUD<Visit> {

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public VisitDa() throws Exception {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Visit save(Visit visit) throws Exception {
        visit.setId(ConnectionProvider.getConnectionProvider().getNextId("VISIT_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO VISIT (VISIT_ID, CUSTOMER, TIMING_ID, VISIT_TIME, DURATION, PAYMEMT_ID, STATUS) VALUES (?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, visit.getId());
        preparedStatement.setInt(2, visit.getCustomer().getId());
        preparedStatement.setInt(3, visit.getTiming().getTimeId());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(visit.getVisitTime()));
        preparedStatement.setInt(5, visit.getDuration());
        preparedStatement.setInt(6, visit.getPayment().getPaymentId());
        preparedStatement.setString(7, visit.getStatus().toString());
        preparedStatement.executeQuery();
        return visit;
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
