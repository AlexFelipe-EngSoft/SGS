/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.concursos.Concurso;
import br.ufc.sgs.model.concursos.CriterioDeSelecao;
import br.ufc.sgs.model.concursos.Fase;
import br.ufc.sgs.model.concursos.Selecao;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexf
 */
public class FaseDAO extends ExecutaSQL{
    
    public FaseDAO(Connection conexao) {
        super(conexao);
    }
    public boolean cadastra(Fase fase) throws SQLException{
        String sql = "INSERT INTO FASE(titulo, descricao, dataInicio, dataTermino, criterioDeSelecao, id_concurso) VALUES (?,?,?,?,?,?)" ; 
        PreparedStatement ps = getConexao().prepareStatement(sql);
        
        ps.setString(1, fase.getTitulo());
        ps.setString(2, fase.getDescricao());
        
        return ps.executeUpdate() == 1;
    }    

    public ArrayList<Fase> getAllFasesConcurso(int id_concurso) {
        try {
            String sql = "SELECT id, titulo, descricao, dataInicio, dataTermino, criterioDeSelecao FROM CONCURSO WHERE id_concurso = ?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1 , id_concurso);
            
            ResultSet rs = ps.executeQuery();
            ArrayList<Fase> fases = new ArrayList<>();
            while(rs != null){
                rs.next();
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String descricao = rs.getString(3);
                LocalDate dataInicio = rs.getDate(4).toLocalDate(); 
                LocalDate dataTermino = rs.getDate(5).toLocalDate();
                String criterioDeSelecao = rs.getString(6);
                fases.add(new Fase(titulo, descricao, dataInicio, dataTermino, (CriterioDeSelecao) Class.forName("br.ufc.sgs.concursos.criterios."+criterioDeSelecao).newInstance()));
                return fases;
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. CandidatoDAO");    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;          
    }
}
