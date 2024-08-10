package API_Gerenciado_De_Produtos.dto;

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
}
