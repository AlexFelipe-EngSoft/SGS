/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.exceptions.DadoInvalidoException;
import br.ufc.sgs.model.usuarios.Avaliador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexf
 */
public class AvaliadorDAO extends ExecutaSQL{
    
    public AvaliadorDAO(Connection conexao) {
        super(conexao);
    }
    
    public Avaliador getAvaliador(String email, String senha) throws DadoInvalidoException{
        try {
            String sql = "SELECT nome FROM avaliador WHERE email=? AND senha=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                rs.next();
                String nome = rs.getString(1);
                return new Avaliador(nome, email, senha);
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. AvaliadorDAO");    
        }
        return null;
    }

    public Avaliador getAvaliador(int aInt) throws DadoInvalidoException {
        try {
            String sql = "SELECT nome, email, senha FROM avaliador WHERE id=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, aInt);
            
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                rs.next();
                String nome = rs.getString(1);
                String email = rs.getString(2);
                String senha = rs.getString(3);
                return new Avaliador(nome, email, senha);
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. AvaliadorDAO");    
        }
        return null;
    }
    
}
