package org.example.cadastroprodutos;

import java.util.HashMap;
import java.util.Map;

public class ProdutoRepositorioImpl implements ProdutoRepositorio {
    private final Map<Integer, Produto> produtos = new HashMap<>();

    @Override
    public void cadastrarProduto(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    @Override
    public Produto buscarProduto(int codigo) {
        return produtos.get(codigo);
    }
}
