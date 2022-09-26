/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.locadorabsl.dao;

import br.com.locadorabsl.dal.ModuloConexao;
import br.com.locadorabsl.models.Locacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Algo
 */
public class LocacaoDAO {

    public List<Locacao> pesquisarLocacao(String loca, String opcao) {
        Connection con = ModuloConexao.conector();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Locacao> locacoes = new ArrayList<>();
        String sql = null;

        try {
            if (opcao.equals("CPF")) {
                sql = "select * from locacao where cpf_cliente like ?";
            } else if (opcao.equals("Veículo")) {
                sql = "select * from locacao where veiculo like ?";
            }
            stmt = con.prepareStatement(sql); 
            stmt.setString(1, "%" + loca + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Locacao locacao = new Locacao();
                locacao.setCpf_cliente(rs.getString("cpf_cliente"));
                locacao.setVeiculo(rs.getString("veiculo"));
                locacao.setPeriodo(rs.getString("periodo"));
                locacao.setId_locacao(rs.getInt("id_locacao"));
                locacao.setValor(rs.getFloat("valor"));
                locacao.setFuncionario(rs.getString("funcionario"));
                locacoes.add(locacao);
            }

        } catch (Exception e) {

        }

        return locacoes;
    }
}
