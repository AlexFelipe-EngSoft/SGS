<%-- 
    Document   : cabecalho
    Created on : 13/05/2017, 18:45:00
    Author     : alexf
--%>

<%@page import="br.ufc.sgs.model.usuarios.Candidato"%>
<%@page import="br.ufc.sgs.model.usuarios.Avaliador"%>
<%@page import="br.ufc.sgs.model.usuarios.Gerente"%>
<%@page import="br.ufc.sgs.model.usuarios.Usuario"%>
<!DOCTYPE html>
<div id="div_cabecalho">

</div>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if(usuario != null){
        
    }else if(usuario instanceof Gerente){
        
    }else if(usuario instanceof Avaliador){
        
    }else if(usuario instanceof Candidato){
        
    }else{
        
    }
%>
