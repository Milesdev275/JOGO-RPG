package rpg.dominio;

// Exercício 21: a mesma impressora pode receber diferentes objetos.
public class ImpressoraRPG {
    public void imprimirHeroi(Heroi heroi) {
        System.out.println(heroi.gerarResumo());
    }

    public void imprimirMonstro(Monstro monstro) {
        System.out.println(monstro.gerarResumo());
    }

    // Exercício 41.
    public void imprimirInventario(Heroi heroi) {
        System.out.println("Inventário de " + heroi.nome);
        if (heroi.inventario == null || heroi.inventario.armaEquipada == null) {
            System.out.println("Nenhuma arma equipada");
        } else {
            Arma arma = heroi.inventario.armaEquipada;
            System.out.println("Arma: " + arma.nome + " | Bônus de ataque: " + arma.bonusAtaque);
        }
        int quantidade = heroi.inventario == null ? 0 : heroi.inventario.quantidadePocoes;
        System.out.println("Poções: " + quantidade);
        System.out.println("Ouro: " + heroi.ouro);
    }
}
