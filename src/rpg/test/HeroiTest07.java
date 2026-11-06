package rpg.test;

import rpg.dominio.*;

// Exercício 19. Execute com -ea para habilitar as verificações.
public class HeroiTest07 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        Arma espada = new Arma();
        espada.bonusAtaque = 8;
        heroi.inventario.armaEquipada = espada;
        String resumo = heroi.gerarResumo();
        System.out.println(resumo);
        assert resumo.equals("Herói: Arthur | Vida: 100/100 | Ataque total: 23 | Defesa: 5 | Nível: 1")
                : "O resumo deve conter nome, vida, ataque total, defesa e nível";
        System.out.println("HeroiTest07: verificações concluídas.");
    }
}
