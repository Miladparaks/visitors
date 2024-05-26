package model.da;

import model.entity.Visit;
import model.tools.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitDa implements AutoCloseable {

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public VisitDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public void save(Visit visit) throws SQLException {
        visit.setVisitId(ConnectionProvider.getConnectionProvider().getNextId("VISIT_ID"));

//        preparedStatement = connection.prepareStatement(
//                "INSERT INTO VISIT (visit_id, customer, timing_id, payment, status) VALUES (?, ?)"
//        )
    }

    @Override
    public void close() throws Exception {

        preparedStatement.close();
        connection.close();
    }
}
