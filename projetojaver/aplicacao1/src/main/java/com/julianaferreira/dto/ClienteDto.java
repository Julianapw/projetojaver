package com.julianaferreira.dto;

import java.math.BigDecimal;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class ClienteDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define Id como chave primária
    private Long id;

    @Nonnull
    @Size(max = 100) //garante que o nome não pode ser nulo
    private String nome;

    @Size(max = 15)
    private String telefone; //limita o telefone a 15 caracteres

    private Boolean correntista; //indica se o cliente possui uma conta no banco

    private Float scoreCredito; //armazena o credito

    @Column(name = "saldo_cc", precision = 15, scale = 2)
    private BigDecimal saldoCc;

    // Construtores
    public ClienteDto() {
    }

    public ClienteDto(String nome, String telefone, Boolean correntista, Float scoreCredito, BigDecimal saldoCc) {
        this.nome = nome;
        this.telefone = telefone;
        this.correntista = correntista;
        this.scoreCredito = scoreCredito;
        this.saldoCc = saldoCc; //recebe os dados do cliente
    }

    // Getters e Setters
    public Long getId() {
        return id; //obter e definir o Id
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Boolean correntista) {
        this.correntista = correntista; //verifica se o cliente é correntista
    }

    public Float getScoreCredito() {
        return scoreCredito;
    }

    public void setScoreCredito(Float scoreCredito) {
        this.scoreCredito = scoreCredito;
    }

    public BigDecimal getSaldoCc() {
        return saldoCc;
    }

    public void setSaldoCc(BigDecimal saldoCc) {
        this.saldoCc = saldoCc;
    }

    // Método toString
    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", correntista=" + correntista +
                ", scoreCredito=" + scoreCredito +
                ", saldoCc=" + saldoCc +
                '}';
    }

   
}