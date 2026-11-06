package rpg.test;

import rpg.dominio.*;

// Exercício 43: nenhuma entrada inválida pode modificar o objeto.
public class ValidacaoHeroiTest01 {
    public static void main(String[] args) {
        Heroi h = CenariosQA.heroi();
        CadastroHeroi cadastro = new CadastroHeroi();
        int rejeitados = 0;
        for (int caso = 0; caso < 5; caso++) {
            try {
                cadastro.cadastrar(h, caso == 0 ? " " : caso == 4 ? null : "Novo",
                        caso == 1 ? 0 : 100, caso == 2 ? -1 : 15, caso == 3 ? -1 : 5);
            } catch (IllegalArgumentException e) {
                rejeitados++;
            }
            CenariosQA.verificar(h.nome.equals("Arthur") && h.vida == 100 && h.ataque == 15 && h.defesa == 5,
                    "Cadastro inválido modificou objeto");
        }
        CenariosQA.verificar(rejeitados == 5, "Todas as entradas inválidas devem ser rejeitadas");
        System.out.println("Nome vazio/nulo, vida zero, ataque e defesa negativos rejeitados.");
    }
}
