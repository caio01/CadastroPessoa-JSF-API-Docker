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



[demo-funcionamento]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/e220c0ae-9824-46d7-a929-2d48bd36af9a
[link-api]: https://github.com/caio01/CadastroPessoa-JSF-API-Docker/tree/main/CadastroPessoaAPI
[server-api]: https://github.com/caio01/CadastroPessoa-JSF-API-Docker/tree/main/wildfly-19.1-API
[banco-api]: https://github.com/caio01/CadastroPessoa-JSF-API-Docker/tree/main/banco-api
[aplicacao-web]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker
[regras-de-negocio]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker#regras-de-neg%C3%B3cio
[img-processo-integracao]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/9596f8ca-bfde-4bf0-98d6-2cb0c7cf3fd5
[img-post]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/736794da-1ab7-482d-8f29-c77962a968a5
[img-put]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/f3a9b4ee-af3e-4a02-b3ef-cf717f25c6f1
[img-get]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/27b12596-ff02-4d72-aa09-fb28e4d5663e
[img-delete]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/b6e757ac-0ee4-4092-8b6b-2f3346eff873
[img-esquema-banco]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/e4fab17e-1a59-45de-85ad-7a391622023b

[eclipse-windows]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip
[eclipse-linux]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-linux-gtk-x86_64.tar.gz
[eclipse-mac]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-macosx-cocoa-x86_64.dmg

[inst-1]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/fb536041-faf4-4e90-98d3-3d6b4dcefa2c
[inst-2]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/8bb8fcef-db13-4a05-be9e-551a3fd650c9
[inst-3]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/4cdaf159-c8ba-4246-900e-dafa75dbd05d
[inst-4]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/ebda7813-116f-42f7-a68c-307eaa528e86
[inst-5]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/a2c2cfd7-1dee-453d-ae29-f4115c09b360
[inst-6]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/fc9a17e2-5150-4a3c-ad08-57230aab7c17
[inst-7]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/8477701b-7c9a-41aa-8b25-64fdcb4dc627
[inst-8]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/71a7ad37-e1e2-4932-a67b-b6234b616989
[inst-9]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/aeca69dc-65c2-4e28-8c45-bd6189a9567e
[inst-10]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/b760067c-b621-49bd-b06f-61728fa92182
[inst-11]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/ae26c309-4c48-468b-ae3a-94bf4d649e6a
[inst-12]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/de59049b-debd-4de4-8115-a7ddbda2ad51
[inst-13]: https://github.com/caio01/CadastroPessoa-JSF-Web-Docker/assets/49879702/1d2354f9-5486-4aa0-8a5a-bdf402d59dd8











#### Créditos pelo Desenvolvimento do case: Senai SC / FIESC
