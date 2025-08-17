package br.com.mixmercado.mix_mercado.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "TDS_TB_MERCADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private String Tipo;
    private String setor;
    private String tamanho;
    private Double preco;

}
