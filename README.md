# Calculadora de Fatorial - Aplica��o de Java Web
Aplica��o para o desafio do laborat�rio Bridge na vaga de Dev. Full Stack (Bolsa)

## Tecnologias e bibliotecas utilizadas
- OpenJDK 11;
- Apache Maven 3.6.3 - [Sobre](https://maven.apache.org/);
	- [Instalando no Ubuntu](https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/)
	- [Instalando no Windows](https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Windows)
- JUnit 5.3.1;
- JavaX Servlet 4.0.1;
- JSP (JavaServer Pages) e JSTL (JavaServer Pages Standard Tag Library) 1.2;
- Apache Tomcat 7 - [Sobre](https://tomcat.apache.org/download-70.cgi).

## Como rodar localmente
1. Clone o reposit�rio git:
``git clone https://github.com/zDudaHang/Desafio-Bridge.git``
2. Mude para o diret�rio da aplica��o:
``cd Desafio-Bridge/``
3. Execute o seguinte comando do Maven:
``mvn clean install``
4. Rode o servidor do Tomcat 7:
``mvn tomcat7:run``
5. Acesse a seguinte URL: 
http://localhost:8080/
6. Fique � vontade para calcular :smiley:

## Testes unit�rios
Foram criados tr�s testes unit�rios para a classe CalculatorService. Os testes se encontram na seguinte classe: 
``src/test/java/TestCalculatorService.java``

Os testes unit�rios feitos foram:
1. ``testNegativeParameter`` : Verificar se retorna -1 (indicando um erro) ao receber o par�metro ``number`` com valor negativo;
2.  ``testBaseParameter`` : Verificar se retorna 1 para os casos de base, nesse caso 0! e 1! ;
3. ``testOrdinaryNumber``: Verificar se retorna o valor de 10! ao colocar o par�metro ``number`` como 10.
