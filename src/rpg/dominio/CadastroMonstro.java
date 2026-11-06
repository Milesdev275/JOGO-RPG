package rpg.dominio;

// Exercício 23.
public class CadastroMonstro {
    public void cadastrar(Monstro monstro, String nome, int vida, int ataque, int defesa,
                          int ouroRecompensa, int experienciaRecompensa) {
        monstro.nome = nome;
        monstro.vida = vida;
        monstro.ataque = ataque;
        monstro.defesa = defesa;
        monstro.ouroRecompensa = ouroRecompensa;
        monstro.experienciaRecompensa = experienciaRecompensa;
        monstro.recompensaRecebida = false;
    }
}
