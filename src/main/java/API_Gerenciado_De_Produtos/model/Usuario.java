package API_Gerenciado_De_Produtos.model;

import API_Gerenciado_De_Produtos.dto.UsuarioDTO;
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
@Entity(name = "tb_usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private  Long id;

    @Column(name = "NOME_USUARIO")
    private String name;

    @Column(name = "EMAIL_USUARIO")
    private String email;


    public UsuarioDTO toDTO (){
        UsuarioDTO dto = new UsuarioDTO();

        dto.setName(name);
        dto.setEmail(email);

        return dto;
    }
}
