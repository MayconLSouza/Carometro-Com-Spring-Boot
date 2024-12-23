# Sistema de Carometro Outorgado pela Matéria de Laboratório de Engenharia de Software
Este é um projeto de um carômetro que esta sendo desenvolvido para integração com o atual site da instituição de ensino FATEC Zona Leste.
Este projeto está baseado nas orientações e anseios da Cordenação do Curso de ADS e da orientadora da matéria "Laboratório de Engenharia de Software".
Este Sistema foi concebido desde o levantamento de requisitos junto ao cliente, modelagem das classes participantes, elaboração de protótipos visuais até o momento de sua plena implementação.

## Seguindo os padrões recomendos da Engenharia de Software foram desenvolvidas as seguintes modelagens:
### MCU - Modelo de Caso de Uso do Sistema
![MCU Carometro](https://github.com/user-attachments/assets/6e77f5cf-7781-41d2-859c-0dbcdfe18878)

### VCP - Visão de Classe Participante do Sistema
![VCP - CARÔMETRO](https://drive.google.com/uc?export=view&id=1i9fW8vR-Ma58dkj6ys4isy6xho3I4kes)


---

## Implementação:
Seguindos os Princípios da Programação Orientada a Objetos(POO) e as Boas Práticas de Desenvolvimento de Software (Clean Architecture) foi desenvolvida uma
APIRESTful que realiza operações de CRUD(`Create, Read, Update, Delete`) nas entidades Curso, Turma, Aluno, Histórico e Comentário.
Todas as entidades Possuem seu front-end em Thymeleaf e seu backend e manipulação de banco em Spring Boot, com JPA e suas dependências.

---

### Desenvolvido por:
  - *Amós Silva Souza* - 1110482223019.
  - *Geovanni Veloso Ferreira* - 1110482223048.
  - *Maycon Leonardo Martins de Souza* - 1110482223011.
  - *Peterson Henryque Chaia dos Santos* - 1110482223003.
  - *Renan Cavalcante Gama* - 1110482223032.
    
### Tecnologias Utilizadas
#### Modelagem
  - Visual Paradigm 17.1
  
#### Implementação
  - Spring Web
  - Spring JPA
  - OpenAPI/Swagger
  - Thymeleaf
