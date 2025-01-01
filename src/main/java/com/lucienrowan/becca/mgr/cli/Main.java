package com.lucienrowan.becca.mgr.cli;

import java.sql.*;
import java.util.Scanner;
import com.lucienrowan.becca.core.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        SqlConnector.setConnectionSettings();

        // Test connection
        try {
            Connection connection = SqlConnector.getSqlConnection();
            System.out.println("Connection established!");
        }

        catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
            System.exit(e.hashCode());
        }

        catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            System.exit(e.hashCode());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(e.hashCode());
        }

        mainMenu();
    }

    public static MainMenuOptions checkOption(int mmo) {
        return switch (mmo) {
            case 1 -> MainMenuOptions.RegisterNewComputer;
            case 2 -> MainMenuOptions.ManageComputers;
            case 3 -> MainMenuOptions.Exit;
            default -> MainMenuOptions.Invalid;
        };
    }

    public static void mainMenu() {
        System.out.println("Welcome to Becca Manager CLI.");
        MainMenuOptions mmo = MainMenuOptions.Invalid;

        do {
            System.out.println("Please select the following:");
            System.out.println("1. Register new computer");
            System.out.println("2. Manage computers");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                mmo = checkOption(scanner.nextInt());
            }
        } while (mmo == MainMenuOptions.Invalid);
    }
}