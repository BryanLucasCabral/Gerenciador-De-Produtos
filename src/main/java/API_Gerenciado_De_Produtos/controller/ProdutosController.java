package API_Gerenciado_De_Produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_Gerenciado_De_Produtos.model.Produtos;
import API_Gerenciado_De_Produtos.services.ProdutosServices;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosServices produtosServices;

    @PostMapping
    public ResponseEntity<Produtos> salvaProdutos(@RequestBody Produtos produtos){
        return ResponseEntity.status(HttpStatus.OK).body(produtosServices.salvarProdutos(produtos));
    } 
}
