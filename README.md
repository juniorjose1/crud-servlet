## CRUD SERVLET JSP

CRUD completo de Empresas utilizando Servlet e JSP.

Caracterísitcas:
- Padrão MVC
- Autenticação
- Validação de Sessão
- Filtros
- Monitoramento de tempo de execução de Actions
- Envio de Dados em formato JSON ou XML(WebService)

Bibliotecas:
- JSTL(Java Standard Tag Library)
- GSON
- XStream

Para representar o banco de dados foi utilizado um ArrayList.

Exemplo de teste de URLs:
- localhost:8080/cadastro/entrada?acao=ListaEmpresas
- /cadastro/entrada?acao=NovaEmpresaForm
- /cadastro/entrada?acao=LoginForm

Logins cadastrados:
- Login: alexandre | Senha: 12345
- Login: vitor | Senha: 123
