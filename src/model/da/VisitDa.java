package model.da;

import model.controller.exceptions.NoVisitFoundException;
import model.entity.Payment;
import model.entity.Person;
import model.entity.Timing;
import model.entity.Visit;
import model.entity.enums.Status;
import model.tools.CRUD;
import model.tools.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
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
                "INSERT INTO VISIT (visit_id, customer, timing_id, visit_time, duration, payment_id, status) VALUES (?, ?, ?, ?, ?, ?, ?)"
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
        List<Visit> visits = new ArrayList<>();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM VISIT"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Visit visit = Visit
                    .builder()
                    .Id(resultSet.getInt("VISIT_ID"))
                    .customer(Person.builder().id(resultSet.getInt("CUSTOMER")).build())
                    .timing(Timing.builder().timeId(resultSet.getInt("TIMING_ID")).build())
                    .visitTime(resultSet.getTimestamp("VISIT_TIME").toLocalDateTime())
                    .duration(resultSet.getInt("DURATION"))
                    .payment(Payment.builder().paymentId(resultSet.getInt("PAYMENT_ID")).build())
                    .status(Status.valueOf(resultSet.getString("STATUS")))
                    .build();

            visits.add(visit);
        }
        return visits;
    }

    @Override
    public Visit findById(int id) throws Exception {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM VISIT WHERE visit_id = ?"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Visit visit = null;
        if (resultSet.next()) {
            visit = Visit
                    .builder()
                    .Id(resultSet.getInt("VISIT_ID"))
                    .customer(Person.builder().id(resultSet.getInt("CUSTOMER")).build())
                    .timing(Timing.builder().timeId(resultSet.getInt("TIMING_ID")).build())
                    .visitTime(resultSet.getTimestamp("VISIT_TIME").toLocalDateTime())
                    .duration(resultSet.getInt("DURATION"))
                    .payment(Payment.builder().paymentId(resultSet.getInt("PAYMENT_ID")).build())
                    .status(Status.valueOf(resultSet.getString("STATUS")))
                    .build();
            return visit;
        } else {
            throw new NoVisitFoundException();
        }

    }

    @Override
    public void close() throws Exception {

        preparedStatement.close();
        connection.close();
    }

}
