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
        System.out.println("Nível: " + nivel);
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
        int nivelPokemon = random.nextInt(100) + 1; // Nível aleatório entre 1 e 100
        Pokemon novoPokemon = new Pokemon(nomePokemon, nivelPokemon);
        System.out.println(nome + " capturou um novo Pokémon!");
        this.pokemonAtual = novoPokemon;
    }

    public void treinarPokemon() {
        if (pokemonAtual != null) {
            System.out.println(nome + " está treinando " + pokemonAtual.nome + "!");
            pokemonAtual.nivel += 10;
            System.out.println(pokemonAtual.nome + " ganhou 10 níveis no treinamento!");
        } else {
            System.out.println(nome + " não tem um Pokémon para treinar. Capture um primeiro!");
        }
    }

    public void desafiarTreinador(TreinadorPokemon oponente) {
        System.out.println(nome + " desafiou " + oponente.nome + " para uma batalha!");

        if (pokemonAtual == null || oponente.pokemonAtual == null) {
            System.out.println("Não é possível iniciar a batalha. Certifique-se de que ambos os treinadores tenham Pokémon.");
            return;
        }

        System.out.println("Batalha iniciada!");
        System.out.println(nome + " envia " + pokemonAtual.nome + " para a batalha!");
        System.out.println(oponente.nome + " envia " + oponente.pokemonAtual.nome + " para a batalha!");

        // Resolver a batalha com base nos níveis dos Pokémon
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
            System.out.println(nome + " possui o seguinte Pokémon:");
            pokemonAtual.exibirInformacoes();
        } else {
            System.out.println(nome + " não possui nenhum Pokémon. Capture um primeiro!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Criar treinadores
        TreinadorPokemon ash = new TreinadorPokemon("Ash");
        TreinadorPokemon gary = new TreinadorPokemon("Gary");

        // Capturar Pokémon
        ash.capturarPokemon("Pikachu");
        gary.capturarPokemon("Eevee");

        // Exibir informações dos Pokémon dos treinadores
        ash.exibirInformacoesPokemon();
        gary.exibirInformacoesPokemon();

        // Ash treina seu Pokémon
        ash.treinarPokemon();

        // Ash desafia Gary para uma batalha
        ash.desafiarTreinador(gary);
    }
}
