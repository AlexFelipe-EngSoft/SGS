/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.controller;

import br.ufc.sgs.dao.CandidatoDAO;
import br.ufc.sgs.dao.ConcursoDAO;
import br.ufc.sgs.dao.ConexaoFactory;
import br.ufc.sgs.model.concursos.Concurso;
import br.ufc.sgs.model.exceptions.DadoInvalidoException;
import br.ufc.sgs.model.usuarios.Candidato;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexf
 */
public class ListarConcursos implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ConexaoFactory conexao = new ConexaoFactory();
        try{
            ConcursoDAO concursoDAO = new ConcursoDAO(conexao.abreConexao());
            ArrayList<Concurso> concursos = concursoDAO.getConcursos();
            request.setAttribute("concursos", concursos);
            return "/WEB-INF/jsp/listaConcursos.jsp";
        }catch(NumberFormatException ex){
            return "index.jsp";
        }finally{
            conexao.fechaConexao();
        }
    }
    
}
