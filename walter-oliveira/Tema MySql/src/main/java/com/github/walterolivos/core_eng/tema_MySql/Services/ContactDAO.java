package com.github.walterolivos.core_eng.tema_MySql.Services;

import com.github.walterolivos.core_eng.tema_MySql.Models.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDAO {

    public Optional<Contact> searchContactById(Integer idSearch){
        String query = "SELECT * FROM contacts WHERE id = " + idSearch.toString();
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Contact contact = new Contact(name, id);
            }
        } catch (Exception exception ) {
            System.out.println(exception.getMessage());
        }
        return Optional.empty();
    }

    public List<Contact> searchContactByName(String nameSearch) {
        String query = "SELECT * FROM contacts WHERE name = '" + nameSearch + "'";
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                contacts.add(new Contact(name, id));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }

    public List<Contact> searchAllClientsByName() {
        String query = "SELECT * FROM contacts ORDER BY name";
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                contacts.add(new Contact(name, id));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }

    public List<Contact> searchAllClientsById() {
        String query = "SELECT * FROM contacts ORDER BY id";
        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                contacts.add(new Contact(name, id));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }

    public boolean addContact(String name) {
        String query = "INSERT INTO contacts (name) VALUES (?)";
        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
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
                contacts.add(new Contact(name, id));
            }
            return contacts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        List<Contact> contacts = new ArrayList<>();
        return contacts;
    }

}
