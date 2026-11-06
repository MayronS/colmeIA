# 🐝 ColmeIA

Sistema de controle de estoque para pequenos comércios.

O ColmeIA expõe uma API REST que permite cadastrar e consultar produtos, centralizando informações como nome, categoria, preço, quantidade disponível e quantidade mínima.

## 🎯 Objetivo

Facilitar o controle de estoque de pequenos comerciantes por meio de um sistema simples e organizado, que permita cadastrar e consultar produtos de forma rápida e eficiente, ajudando a identificar necessidades de reposição.

## 🧑‍🤝‍🧑 Integrantes

- Weisler Antônio de Freitas Filho
- Lyan Chievo Coser
- Josenaldo Silva Sousa
- Mayron Silva Vieira

## 🛠️ Tecnologias

- Java 25
- Spring Boot 4.1.1 (`spring-boot-starter-web`)
- Maven (com Maven Wrapper)

## ✅ Requisitos funcionais

| ID   | Descrição                                                                                        |
| ---- | ------------------------------------------------------------------------------------------------ |
| RF01 | Cadastrar um novo produto informando id, nome, categoria, preço, quantidade e quantidade mínima. |
| RF02 | Consultar um produto específico a partir do seu id ou nome.                                      |
| RF03 | Exibir todos os dados do produto consultado.                                                     |
| RF04 | Informar ao usuário quando o id/nome consultado não corresponder a nenhum produto cadastrado.    |

> **Observação:** na versão atual, a consulta é feita apenas por **id**. A consulta por nome ainda não foi implementada.

## 📁 Estrutura do projeto

```
colmeIA/
├── mvnw / mvnw.cmd                 # Maven Wrapper (Linux/macOS e Windows)
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/uniessa/colmeIA/
    │   │   ├── ColmeIaApplication.java      # Classe principal
    │   │   ├── controller/EstoqueController.java
    │   │   ├── service/EstoqueService.java
    │   │   └── entity/
    │   │       ├── Estoque.java
    │   │       └── Produto.java
    │   └── resources/application.properties
    └── test/java/com/uniessa/colmeIA/ColmeIaApplicationTests.java
```

Arquitetura em camadas: **Controller** (HTTP) → **Service** (regras) → **Entity** (modelo).

## 🚀 Como executar

### Pré-requisitos

- JDK 25 instalado (`java -version`)
- Não é necessário instalar o Maven: o projeto usa o Maven Wrapper.

### Passos

```bash
# 1. Clonar o repositório
git clone https://github.com/MayronS/colmeIA.git
cd colmeIA

# 2. Executar a aplicação
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

> No Linux/macOS, se aparecer `Permission denied`, rode `chmod +x mvnw`.

## 🔌 Endpoints

Base URL: `http://localhost:8080/estoque`

| Método | Rota                | Descrição                                      | Respostas    |
| ------ | ------------------- | ---------------------------------------------- | ------------ |
| GET    | `/estoque`          | Retorna o estoque completo (lista de produtos) | `200 OK`     |
| GET    | `/estoque/{id}`     | Consulta um produto pelo id                    | `200`, `404` |
| POST   | `/estoque/produtos` | Cadastra um novo produto                       | `200 OK`     |

### Exemplos

**Listar o estoque**

```bash
curl http://localhost:8080/estoque
```

**Consultar produto por id**

```bash
curl http://localhost:8080/estoque/123231
```

```json
{
  "id": 123231,
  "nome": "Arroz Tipo 1",
  "categoria": "Mercearia",
  "preco": 5.49,
  "quantidade": 20,
  "quantidadeMinima": 5
}
```

Se o id não existir, a API retorna `404 Not Found`.

**Cadastrar produto**

```bash
curl -X POST http://localhost:8080/estoque/produtos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Macarrão Espaguete",
    "categoria": "Mercearia",
    "preco": 4.99,
    "quantidade": 40,
    "quantidadeMinima": 10
  }'
```

Se o `id` não for informado, a API gera um automaticamente.

## 📦 Modelo de dados

**Produto**

| Campo              | Tipo    | Descrição                           |
| ------------------ | ------- | ----------------------------------- |
| `id`               | Integer | Identificador do produto            |
| `nome`             | String  | Nome do produto                     |
| `categoria`        | String  | Categoria (ex.: Mercearia, Limpeza) |
| `preco`            | double  | Preço unitário                      |
| `quantidade`       | int     | Quantidade em estoque               |
| `quantidadeMinima` | int     | Quantidade mínima desejada          |

O método `estaAbaixoDoMinimo()` indica se a quantidade atual está abaixo da mínima.

**Estoque** — mantém a lista de produtos e oferece operações de cadastro, consulta, atualização de quantidade e listagem de itens abaixo do mínimo.

## 🌱 Dados iniciais

Ao iniciar, a aplicação carrega três produtos de exemplo:

| ID      | Nome           | Categoria | Preço | Qtd | Mínimo |
| ------- | -------------- | --------- | ----- | --- | ------ |
| 123231  | Arroz Tipo 1   | Mercearia | 5,49  | 20  | 5      |
| 2123213 | Feijão Carioca | Mercearia | 4,29  | 2   | 5      |
| 3123123 | Sabão em Pó    | Limpeza   | 12,90 | 30  | 10     |

## ⚠️ Limitações conhecidas

- Os dados ficam **em memória**: tudo é perdido ao reiniciar a aplicação (não há banco de dados).
- Consulta por nome (RF02) ainda não implementada.
- O cadastro com um `id` já existente adiciona um item duplicado em vez de substituir o anterior.
- Os métodos de atualização de quantidade e listagem de produtos abaixo do mínimo existem no serviço, mas ainda não têm endpoint.
