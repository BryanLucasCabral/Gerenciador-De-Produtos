package API_Gerenciado_De_Produtos.model;

import API_Gerenciado_De_Produtos.constants.StatusProdutos;
import API_Gerenciado_De_Produtos.dto.ProdutosDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTOS")
    private Long id;

    @Column(name = "NOME_PRODUTOS", nullable = false, unique = false)
    private String nome;

    @Column(name = "DESC_PRODUTOS", nullable = false)
    private String descricao;

    @Column(name = "MARCA_PRODUTOS", nullable = false)
    private String marca;

    @Column(name = "STATUS_PRODUTOS", nullable = false)
    private StatusProdutos status;

    public ProdutosDTO toDTO(){
        ProdutosDTO dto = new ProdutosDTO();

        dto.setId(id);
        dto.setNome(nome);
        dto.setDescricao(descricao);

        return dto;
    }
}
