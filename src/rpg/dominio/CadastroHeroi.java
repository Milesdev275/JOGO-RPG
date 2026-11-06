package rpg.dominio;

// Exercício 22: preenche o objeto recebido, sem criar outro herói.
public class CadastroHeroi {
    public void cadastrar(Heroi heroi, String nome, int vidaMaxima, int ataque, int defesa) {
        // Exercício 43: valida tudo antes de modificar o objeto.
        if (heroi == null || nome == null || nome.isBlank() || vidaMaxima <= 0
                || ataque < 0 || defesa < 0) {
            throw new IllegalArgumentException("Nome, vida máxima, ataque ou defesa inválidos.");
        }
        heroi.nome = nome.trim();
        heroi.vidaMaxima = vidaMaxima;
        heroi.vida = vidaMaxima;
        heroi.ataque = ataque;
        heroi.defesa = defesa;
        heroi.nivel = 1;
        heroi.experiencia = 0;
        heroi.ouro = 30;
        heroi.inventario = new Inventario();
        heroi.inventario.quantidadePocoes = 2;
    }
}
