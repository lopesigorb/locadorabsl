/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.locadorabsl.dao;

import br.com.locadorabsl.dal.ModuloConexao;
import br.com.locadorabsl.models.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Algo
 */
public class VeiculoDAO {
    
    public List<Veiculo> pesquisarVeiculo(String carro, String opcao) {
        Connection con = ModuloConexao.conector();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Veiculo> veiculos = new ArrayList<>();
        String sql;

        try {
            if (opcao.equals("Placa")) {
                sql = "select * from veiculo where placa like ?";
            } else if (opcao.equals("Marca")) {
                sql = "select * from veiculo where marca like ?";
            } else if (opcao.equals("Modelo")) {
                sql = "select * from veiculo where modelo like ?";
            } else {
                sql = "select * from veiculo where ano like ?";
            }
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + carro + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId_veiculo(rs.getInt("id_veiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAno(rs.getString("ano"));
                veiculo.setRenavam(rs.getString("renavam"));
                veiculo.setChassi(rs.getString("chassi"));
                veiculo.setObservacao(rs.getString("observacao"));
                veiculo.setQuilom(rs.getFloat("quilom"));
                veiculo.setAquisicao(rs.getString("aquisicao"));
                veiculos.add(veiculo);
            }
        } catch (Exception e) {

        }
        return veiculos;
    }
    
    public List<Veiculo> pesVeiCurto(String carro) {
        Connection con = ModuloConexao.conector();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Veiculo> veiculos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select modelo as Modelo, placa as Placa, marca as Marca, ano as Ano from veiculo where modelo like ?");
            stmt.setString(1, "%" + carro + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getString("ano"));
                veiculos.add(veiculo);
            }
        } catch (Exception e) {

        }
        return veiculos;
    }
    
    
}
