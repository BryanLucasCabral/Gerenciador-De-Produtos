package API_Gerenciado_De_Produtos.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_Gerenciado_De_Produtos.dto.FornecedorDTO;
import API_Gerenciado_De_Produtos.model.Fornecedor;
import API_Gerenciado_De_Produtos.services.FornecedoresServices;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedoresServices fornecedoresServices;

    public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedoresServices.salvarFornecedor(fornecedor));
    }

    public ResponseEntity<Page<Fornecedor>> listarFornecedores(
            @PageableDefault(size = 10, page = 1, sort = "nome", direction = Direction.DESC) Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(fornecedoresServices.listarFornecedores(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscarFornecedor(@PathVariable("id") Long id) {
        FornecedorDTO fornecedor = fornecedoresServices.buscarFornecedorPeloId(id);

        if (Objects.isNull(fornecedor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable("id") Long id, Fornecedor dadosFornecedor) {
        FornecedorDTO fornecedor = fornecedoresServices.buscarFornecedorPeloId(id);

        if (Objects.isNull(fornecedor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        dadosFornecedor.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedoresServices.atualizarFornecedor(id, dadosFornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable("id") Long id){
        FornecedorDTO fornecedor = fornecedoresServices.buscarFornecedorPeloId(id);

        if (Objects.isNull(fornecedor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }   

        fornecedoresServices.deletarFornecedores(id);       
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
