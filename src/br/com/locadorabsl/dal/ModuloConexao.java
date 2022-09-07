/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.locadorabsl.dal;

import java.sql.*;
/**
 *
 * @author Aluno
 */
public class ModuloConexao {
    //Metodo responsavel por estabelecer a conexão com o banco de dados
    public static Connection conector() {
    //conenction é um conjunto de funcionalidades que vem do pacote java.sql e conector é o nome do meu método
    java.sql.Connection conexao = null; //variavel para armazenzar as informações que vem do banco de dados
    //a linha abaixo "chama" o driver que importei para a biblioteca
    String driver = "com.mysql.cj.jdbc.Driver";
    //Variaveis para armazenar informações referente ao banco de dados
    String url = "jdbc:mysql://localhost:3306/locadora?characterEncoding=utf-8";
    String user = "root";
    String password = "";
    
    //Estabelecendo a conexão com o banco de dados
    try {
        Class.forName(driver);
        conexao = DriverManager.getConnection(url, user, password);
        return conexao;
    } catch (Exception e) {
        //A linha abaixo serve de apoio para esclarecer o erro de conexao
        //Porém não posso devolver essa mensagem para o usuário
        //System.out.println (e);
        return null;
    }
    }
}
