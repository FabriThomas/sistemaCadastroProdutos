package org.example.cadastroprodutos;

public interface ProdutoRepositorio {
    void cadastrarProduto(Produto produto);
    Produto buscarProduto(int codigo);
}