package org.br.lucaspjardim.domain;

import javax.persistence.*;

/**
 * Author: Lucas Jardim
 */
@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_sequence")
    @SequenceGenerator(name = "marca_sequence", sequenceName = "sq_marca", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "Nome", length = 50, nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
