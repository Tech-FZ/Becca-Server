package com.lucienrowan.becca.srv;

import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class SqlConnector {
    public static String connectionString;
    public static String dbUsername;
    public static String dbPassword;

    public static void setConnectionSettings() {
        connectionString = setConnectionString();
        dbUsername = setDbUsername();
        dbPassword = setDbPwd();
    }

    public static String setConnectionString() {
        String tempConStrVal = System.getenv("BECCA_CONNECTION_STRING");

        if (tempConStrVal != null) {
            System.out.println("The connection string is: " + tempConStrVal);
            return tempConStrVal;
        }

        else {
            System.out.println("Unable to retrieve connection string from environment variables.");
            return getConnectionString();
        }
    }

    public static String getConnectionString() {
        System.out.print("Please type in the connection string: ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static String setDbUsername() {
        String tempConStrVal = System.getenv("BECCA_SRV_DBUSER");

        if (tempConStrVal != null) {
            System.out.println("The DB user is: " + tempConStrVal);
            return tempConStrVal;
        }

        else {
            System.out.println("Unable to retrieve database user from environment variables.");
            return getDbUsername();
        }
    }

    public static String getDbUsername() {
        System.out.print("Please type in the DB user: ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static String setDbPwd() {
        String tempConStrVal = System.getenv("BECCA_SRV_DBPWD");

        if (tempConStrVal != null) {
            return tempConStrVal;
        }

        else {
            System.out.println("Unable to retrieve database password from environment variables.");
            return getDbPwd();
        }
    }

    public static String getDbPwd() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(58116114);
        }

        char[] passwordArray = console.readPassword("Enter your DB password: ");


        return new String(passwordArray);
    }

    public static Connection getSqlConnection() throws Exception {
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        return DriverManager.getConnection(connectionString, dbUsername, dbPassword);
    }
}
