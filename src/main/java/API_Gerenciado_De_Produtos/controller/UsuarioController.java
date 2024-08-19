package API_Gerenciado_De_Produtos.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import API_Gerenciado_De_Produtos.dto.UsuarioDTO;

import API_Gerenciado_De_Produtos.model.Usuario;
import API_Gerenciado_De_Produtos.services.UsuarioService;

@Service
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuarios(usuario));
    }

    public ResponseEntity<Page<Usuario>> listarUsuarios(
            @PageableDefault(size = 10, page = 1, sort = "nome", direction = Direction.DESC) Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarUsuarios(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable("id") Long id) {
        UsuarioDTO usuario = usuarioService.buscarUsuarioPeloId(id); 

        if (Objects.isNull(usuario)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
     @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarFornecedor(@PathVariable("id") Long id, Usuario dadosUsuario) {
        UsuarioDTO usuario = usuarioService.buscarUsuarioPeloId(id);

        if (Objects.isNull(usuario)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        dadosUsuario.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizarUsuario(id, dadosUsuario));
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id){
        UsuarioDTO usuario = usuarioService.buscarUsuarioPeloId(id);

        if (Objects.isNull(usuario)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }   

        usuarioService.deletarUsuarios(id);       
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
