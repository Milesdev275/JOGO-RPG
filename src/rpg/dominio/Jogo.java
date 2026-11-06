package rpg.dominio;

import java.util.Scanner;

public class Jogo {
    public String titulo;
    public Heroi heroi;
    public boolean emExecucao;
    public Fase[] fases;
    public int indiceFaseAtual;
    public Pocao pocao = new Pocao();
    public Pocao pocaoGrande = new Pocao();
    public Arma espadaMadeira = new Arma();
    public Arma espadaFerro = new Arma();
    public Batalha batalha = new Batalha();
    public Loja loja = new Loja();
    public ImpressoraRPG impressora = new ImpressoraRPG();

    // Exercícios 32 e 33.
    public void configurar(Heroi heroi, Fase[] fases) {
        if (heroi == null || fases == null || fases.length == 0) {
            throw new IllegalArgumentException("O jogo precisa de um herói e de fases.");
        }
        this.heroi = heroi;
        this.fases = fases;
        indiceFaseAtual = 0;
        emExecucao = true;
        titulo = "RPG: A Jornada de Eldoria";
        pocao.nome = "Poção Pequena";
        pocao.pontosCura = 20;
        pocao.preco = 10;
        pocaoGrande.nome = "Poção Grande";
        pocaoGrande.pontosCura = 50;
        pocaoGrande.preco = 25;
        espadaMadeira.nome = "Espada de Madeira";
        espadaMadeira.bonusAtaque = 2;
        espadaMadeira.preco = 50;
        espadaFerro.nome = "Espada de Ferro";
        espadaFerro.bonusAtaque = 8;
        espadaFerro.preco = 150;
    }

    // Exercício 34.
    public void exibirBoasVindas() {
        System.out.println("Bem-vindo ao " + titulo + "!");
        System.out.println("Herói: " + heroi.nome);
        System.out.println("Criaturas invadiram as florestas, cavernas e o castelo de Eldoria.");
        System.out.println("Sua missão é derrotar o Guardião Sombrio e salvar o reino.");
    }

    // Exercício 35.
    public void exibirMenu() {
        System.out.println("\n================================");
        System.out.println("RPG - ELDORIA");
        System.out.println("================================");
        System.out.println("1 - Ver status do herói\n2 - Explorar / Lutar\n3 - Abrir inventário\n4 - Visitar loja\n5 - Sair do jogo");
        System.out.print("Escolha uma opção: ");
    }

    // Exercícios 36 e 42. A linha inteira é consumida, inclusive quando inválida.
    public int lerOpcao(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            emExecucao = false;
            return 5;
        }
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
            return -1;
        }
    }

    public void executarOpcao(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1:
                impressora.imprimirHeroi(heroi);
                System.out.println("Experiência: " + heroi.experiencia + "/" + (heroi.nivel * 100));
                System.out.println("Ouro: " + heroi.ouro);
                break;
            case 2:
                explorar(scanner);
                break;
            case 3:
                abrirInventario(scanner);
                break;
            case 4:
                visitarLoja(scanner);
                break;
            case 5:
                emExecucao = false;
                System.out.println("Jogo encerrado. Até a próxima jornada!");
                break;
            default:
                System.out.println("Opção inexistente. Escolha de 1 a 5.");
        }
    }

    // Exercício 37.
    public void iniciar(Scanner scanner) {
        exibirBoasVindas();
        while (emExecucao && heroi.estaVivo() && indiceFaseAtual < fases.length) {
            exibirMenu();
            executarOpcao(lerOpcao(scanner), scanner);
        }
        if (!heroi.estaVivo()) {
            emExecucao = false;
            System.out.println("=====================================\nGAME OVER\n=====================================");
            System.out.println("Seu herói foi derrotado. Sua jornada terminou...");
        }
    }

    public void explorar(Scanner scanner) {
        if (!heroi.estaVivo() || indiceFaseAtual >= fases.length) {
            return;
        }
        Fase fase = fases[indiceFaseAtual];
        System.out.println("\nFase: " + fase.nome);
        impressora.imprimirMonstro(fase.inimigo);
        if (batalha.iniciarBatalha(heroi, fase.inimigo, pocao, scanner)) {
            avancarFase();
        }
    }

    // Exercício 39: as poções compartilham a quantidade do inventário, conforme o modelo pedido.
    public void abrirInventario(Scanner scanner) {
        int opcao;
        do {
            impressora.imprimirInventario(heroi);
            System.out.println("1 - Usar Poção Pequena (cura 20)\n0 - Voltar");
            opcao = lerOpcao(scanner);
            if (!emExecucao) return;
            if (opcao == 1) {
                System.out.println(heroi.usarPocao(pocao) ? "Poção utilizada." : "Não foi possível usar a poção.");
            } else if (opcao != 0) {
                System.out.println("Opção inexistente.");
            }
        } while (opcao != 0);
    }

    public void visitarLoja(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\nLOJA DE ELDORIA | Ouro: " + heroi.ouro);
            System.out.println("1 - Poção Pequena: " + pocao.preco + " de ouro");
            System.out.println("2 - Espada de Madeira (+2): " + (int) espadaMadeira.preco + " de ouro");
            System.out.println("3 - Espada de Ferro (+8): " + (int) espadaFerro.preco + " de ouro");
            System.out.println("0 - Voltar");
            opcao = lerOpcao(scanner);
            if (!emExecucao) return;
            boolean comprou;
            switch (opcao) {
                case 0: return;
                case 1: comprou = loja.comprarPocao(heroi, pocao); break;
                case 2: comprou = loja.comprarArma(heroi, espadaMadeira); break;
                case 3: comprou = loja.comprarArma(heroi, espadaFerro); break;
                default:
                    System.out.println("Opção inexistente.");
                    continue;
            }
            System.out.println(comprou ? "Compra realizada!" : "Compra recusada: verifique seu ouro e o produto.");
        } while (opcao != 0);
    }

    // Exercício 40: fase e monstro protegem a recompensa de duplicação.
    public void avancarFase() {
        if (indiceFaseAtual >= fases.length || !heroi.estaVivo()) return;
        Fase fase = fases[indiceFaseAtual];
        if (fase.concluida || fase.inimigo.estaVivo()) return;
        heroi.receberRecompensa(fase.inimigo);
        heroi.verificarSubidaDeNivel();
        fase.concluida = true;
        indiceFaseAtual++;
        if (indiceFaseAtual >= fases.length) {
            emExecucao = false;
            System.out.println("=====================================\nPARABÉNS, HERÓI!\n=====================================");
            System.out.println("Você derrotou o Guardião Sombrio!\nO Reino de Eldoria foi salvo!\nObrigado por jogar.");
        } else {
            System.out.println("Próxima fase desbloqueada: " + fases[indiceFaseAtual].nome);
        }
    }
}
