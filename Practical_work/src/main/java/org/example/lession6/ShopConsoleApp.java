package org.example.lession6;
import java.sql.*;
import java.util.Scanner;

public class ShopConsoleApp {

    private static final String URL = "jdbc:postgresql://localhost:5432/shop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Muhammad2323.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду:");

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.startsWith("/showProductsByPerson ")) {
                showProductsByPerson(command.split(" ")[1]);
            } else if (command.startsWith("/findPersonsByProductTitle ")) {
                findPersonsByProductTitle(command.split(" ")[1]);
            } else if (command.startsWith("/removePerson ")) {
                removePerson(command.split(" ")[1]);
            } else if (command.startsWith("/removeProduct ")) {
                removeProduct(command.split(" ")[1]);
            } else if (command.startsWith("/buy ")) {
                String[] parts = command.split(" ");
                buyProduct(parts[1], parts[2]);
            } else if (command.equalsIgnoreCase("/exit")) {
                break;
            } else {
                System.out.println("Неизвестная команда.");
            }
        }
        scanner.close();
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void showProductsByPerson(String customerName) {
        String query = "SELECT p.name, pu.purchase_price, pu.purchase_date FROM purchases pu " +
                "JOIN products p ON pu.product_id = p.id " +
                "JOIN customers c ON pu.customer_id = c.id WHERE c.name = ?";
        try (Connection con = connect();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, customerName);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.printf("Товар: %s, Цена покупки: %.2f, Дата покупки: %s%n",
                        rs.getString("name"),
                        rs.getDouble("purchase_price"),
                        rs.getTimestamp("purchase_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findPersonsByProductTitle(String productName) {
        String query = "SELECT DISTINCT c.name FROM purchases pu " +
                "JOIN customers c ON pu.customer_id = c.id " +
                "JOIN products p ON pu.product_id = p.id WHERE p.name = ?";
        try (Connection con = connect();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, productName);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("Клиент: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void removePerson(String customerName) {
        String query = "DELETE FROM customers WHERE name = ?";
        try (Connection con = connect();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, customerName);
            int affected = pst.executeUpdate();
            System.out.println("Удалено клиентов: " + affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void removeProduct(String productName) {
        String query = "DELETE FROM products WHERE name = ?";
        try (Connection con = connect();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, productName);
            int affected = pst.executeUpdate();
            System.out.println("Удалено товаров: " + affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void buyProduct(String customerName, String productName) {
        String query = "INSERT INTO purchases(customer_id, product_id, purchase_price) " +
                "SELECT c.id, p.id, p.price FROM customers c, products p " +
                "WHERE c.name = ? AND p.name = ?";
        try (Connection con = connect();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, customerName);
            pst.setString(2, productName);
            int inserted = pst.executeUpdate();
            System.out.println("Совершено покупок: " + inserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
