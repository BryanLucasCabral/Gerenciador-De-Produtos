package API_Gerenciado_De_Produtos.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import API_Gerenciado_De_Produtos.Repository.ProdutosRepository;
import API_Gerenciado_De_Produtos.dto.ProdutosDTO;
import API_Gerenciado_De_Produtos.model.Produtos;

@Service
public class ProdutosServices {
    @Autowired
    private ProdutosRepository produtosRepository;

    public Produtos salvarProdutos(Produtos produtos){
        return produtosRepository.save(produtos);
    }

    public List<Produtos> listarProdutos(){
        return produtosRepository.findAll();
    }

    public List<Produtos> listarMarcas(String marca){
        return produtosRepository.findByMarcaLike(marca);
    }

    public void deletarProdutos(Long id){
        produtosRepository.deleteById(id);
    }

    public ProdutosDTO buscarProdutoPeloId(Long id){
        Optional<Produtos> produtosOpt = produtosRepository.findById(id);

        if (produtosOpt.isPresent()) {
            return produtosOpt.get().toDTO();
        }

        return null;
    }

    public Produtos atualizarProdutos(Long id, Produtos dadosProdutos){
        Optional<Produtos> produtosOpt = produtosRepository.findById(id);
        
        if (produtosOpt.isPresent()) {
            Produtos produtos = produtosOpt.get();

            produtos.setNome(dadosProdutos.getNome());
            produtos.setDescricao(dadosProdutos.getDescricao());

            return produtosRepository.save(produtos);
        }

        return null;
    }
}
