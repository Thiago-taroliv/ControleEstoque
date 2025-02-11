# Sistema de Controle de Estoque

## 📌 Descrição
Este é um sistema simples de **Controle de Estoque** desenvolvido em **Java** com interface gráfica utilizando **Swing** e persistência de dados em **MySQL**.

O sistema permite:
- 📌 Cadastrar produtos no banco de dados.
- 🔍 Consultar produtos cadastrados.
- ✏️ Atualizar informações de produtos.
- ❌ Remover produtos.


## 🛠️ Tecnologias Utilizadas
- **Java** (JDK 21)
- **Swing** (Interface Gráfica)
- **MySQL** (Banco de Dados)
- **JDBC** (Conexão com o Banco)
- **Apache NetBeans** (IDE de Desenvolvimento)

## 🚀 Instalação e Configuração

### 1️⃣ Requisitos
- Java JDK instalado.
- MySQL instalado e rodando.
- Driver JDBC do MySQL.
- Apache NetBeans (ou outra IDE compatível).

### 2️⃣ Configurar Banco de Dados
Antes de rodar o sistema, crie o banco de dados no MySQL:
```sql
CREATE DATABASE controle_estoque;
USE controle_estoque;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    preco DOUBLE NOT NULL,
    descricao TEXT
);
```