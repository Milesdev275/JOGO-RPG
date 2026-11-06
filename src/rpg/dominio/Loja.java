package rpg.dominio;

public class Loja {
    // Exercício 28.
    public boolean comprarPocao(Heroi heroi, Pocao pocao) {
        if (heroi == null || heroi.inventario == null || pocao == null
                || pocao.preco <= 0 || heroi.ouro < pocao.preco) {
            return false;
        }
        heroi.ouro -= pocao.preco;
        heroi.inventario.quantidadePocoes++;
        return true;
    }

    // Exercício 29: o ouro é inteiro; não arredondamos preços fracionados de armas.
    public boolean comprarArma(Heroi heroi, Arma arma) {
        if (heroi == null || heroi.inventario == null || arma == null
                || !Double.isFinite(arma.preco) || arma.preco <= 0
                || arma.preco != Math.floor(arma.preco) || heroi.ouro < arma.preco) {
            return false;
        }
        heroi.ouro -= (int) arma.preco;
        heroi.inventario.armaEquipada = arma;
        return true;
    }
}
