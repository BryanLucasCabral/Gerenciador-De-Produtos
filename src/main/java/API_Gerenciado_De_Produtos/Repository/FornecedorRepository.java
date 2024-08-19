package API_Gerenciado_De_Produtos.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import API_Gerenciado_De_Produtos.model.Fornecedor;

/**
 * FornecedorRepository
 */
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByCnpj(String cnpj);

    
}
