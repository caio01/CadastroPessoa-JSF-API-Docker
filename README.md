# CadastroPessoa-JSF-API-Docker

Esse projeto consiste na criação de:

    • Um CRUD de pessoa (Aplicação-WEB)
    • Consulta em api externa (ViaCep), para os dados do endereço (Aplicação-WEB)
    • Salvamento na base de dados (Aplicação-WEB e API)
    • Envio da pessoa para uma fila interna (JMS) (Aplicação-WEB)
    • Envio da pessoa para essa API
    • Criação de um endpoint de consumo de informações da pessoa (pelo CPF)

## Demonstração de Funcionamento
![chrome_fZa1vDXDfm][demo-funcionamento]


## Repositórios

[ Ambiente 2 - API ][link-api] 

[ Servidor WildFly da API ][server-api] 

[ Banco de dados da API (Docker) ][banco-api] 

Foram implementadas duas aplicações:  
Uma [aplicação WEB][aplicacao-web], usado no cadastro e consulta da pessoa;  
E essa API que apenas disponibilizará endpoints REST para registro das pessoas. 


## Regras de Negócio
Todas as Regras de Negócio estão descritas [aqui][regras-de-negocio].
 


# Instruções para Execução do Projeto

## Versão JDK
Utilizar a versão mais recente.

## Download da IDE
Baixar e descompactar o Eclipse:

- [Windows][eclipse-windows]
- [Linux][eclipse-linux]
- [Mac][eclipse-mac]

Iniciar o Eclipse escolhendo uma workspace de sua preferência.

*Fique a vontade para usar outras IDE, com o IntelliJ ou VSCode.*

## Download do Servidor de aplicação 
Fazer o download do servidor de aplicação (Wildfly) pré-configurado [aqui][server-api] e extrair em um local apropriado.

## Clone do repositório do projeto

Clonar esse repositório dentro da pasta do workspace utilizado no Eclipse.

## Clone do repositório do banco de dados

Instalar o docker: https://www.docker.com/get-started > Docker Desktop

O banco de dados é criado via docker e o fonte está disponível [aqui][banco-api]

Apos o clone, ir via terminal na pasta extraida e executar o banco pelo docker: `docker-compose up -d`

OBS: Se atentar que não pode haver nenhum servidor postgres rodando na máquina, se tiver, necessário fechar todos os serviços, assim como
qualquer outro serviço que esteja utilizando a porta 5433 (ou trocar a porta no arquivo docker-compose.yaml da aplicação).  
Para verificar se o docker subiu corretamente, realizar a conexão com o banco:
- host: localhost
- port: 5433
- database: ist-api
- user: ist
- password: ist

## Configuração da IDE

### Eclipse
- Ir em "File > Import..." e escolher a opção conforme segue:

  ![image][inst-1]

- Selecionar a pasta do projeto e confirmar como segue:

  ![image][inst-2]

- Em *Select root repository* escolher a pasta do projeto e clicar em *Finish*.
- Ir no menu "Window > Preferences" e Adicionar um novo *Runtime Environment* conforme segue:

  ![image][inst-3]

  - Nesse momento será feito o download dos arquivos necessários para que o *Ecplise* consiga usar o servidor de aplicação Wildfly.
  - A instalação será feita em segundo plano (verificar barra de status).
  - Confirmar, caso haja, alguma tela de confirmação e reiniciar o *Eclipse ao final do processo*.

- Na aba "Servers" clicar em *No server are available. Click this link to create a new server...* como segue:

  ![image][inst-4]

- Na etapa de criação do servidor, selecionar a pasta do servidor baixado anteriormente. Como por exemplo:

  ![image][inst-5]

- Na próxima etapa, adicionar o projeto ficando dessa forma:

  ![image][inst-6]

- Finalizar em *Finish*.

- Subir o servidor em modo *Debug* no botão à seguir:

  ![image][inst-7]

- Utilizando algum software de consumo de API (ex.: Postman), digite a seguinte URL: http://localhost:8081/pessoa

  ![image][inst-8]


### IntelliJ

- Ir em File -> New -> Project from Existing Sources...

- Selecionar o arquivo pom.xml, na raiz do projeto

- Adicionar uma nova configuração

  ![image][inst-9]

- Selecionar a pasta do servidor

  ![image][inst-10]

  *Note que essa configuração pode conflitar com o repositorio API. Assim, basta mudar o nome do Server.*

  *O caminho do servidor muda de acordo com o local baixado, e nome da pasta. Nesse caso, deveria ser ..../wildfly-19.1.0.Final-ProvaJavaPleno-Web*

- Adicionar o artefato

  ![image][inst-11]

- Selecionar Exploded

  ![image][inst-12]

- Executar o servidor

  ![image][inst-13]

- Utilizando algum software de consumo de API (ex.: Postman), ou no seu navegador, digite a seguinte URL: http://localhost:8081/pessoa

  ![image][inst-8]



[demo-funcionamento]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/ff8a8321-842c-4cd1-be5f-c2c4c912338e
[link-api]: https://github.com/caio01/CadastroPessoa-JSF-API-Docker/tree/main/CadastroPessoaAPI
[server-api]: https://github.com/caio01/CadastroPessoa-JSF-API-Docker/tree/main/wildfly-19.1-API
[banco-api]: https://github.com/caio01/CadastroPessoa-JSF-API-Docker/tree/main/banco-api
[aplicacao-web]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker
[regras-de-negocio]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker#regras-de-neg%C3%B3cio
[img-processo-integracao]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/000ed0ab-3253-4efc-80b6-ddbff266d054
[img-post]:https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/19d058ca-6121-4993-8740-94e3fd5aa687
[img-put]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/684b7167-19c3-43fa-984a-47fd90b2ab68
[img-get]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/e921fd8e-fe76-4caa-815a-4850d77a7417
[img-delete]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/96581638-d3f0-410f-b3cb-20701a92b92a
[img-esquema-banco]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/31099735-4c3c-4806-854f-f87350770252

[eclipse-windows]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip
[eclipse-linux]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-linux-gtk-x86_64.tar.gz
[eclipse-mac]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-macosx-cocoa-x86_64.dmg

[inst-1]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/0d3b5cd3-9fa7-47d4-b2ae-5e9508d9db07
[inst-2]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/d56a7518-d58f-4e11-b5a2-4e4c4ecd351e
[inst-3]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/d6249d32-9127-4351-9061-221f2a8197dc
[inst-4]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/79b55c9a-968b-490a-8463-94b879d0d618
[inst-5]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/f21d8273-9a78-4931-a211-9ad6ee9415ee
[inst-6]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/1f839881-f2b9-4486-aabf-6c2552b1fd51
[inst-7]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/63453a59-07a2-489f-907b-31449e890c57
[inst-8]: https://github.com/caio01/CadastroPessoa-JSF-API-Docker/assets/49879702/b4308eb0-9e84-4e32-9606-cab0e193f3c4
[inst-9]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/5a76cadc-0697-4fdd-ac37-97b21ebacf01
[inst-10]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/dd593fbe-5dd6-4e35-990a-57c6e2097a61
[inst-11]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/06cc685a-e68c-4e67-9041-2aa5fdd21e98
[inst-12]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/5c31eb6c-0dc9-4430-bde8-8623a5bace69
[inst-13]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/3d94b09d-812b-46ab-b875-993ca2aa4a27














#### Créditos pelo Desenvolvimento do case: Senai SC / FIESC
