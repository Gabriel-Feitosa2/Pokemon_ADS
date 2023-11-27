import java.util.Random;

class Pokemon {
    String nome;
    int nivel;

    public Pokemon(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("N�vel: " + nivel);
    }
}

class TreinadorPokemon {
    String nome;
    Pokemon pokemonAtual;

    public TreinadorPokemon(String nome) {
        this.nome = nome;
    }

    public void capturarPokemon(String nomePokemon) {
        Random random = new Random();
        int nivelPokemon = random.nextInt(100) + 1; // N�vel aleat�rio entre 1 e 100
        Pokemon novoPokemon = new Pokemon(nomePokemon, nivelPokemon);
        System.out.println(nome + " capturou um novo Pok�mon!");
        this.pokemonAtual = novoPokemon;
    }

    public void treinarPokemon() {
        if (pokemonAtual != null) {
            System.out.println(nome + " est� treinando " + pokemonAtual.nome + "!");
            pokemonAtual.nivel += 10;
            System.out.println(pokemonAtual.nome + " ganhou 10 n�veis no treinamento!");
        } else {
            System.out.println(nome + " n�o tem um Pok�mon para treinar. Capture um primeiro!");
        }
    }

    public void desafiarTreinador(TreinadorPokemon oponente) {
        System.out.println(nome + " desafiou " + oponente.nome + " para uma batalha!");

        if (pokemonAtual == null || oponente.pokemonAtual == null) {
            System.out.println("N�o � poss�vel iniciar a batalha. Certifique-se de que ambos os treinadores tenham Pok�mon.");
            return;
        }

        System.out.println("Batalha iniciada!");
        System.out.println(nome + " envia " + pokemonAtual.nome + " para a batalha!");
        System.out.println(oponente.nome + " envia " + oponente.pokemonAtual.nome + " para a batalha!");

        // Resolver a batalha com base nos n�veis dos Pok�mon
        if (pokemonAtual.nivel > oponente.pokemonAtual.nivel) {
            System.out.println(nome + " venceu a batalha!");
        } else if (pokemonAtual.nivel < oponente.pokemonAtual.nivel) {
            System.out.println(oponente.nome + " venceu a batalha!");
        } else {
            System.out.println("A batalha terminou em empate!");
        }
    }

    public void exibirInformacoesPokemon() {
        if (pokemonAtual != null) {
            System.out.println(nome + " possui o seguinte Pok�mon:");
            pokemonAtual.exibirInformacoes();
        } else {
            System.out.println(nome + " n�o possui nenhum Pok�mon. Capture um primeiro!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Criar treinadores
        TreinadorPokemon ash = new TreinadorPokemon("Ash");
        TreinadorPokemon gary = new TreinadorPokemon("Gary");

        // Capturar Pok�mon
        ash.capturarPokemon("Pikachu");
        gary.capturarPokemon("Eevee");

        // Exibir informa��es dos Pok�mon dos treinadores
        ash.exibirInformacoesPokemon();
        gary.exibirInformacoesPokemon();

        // Ash treina seu Pok�mon
        ash.treinarPokemon();

        // Ash desafia Gary para uma batalha
        ash.desafiarTreinador(gary);
    }
}
