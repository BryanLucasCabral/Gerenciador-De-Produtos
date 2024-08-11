package API_Gerenciado_De_Produtos.dto;

import API_Gerenciado_De_Produtos.constants.StatusProdutos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String marca;
    private StatusProdutos status;
}
