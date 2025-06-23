package PetShop;

import java.util.*;

public class PetShop {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}

class Sistema {
    private Scanner scanner = new Scanner(System.in);
    private List<Cliente> clientes = new ArrayList<>();

    public void iniciar() {
        boolean executando = true;
        while (executando) {
            System.out.println("\n1. Cadastrar Cliente\n2. Listar Clientes\n3. Buscar Cliente\n4. Excluir Cliente");
            System.out.println("5. Cadastrar Pet\n6. Listar Pets\n7. Contratar Serviço\n8. Listar Serviços\n9. Cancelar Serviço\n10. Ver Detalhes do Cliente\n11. Sair");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> excluirCliente();
                case 5 -> cadastrarPet();
                case 6 -> listarPets();
                case 7 -> contratarServico();
                case 8 -> listarServicos();
                case 9 -> cancelarServico();
                case 10 -> verDetalhesCliente();
                case 11 -> executando = false;
            }
        }
    }

    private void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        clientes.add(new Cliente(nome, telefone, email));
        System.out.println("Cliente cadastrado!");
    }

    private void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    private void buscarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        clientes.stream().filter(c -> c.getNome().equalsIgnoreCase(nome))
                .forEach(System.out::println);
    }

    private void excluirCliente() {
        System.out.print("Nome do cliente a excluir: ");
        String nome = scanner.nextLine();
        clientes.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
        System.out.println("Cliente removido.");
    }

    private void cadastrarPet() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarCliente(nomeCliente);

        if (cliente != null) {
            System.out.print("Nome do pet: ");
            String nome = scanner.nextLine();
            System.out.print("Espécie: ");
            String especie = scanner.nextLine();
            System.out.print("Raça: ");
            String raca = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());
            System.out.print("Peso: ");
            double peso = Double.parseDouble(scanner.nextLine());

            cliente.addPet(new Pet(nome, especie, raca, idade, peso));
            System.out.println("Pet cadastrado!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void listarPets() {
        for (Cliente c : clientes) {
            for (Pet p : c.getPets()) {
                System.out.println(p + " (Dono: " + c.getNome() + ")");
            }
        }
    }

    private void contratarServico() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarCliente(nomeCliente);

        if (cliente != null) {
            System.out.println("1. Serviço Avulso\n2. Pacote de Serviços");
            int tipo = Integer.parseInt(scanner.nextLine());

            if (tipo == 1) {
                Servico servico = escolherServico();
                if (servico != null) {
                    associarServicoAoPet(cliente, servico);
                }
            } else if (tipo == 2) {
                List<Servico> servicos = new ArrayList<>();
                servicos.add(new BanhoETosa());
                servicos.add(new ConsultaVeterinaria());
                servicos.add(new Hospedagem());
                servicos.add(new Adestramento());
                PacoteServicos pacote = new PacoteServicos(servicos, 0.2);
                for (Servico s : servicos) {
                    associarServicoAoPet(cliente, s);
                }
                cliente.setUltimoPacote(pacote);
                System.out.println("Pacote contratado com desconto: R$ " + pacote.calcularValorTotalComDesconto());
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void listarServicos() {
        for (Cliente c : clientes) {
            System.out.println("Serviços de " + c.getNome() + ":");
            for (Servico s : c.getServicos()) {
                System.out.println("- " + s.getDescricao());
            }
        }
    }

    private void cancelarServico() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarCliente(nomeCliente);

        if (cliente != null) {
            System.out.print("Digite parte da descrição do serviço para cancelar: ");
            String descricao = scanner.nextLine();
            cliente.getServicos().removeIf(s -> s.getDescricao().toLowerCase().contains(descricao.toLowerCase()));
            System.out.println("Serviço cancelado se encontrado.");
        }
    }

    private void verDetalhesCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = encontrarCliente(nome);
        if (cliente != null) {
            System.out.println(cliente);
            System.out.println("Pets:");
            for (Pet p : cliente.getPets()) {
                System.out.println("- " + p);
            }
            System.out.println("Serviços contratados:");
            for (Servico s : cliente.getServicos()) {
                System.out.println("- " + s.getDescricao());
            }
            if (cliente.getUltimoPacote() != null) {
                System.out.println("Último pacote contratado com valor: R$ " + cliente.getUltimoPacote().calcularValorTotalComDesconto());
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private Cliente encontrarCliente(String nomeCliente) {
        return clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente))
                .findFirst().orElse(null);
    }

    private Servico escolherServico() {
        System.out.println("Escolha o serviço: 1. Banho e Tosa 2. Consulta Veterinária 3. Hospedagem 4. Adestramento");
        int opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1:
                return new BanhoETosa();
            case 2:
                return new ConsultaVeterinaria();
            case 3:
                return new Hospedagem();
            case 4:
                return new Adestramento();
            default:
                return null;
        }
    }

    private void associarServicoAoPet(Cliente cliente, Servico servico) {
        System.out.print("Nome do pet: ");
        String nomePet = scanner.nextLine();
        Pet pet = cliente.getPets().stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nomePet))
                .findFirst().orElse(null);
        if (pet != null) {
            servico.agendar(gerarDataAleatoria());
            cliente.addServico(servico);
            System.out.println("Serviço contratado!");
        } else {
            System.out.println("Pet não encontrado.");
        }
    }

    private Date gerarDataAleatoria() {
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();
        int diasFuturos = random.nextInt(30) + 1;
        calendar.add(Calendar.DAY_OF_YEAR, diasFuturos);
        return calendar.getTime();
    }
}

class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();
    private PacoteServicos ultimoPacote;

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() { return nome; }
    public List<Pet> getPets() { return pets; }
    public List<Servico> getServicos() { return servicos; }
    public void addPet(Pet pet) { pets.add(pet); }
    public void addServico(Servico servico) { servicos.add(servico); }
    public void setUltimoPacote(PacoteServicos pacote) { this.ultimoPacote = pacote; }
    public PacoteServicos getUltimoPacote() { return ultimoPacote; }

    public String toString() {
        return "Cliente: " + nome + ", Tel: " + telefone + ", Email: " + email;
    }
}

class Pet {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;

    public Pet(String nome, String especie, String raca, int idade, double peso) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() { return nome; }

    public String toString() {
        return "Pet: " + nome + ", " + especie + ", " + raca + ", " + idade + " anos, " + peso + "kg";
    }
}

abstract class Servico {
    protected Date data;
    public void agendar(Date data) { this.data = data; }
    public abstract String getDescricao();
}

class BanhoETosa extends Servico {
    public String getDescricao() {
        return "Banho e Tosa agendado para " + data;
    }
}

class ConsultaVeterinaria extends Servico {
    public String getDescricao() {
        return "Consulta Veterinária agendada para " + data;
    }
}

class Hospedagem extends Servico {
    public String getDescricao() {
        return "Hospedagem reservada para " + data;
    }
}

class Adestramento extends Servico {
    public String getDescricao() {
        return "Aula de Adestramento marcada para " + data;
    }
}

class PacoteServicos {
    private List<Servico> servicos;
    private double desconto;

    public PacoteServicos(List<Servico> servicos, double desconto) {
        this.servicos = servicos;
        this.desconto = desconto;
    }

    public double calcularValorTotalComDesconto() {
        double total = servicos.size() * 100.0;
        return total * (1 - desconto);
    }
}