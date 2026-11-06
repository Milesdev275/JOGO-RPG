package rpg.test;

import rpg.dominio.*;

// Exercício 20. Execute com -ea para habilitar as verificações.
public class MonstroTest05 {
    public static void main(String[] args) {
        CadastroMonstro cadastro = new CadastroMonstro();
        Monstro goblin = new Monstro();
        Monstro esqueleto = new Monstro();
        Monstro guardiao = new Monstro();
        cadastro.cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
        cadastro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 20, 40);
        cadastro.cadastrar(guardiao, "Guardião Sombrio", 75, 12, 3, 50, 100);
        String resumoGoblin = goblin.gerarResumo();
        String resumoEsqueleto = esqueleto.gerarResumo();
        String resumoGuardiao = guardiao.gerarResumo();
        System.out.println(resumoGoblin);
        System.out.println(resumoEsqueleto);
        System.out.println(resumoGuardiao);
        assert resumoGoblin.equals("Monstro: Goblin | Vida: 30 | Ataque: 6 | Defesa: 1 | Ouro de recompensa: 10 | Experiência de recompensa: 20");
        assert resumoEsqueleto.contains("Esqueleto") && resumoEsqueleto.contains("Vida: 45");
        assert resumoGuardiao.contains("Guardião Sombrio") && resumoGuardiao.contains("Vida: 75");
        System.out.println("MonstroTest05: verificações concluídas.");
    }
}
