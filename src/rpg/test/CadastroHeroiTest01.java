package rpg.test;

import rpg.dominio.*;

// Exercício 22. Execute com -ea para habilitar as verificações.
public class CadastroHeroiTest01 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        Heroi arthur = new Heroi();
        Heroi luna = new Heroi();
        cadastro.cadastrar(arthur, "Arthur", 100, 15, 5);
        cadastro.cadastrar(luna, "Luna", 80, 20, 3);
        ImpressoraRPG impressora = new ImpressoraRPG();
        impressora.imprimirHeroi(arthur);
        impressora.imprimirHeroi(luna);
        assert arthur.nome.equals("Arthur") && arthur.vidaMaxima == 100 && arthur.vida == 100;
        assert arthur.ataque == 15 && arthur.defesa == 5;
        assert arthur.nivel == 1 && arthur.experiencia == 0 && arthur.ouro == 30;
        assert arthur.inventario.quantidadePocoes == 2;
        assert luna.nome.equals("Luna") && luna.vidaMaxima == 80 && luna.vida == 80;
        assert luna.ataque == 20 && luna.defesa == 3;
        assert luna.nivel == 1 && luna.experiencia == 0 && luna.ouro == 30;
        assert luna.inventario.quantidadePocoes == 2;
        assert arthur.inventario != luna.inventario : "Cada herói deve ter seu próprio inventário";
        arthur.inventario.quantidadePocoes--;
        assert luna.inventario.quantidadePocoes == 2 : "Inventários devem ser independentes";
        System.out.println("CadastroHeroiTest01: verificações concluídas.");
    }
}
