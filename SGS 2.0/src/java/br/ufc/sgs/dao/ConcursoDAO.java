/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import br.ufc.sgs.model.concurso.Concurso;
import br.ufc.sgs.model.concurso.Documento;
import br.ufc.sgs.model.concurso.Fase;
import br.ufc.sgs.model.concurso.Selecao;
import java.io.File;
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
public class ConcursoDAO extends ExecutaSQL{
    
    public ConcursoDAO(Connection conexao) {
        super(conexao);
    }
    
    public void cadastraConcurso(Concurso concurso){
        
    }
    public void atualizaConcurso(Concurso concurso){
        
    }
    public Concurso consultaConcurso(int id_concurso){
        try {
            String sql = "SELECT titulo, descricao, id_edital, preRequisitos, maisInformacoes, isDivulgado, id_gerente FROM CONCURSO WHERE id = ?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, id_concurso);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                Documento edital = new DocumentoDAO(getConexao()).getDocumento(rs.getInt("id_edital"));
                String preRequisitos = rs.getString("preRequisitos");
                String maisInformacoes = rs.getString("maisInformacoes");
                boolean isDivulgado = rs.getBoolean("isDivulgado");
                Collection<Documento> documentos = new DocumentoDAO(getConexao()).getDocumentosDoConcurso(id_concurso);
                Collection<Selecao> selecoes = new SelecaoDAO(getConexao()).getSelecoesDoConcurso(id_concurso);
                Collection<Fase> fases = new FaseDAO(getConexao()).getFasesDoConcurso(id_concurso);
                return new Concurso(titulo, descricao, edital, preRequisitos, maisInformacoes, isDivulgado, documentos, selecoes, fases);
            }
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. ConcursoDAO");    
        }
        return null;         
    }
    public ArrayList<Concurso> getConcursos(){
        try {
            String sql = "SELECT id, titulo, descricao, id_edital, preRequisitos, maisInformacoes, isDivulgado, id_gerente FROM CONCURSO";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Concurso> concursos = new ArrayList<>();
            while(rs.next()){
                int id_concurso = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                Documento edital = new DocumentoDAO(getConexao()).getDocumento(rs.getInt("id_edital"));
                String preRequisitos = rs.getString("preRequisitos");
                String maisInformacoes = rs.getString("maisInformacoes");
                boolean isDivulgado = rs.getBoolean("isDivulgado");
                Collection<Documento> documentos = new DocumentoDAO(getConexao()).getDocumentosDoConcurso(id_concurso);
                Collection<Selecao> selecoes = new SelecaoDAO(getConexao()).getSelecoesDoConcurso(id_concurso);
                Collection<Fase> fases = new FaseDAO(getConexao()).getFasesDoConcurso(id_concurso);
                concursos.add(new Concurso(id_concurso, titulo, descricao, edital, preRequisitos, maisInformacoes, isDivulgado, documentos, selecoes, fases));
            }
            return concursos;
        } catch (SQLException ex) {
            System.err.println("Erro com a sintaxe SQL no metodo de consulta. ConcursoDAO");    
        }
        return null;         
    }    
}
