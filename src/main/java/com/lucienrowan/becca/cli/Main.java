package com.lucienrowan.becca.cli;

import java.sql.*;
import java.util.Scanner;

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
        System.out.println("Welcome to Becca CLI.");
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