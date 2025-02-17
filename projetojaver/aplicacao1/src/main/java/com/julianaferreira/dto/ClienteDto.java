package com.julianaferreira.dto;

public class ClienteDto {

    private Long id;
    private String nome;
    private Long telefone;
    private Boolean correntista;
    private Float scoreCredito;
    private Float saldoCc;

    // Getters e Setters
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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Boolean getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Boolean correntista) {
        this.correntista = correntista;
    }

    public Float getScoreCredito() {
        return scoreCredito;
    }

    public void setScoreCredito(Float scoreCredito) {
        this.scoreCredito = scoreCredito;
    }

    public Float getSaldoCc() {
        return saldoCc;
    }

    // Quando definir saldoCc, calcula automaticamente o scoreCredito
    public void setSaldoCc(Float saldoCc) {
        this.saldoCc = saldoCc;
        this.scoreCredito = (saldoCc != null) ? saldoCc * 0.1f : 0f;
    }
}
