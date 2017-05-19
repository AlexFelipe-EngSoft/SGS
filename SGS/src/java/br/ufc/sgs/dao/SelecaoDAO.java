/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.concursos.FaseDaSelecao;
import br.ufc.sgs.model.concursos.Selecao;
import br.ufc.sgs.model.usuarios.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Lavínia
 */
public class SelecaoDAO extends ExecutaSQL{
    
    public SelecaoDAO(Connection conexao) {
        super(conexao);
    }
    
    public boolean cadastra(Selecao selecao) throws SQLException{
        String sql = "INSERT INTO SELECAO(titulo, descricao, id_responsavel, vagasRemuneradas, vagasVoluntarias, id_concurso) values(?,?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        
        ps.setString(1, selecao.getTitulo());
        ps.setString(2, selecao.getDescricao());
        
        
        return false;
    }

    ArrayList<Selecao> getAllSelecaoConcurso(int id_concurso) {
        try {
            String sql = "SELECT id, titulo, descricao, id_responsavel, vagasRemuneradas, vagasVoluntarias FROM SELECAO WHERE id_concurso = ?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1 , id_concurso);
            
            ResultSet rs = ps.executeQuery();
            ArrayList<Selecao> selecoes = new ArrayList<>();
            while(rs != null){
                rs.next();
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String descricao = rs.getString(3);
                Responsavel responsavel = new ResponsavelDAO(getConexao()).getResponsavel(rs.getInt(4));
                int vagasRemuneradas = rs.getInt(5);
                int vagasVoluntarias = rs.getInt(6);
                Collection<FaseDaSelecao> fases; //TEM QUE AJEITAR ISSO DAQUI, ESSA PORQUEIRA
                selecoes.add(new Selecao(titulo, descricao, responsavel, vagasRemuneradas, vagasVoluntarias, fases));
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. CandidatoDAO");    
        }
        
        return null;
    }
    
}
