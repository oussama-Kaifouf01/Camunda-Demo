package com.example.workflow.Repository;

import com.example.workflow.JDBC.JDBCHelper;
import com.example.workflow.Modals.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionRepo {
    public static final String INSERT_TRANSACTION_SQL_QUERY = "INSERT INTO transaction(id,sender_id,recipient_id,amount,signature,Status) VALUES(?,?,?,?,?,?)";


    public static void insertUser(Transaction transaction) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                //TODO:LOGGER
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
            con.setAutoCommit(false);
            ps = con.prepareStatement(INSERT_TRANSACTION_SQL_QUERY);
            ps.setLong(1, transaction.getId());
            ps.setInt(4, transaction.getAmount());
            ps.setInt(2, transaction.getSenderId());
            ps.setInt(3, transaction.getRecipientId());
            ps.setString(5, transaction.getSignature());
            ps.setString(6, transaction.getStatus());
            ps.execute();
            con.commit();
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                throw e1;
            }
            throw e;
        } finally {
            try {
                JDBCHelper.closePrepaerdStatement(ps);
                JDBCHelper.closeConnection(con);
            } catch (SQLException e) {
                throw e;
            }
        }
        //
    }
}
