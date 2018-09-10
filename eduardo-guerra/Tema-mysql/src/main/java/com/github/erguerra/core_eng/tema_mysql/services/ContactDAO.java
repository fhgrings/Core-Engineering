package com.github.erguerra.core_eng.tema_mysql.services;

import com.github.erguerra.core_eng.tema_mysql.models.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDAO {


    public Optional<Contact> searchContactById(Integer idToSearch) {
        String query = "SELECT * FROM contacts WHERE id = " + idToSearch.toString();
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                Contact contact = new Contact(id, name, phoneNumber, email);
                return Optional.ofNullable(contact);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return Optional.empty();
    }

    public List<Contact> searchContactByName(String nameToSearch) {
        String query = "SELECT * FROM contacts WHERE name = '" + nameToSearch + "'";
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                contacts.add(new Contact(id, name, phoneNumber, email));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }

    public List<Contact> searchAllClientsOrderByName() {
        String query = "SELECT * FROM contacts ORDER BY name";
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                contacts.add(new Contact(id, name, phoneNumber, email));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }

    public List<Contact> searchAllClientsOrderById() {
        String query = "SELECT * FROM contacts ORDER BY id";
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                contacts.add(new Contact(id, name, phoneNumber, email));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }

    public boolean addContact(String name, String phoneNumber, String email) {
        String query = "INSERT INTO contacts (name, phoneNumber, email) VALUES (?,?,?)";
        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            return (preparedStatement.executeUpdate() > 0);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    public boolean removeContactById(Integer id) {
        String query = "DELETE FROM contacts WHERE id = " + id.toString();
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(query) > 0);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public List<Contact> showAllContacts() {

        String query = "SELECT * FROM contacts";
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                contacts.add(new Contact(id, name, phoneNumber, email));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }


}
