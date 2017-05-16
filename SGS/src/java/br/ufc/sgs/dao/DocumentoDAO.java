/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexf
 */
public class DocumentoDAO extends ExecutaSQL{
    
    public DocumentoDAO(Connection conexao) {
        super(conexao);
    }
    public boolean insertFile( File f ){
        try {
            PreparedStatement ps = getConexao().prepareStatement("INSERT INTO documento(nome, arquivo ) VALUES (?, ? )");

            //converte o objeto file em array de bytes
            InputStream is = new FileInputStream( f );
            byte[] bytes = new byte[(int)f.length() ];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                   && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
                offset += numRead;
            }

            ps.setString( 1, f.getName() );
            ps.setBytes( 2, bytes );
            ps.execute();
            ps.close();
            return true;

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public File getFile( int id ){
        File f = null;
        try {
            PreparedStatement ps = getConexao().prepareStatement("SELECT id, nome, arquivo FROM documento WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ){
                byte [] bytes = rs.getBytes("arquivo");
                String nome = rs.getString("nome");

                //converte o array de bytes em file
                f = new File( "C:\\Users\\alexf\\Desktop\\Teste\\" + nome );
                FileOutputStream fos = new FileOutputStream( f);
                fos.write( bytes );
                fos.close();
            }
            rs.close();
            ps.close();
            return f;
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        catch (IOException ex) {
        ex.printStackTrace();
        }
    return null;
    }    
    
}
