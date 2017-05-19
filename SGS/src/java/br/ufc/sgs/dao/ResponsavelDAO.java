/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.usuarios.Gerente;
import br.ufc.sgs.model.usuarios.Responsavel;
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
public class ResponsavelDAO extends ExecutaSQL{

    public ResponsavelDAO(Connection conexao) {
        super(conexao);
    }

    public Responsavel getResponsavel(int id) {
        try {
            String sql = "SELECT id_responsavel, tipo FROM gerente WHERE id_responsavel = ?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                rs.next();
                int id_responsavel = rs.getInt(1);
                String tipo = rs.getString(2);
                return (Responsavel) Class.forName("br.ufc.sgs.usuarios."+ tipo).newInstance();
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. GerenteDAO");    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ResponsavelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }
    
}
