package rpg.dominio;

public class Heroi {
    public String nome = "";
    public int vida;
    public int vidaMaxima;
    public int ataque;
    public int defesa;
    public int nivel;
    public int experiencia;
    public int ouro;
    public Inventario inventario;

    // Exercício 11: vida igual ou menor que zero significa derrota.
    public boolean estaVivo() {
        return vida > 0;
    }

    // Exercício 13: um herói também pode estar sem inventário ou sem arma.
    public int calcularAtaqueTotal() {
        if (inventario != null && inventario.armaEquipada != null) {
            return ataque + inventario.armaEquipada.bonusAtaque;
        }
        return ataque;
    }

    // Exercício 14: a defesa nunca reduz o dano para menos de um.
    public int calcularDano(int defesaInimigo) {
        int dano = calcularAtaqueTotal() - defesaInimigo;
        if (dano < 1) {
            return 1;
        }
        return dano;
    }

    // Exercício 16: dano negativo é ignorado e a vida para em zero.
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

    // Exercício 18: ignora cura inválida e respeita a vida máxima.
    public void curar(int pontosDeCura) {
        if (pontosDeCura <= 0 || vida >= vidaMaxima) {
            return;
        }
        int vidaFaltante = vidaMaxima - vida;
        if (pontosDeCura >= vidaFaltante) {
            vida = vidaMaxima;
        } else {
            vida += pontosDeCura;
        }
    }

    // Exercício 19: retorna o texto; a impressão fica na classe de teste/impressora.
    public String gerarResumo() {
        return "Herói: " + nome + " | Vida: " + vida + "/" + vidaMaxima
                + " | Ataque total: " + calcularAtaqueTotal()
                + " | Defesa: " + defesa + " | Nível: " + nivel;
    }

    // Exercício 27: só consome uma poção quando consegue recuperar vida.
    public boolean usarPocao(Pocao pocao) {
        if (!estaVivo() || pocao == null || pocao.pontosCura <= 0 || inventario == null
                || inventario.quantidadePocoes <= 0 || vida >= vidaMaxima) {
            return false;
        }
        curar(pocao.pontosCura);
        inventario.quantidadePocoes--;
        return true;
    }

    // Exercício 30: o próprio monstro registra se a recompensa já foi entregue.
    public void receberRecompensa(Monstro monstro) {
        if (monstro == null || !estaVivo() || monstro.estaVivo() || monstro.recompensaRecebida) {
            return;
        }
        ouro += monstro.ouroRecompensa;
        experiencia += monstro.experienciaRecompensa;
        monstro.recompensaRecebida = true;
    }


    // Exercício 31: desconta a experiência usada e permite várias subidas.
    public void verificarSubidaDeNivel() {
        if (nivel < 1) {
            return;
        }
        while (experiencia >= (long) nivel * 100) {
            experiencia -= nivel * 100;
            nivel++;
            ataque += 3;
            vidaMaxima += 10;
            vida = vidaMaxima;
            System.out.println(nome + " subiu para o nível " + nivel + "!");
        }
    }
}
