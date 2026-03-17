/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sarmo01
 *///package kontaktlista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jahar
 */
public class DbManager {
    private Connection conn = null;

    /**
     * Constructor for database class. This class handels database connection and
     * querys
     *
     */
    public DbManager() {
        String url = "jdbc:mysql://localhost:3306/"; // som mysql värde jdbc mysql
        String dbName = "kontaktlista";// namn på databas
        String userName = "kontaktlista"; // användarnamn
        String password = "kontaktlista";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Ansluten");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getSQLState());
            if (conn == null) {
                System.out.println("Ingen anslutning");
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
        /**
     * Inserting a new contact in tha database
     *
     * @param kontakt is the new contact to be inserted to the databse.
     * @return non zero value on succsessfull insert, zero value on none
     * succsessful insert.
     */
    public int insert(Kontakt kontakt) {
        int res = 0;

        // Check for active connection, not written yet
        //if (connected()) {
            try {
                String sql = "insert into kontakt(firstname, lastname, phonenumber)"
                        + " VALUES (?, ?, ?)";
                PreparedStatement stmt
                        = conn.prepareStatement(sql);

                // Set Parameters
                stmt.setString(1, kontakt.getFörnamn());
                stmt.setString(2, kontakt.getEfternamn());
                stmt.setString(3, kontakt.getTelefonnummer());

                // Execute SQL query
                res = stmt.executeUpdate();
                System.out.println(res + " record inserted");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        //}
        return res;
    }

        /**
     * Metod for retriveing all the records in the database
     *
     * @return ResultSet object whith all records orders by id
     */
    public ResultSet getAllData() {
        ResultSet rs = null;
        // Check for active connection, not written yet
        //if (connected()) {
            try {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM kontakt order by kontaktid");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + " Error!");
            }
        //}
        return rs;
    }

    /**
     * Method for updating a contact in the datebase by it´s id number.
     *
     * @param kontakt object to be updated in the database
     */
    /*public void udateRow(Kontakt kontakt) {
        int res = 0;
        try {
            String sql = "update kontakt set egenskap1 = ?, egenskap2 = ? where kontaktid= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Set Parameters
            stmt.setString(1, kontakt.getEgenskap1());
            stmt.setInt(2, kontakt.getEgenskap2());
            stmt.setInt(3, kontakt.getId());

            // Execute SQL query
            res = stmt.executeUpdate();
            System.out.println(res + " records updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }*/

}