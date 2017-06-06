/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.concurso.Fase;
import br.ufc.sgs.model.concurso.Selecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author alexf
 */
public class SelecaoDAO extends ExecutaSQL{
    
    public SelecaoDAO(Connection conexao) {
        super(conexao);
    }

    public Collection<Selecao> getSelecoesDoConcurso(int id_concurso) {
        try {
            String sql = "SELECT id, titulo, descricao, vagasRemuneradas, vagasVoluntarias FROM SELECAO WHERE id_concurso = ?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1 , id_concurso);
            
            ResultSet rs = ps.executeQuery();
            ArrayList<Selecao> selecoes = new ArrayList<>();
            while(rs.next()){
                int id_selecao = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                int vagasRemuneradas = rs.getInt("vagasRemuneradas");
                int vagasVoluntarias = rs.getInt("vagasVoluntarias");
                selecoes.add(new Selecao(id_selecao, titulo, descricao, vagasRemuneradas, vagasVoluntarias));
            }
            return selecoes;
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. selecaoDAO");    
        }
        return null;
    }
    
}
