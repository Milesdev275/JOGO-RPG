# Relatório de QA — A Jornada de Eldoria

Execução em 6 de novembro de 2026. JDK 21, UTF-8, sem frameworks. Testes determinísticos com objetos novos por cenário.

| Identificação | Funcionalidade | Entrada | Resultado esperado | Resultado obtido | Status | Observações |
| --- | --- | --- | --- | --- | --- | --- |
| QA-001 | Cadastro | Arthur, 100, 15, 5 | Nível 1, ouro 30, poções 2 | Nível 1, ouro 30, poções 2 | Aprovado | Sem divergências nesta execução |
| QA-002 | Compra de poção | 30 ouro e preço 10 | 20 ouro e 3 poções | 20 ouro e 3 poções | Aprovado | Sem divergências nesta execução |
| QA-003 | Compra de arma | 50 ouro, bônus 2 | 0 ouro e ataque 17 | 0 ouro e ataque 17 | Aprovado | Sem divergências nesta execução |
| QA-004 | Uso de poção | Vida 90, cura 20 | Vida 100, consome 1 | Vida 100, poções 2 | Aprovado | Sem divergências nesta execução |
| QA-005 | Vitória em batalha | Arthur contra Goblin, 3 ataques | Vitória, herói 98, monstro 0 | Vitória true, herói 98, monstro 0 | Aprovado | Sem divergências nesta execução |
| QA-006 | Derrota | Herói com 1 de vida | Derrota e vida 0 | Vitória false, vida 0 | Aprovado | Sem divergências nesta execução |
| QA-007 | Fuga | Opção 3 | Sem recompensa e sem dano | Ouro 30, vida 100, inimigo 30 | Aprovado | Sem divergências nesta execução |
| QA-008 | Subida de nível | 300 XP no nível 1 | Nível 3, ataque 21, vida 120, XP 0 | Nível 3, ataque 21, vida 120, XP 0 | Aprovado | Sem divergências nesta execução |
| QA-009 | Entrada inválida | abc, @, 100 e 5 | Permite nova tentativa e encerra com 5 | Em execução false, vida 100 | Aprovado | Sem divergências nesta execução |
| QA-010 | Chefe final | Três fases, apenas ataques | 3 fases concluídas e campanha encerrada | Fases 3, em execução false | Aprovado | Sem divergências nesta execução |
| QA-011 | Recompensa única | Repetir avanço e recompensa | Ouro e XP inalterados | Ouro 110, XP 60 | Aprovado | Sem divergências nesta execução |
| QA-012 | Menu da loja | Comprar poção, tentar arma e voltar | Ouro 20, poções 3, sem arma | Ouro 20, poções 3 | Aprovado | Sem divergências nesta execução |
| QA-013 | Fim de entrada | Terminal sem novas linhas | Encerra sem laço infinito | Em execução false | Aprovado | Sem divergências nesta execução |
| QA-014 | Ação inválida em batalha | Texto, opção inexistente e poção com vida cheia | Nenhum contra-ataque | Vida 100, poções 2 | Aprovado | Sem divergências nesta execução |
| QA-015 | GAME OVER | Herói com 1 de vida explora e ataca | Encerra por morte, fase não concluída | Vida 0, fase 0 | Aprovado | Sem divergências nesta execução |

15 casos de integração aprovados. 33 classes com main executadas sem falhas. A campanha também foi concluída pelo ponto de entrada real JogoTest01.

## Evidências

- [Saída dos cenários integrados](evidencia-integracao.txt)
- [Partida completa pelo ponto de entrada real](partida-completa.txt)
- [Saída de todas as classes de teste](resultado-testes.txt)

## Limites da verificação

Os resultados cobrem os dados e caminhos registrados. Não representam prova de ausência de defeitos em qualquer combinação de valores. Os atributos públicos seguem a proposta didática do professor. Não há persistência: uma nova execução começa outra partida.
