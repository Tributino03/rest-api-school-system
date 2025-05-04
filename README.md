Desafio do Bootcamp da DIO, de criar uma API do zero

Tecnologias Utilizadas
Java 17+

Spring Boot

Spring Data JPA

Hibernate Validator

Swagger / OpenAPI 3

ViaCEP (integração automática de CEP)

Estrutura da APi:
Teacher(/api/techer)
Gerencia os dados de professores.

Studant(/api/students)
Gerencia os dados de alunos (estudantes).

ClassStudant(/api/classStudants)
Gerencia as classes de estudantes.

Exemplo de Requisição (POST /api/students)
json
Copiar
Editar
{
  "ra": "2167555",
  "name": "João da Silva",
  "endereco": {
    "cep": "03308-060"
  },
  "teacherCpf": "29853424232",
  "classStudantId": 1,
  "schoolCodInep": "30765460"
}

Como executar: git clone https://github.com/seu-usuario/sua-api-escolar.git
cd sua-api-escolar
./mvnw spring-boot:run
Acesse: http://localhost:8080/swagger-ui.html para visualizar a documentação interativa.

Para fazer testes: deve criar primeiro a escola, depois o professor, as classes e por ultimo o aluno.
