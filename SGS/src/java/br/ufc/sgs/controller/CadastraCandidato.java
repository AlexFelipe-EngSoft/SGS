/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.controller;

import br.ufc.sgs.dao.CandidatoDAO;
import br.ufc.sgs.dao.ConexaoFactory;
import br.ufc.sgs.model.exceptions.DadoInvalidoException;
import br.ufc.sgs.model.usuarios.Candidato;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexf
 */
public class CadastraCandidato implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getParameter("termo") == null) return "cadastro.jsp?erro=true";
        ConexaoFactory conexao = new ConexaoFactory();
        try{
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            String curso = request.getParameter("curso");
            float ano_entrada = Float.parseFloat(request.getParameter("ano_entrada"));
            
            Candidato candidato = new Candidato(nome, email, senha, matricula, curso, ano_entrada);
            CandidatoDAO candidatoDAO = new CandidatoDAO(conexao.abreConexao());
            
            if(candidatoDAO.cadastra(candidato)){
                request.getSession().setAttribute("usuario", candidato);
                return "/WEB-INF/jsp_candidato/principal.jsp";
            }
            
        }catch(DadoInvalidoException | NumberFormatException ex){
            return "cadastro.jsp?erro=true";
        }finally{
            conexao.fechaConexao();
        }
        return "cadastro.jsp?erro=true";
    }
    
}
