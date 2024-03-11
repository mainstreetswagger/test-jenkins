package repositories;

import dto.PersonDto;
import models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepository implements IPeopleRepository {
    private static final String url = "jdbc:postgresql://172.30.12.44:5432/andersen";
    private static final String username = "postgres";
    private static final String password = "1234";

    public PeopleRepository() { }
    public List<Person> getAll() {
        List<Person> people = new ArrayList<Person>();
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from people;");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    Person person = new Person(id, name, surname, age);
                    people.add(person);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return people;
    }
    public Person get(int id) {
        Person person = null;
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "select * from people where id=? limit 1";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int personId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String surname = resultSet.getString(3);
                        int age = resultSet.getInt(4);
                        person = new Person(id, name, surname, age);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return person;
    }
    public int add(PersonDto person) {
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "insert into people (name, surname, age) values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setInt(3, person.getAge());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public boolean update(Person person) {
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "update people set name = ?, surname = ?, age = ? where id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setInt(3, person.getAge());
                    preparedStatement.setInt(4, person.getId());

                    return  preparedStatement.executeUpdate() == 1 ? true : false;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    public boolean delete(int id) {
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "delete from people where id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate() == 1 ? true : false;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }
}
