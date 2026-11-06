# ⚔️ JOGO/RPG — A Jornada de Eldoria

Um RPG de terminal feito em **Java puro**, construído em **50 exercícios progressivos** de Programação Orientada a Objetos e Quality Assurance.

O Reino de Eldoria foi invadido. Crie seu herói, enfrente o Goblin, explore a Caverna dos Ossos e derrote o Guardião Sombrio no castelo.

**Um projeto que cresce a cada exercício:** classes e objetos primeiro, depois comportamentos, combate, menus e testes.

## 🎮 O que dá para fazer

- Escolher o nome do herói e consultar seus atributos.
- Atacar, usar poções ou fugir de uma batalha.
- Comprar poções e equipar armas com o ouro das vitórias.
- Ganhar experiência e subir de nível, recuperando a vida.
- Avançar por três fases, com recompensa única por vitória.
- Receber a mensagem de vitória ou de GAME OVER.
- Digitar opções inválidas e tentar novamente sem encerrar o programa.

## 🛠️ Como executar

Requisito: **JDK 21 ou superior**, com `java` e `javac` no PATH. Sem Maven, bibliotecas externas, banco de dados ou frameworks.

```bash
git clone https://github.com/Milesdev275/JOGO-RPG.git
cd JOGO-RPG
```

**No IntelliJ IDEA:** abra a pasta, selecione o JDK e execute o `main` de [JogoTest01](src/rpg/test/JogoTest01.java).

**No PowerShell:**

```powershell
.\executar.ps1
```

Ou compile e execute manualmente:

```powershell
New-Item -ItemType Directory -Force out
$fontes = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $fontes
java -Dfile.encoding=UTF-8 -cp out rpg.test.JogoTest01
```

## 🧭 A campanha

| Fase | Inimigo | Vida | Ataque | Defesa | Ouro | XP |
| --- | --- | ---: | ---: | ---: | ---: | ---: |
| Floresta Sombria | Goblin | 30 | 6 | 1 | 10 | 20 |
| Caverna dos Ossos | Esqueleto | 45 | 9 | 2 | 20 | 40 |
| Castelo das Sombras | Guardião Sombrio | 75 | 12 | 3 | 50 | 100 |

O herói começa com 100 de vida, ataque 15, defesa 5, nível 1, 30 de ouro e duas poções. Os preços e recompensas são escolhas de configuração nos pontos em que o enunciado deixa os valores livres.

| Produto da loja | Preço em ouro | Efeito |
| --- | ---: | --- |
| Poção Pequena | 10 | Recupera até 20 de vida |
| Espada de Madeira | 50 | Bônus de ataque +2 |
| Espada de Ferro | 150 | Bônus de ataque +8 |

A Poção Grande, com cura 50, também existe como objeto e nos exemplos didáticos. O inventário pedido no enunciado mantém apenas uma quantidade de poções, por isso o menu usa a Poção Pequena como consumível padrão.

## 🧠 As regras por trás do jogo

| Regra | Como funciona | Código |
| --- | --- | --- |
| Dano | Maior valor entre 1 e ataque total menos defesa | [Heroi](src/rpg/dominio/Heroi.java), [Monstro](src/rpg/dominio/Monstro.java) |
| Vida | Nunca fica abaixo de zero | [Heroi](src/rpg/dominio/Heroi.java) |
| Cura | Precisa ser positiva e respeita a vida máxima | [Heroi](src/rpg/dominio/Heroi.java) |
| Arma | O ataque básico soma o bônus da arma equipada | [Inventario](src/rpg/dominio/Inventario.java) |
| Turno | O inimigo reage depois de uma ação válida, se continuar vivo | [Batalha](src/rpg/dominio/Batalha.java) |
| Fuga | Encerra o combate sem recompensa | [Batalha](src/rpg/dominio/Batalha.java) |
| Evolução | Consome `nivel * 100` XP, acrescenta 3 de ataque e 10 de vida máxima | [Heroi](src/rpg/dominio/Heroi.java) |
| Recompensa | Monstro e fase impedem entregas repetidas | [Jogo](src/rpg/dominio/Jogo.java) |

Arma.preco permanece `double`, como no projeto inicial. Como o ouro é inteiro, a loja aceita preços inteiros positivos e recusa preços fracionados, negativos ou não finitos.

## 📂 Organização do projeto

```text
JOGO-RPG/
├── src/rpg/
│   ├── dominio/       # Classes e regras do jogo
│   └── test/          # Testes com main e entrada do jogo
├── docs/
│   ├── RELATORIO_QA.md
│   ├── resultado-testes.txt
│   └── partida-completa.txt
├── executar.ps1
├── testar.ps1
└── README.md
```

`Jogo` coordena menus e fases. `Batalha` executa o combate. `Heroi` e `Monstro` guardam estado e comportamento. `Loja` altera ouro e inventário. **ImpressoraRPG** centraliza a exibição dos personagens e itens.

O código usa objetos e métodos de instância, passagem de parâmetros, `void`, `return`, arrays, `Scanner`, `switch` e `try-catch`. As classes seguem a proposta da aula, com atributos públicos e sem herança ou interfaces.

## 📚 Os 50 exercícios

Clique no nome para abrir o código correspondente. Eles evoluem o mesmo projeto.

### 🏗️ Fase 1 — Classes, objetos e referências

| # | Exercício |
| --- | --- |
| 01 | [Criando o projeto](src/rpg/test/JogoTest01.java) |
| 02 | [Classe Heroi](src/rpg/dominio/Heroi.java) |
| 03 | [Dois heróis](src/rpg/test/HeroiTest01.java) |
| 04 | [Classe Monstro](src/rpg/dominio/Monstro.java) |
| 05 | [Primeiros inimigos](src/rpg/test/MonstroTest01.java) |
| 06 | [Armas](src/rpg/test/ArmaTest01.java) |
| 07 | [Poções](src/rpg/test/PocaoTest01.java) |
| 08 | [Inventário](src/rpg/dominio/Inventario.java) |
| 09 | [Fases](src/rpg/test/FaseTest01.java) |
| 10 | [Classe Jogo](src/rpg/dominio/Jogo.java) |

### 💚 Fase 2 — Comportamentos dos personagens

| # | Exercício |
| --- | --- |
| 11 | [Herói vivo](src/rpg/test/HeroiTest02.java) |
| 12 | [Monstro vivo](src/rpg/test/MonstroTest02.java) |
| 13 | [Ataque total](src/rpg/test/HeroiTest03.java) |
| 14 | [Dano do herói](src/rpg/test/HeroiTest04.java) |
| 15 | [Dano do monstro](src/rpg/test/MonstroTest03.java) |
| 16 | [Herói recebe dano](src/rpg/test/HeroiTest05.java) |
| 17 | [Monstro recebe dano](src/rpg/test/MonstroTest04.java) |
| 18 | [Cura do herói](src/rpg/test/HeroiTest06.java) |
| 19 | [Resumo do herói](src/rpg/test/HeroiTest07.java) |
| 20 | [Resumo do monstro](src/rpg/test/MonstroTest05.java) |

### ⚔️ Fase 3 — Classes trabalhando juntas

| # | Exercício |
| --- | --- |
| 21 | [Impressora do RPG](src/rpg/dominio/ImpressoraRPG.java) |
| 22 | [Cadastro de heróis](src/rpg/dominio/CadastroHeroi.java) |
| 23 | [Cadastro de monstros](src/rpg/dominio/CadastroMonstro.java) |
| 24 | [Ataque do herói](src/rpg/test/BatalhaTest01.java) |
| 25 | [Contra-ataque](src/rpg/test/BatalhaTest02.java) |
| 26 | [Turno de combate](src/rpg/test/BatalhaTest03.java) |
| 27 | [Uso de poção](src/rpg/test/PocaoTest02.java) |
| 28 | [Loja de poções](src/rpg/test/LojaTest01.java) |
| 29 | [Compra de armas](src/rpg/test/LojaTest02.java) |
| 30 | [Recompensas](src/rpg/test/RecompensaTest01.java) |

### 🧭 Fase 4 — O jogo interativo

| # | Exercício |
| --- | --- |
| 31 | [Subida de nível](src/rpg/dominio/Heroi.java) |
| 32 | [Três fases em array](src/rpg/test/JogoTest01.java) |
| 33 | [Configuração do jogo](src/rpg/dominio/Jogo.java) |
| 34 | [Boas-vindas](src/rpg/dominio/Jogo.java) |
| 35 | [Menu principal](src/rpg/dominio/Jogo.java) |
| 36 | [Leitura e execução de opções](src/rpg/dominio/Jogo.java) |
| 37 | [Laço principal](src/rpg/dominio/Jogo.java) |
| 38 | [Batalha interativa](src/rpg/dominio/Batalha.java) |
| 39 | [Loja e inventário](src/rpg/dominio/Jogo.java) |
| 40 | [Avanço de fase](src/rpg/dominio/Jogo.java) |

### 🧪 Fase 5 — QA e finalização

| # | Exercício |
| --- | --- |
| 41 | [Impressão do inventário](src/rpg/dominio/ImpressoraRPG.java) |
| 42 | [Entradas inválidas](src/rpg/dominio/Jogo.java) |
| 43 | [Validação do cadastro](src/rpg/test/ValidacaoHeroiTest01.java) |
| 44 | [Testes de poção](src/rpg/test/PocaoTest01.java) |
| 45 | [Testes da loja](src/rpg/test/LojaTest01.java) |
| 46 | [Referências de objetos](src/rpg/test/ReferenciaTest01.java) |
| 47 | [Limites do combate](src/rpg/test/BatalhaTest01.java) |
| 48 | [Testes de experiência](src/rpg/test/NivelTest01.java) |
| 49 | [Relatório de QA](docs/RELATORIO_QA.md) |
| 50 | [RPG completo](src/rpg/test/JogoTest01.java) |

## 🧪 Como testar

```powershell
.\testar.ps1
```

Os testes usam `main`, verificações de estado e assertions habilitadas com `-ea`. O script pula apenas o ponto de entrada interativo `JogoTest01`.

- [Relatório de QA](docs/RELATORIO_QA.md): 15 casos integrados, incluindo vitória, derrota, fuga, compras, XP, entrada inválida e chefe final.
- [Resultado completo dos testes](docs/resultado-testes.txt): saída registrada das classes executadas.
- [Partida completa](docs/partida-completa.txt): execução real de `JogoTest01` do nome do herói à vitória final.

Os casos aprovados documentam os caminhos executados. Outras combinações ainda podem revelar defeitos.

## 🎓 Contexto acadêmico

Projeto de estudo de Java, Programação Orientada a Objetos e Quality Assurance de Lucas Souto Silva, [Milesdev275](https://github.com/Milesdev275), a partir da proposta “A Jornada de Eldoria”. A implementação recebeu apoio de IA e deve ser estudada junto dos enunciados e dos testes.

Cada nova execução inicia uma partida do zero. Não há salvamento, interface gráfica ou acesso à rede durante o jogo.

---

Feito com ☕, Java e vontade de aprender.
