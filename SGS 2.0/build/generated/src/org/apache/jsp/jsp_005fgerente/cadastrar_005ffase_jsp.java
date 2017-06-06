package org.apache.jsp.jsp_005fgerente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.ufc.sgs.model.concurso.Selecao;
import br.ufc.sgs.model.concurso.Fase;
import br.ufc.sgs.model.concurso.Concurso;
import java.util.ArrayList;
import br.ufc.sgs.model.concurso.Concurso;
import java.util.ArrayList;
import br.ufc.sgs.dao.ConcursoDAO;
import br.ufc.sgs.dao.ConcursoDAO;
import br.ufc.sgs.dao.ConexaoFactory;

public final class cadastrar_005ffase_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/jsp_gerente/cabecalho.jsp");
    _jspx_dependants.add("/jsp_gerente/lateral.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"pt\">\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("  <title>SGS - Sistema de Gerenciamento de Seleções</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"../theme/stylesheets/base.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("  <link rel=\"stylesheet\" id=\"current-theme\" href=\"../theme/stylesheets/themes/default/style.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("  <script type=\"text/javascript\" charset=\"utf-8\" src=\"../theme/javascripts/jquery-1.3.min.js\"></script>\n");
      out.write("  <script type=\"text/javascript\" charset=\"utf-8\" src=\"../theme/javascripts/jquery.scrollTo.js\"></script>\n");
      out.write("  <script type=\"text/javascript\" charset=\"utf-8\" src=\"../theme/javascripts/jquery.localscroll.js\"></script>\n");
      out.write("  <link href=\"../jquery-ui/jquery-ui.css\" rel=\"stylesheet\"></link>\n");
      out.write("  \n");
      out.write("  <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("    // <![CDATA[\n");
      out.write("    var Theme = {\n");
      out.write("      activate: function(name) {\n");
      out.write("        window.location.hash = 'themes/' + name\n");
      out.write("        Theme.loadCurrent();\n");
      out.write("      },\n");
      out.write("\n");
      out.write("      loadCurrent: function() {\n");
      out.write("        var hash = window.location.hash;\n");
      out.write("        if (hash.length > 0) {\n");
      out.write("          matches = hash.match(/^#themes\\/([a-z0-9\\-_]+)$/);\n");
      out.write("          if (matches && matches.length > 1) {\n");
      out.write("            $('#current-theme').attr('href', 'stylesheets/themes/' + matches[1] + '/style.css');\n");
      out.write("          } else {\n");
      out.write("            alert('theme not valid');\n");
      out.write("          }\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    $(document).ready(function() {\n");
      out.write("      Theme.loadCurrent();\n");
      out.write("      $.localScroll();\n");
      out.write("      $('.table :checkbox.toggle').each(function(i, toggle) {\n");
      out.write("        $(toggle).change(function(e) {\n");
      out.write("          $(toggle).parents('table:first').find(':checkbox:not(.toggle)').each(function(j, checkbox) {\n");
      out.write("            checkbox.checked = !checkbox.checked;\n");
      out.write("          })\n");
      out.write("        });\n");
      out.write("      });\n");
      out.write("    });\n");
      out.write("    // ]]>\n");
      out.write("    \n");
      out.write("    function block_modificado(block){\n");
      out.write("        for(i = 1;i <= 5;i++)\n");
      out.write("            document.getElementById(\"item\"+i).className = \"desactive\";\n");
      out.write("        block.className = \"active\";\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"container\">\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

        if(request.getAttribute("listaConcursos") == null){
            ConexaoFactory conexao = new ConexaoFactory();
            ConcursoDAO concursoDAO = new ConcursoDAO(conexao.abreConexao());
            request.setAttribute("listaConcursos", concursoDAO.getConcursos());
            conexao.fechaConexao();
        }

      out.write("\n");
      out.write("<div id=\"header\">\n");
      out.write("      <h1><a href=\"index.html\">SGS - Sistema de Gerenciamento de Seleções</a></h1>\n");
      out.write("      <div id=\"user-navigation\">\n");
      out.write("        <ul class=\"wat-cf\">\n");
      out.write("          <li><a href=\"#\">Perfil</a></li>\n");
      out.write("          <li><a href=\"#\">Configurações</a></li>\n");
      out.write("          <li><a class=\"logout\" href=\"#\">Sair</a></li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"main-navigation\">\n");
      out.write("        <ul class=\"wat-cf\">\n");
      out.write("          <li class=\"active\"><a href=\"principal.jsp\">Página Inicial</a></li>\n");
      out.write("          <li class=\"\"><a href=\"#block-text\">Concursos</a></li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    <div id=\"wrapper\" class=\"wat-cf\">\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <div class=\"block\" id=\"block-forms\">\n");
      out.write("              <div class=\"content\">\n");
      out.write("                <h2 class=\"title\">Cadastrar Fase</h2>\n");
      out.write("                <div class=\"inner\">\n");
      out.write("                  <form action=\"../ServletController\" method=\"POST\" class=\"form\">\n");
      out.write("                    <input type=\"hidden\" name=\"acao\" value=\"CadastraFase\"/>\n");
      out.write("                    <input type=\"hidden\" name=\"id_concurso\" value=\"1\"/>\n");
      out.write("                    <div class=\"group\">\n");
      out.write("                        <label class=\"label\">Título</label>\n");
      out.write("                        <input type=\"text\" class=\"text_field\" style=\"width: 300px;\" name=\"titulo\"/>\n");
      out.write("                        <span class=\"description\">Ex: Fase 1: Inscrições</span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"group\">\n");
      out.write("                        <label class=\"label\">Descrição</label>\n");
      out.write("                        <textarea class=\"text_area\" rows=\"5\" cols=\"80\" name=\"descricao\"></textarea>\n");
      out.write("                        <span class=\"description\">Faça uma descrição breve sobre o que será abordado nesta fase do concurso</span>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"group\">\n");
      out.write("                        <label class=\"label\">Data de Início </label>\n");
      out.write("                        <input type=\"text\" class=\"text_field\" id=\"dataInicio\" style=\"width: 200px;\" name=\"dataInicio\"/>\n");
      out.write("                        <span class=\"description\">Selecione a data em que a fase será iniciada</span>\n");
      out.write("                    </div>\n");
      out.write("                      \n");
      out.write("                    <div class=\"group\">\n");
      out.write("                        <label class=\"label\">Data de Término </label>\n");
      out.write("                        <input type=\"text\" class=\"text_field\" id=\"dataTermino\" style=\"width: 200px;\" name=\"dataTermino\"/>\n");
      out.write("                        <span class=\"description\">Selecione a data em que a fase será finalizada</span>\n");
      out.write("                    </div>  \n");
      out.write("                    <div class=\"group\">\n");
      out.write("                        <label class=\"label\">Critério de Seleção </label>\n");
      out.write("                        <select class=\"text_field\" name=\"criterioDeSelecao\">\n");
      out.write("                            <option>Automático</option>\n");
      out.write("                        </select>\n");
      out.write("                        <span class=\"description\">Selecione qual será o critério de seleção desta fase</span>\n");
      out.write("                    </div>                        \n");
      out.write("                      <div class=\"group navform wat-cf\">\n");
      out.write("                      \n");
      out.write("                        <button class=\"button\" type=\"button\">\n");
      out.write("                            <img src=\"../theme/images/icons/cross.png\" alt=\"Cancelar\" /> Cancelar\n");
      out.write("                        </button>\n");
      out.write("                        <span class=\"text_button_padding\">ou</span>\n");
      out.write("                        <button class=\"button\" type=\"submit\">\n");
      out.write("                              <img src=\"../theme/images/icons/tick.png\" alt=\"Confirmar\" /> Confirmar\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                  </form>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>                                \n");
      out.write("            <div id=\"footer\">\n");
      out.write("              <div class=\"block\">\n");
      out.write("                <p>Copyright &copy; 2017 SGS- Sistema de Gerenciamento de Seleções.</p>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"sidebar\">\n");
      out.write("        ");
      out.write("    <div class=\"block notice\">\n");
      out.write("        <h4>Notice Title</h4>\n");
      out.write("        <p>Morbi posuere urna vitae nunc. Curabitur ultrices, lorem ac aliquam blandit, lectus eros hendrerit eros, at eleifend libero ipsum hendrerit urna. Suspendisse viverra. Morbi ut magna. Praesent id ipsum. Sed feugiat ipsum ut felis. Fusce vitae nibh sed risus commodo pulvinar. Duis ut dolor. Cras ac erat pulvinar tortor porta sodales. Aenean tempor venenatis dolor.</p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"block\">\n");
      out.write("      <ul class=\"navigation\">\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('default'); return false;\">Default</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('red'); return false;\">Red</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('amro'); return false;\">Amro</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('bec'); return false;\">Bec</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('bec-green'); return false;\">Bec-Green</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('blue'); return false;\">Blue</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('djime-cerulean'); return false;\">Djime-Cerulean</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('drastic-dark'); return false;\">Drastic Dark</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('kathleene'); return false;\">Kathleene</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('olive'); return false;\">Olive</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('orange'); return false;\">Orange</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('reidb-greenish'); return false;\">Greenish</a></li>\n");
      out.write("        <li><a href=\"#\" onclick=\"Theme.activate('warehouse'); return false;\">Warehouse</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("      <div class=\"block\">\n");
      out.write("      <h3>Sidebar</h3>\n");
      out.write("        <ul class=\"navigation\">\n");
      out.write("          <li><a href=\"#block-text\">Text</a></li>\n");
      out.write("          <li><a href=\"#block-tables\">Tables</a></li>\n");
      out.write("          <li><a href=\"#block-forms\">Forms</a></li>\n");
      out.write("          <li><a href=\"#block-messages\">Messages</a></li>\n");
      out.write("          <li><a href=\"#block-forms-2\">2 Columns Forms</a></li>\n");
      out.write("          <li><a href=\"#block-lists\">Lists</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("      <div class=\"block\">\n");
      out.write("    <div class=\"sidebar-block\">\n");
      out.write("      <h4>Sidebar Inner block Title</h4>\n");
      out.write("      <p>Morbi posuere urna vitae nunc. Curabitur ultrices, lorem ac <a href=\"#\">aliquam blandit</a>, lectus eros hendrerit eros, at eleifend libero ipsum hendrerit urna. Suspendisse viverra. Morbi ut magna. Praesent id ipsum. Sed feugiat ipsum ut felis. Fusce vitae nibh sed risus commodo pulvinar. Duis ut dolor. Cras ac erat pulvinar tortor porta sodales. Aenean tempor venenatis dolor.</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <script src=\"../jquery-ui/external/jquery/jquery.js\"></script>\n");
      out.write("    <script src=\"../jquery-ui/jquery-ui.js\"></script>     \n");
      out.write("    <script>\n");
      out.write("        $( \"#dataInicio\" ).datepicker({\n");
      out.write("            inline: true\n");
      out.write("        });\n");
      out.write("        $( \"#dataTermino\" ).datepicker({\n");
      out.write("            inline: true\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
