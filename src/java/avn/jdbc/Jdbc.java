package java.avn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {

    private static String USERNAME = "sriram";
    private static String PWD = "97040";
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";

    public static void main(String[] args) {

        try {
            // Load Driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded");

            // Establish Connection
            Connection con = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("Connection Established");

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute Query
            String query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);

            // Retrieve Data
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("phone_num")
                );
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


	
