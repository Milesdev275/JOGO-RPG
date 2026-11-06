package rpg.test;

import rpg.dominio.Heroi;

// Exercícios 31 e 48.
public class NivelTest01 {
    public static void main(String[] args) {
        int[] entradas = {0, 99, 100, 300};
        int[] niveis = {1, 1, 2, 3};
        int[] restantes = {0, 99, 0, 0};
        for (int i = 0; i < entradas.length; i++) {
            Heroi h = CenariosQA.heroi();
            h.vida = 50;
            h.experiencia = entradas[i];
            h.verificarSubidaDeNivel();
            CenariosQA.verificar(h.nivel == niveis[i] && h.experiencia == restantes[i], "Nível/XP incorretos");
            CenariosQA.verificar(h.ataque == 15 + (niveis[i] - 1) * 3, "Ataque não evoluiu corretamente");
            CenariosQA.verificar(h.vidaMaxima == 100 + (niveis[i] - 1) * 10, "Vida máxima incorreta");
            CenariosQA.verificar(h.vida == (niveis[i] > 1 ? h.vidaMaxima : 50), "Cura ao evoluir incorreta");
            System.out.println("XP inicial: " + entradas[i] + " | Nível: " + h.nivel + " | XP restante: " + h.experiencia);
        }
    }
}
