****Projeto Java JDBC - CRUD Clientes
Este é um projeto Java local que visa demonstrar a realização de conexão com banco de dados PostGreSQL e as operações de CRUD (cadastro, consulta, edição e exclusão) para uma tabela de clientes.

****Pré-requisitos
Antes de executar este projeto, é necessário ter o seguinte software instalado:

Java JDK 11
Eclipse IDE

***Como executar o projeto

Clone este repositório em sua máquina local.
Abra o projeto no Eclipse
Adicione a biblioteca .JAR contendo o driver do PostGreSQL

Crie um banco de dados no PostGreSQL com o nome 'bd_java_projeto03' e execute o script abaixo:

CREATE TABLE cliente (
  idcliente SERIAL PRIMARY KEY,
  nome VARCHAR(150),
  email VARCHAR(50),
  telefone VARCHAR(15),
  cpf VARCHAR(11)
);