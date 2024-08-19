package API_Gerenciado_De_Produtos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import API_Gerenciado_De_Produtos.model.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    
}
