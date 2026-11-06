package rpg.test;

import java.util.Scanner;
import rpg.dominio.*;

// Exercícios 32 a 42, 49 e 50: testes determinísticos de integração e QA.
public class JogoCompletoTest01 {
    public static void registrar(String id, String funcionalidade, String entrada,
                                 String esperado, String obtido, boolean passou) {
        System.out.println("QA;" + id + ";" + funcionalidade + ";" + entrada + ";" + esperado + ";" + obtido + ";" + (passou ? "Aprovado" : "Reprovado"));
        CenariosQA.verificar(passou, id + " - " + funcionalidade);
    }
    public static void main(String[] args) {
        Jogo j = CenariosQA.jogo();
        Heroi h = j.heroi;
        registrar("QA-001", "Cadastro", "Arthur, 100, 15, 5", "Nível 1, ouro 30, poções 2", "Nível " + h.nivel + ", ouro " + h.ouro + ", poções " + h.inventario.quantidadePocoes,
                h.nivel == 1 && h.ouro == 30 && h.inventario.quantidadePocoes == 2 && h.vida == 100);
        boolean comprou = j.loja.comprarPocao(h, j.pocao);
        registrar("QA-002", "Compra de poção", "30 ouro e preço 10", "20 ouro e 3 poções", h.ouro + " ouro e " + h.inventario.quantidadePocoes + " poções", comprou && h.ouro == 20 && h.inventario.quantidadePocoes == 3);
        h.ouro = 50;
        comprou = j.loja.comprarArma(h, j.espadaMadeira);
        registrar("QA-003", "Compra de arma", "50 ouro, bônus 2", "0 ouro e ataque 17", h.ouro + " ouro e ataque " + h.calcularAtaqueTotal(), comprou && h.ouro == 0 && h.calcularAtaqueTotal() == 17);
        h.vida = 90;
        boolean usou = h.usarPocao(j.pocao);
        registrar("QA-004", "Uso de poção", "Vida 90, cura 20", "Vida 100, consome 1", "Vida " + h.vida + ", poções " + h.inventario.quantidadePocoes, usou && h.vida == 100 && h.inventario.quantidadePocoes == 2);

        Heroi vencedor = CenariosQA.heroi();
        Monstro goblin = CenariosQA.monstro(30);
        boolean venceu = new Batalha().iniciarBatalha(vencedor, goblin, j.pocao, new Scanner("1\n1\n1\n"));
        registrar("QA-005", "Vitória em batalha", "Arthur contra Goblin, 3 ataques", "Vitória, herói 98, monstro 0", "Vitória " + venceu + ", herói " + vencedor.vida + ", monstro " + goblin.vida, venceu && vencedor.vida == 98 && goblin.vida == 0);
        Heroi fragil = CenariosQA.heroi();
        fragil.vida = 1;
        Monstro forte = CenariosQA.monstro(30);
        venceu = new Batalha().iniciarBatalha(fragil, forte, j.pocao, new Scanner("1\n"));
        registrar("QA-006", "Derrota", "Herói com 1 de vida", "Derrota e vida 0", "Vitória " + venceu + ", vida " + fragil.vida, !venceu && fragil.vida == 0 && fragil.ouro == 30);
        Heroi fugitivo = CenariosQA.heroi();
        Monstro intacto = CenariosQA.monstro(30);
        venceu = new Batalha().iniciarBatalha(fugitivo, intacto, j.pocao, new Scanner("3\n"));
        registrar("QA-007", "Fuga", "Opção 3", "Sem recompensa e sem dano", "Ouro " + fugitivo.ouro + ", vida " + fugitivo.vida + ", inimigo " + intacto.vida, !venceu && fugitivo.ouro == 30 && fugitivo.vida == 100 && intacto.vida == 30);
        Heroi evoluido = CenariosQA.heroi();
        evoluido.experiencia = 300;
        evoluido.verificarSubidaDeNivel();
        registrar("QA-008", "Subida de nível", "300 XP no nível 1", "Nível 3, ataque 21, vida 120, XP 0", "Nível " + evoluido.nivel + ", ataque " + evoluido.ataque + ", vida " + evoluido.vida + ", XP " + evoluido.experiencia, evoluido.nivel == 3 && evoluido.ataque == 21 && evoluido.vida == 120 && evoluido.experiencia == 0);
        Jogo entradas = CenariosQA.jogo();
        entradas.iniciar(new Scanner("abc\n@\n100\n5\n"));
        registrar("QA-009", "Entrada inválida", "abc, @, 100 e 5", "Permite nova tentativa e encerra com 5", "Em execução " + entradas.emExecucao + ", vida " + entradas.heroi.vida, !entradas.emExecucao && entradas.heroi.vida == 100);
        Jogo completo = CenariosQA.jogo();
        String campanha = "2\n" + "1\n".repeat(3) + "2\n" + "1\n".repeat(4) + "2\n" + "1\n".repeat(7);
        completo.iniciar(new Scanner(campanha));
        registrar("QA-010", "Chefe final", "Três fases, apenas ataques", "3 fases concluídas e campanha encerrada", "Fases " + completo.indiceFaseAtual + ", em execução " + completo.emExecucao,
                completo.indiceFaseAtual == 3 && !completo.emExecucao && completo.heroi.estaVivo()
                && completo.fases[0].concluida && completo.fases[1].concluida && completo.fases[2].concluida);
        int ouroFinal = completo.heroi.ouro;
        int xpFinal = completo.heroi.experiencia;
        completo.avancarFase();
        completo.heroi.receberRecompensa(completo.fases[2].inimigo);
        registrar("QA-011", "Recompensa única", "Repetir avanço e recompensa", "Ouro e XP inalterados", "Ouro " + completo.heroi.ouro + ", XP " + completo.heroi.experiencia, ouroFinal == completo.heroi.ouro && xpFinal == completo.heroi.experiencia);
        Jogo loja = CenariosQA.jogo();
        loja.visitarLoja(new Scanner("1\n2\n0\n"));
        registrar("QA-012", "Menu da loja", "Comprar poção, tentar arma e voltar", "Ouro 20, poções 3, sem arma", "Ouro " + loja.heroi.ouro + ", poções " + loja.heroi.inventario.quantidadePocoes, loja.heroi.ouro == 20 && loja.heroi.inventario.quantidadePocoes == 3 && loja.heroi.inventario.armaEquipada == null);
        Jogo fimEntrada = CenariosQA.jogo();
        fimEntrada.iniciar(new Scanner(""));
        registrar("QA-013", "Fim de entrada", "Terminal sem novas linhas", "Encerra sem laço infinito", "Em execução " + fimEntrada.emExecucao, !fimEntrada.emExecucao);
        Heroi protegido = CenariosQA.heroi();
        Monstro paciente = CenariosQA.monstro(30);
        new Batalha().iniciarBatalha(protegido, paciente, j.pocao, new Scanner("abc\n100\n2\n3\n"));
        registrar("QA-014", "Ação inválida em batalha", "Texto, opção inexistente e poção com vida cheia", "Nenhum contra-ataque", "Vida " + protegido.vida + ", poções " + protegido.inventario.quantidadePocoes, protegido.vida == 100 && protegido.inventario.quantidadePocoes == 2);
        Jogo derrota = CenariosQA.jogo();
        derrota.heroi.vida = 1;
        derrota.iniciar(new Scanner("2\n1\n"));
        registrar("QA-015", "GAME OVER", "Herói com 1 de vida explora e ataca", "Encerra por morte, fase não concluída", "Vida " + derrota.heroi.vida + ", fase " + derrota.indiceFaseAtual, !derrota.emExecucao && derrota.heroi.vida == 0 && derrota.indiceFaseAtual == 0);
    }
}
