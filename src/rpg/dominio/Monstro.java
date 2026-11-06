package rpg.dominio;

public class Monstro {
    public String nome;
    public int vida;
    public int ataque;
    public int defesa;
    public int ouroRecompensa;
    public int experienciaRecompensa;

    // Exercício 12.
    public boolean estaVivo() {
        return vida > 0;
    }

    // Exercício 15.
    public int calcularDano(int defesaHeroi) {
        int dano = ataque - defesaHeroi;
        if (dano < 1) {
            return 1;
        }
        return dano;
    }

    // Exercício 17: a alteração acontece neste próprio objeto.
    public void receberDano(int dano) {
        if (dano < 0) {
            return;
        }
        if (dano >= vida) {
            vida = 0;
        } else {
            vida -= dano;
        }
    }

    // Exercício 30: evita recompensar duas vezes a mesma vitória.
    public boolean recompensaRecebida;

    // Exercício 20.
    public String gerarResumo() {
        return "Monstro: " + nome + " | Vida: " + vida + " | Ataque: " + ataque
                + " | Defesa: " + defesa + " | Ouro de recompensa: " + ouroRecompensa
                + " | Experiência de recompensa: " + experienciaRecompensa;
    }

}
