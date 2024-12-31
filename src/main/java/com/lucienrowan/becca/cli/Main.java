package com.lucienrowan.becca.cli;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        SqlConnector.setConnectionSettings();

        // Test connection
        try {
            Connection connection = SqlConnector.getSqlConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(e.hashCode());
        }
    }
}