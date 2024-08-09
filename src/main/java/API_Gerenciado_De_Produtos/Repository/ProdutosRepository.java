package API_Gerenciado_De_Produtos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import API_Gerenciado_De_Produtos.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository <Produtos, Long>{

}
