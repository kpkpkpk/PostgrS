package com.example.authorlv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectPostgres implements Runnable {
    private final String USER="postgres";
    private final String PASSWORD="postgres";
    private final String DB_URL="jdbc:postgresql://83.69.10.56:40023/myBookDatabase";
    private final String JDBC_DRIVER="org.postgresql.Driver";
    private ArrayList<Author> authorArrayList;
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;
    public ConnectPostgres(){
        authorArrayList=new ArrayList<Author>();
    }
    @Override
    public void run() {
//        authorArrayList.add(new Author(120,"name"));
    connectionAndExtractData();
    }
    private void connectionAndExtractData(){
        try{
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            connection=null;
        statement=null;
        try{
            connection= DriverManager.getConnection(DB_URL,USER,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(connection!=null){
            try {
                statement=connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        String getAuthorsTable="SELECT * FROM authors;";
        try {
            resultSet=statement.executeQuery(getAuthorsTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                authorArrayList.add(new Author(resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Author> getAuthorArrayList() {
        return authorArrayList;
    }
}
