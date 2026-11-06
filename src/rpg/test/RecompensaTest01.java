package rpg.test;

import rpg.dominio.*;

// Exercício 30. Execute com -ea para habilitar as verificações.
public class RecompensaTest01 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        Monstro goblin = new Monstro();
        new CadastroHeroi().cadastrar(heroi, "Arthur", 100, 15, 5);
        new CadastroMonstro().cadastrar(goblin, "Goblin", 30, 6, 1, 10, 20);
        heroi.receberRecompensa(goblin);
        assert heroi.ouro == 30 && heroi.experiencia == 0 : "Não pode recompensar inimigo vivo";
        Batalha batalha = new Batalha();
        batalha.executarTurno(heroi, goblin);
        assert heroi.ouro == 30 && heroi.experiencia == 0 : "Turno sem vitória não entrega recompensa";
        while (heroi.estaVivo() && goblin.estaVivo()) {
            batalha.executarTurno(heroi, goblin);
        }
        System.out.println("Ouro após vitória: " + heroi.ouro);
        System.out.println("Experiência após vitória: " + heroi.experiencia);
        assert heroi.ouro == 40 && heroi.experiencia == 20 && goblin.recompensaRecebida;
        batalha.executarTurno(heroi, goblin);
        heroi.receberRecompensa(goblin);
        new Batalha().executarTurno(heroi, goblin);
        assert heroi.ouro == 40 && heroi.experiencia == 20 : "Recompensa não pode se repetir";

        Heroi outro = new Heroi();
        new CadastroHeroi().cadastrar(outro, "Luna", 80, 20, 3);
        outro.receberRecompensa(goblin);
        assert outro.ouro == 30 && outro.experiencia == 0 : "Outro herói não pode receber a mesma recompensa";

        Monstro forte = new Monstro();
        new CadastroMonstro().cadastrar(forte, "Guardião Sombrio", 75, 12, 3, 50, 100);
        outro.vida = 1;
        while (outro.estaVivo() && forte.estaVivo()) {
            batalha.executarTurno(outro, forte);
        }
        assert outro.ouro == 30 && outro.experiencia == 0 && !forte.recompensaRecebida
                : "Derrota não deve conceder recompensa";
        assert heroi.nivel == 1 : "Subida de nível fica para o exercício 31";
        System.out.println("RecompensaTest01: verificações concluídas.");
    }
}
