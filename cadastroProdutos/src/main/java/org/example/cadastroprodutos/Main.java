package org.example.cadastroprodutos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoRepositorio repositorio = new ProdutoRepositorioImpl();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int codigo;
                    while (true) {
                        System.out.print("Digite o código do produto: ");
                        if (scanner.hasNextInt()) {
                            codigo = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Entrada inválida! Digite um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    if (repositorio.buscarProduto(codigo) != null) {
                        System.out.println("Código já cadastrado!");
                        break;
                    }

                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    double preco;
                    while (true) {
                        System.out.print("Digite o preço do produto: ");
                        if (scanner.hasNextDouble()) {
                            preco = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Entrada inválida! Digite um número válido para o preço.");
                            scanner.nextLine();
                        }
                    }

                    repositorio.cadastrarProduto(new Produto(codigo, nome, preco));
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o código do produto: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida! Digite um número inteiro.");
                        scanner.next();
                    }
                    int codigoBusca = scanner.nextInt();
                    scanner.nextLine();

                    Produto produto = repositorio.buscarProduto(codigoBusca);
                    if (produto != null) {
                        System.out.println("Produto encontrado: " + produto);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}