package API_Gerenciado_De_Produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import API_Gerenciado_De_Produtos.Repository.FornecedorRepository;
import API_Gerenciado_De_Produtos.model.Fornecedor;

@Service
public class FornecedoresServices {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor salvarFornecedor(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public Page<Fornecedor> listarProdutos(Pageable paginacao){
        return fornecedorRepository.findAll(paginacao);
    }

    public void deletarFornecedores(Long id){
        fornecedorRepository.findById(id);
    }

    public Fornecedor atualizarFornecedor(Long id,Fornecedor dadosFornecedor){
        
    }
}
