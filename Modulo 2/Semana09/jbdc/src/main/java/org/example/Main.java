package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        String nome = "Fulano";
        int idade = 30;
        String email = "fulano@gmail.com";

        Connection connection = null;
        PreparedStatement stm = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:1521/BancoDeDados", "user", "password");
            String sql = "INSERT INTO PESSOAS (NOME, IDADE, EMAIL) VALUES(?, ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, nome);
            stm.setInt(2, idade);
            stm.setString(3, email);
            stm.execute();
            connection.commit();
            connection.close();
        }catch (Exception e){

        }
    }
}