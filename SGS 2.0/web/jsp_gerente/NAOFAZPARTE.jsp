<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>SGS - Sistema de Gerenciamento de Sele��es</title>
  <link rel="stylesheet" href="../theme/stylesheets/base.css" type="text/css" media="screen" />
  <link rel="stylesheet" id="current-theme" href="../theme/stylesheets/themes/default/style.css" type="text/css" media="screen" />
  <script type="text/javascript" charset="utf-8" src="../theme/javascripts/jquery-1.3.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="../theme/javascripts/jquery.scrollTo.js"></script>
  <script type="text/javascript" charset="utf-8" src="../theme/javascripts/jquery.localscroll.js"></script>
  
  <script type="text/javascript" charset="utf-8">
    // <![CDATA[
    var Theme = {
      activate: function(name) {
        window.location.hash = 'themes/' + name
        Theme.loadCurrent();
      },

      loadCurrent: function() {
        var hash = window.location.hash;
        if (hash.length > 0) {
          matches = hash.match(/^#themes\/([a-z0-9\-_]+)$/);
          if (matches && matches.length > 1) {
            $('#current-theme').attr('href', 'stylesheets/themes/' + matches[1] + '/style.css');
          } else {
            alert('theme not valid');
          }
        }
      }
    }

    $(document).ready(function() {
      Theme.loadCurrent();
      $.localScroll();
      $('.table :checkbox.toggle').each(function(i, toggle) {
        $(toggle).change(function(e) {
          $(toggle).parents('table:first').find(':checkbox:not(.toggle)').each(function(j, checkbox) {
            checkbox.checked = !checkbox.checked;
          })
        });
      });
    });
    // ]]>
  </script>
</head>
<body>
    <div id="container">
    <%@include file="cabecalho.jsp" %>
    <div id="wrapper" class="wat-cf">
        <div id="main">
            
            <!-- BLOCO DE TEXTO
            <div class="block" id="block-text">
                <div class="secondary-navigation">
                    <ul class="wat-cf">
                      <li class="active first"><a href="#block-text">Text</a></li>
                      <li><a href="#block-tables">Tables</a></li>
                      <li><a href="#block-forms">Forms</a></li>
                      <li><a href="#block-messages">Messages</a></li>
                      <li><a href="#block-forms-2">2 Columns Forms</a></li>
                      <li><a href="#block-lists">Lists</a></li>
                    </ul>
                </div>
                <div class="content">
                  <h2 class="title">Text</h2>
                  <div class="inner">
                    <p class="first">
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. <span class="hightlight">Excepteur sint occaecat cupidatat non proident</span>, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    </p>
                    <p> <span class="small">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore</span></p>
                    <p> <span class="gray">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore</span></p>
                    <hr />
                    <p>
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. <span class="hightlight">Excepteur sint occaecat cupidatat non proident</span>, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    </p>
                  </div>
                </div>
            </div>
            -->

            <!-- TABELA 
            <div class="block" id="block-tables">
              <div class="secondary-navigation">
                <ul class="wat-cf">
                  <li class="first"><a href="#block-text">Text</a></li>
                  <li class="active"><a href="#block-tables">Tables</a></li>
                  <li><a href="#block-forms">Forms</a></li>
                  <li><a href="#block-messages">Messages</a></li>
                  <li><a href="#block-forms-2">2 Columns Forms</a></li>
                  <li><a href="#block-lists">Lists</a></li>
                </ul>
              </div>
              <div class="content">
                <h2 class="title">Tables</h2>
                <div class="inner">
                  <form action="#" class="form">
                    <table class="table">
                      <tr>
                        <th class="first"><input type="checkbox" class="checkbox toggle" /></th>
                        <th>ID</th>
                        <th>Login</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th class="last">&nbsp;</th>
                      </tr>
                      <tr class="odd">
                        <td><input type="checkbox" class="checkbox" name="id" value="1" /></td><td>1</td><td>hulk</td><td>Hulk</td><td>Hogan</td><td class="last"><a href="#">show</a> | <a href="#">edit</a> | <a href="#">destroy</a></td>
                      </tr>
                      <tr class="even">
                        <td><input type="checkbox" class="checkbox" name="id" value="1" /></td><td>2</td><td>ultimate</td><td>Ultimate</td><td>Warrior</td><td class="last"><a href="#">show</a> | <a href="#">edit</a> | <a href="#">destroy</a></td>
                      </tr>
                      <tr class="odd">
                        <td><input type="checkbox" class="checkbox" name="id" value="1" /></td><td>3</td><td>andre</td><td>Andre</td><td>The Giant</td><td class="last"><a href="#">show</a> | <a href="#">edit</a> | <a href="#">destroy</a></td>
                      </tr>
                      <tr class="even">
                        <td><input type="checkbox" class="checkbox" name="id" value="1" /></td><td>4</td><td>machoman</td><td>Macho Man</td><td>Randy Savage</td><td class="last"><a href="#">show</a> | <a href="#">edit</a> | <a href="#">destroy</a></td>
                      </tr>
                    </table>
                    <div class="actions-bar wat-cf">
                      <div class="actions">
                        <button class="button" type="submit">
                          <img src="images/icons/cross.png" alt="Delete" /> Delete
                        </button>
                      </div>
                      <div class="pagination">
                        <span class="disabled prev_page">� Previous</span><span class="current">1</span><a rel="next" href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">7</a><a href="#">8</a><a href="#">9</a><a href="#">10</a><a href="#">11</a><a rel="next" class="next_page" href="#">Next �</a>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            -->
 
            <!-- FORMULARIO
            <div class="block" id="block-forms">
              <div class="secondary-navigation">
                <ul class="wat-cf">
                  <li class="first"><a href="#block-text">Text</a></li>
                  <li><a href="#block-tables">Tables</a></li>
                  <li class="active"><a href="#block-forms">Forms</a></li>
                  <li><a href="#block-messages">Messages</a></li>
                  <li><a href="#block-forms-2">2 Columns Forms</a></li>
                  <li><a href="#block-lists">Lists</a></li>
                </ul>
              </div>
              <div class="content">
                <h2 class="title">Forms</h2>
                <div class="inner">
                  <form action="#" method="get" class="form">
                    <div class="group">
                      <label class="label">Text field</label>
                      <input type="text" class="text_field" />
                      <span class="description">Ex: a simple text</span>
                    </div>
                    <div class="group">
                      <div class="fieldWithErrors">
                        <label class="label" for="post_title">Title</label>
                        <span class="error">can't be blank</span>
                      </div>
                      <input type="text" class="text_field" />
                      <span class="description">Ex: a simple text</span>
                    </div>
                    <div class="group">
                      <label class="label">Text area</label>
                      <textarea class="text_area" rows="10" cols="80"></textarea>
                      <span class="description">Write here a long text</span>
                    </div>
                    <div class="group navform wat-cf">
                      <button class="button" type="submit">
                        <img src="images/icons/tick.png" alt="Save" /> Save
                      </button>
                      <span class="text_button_padding">or</span>
                      <a class="text_button_padding link_button" href="#header">Cancel</a>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            -->
            <!-- MENSAGENS
            <div class="block" id="block-messages">
          <div class="secondary-navigation">
            <ul class="wat-cf">
              <li class="first"><a href="#block-text">Text</a></li>
              <li><a href="#block-tables">Tables</a></li>
              <li><a href="#block-forms">Forms</a></li>
              <li class="active"><a href="#block-messages">Messages</a></li>
              <li><a href="#block-forms-2">2 Columns Forms</a></li>
              <li><a href="#block-lists">Lists</a></li>
            </ul>
          </div>
          <div class="content">
            <h2 class="title">Messages</h2>
            <div class="inner">
              <div class="flash">
                <div class="message error">
                  <p>Error message</p>
                </div>
                <div class="message warning">
                  <p>Warning message</p>
                </div>
                <div class="message notice">
                  <p>Notice message</p>
                </div>
              </div>
            </div>
          </div>
        </div>
            -->
            
            <!--  OUTRO FORMUL�RIO
            <div class="block" id="block-forms-2">
          <div class="secondary-navigation">
            <ul class="wat-cf">
              <li class="first"><a href="#block-text">Text</a></li>
              <li><a href="#block-tables">Tables</a></li>
              <li><a href="#block-forms">Forms</a></li>
              <li><a href="#block-messages">Messages</a></li>
              <li class="active"><a href="#block-forms-2">2 Columns Forms</a></li>
              <li><a href="#block-lists">Lists</a></li>
            </ul>
          </div>
          <div class="content">
            <h2 class="title">2 columns forms</h2>
            <div class="inner">
              <form action="#" method="get" class="form">
                <div class="columns wat-cf">
                  <div class="column left">
                    <div class="group">
                      <label class="label">Text field</label>
                      <input type="text" class="text_field" />
                    </div>
                    <div class="group">
                      <label class="label">Text area</label>
                      <textarea class="text_area" rows="10" cols="80"></textarea>
                    </div>
                  </div>
                  <div class="column right">
                    <div class="group">
                      <label class="label">Select</label>
                      <select><option value="1">Choose...</option></select>
                    </div>
                    <div class="group">
                      <label class="label">Check box</label>
                      <div>
                        <input type="checkbox" name="checkbox" id="checkbox_1" class="checkbox" value="1" /> <label for="checkbox_1" class="checkbox">Option 1</label>
                      </div>
                      <div>
                        <input type="checkbox" name="checkbox" id="checkbox_2" class="checkbox" value="2" /> <label for="checkbox_2" class="checkbox">Option 2</label>
                      </div>
                    </div>
                    <div class="group">
                      <label class="label">Radio</label>
                      <div>
                        <input type="radio" name="radio" id="radio_1" class="checkbox" value="1" /> <label for="radio_1" class="radio">Option 1</label>
                      </div>
                      <div>
                        <input type="radio" name="radio" id="radio_2" class="checkbox" value="2" /> <label for="radio_2" class="radio">Option 2</label>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="group navform wat-cf">
                  <button class="button" type="submit">
                    <img src="images/icons/tick.png" alt="Save" /> Save
                  </button>
                  <span class="text_button_padding">or</span>
                  <a class="text_button_padding link_button" href="#header">Cancel</a>
                </div>
              </form>
            </div>
          </div>
        </div>
            -->
            
            <!-- LISTA
            <div class="block" id="block-lists">
          <div class="secondary-navigation">
            <ul class="wat-cf">
              <li class="first"><a href="#block-text">Text</a></li>
              <li><a href="#block-tables">Tables</a></li>
              <li><a href="#block-forms">Forms</a></li>
              <li><a href="#block-messages">Messages</a></li>
              <li><a href="#block-forms-2">2 Columns Forms</a></li>
              <li class="active"><a href="#block-lists">Lists</a></li>
            </ul>
          </div>
          <div class="content">
            <h2 class="title">Lists</h2>
            <div class="inner">
              <ul class="list">
                <li>
                  <div class="left">
                    <a href="#"><img class="avatar" src="images/avatar.png" alt="avatar" /></a>
                  </div>
                  <div class="item">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                  </div>
                </li>
                <li>
                  <div class="left">
                    <a href="#"><img class="avatar" src="images/avatar.png" alt="avatar" /></a>
                  </div>
                  <div class="item">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                  </div>
                </li>
                <li>
                  <div class="left">
                    <a href="#"><img class="avatar" src="images/avatar.png" alt="avatar" /></a>
                  </div>
                  <div class="item">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
            -->
            
            <div id="footer">
              <div class="block">
                <p>Copyright &copy; 2010 Your Site.</p>
              </div>
            </div>
        </div>
        
        <div id="sidebar">
        
          <!-- OPCOES LATERAIS
          
          <div class="block">
            <ul class="navigation">
              <li><a href="#" onclick="Theme.activate('default'); return false;">Default</a></li>
              <li><a href="#" onclick="Theme.activate('red'); return false;">Red</a></li>
              <li><a href="#" onclick="Theme.activate('amro'); return false;">Amro</a></li>
              <li><a href="#" onclick="Theme.activate('bec'); return false;">Bec</a></li>
              <li><a href="#" onclick="Theme.activate('bec-green'); return false;">Bec-Green</a></li>
              <li><a href="#" onclick="Theme.activate('blue'); return false;">Blue</a></li>
              <li><a href="#" onclick="Theme.activate('djime-cerulean'); return false;">Djime-Cerulean</a></li>
              <li><a href="#" onclick="Theme.activate('drastic-dark'); return false;">Drastic Dark</a></li>
              <li><a href="#" onclick="Theme.activate('kathleene'); return false;">Kathleene</a></li>
              <li><a href="#" onclick="Theme.activate('olive'); return false;">Olive</a></li>
              <li><a href="#" onclick="Theme.activate('orange'); return false;">Orange</a></li>
              <li><a href="#" onclick="Theme.activate('reidb-greenish'); return false;">Greenish</a></li>
              <li><a href="#" onclick="Theme.activate('warehouse'); return false;">Warehouse</a></li>
            </ul>
          </div>
            <div class="block">
            <h3>Sidebar</h3>
              <ul class="navigation">
                <li><a href="#block-text">Text</a></li>
                <li><a href="#block-tables">Tables</a></li>
                <li><a href="#block-forms">Forms</a></li>
                <li><a href="#block-messages">Messages</a></li>
                <li><a href="#block-forms-2">2 Columns Forms</a></li>
                <li><a href="#block-lists">Lists</a></li>
              </ul>
          </div>
          -->
        
            
            <!-- BLOCO DE ALERTA (Noticia)
            <div class="block notice">
          <h4>Notice Title</h4>
          <p>Morbi posuere urna vitae nunc. Curabitur ultrices, lorem ac aliquam blandit, lectus eros hendrerit eros, at eleifend libero ipsum hendrerit urna. Suspendisse viverra. Morbi ut magna. Praesent id ipsum. Sed feugiat ipsum ut felis. Fusce vitae nibh sed risus commodo pulvinar. Duis ut dolor. Cras ac erat pulvinar tortor porta sodales. Aenean tempor venenatis dolor.</p>
        </div>
            -->
            <!-- BLOCO DE NOTICIA SIMPLES
            <div class="block">
          <div class="sidebar-block">
            <h4>Sidebar Inner block Title</h4>
            <p>Morbi posuere urna vitae nunc. Curabitur ultrices, lorem ac <a href="#">aliquam blandit</a>, lectus eros hendrerit eros, at eleifend libero ipsum hendrerit urna. Suspendisse viverra. Morbi ut magna. Praesent id ipsum. Sed feugiat ipsum ut felis. Fusce vitae nibh sed risus commodo pulvinar. Duis ut dolor. Cras ac erat pulvinar tortor porta sodales. Aenean tempor venenatis dolor.</p>
          </div>
        </div>
            -->
      </div>
    </div>
    <div id="box">
      <!-- Login
        <div class="block" id="block-login">
        <h2>Login Box</h2>
        <div class="content login">
          <div class="flash">
            <div class="message notice">
              <p>Logged in successfully</p>
            </div>
          </div>
          <form action="#" class="form login">
            <div class="group wat-cf">
              <div class="left">
                <label class="label right">Login</label>
              </div>
              <div class="right">
                <input type="text" class="text_field" />
              </div>
            </div>
            <div class="group wat-cf">
              <div class="left">
                <label class="label right">Password</label>
              </div>
              <div class="right">
                <input type="password" class="text_field" />
              </div>
            </div>
            <div class="group navform wat-cf">
              <div class="right">
                <button class="button" type="submit">
                  <img src="images/icons/key.png" alt="Save" /> Login
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
      -->
      
      <!-- CADASTRO
      <div class="block" id="block-signup">
        <h2>Sign up</h2>
        <div class="content">
          <form action="#" class="form">
            <div class="group wat-cf">
              <div class="left">
                <label class="label">Login</label>
              </div>
              <div class="right">
                <input type="text" class="text_field" />
                <span class="description">Ex: web-app-theme</span>
              </div>
            </div>
            <div class="group wat-cf">
              <div class="left">
                <label class="label">Email</label>
              </div>
              <div class="right">
                <input type="text" class="text_field" />
                <span class="description">Ex: test@example.com</span>
              </div>
            </div>
            <div class="group wat-cf">
              <div class="left">
                <label class="label">Password</label>
              </div>
              <div class="right">
                <input type="password" class="text_field" />
                <span class="description">Must contains the word 'yeah'</span>
              </div>
            </div>

            <div class="group">
              <label class="label">Text field</label>
              <input type="text" class="text_field" />
              <span class="description">Ex: a simple text</span>
            </div>
            <div class="group">
              <label class="label">Text field</label>
              <input type="text" class="text_field" />
              <span class="description">Ex: a simple text</span>
            </div>
            <div class="group navform wat-cf">
              <button class="button" type="submit">
                <img src="images/icons/tick.png" alt="Save" /> Signup
              </button>
            </div>
          </form>
        </div>
      </div>
      -->
    </div>
  </div>
</body>
</html>

