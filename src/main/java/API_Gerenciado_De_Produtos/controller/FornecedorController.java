package API_Gerenciado_De_Produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_Gerenciado_De_Produtos.model.Fornecedor;
import API_Gerenciado_De_Produtos.services.FornecedoresServices;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedoresServices fornecedoresServices;

    public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedoresServices.salvarFornecedor(fornecedor));
    }
}
