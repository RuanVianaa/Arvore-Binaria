import java.util.*;

public class App {

    static int menu(){
    Scanner leia = new Scanner(System.in);
    System.out.println("\n=== SISTEMA DE CADASTRO DE ALUNOS ===");
    System.out.println("1. Inserir Aluno");
    System.out.println("2. Remover Aluno");
    System.out.println("3. Buscar Aluno por Matrícula");
    System.out.println("4. Exibir Árvore de Alunos (Percursos)");
    System.out.println("0. Sair");
    System.out.print("Escolha uma opção: ");
    return leia.nextInt();
}

    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        // 1. Instanciar a árvore com o tipo Aluno em vez de Integer
        BinarySearchTree<Aluno> arvore = new BinarySearchTree<>();
        int opcao = 0;

        do {
            System.out.println("----------------------------------");
            opcao = menu();
            switch (opcao) {
                case 1:
                    // 2. Opção 1 - Inserir Aluno
                    System.out.print("Digite a matrícula do aluno: ");
                    int matriculaInserir = leia.nextInt();
                    leia.nextLine();
                    System.out.print("Digite o nome do aluno: ");
                    String nomeInserir = leia.nextLine();
                    Aluno alunoInserir = new Aluno(matriculaInserir, nomeInserir);
                    arvore.add(alunoInserir);

                    System.out.println("Aluno inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite a matrícula a ser removida: ");
                    int matRemover = leia.nextInt();
                    leia.nextLine();
                    
                    Aluno alunoRemover = new Aluno(matRemover);
                    System.out.println("Elemento removido com sucesso!");
                    break;

                case 3:
                    // 3. Opção 3 - Buscar Aluno
                    System.out.print("Digite a matrícula do aluno a ser buscado: ");
                    int matBuscar = leia.nextInt();
                    leia.nextLine();
                    Aluno alunoBusca = new Aluno(matBuscar);
                    Aluno alunoEncontrado = arvore.buscar(alunoBusca);

                    if (alunoEncontrado != null) {
                        System.out.println("Aluno encontrado: " + alunoEncontrado);
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;

                case 4:
                    // 4. Opção 4 - Exibir os percursos da árvore
                    System.out.println("Exibindo a árvore em pré-ordem:");
                    arvore.preOrder();

                    System.out.println("\nExibindo a árvore em ordem:");
                    arvore.inOrder();

                    System.out.println("\nExibindo a árvore em pós-ordem:");
                    arvore.postOrder();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
        
        leia.close();
    }
}