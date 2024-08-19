package API_Gerenciado_De_Produtos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import API_Gerenciado_De_Produtos.Repository.UsuarioRepository;

import API_Gerenciado_De_Produtos.dto.UsuarioDTO;

import API_Gerenciado_De_Produtos.model.Usuario;

@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuarios(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

        public Page<Usuario> listarUsuarios(Pageable paginacao){
        return usuarioRepository.findAll(paginacao);
    }

        public UsuarioDTO buscarUsuarioPeloId(Long id){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get().toDTO();
        }
        return null;
    }
    
    public void deletarUsuarios(Long id){
        usuarioRepository.findById(id);
    }

     public Usuario atualizarUsuario(Long id,Usuario dadosUsuario){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setName(dadosUsuario.getName());

            return usuarioRepository.save(usuario);
        }

        return null;
    }
}
