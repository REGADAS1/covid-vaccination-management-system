# Sistema de Gestão de Vacinação COVID-19

Projeto académico desenvolvido em **Java** com interface gráfica em **Java Swing**, com o objetivo de simular um sistema de gestão de vacinação contra a COVID-19.

A aplicação permite gerir utilizadores, centros de vacinação, vacinas, stocks, marcações e informação associada ao processo de vacinação, contemplando diferentes perfis de utilizador: **Administrador**, **Gestor** e **Utente**.

---

## Índice

- [Sobre o projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Perfis de utilizador](#perfis-de-utilizador)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Como executar](#como-executar)
- [Credenciais de teste](#credenciais-de-teste)
- [Persistência de dados](#persistência-de-dados)
- [Conceitos aplicados](#conceitos-aplicados)
- [Possíveis melhorias futuras](#possíveis-melhorias-futuras)
- [Contexto académico](#contexto-académico)
- [Competências demonstradas](#competências-demonstradas)

---

## Sobre o projeto

Este projeto representa uma aplicação desktop para gestão de um processo de vacinação, permitindo a interação entre diferentes tipos de utilizadores.

O sistema foi desenvolvido com foco em conceitos fundamentais de programação orientada a objetos, incluindo:

- Encapsulamento
- Herança
- Polimorfismo
- Composição de objetos
- Separação entre backend e frontend
- Persistência de dados através de serialização
- Gestão de coleções de objetos
- Interface gráfica com Java Swing

A aplicação permite que administradores façam a gestão global do sistema, que gestores acompanhem o funcionamento dos centros de vacinação e que utentes possam consultar dados, escolher centros e agendar marcações.

---

## Funcionalidades

### Administrador

O perfil de administrador permite:

- Criar, editar e remover gestores
- Criar, editar e remover centros de vacinação
- Associar gestores a centros de vacinação
- Gerir vacinas disponíveis no sistema
- Alocar vacinas a centros de vacinação
- Consultar informação geral sobre vacinação
- Acompanhar dados globais do sistema

### Gestor

O perfil de gestor permite:

- Consultar o centro de vacinação associado
- Consultar utentes associados ao centro
- Consultar marcações
- Monitorizar stocks de vacinas
- Consultar estatísticas do centro
- Acompanhar a atividade do centro de vacinação

### Utente

O perfil de utente permite:

- Efetuar registo no sistema
- Iniciar sessão
- Consultar dados pessoais
- Associar-se a um centro de vacinação
- Adicionar doenças ou condições relevantes
- Agendar marcação de vacinação
- Consultar informação do centro associado
- Consultar informação da marcação

---

## Perfis de utilizador

| Perfil | Descrição |
|---|---|
| Administrador | Responsável pela gestão global do sistema |
| Gestor | Responsável pela gestão de um centro de vacinação |
| Utente | Utilizador que pode consultar dados e agendar vacinação |

---

## Tecnologias utilizadas

- **Java**
- **Java Swing**
- **Apache Ant**
- **NetBeans GUI Builder**
- **Serialização de objetos**
- **JCalendar**
- **AbsoluteLayout**

---

## Estrutura do projeto

```text
PROJETO COVIDii/
├── build.xml
├── nbproject/
├── src/
│   ├── BACKEND/
│   │   ├── Administrador.java
│   │   ├── CentroVacinacao.java
│   │   ├── Gestor.java
│   │   ├── Marcacao.java
│   │   ├── RepositorioCentrosVacinacao.java
│   │   ├── RepositorioUtilizador.java
│   │   ├── Sistema.java
│   │   ├── StockVacinas.java
│   │   ├── Utente.java
│   │   └── Vacina.java
│   │
│   ├── FRONTEND/
│   │   ├── LoginForm.java
│   │   ├── RegisterForm.java
│   │   ├── HomePage.java
│   │   ├── Piloto.java
│   │   ├── ADMIN/
│   │   ├── GESTOR/
│   │   └── UTENTE/
│   │
│   └── SERIALIZACAO/
│       └── Serializacao.java
│
├── lib/
│   ├── AbsoluteLayout.jar
│   └── jcalendar-1.3.3.jar
│
├── README.md
└── .gitignore
```

---

## Como executar

### Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java JDK 11 ou superior
- Apache Ant

Para confirmar se estão instalados corretamente:

```powershell
java -version
javac -version
ant -version
```

### Executar o projeto

Na pasta principal do projeto, onde se encontra o ficheiro `build.xml`, executar:

```powershell
ant clean run
```

A classe principal do projeto é:

```text
FRONTEND.Piloto
```

### Executar caso o projeto esteja no OneDrive

Em algumas situações, quando o projeto está dentro de uma pasta sincronizada com OneDrive, o Ant pode não conseguir criar a pasta `build`.

Nesse caso, pode ser usado um diretório temporário para a compilação:

```powershell
ant "-Dbuild.dir=$env:TEMP\covid_build" "-Ddist.dir=$env:TEMP\covid_dist" clean run
```

---

## Dependências externas

O projeto utiliza duas bibliotecas externas, incluídas na pasta `lib/`:

```text
lib/AbsoluteLayout.jar
lib/jcalendar-1.3.3.jar
```

Estas bibliotecas são necessárias para a interface gráfica criada originalmente com o NetBeans GUI Builder.

---

## Credenciais de teste

A aplicação inclui utilizadores de teste para facilitar a demonstração.

### Administrador

```text
Username: admin
Password: admin
```

### Gestor

```text
Username: gestor
Password: gestor
```

### Utente

```text
Username: utente
Password: utente
```

---

## Persistência de dados

O sistema utiliza serialização de objetos para guardar o estado da aplicação num ficheiro `.data`.

Isto permite guardar informação como:

- Utilizadores
- Centros de vacinação
- Vacinas
- Marcações
- Stocks
- Dados associados ao funcionamento do sistema

O ficheiro de dados é criado automaticamente durante a execução da aplicação.

---

## Exemplos de utilização

Fluxo típico de utilização da aplicação:

1. O administrador inicia sessão.
2. Cria ou edita gestores.
3. Cria centros de vacinação.
4. Associa gestores a centros.
5. Gere vacinas e stocks.
6. O utente efetua login ou registo.
7. O utente escolhe um centro de vacinação.
8. O utente agenda uma marcação.
9. O gestor consulta utentes, marcações e estatísticas do centro.

---

## Conceitos aplicados

Durante o desenvolvimento foram aplicados vários conceitos de programação orientada a objetos e desenvolvimento de aplicações desktop:

- Modelação de entidades do domínio
- Organização por camadas
- Repositórios para gestão de dados
- Interfaces gráficas com eventos
- Validação de formulários
- Persistência local de dados
- Gestão de diferentes perfis de utilizador
- Manipulação de coleções
- Tratamento de exceções

---

## Possíveis melhorias futuras

Algumas melhorias que poderiam ser implementadas em versões futuras:

- Migração da persistência por serialização para base de dados relacional
- Implementação de autenticação mais robusta
- Encriptação de passwords
- Melhorias no design visual da interface
- Adição de testes unitários
- Exportação de relatórios em PDF ou CSV
- Sistema de permissões mais detalhado
- Histórico completo de vacinação por utente
- Confirmação de presença ou ausência nas marcações
- Dashboard estatístico mais completo
- Validações adicionais nos formulários
- Migração para JavaFX ou aplicação web

---

## Contexto académico

Este projeto foi desenvolvido no âmbito académico, com o objetivo de aplicar conhecimentos de programação orientada a objetos, desenvolvimento de interfaces gráficas em Java e persistência de dados.

O projeto simula um cenário realista de gestão de vacinação, permitindo trabalhar conceitos relacionados com gestão de utilizadores, marcações, centros de vacinação e stocks.

---

## Competências demonstradas

Este projeto demonstra experiência prática em:

- Desenvolvimento de aplicações desktop em Java
- Programação orientada a objetos
- Criação de interfaces gráficas com Swing
- Organização modular de código
- Persistência de dados
- Gestão de eventos em interfaces gráficas
- Estruturação de projetos Java com Ant
- Resolução de bugs e melhoria de código legado
- Preparação de projeto académico para portfólio GitHub

---

## Autor

Projeto desenvolvido no contexto universitário.

Preparado e documentado para apresentação em portfólio académico e profissional.

---

## Nota

Este projeto tem fins académicos e foi desenvolvido como exercício de aplicação prática de conceitos de programação e desenvolvimento de software.
