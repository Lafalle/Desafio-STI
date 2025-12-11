# Desafio STI - Sistema de Cálculo de CR

Este repositório contém a solução para o desafio de cálculo de Coeficiente de Rendimento (CR) de alunos e média de cursos, implementada em duas versões distintas:

* **Versão Console (*Desafio/*):** Implementação em Java, rodando via terminal.
* **Versão Web (*demo/*):** Implementação adaptada do Java utilizando o framework **Spring Boot** com interface HTML/Thymeleaf.



# Pré-requisitos

* Java JDK: Versão 21 ou superior (Recomendado JDK 25 conforme configuração do projeto).
* IDE: IntelliJ IDEA ou VS Code.



# Como executar a Versão Console (Java)

Esta versão lê o arquivo CSV e imprime o relatório diretamente no console da IDE.


* **Passos para Executar:**

    - Navegue até a pasta *Desafio*.
    - Abra o arquivo *src/Main.java* na sua IDE.
    - Execute o método *main*.


**Saída esperada no Console:**

```text
------- O CR dos alunos é: --------
100    -   63
101    -   82
102    -   56
...
-----------------------------------
----- Média de CR dos cursos ------
10     -   65
21     -   70
...
-----------------------------------
```



# Como executar a Versão Web (Spring Boot)

Esta versão sobe um servidor local e exibe uma página HTML estilizada com as tabelas de resultados.




* **Passos para Executar:**

    - Abra a pasta *demo* na sua IDE.
    - Aguarde o Maven baixar as dependências (listadas no *pom.xml*).
    - Localize a classe principal: *src/main/java/com/desafio/demo/DemoApplication.java*.
    - Execute o método *main* desta classe (Run Java Application).
    - Aguarde a mensagem no console: *Started DemoApplication in X seconds*.
    - Abra seu navegador e acesse: *http://localhost:8080*
      

  **Nota Importante:** O sistema busca o arquivo de dados em *src/main/resources/notas.csv*.


# Estrutura do Projeto

* ***Desafio/*:**

    - ***src/Main.java*:** Ponto de entrada da aplicação console.
    - ***src/LeitorCSV.java*:** Lógica de leitura manual do arquivo.
    - ***src/Aluno.java* e *src/Curso.java*:** Classes de domínio e cálculo.
    - ***src/Registro.java*:** Classe que recebe os dados brutos do CSV.
    - ***src/AlunoTest.java* e *src/CursoTest.java*:** Testes unitários de *Aluno.java* e *Curso.java* utilizando jUnit 5


* ***demo/*:**

    - ***model/*:** Contém as classes *Aluno.java*, *Curso.java* e *Registro.java*.
    - ***controller/RelatorioController.java*:** Gerencia as requisições Web.
    - ***service/DesafioService.java*:** Contém a regra de negócio e processamento de dados.
    - ***resources/templates/relatorio.html*:** A página HTML (*View*) gerada pelo Thymeleaf.
    - ***resources/static/css/estilo.css*:** Folha de estilos para centralização e design da página.
