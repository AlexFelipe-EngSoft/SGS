/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.exceptions.DadoInvalidoException;
import br.ufc.sgs.model.usuarios.Candidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexf
 */
public class CandidatoDAO extends ExecutaSQL{
    
    public CandidatoDAO(Connection conexao) {
        super(conexao);
    }
    
    public boolean cadastra(Candidato candidato) throws SQLException{
        String sql = "INSERT INTO CANDIDATO(matricula, nome, email, senha, curso, ano_entrada) VALUES (?,?,?,?,?,?)" ; 
        PreparedStatement ps = getConexao().prepareStatement(sql);
        
        ps.setInt(1, candidato.getMatricula());
        ps.setString(2, candidato.getNome());
        ps.setString(3, candidato.getEmail());
        ps.setString(4, candidato.getSenha());
        ps.setString(5, candidato.getCurso());
        ps.setFloat(6, candidato.getAno_entrada());
        
        return ps.executeUpdate() == 1;
    }    

    public Candidato getCandidato(String email, String senha) throws DadoInvalidoException{
        try {
            String sql = "SELECT matricula, nome, curso, ano_entrada FROM CANDIDATO WHERE email=? AND senha=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                rs.next();
                int matricula = rs.getInt(1);
                String nome = rs.getString(2);
                String curso = rs.getString(3);
                float ano_entrada = rs.getFloat(4);
                return new Candidato(nome, email, senha, matricula, curso, ano_entrada);
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. CandidatoDAO");    
        }
        return null;
    }
    
}
