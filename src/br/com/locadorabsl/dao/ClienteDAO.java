/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.locadorabsl.dao;

import br.com.locadorabsl.dal.ModuloConexao;
import br.com.locadorabsl.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ClienteDAO {
    
    public List<Cliente> pesquisaCpf(String cpf) {
        Connection con = ModuloConexao.conector();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select cpf as CPF, nome as Nome, telefone as Telefone from cliente where cpf like ?");
            stmt.setString(1, "%" + cpf + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setNome(rs.getString("Nome"));

                cliente.setCpf(rs.getString("CPF"));

                cliente.setTelefone(rs.getString("Telefone"));
                
                clientes.add(cliente);
            }
            
        } catch (Exception e) {
            
        }
        
        return clientes;
    }
    
}
