/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.exceptions.DadoInvalidoException;
import br.ufc.sgs.modelo.usuario.Candidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexf
 */
public class CandidatoDAO extends ExecutaSQL{
    
    public CandidatoDAO(Connection conexao) {
        super(conexao);
    }
    
    public boolean cadastra(Candidato candidato) throws SQLException{
        String sql = "INSERT INTO CANDIDATO( matricula, nome, email, senha, curso, ano_entrada) VALUES (?,?,?,?,?,?)" ; 
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
                int matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");
                String curso = rs.getString("curso");
                float ano_entrada = rs.getFloat("ano_entrada");
                return new Candidato(nome, email, senha, matricula, curso, ano_entrada);
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta 1. CandidatoDAO");    
        }
        return null;
    }

    public Candidato getCandidato(int matricula) throws DadoInvalidoException {
        try {
            String sql = "SELECT 'matricula' , 'nome' , 'email' , 'senha' , 'curso' , 'ano_entrada' FROM 'candidato' WHERE matricula = ?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, matricula);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String curso = rs.getString("curso");
                float ano_entrada = rs.getFloat("ano_entrada");
                return new Candidato(nome, email, senha, matricula, curso, ano_entrada);
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta 2. CandidatoDAO");    
        }
        return null;
    }
    
}
