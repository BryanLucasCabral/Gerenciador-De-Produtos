package API_Gerenciado_De_Produtos.model;

import API_Gerenciado_De_Produtos.dto.FornecedorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    public FornecedorDTO toDTO(){
        FornecedorDTO dto = new FornecedorDTO();

        dto.setCnpj(cnpj);
        dto.setNome(nome);
        dto.setId(id);

        return dto;

    }
}
