/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.concursos.*;
import java.io.File;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexf
 */
public class ConcursoDAO extends ExecutaSQL{
    
    public ConcursoDAO(Connection conexao) {
        super(conexao);
    }
    
    public ArrayList<Concurso> getConcursos(){
        try {
            String sql = "SELECT id, titulo, descricao, id_edital, preRequisitos, maisInformacoes, id_gerente FROM CONCURSO";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            ArrayList<Concurso> concursos = new ArrayList<>();
            while(rs != null){
                rs.next();
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String descricao = rs.getString(3);
                File edital = new EditalDAO(getConexao()).getFile(rs.getInt(4));
                String preRequisitos = rs.getString(5);
                String maisInformacoes = rs.getString(6);
                ArrayList<File> documentos = new DocumentoDAO(getConexao()).getAllDocumentosConcurso(id);
                ArrayList<Fase> fases = new FaseDAO(getConexao()).getAllFasesConcurso(id);
                ArrayList<Selecao> selecoes = new SelecaoDAO(getConexao()).getAllSelecaoConcurso(id);
                concursos.add(new Concurso(titulo, descricao, edital, preRequisitos, maisInformacoes, documentos, fases, selecoes));
                return concursos;
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. CandidatoDAO");    
        }
        return null;        
    }
    public static void main(String[] args) {
        ConexaoFactory c = new ConexaoFactory();
        ConcursoDAO cd = new ConcursoDAO(c.abreConexao());
        System.out.println(cd.getConcursos().get(1).toString());
        c.fechaConexao();
    }
}
