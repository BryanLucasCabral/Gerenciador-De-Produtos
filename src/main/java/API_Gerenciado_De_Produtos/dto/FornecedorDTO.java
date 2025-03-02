package API_Gerenciado_De_Produtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDTO {
    private Long id;
    private String nome;
    private String cnpj;
}
