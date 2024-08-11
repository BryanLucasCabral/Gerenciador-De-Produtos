package API_Gerenciado_De_Produtos.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import API_Gerenciado_De_Produtos.dto.ProdutosDTO;
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

    @GetMapping
    public ResponseEntity<List<Produtos>> listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtosServices.listarProdutos());
    } 

    @GetMapping("/filtro")
    public ResponseEntity<List<Produtos>> listarProdutosDasMarcas(@RequestParam("marca") String marca){
        return ResponseEntity.status(HttpStatus.OK).body(produtosServices.listarProdutosDasMarcas(marca));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutosDTO> buscarUsuarioPeloId(@PathVariable("id") Long id){
        ProdutosDTO produtos = produtosServices.buscarProdutoPeloId(id);

        if (Objects.isNull(produtos)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutos(@PathVariable("id") Long id){
        ProdutosDTO produtos = produtosServices.buscarProdutoPeloId(id);

        if (Objects.isNull(produtos)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        produtosServices.deletarProdutos(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarProdutos(@PathVariable("id") Long id, @RequestBody Produtos dadosProdutos){
        ProdutosDTO produtos = produtosServices.buscarProdutoPeloId(id);

        if (Objects.isNull(produtos)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtosServices.atualizarProdutos(id, dadosProdutos));
    }
}
