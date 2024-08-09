package API_Gerenciado_De_Produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import API_Gerenciado_De_Produtos.Repository.ProdutosRepository;

@Service
public class ProdutosServices {
    @Autowired
    private ProdutosRepository produtosRepository;
}
