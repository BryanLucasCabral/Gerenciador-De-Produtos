package API_Gerenciado_De_Produtos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import API_Gerenciado_De_Produtos.model.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long>{
    
}
