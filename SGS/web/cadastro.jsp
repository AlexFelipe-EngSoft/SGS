<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGS - Sistema de Gerenciamento de Seleções</title>
        <link rel="shortcut icon" href="img/brasao.ico" />
        
        <link rel='stylesheet' href='css/default.css'/>
        <link rel='stylesheet' href='css/inputs.css'/>
        <link rel='stylesheet' href='css/struct.css'/>
    </head>
    <body>
        <div id='div_content'>
            <jsp:include page="cabecalho.jsp"/>
            <div id="div_corpo">
                <form class="form_registro" method="POST" action="ServletController">
                    <input type='hidden' value='CadastraCandidato' name='acao'>
                    <table>
                        <thead>
                            <tr>
                                <td colspan="2"><b>Inscreva-se</b></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr><td colspan="2"><input type="text" class="input_text" name="matricula" placeholder="Número de matrícula" maxlength="6"></td></tr>
                            <tr><td colspan="2"><input type="text" class="input_text" name="nome" placeholder="Nome do usuário"></td></tr>
                            <tr><td colspan="2"><input type="text" class="input_text" name="email" placeholder="E-mail"></td></tr>
                            <tr><td colspan="2"><input type="text" class="input_text" name="curso" placeholder="Nome do curso"></td></tr>
                            <tr><td colspan="2"><input type="text" class="input_text" name="ano_entrada" placeholder="Ano de entrada"></td></tr>
                            <tr><td colspan="2"><input type="password" class="input_text" name="senha" placeholder="Senha"></td></tr>
                        </tbody>
                        <tfoot>
                            <tr><td colspan="2">
                                    <p>
                                        <input type='checkbox'name='termo'/>
                                        Eu concordo com as Condições de serviço e dou consentimento para a coleta, o processamento e uso de meus dados pessoais, como descrito com mais detalhes na Declaração de privacidade. 
                                    </p>      
                                </td></tr>
                            <tr>
                                <td ><input type="button" class="input_button" value="Cancelar"></td>
                                <td><input type="submit" class="input_button input_submit" value="Inscreva-se"></td>
                            </tr>
                        </tfoot>
                    </table>
                </form>               
            </div>
            <jsp:include page="rodape.jsp"/>       
        </div>
</html>
