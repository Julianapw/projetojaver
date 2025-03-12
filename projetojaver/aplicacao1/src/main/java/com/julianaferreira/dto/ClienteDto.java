package com.julianaferreira.dto;

public class ClienteDto {

    private Long id;
    private String nome;
    private String email;
    private Long telefone;
    private Boolean correntista;
    private Float scoreCredito;
    private Float saldoCc;

    // Construtor padrão necessário para serialização/deserialização
    public ClienteDto() {
        // Inicialização padrão, se necessário
    }

    // Construtor completo
    public ClienteDto(Long id, String nome, String email, Long telefone, Boolean correntista, Float saldoCc) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.correntista = correntista;
        this.saldoCc = saldoCc;
        this.scoreCredito = calcularScoreCredito(saldoCc);
    }

    public ClienteDto(String string, String string2, boolean b, int i) {
        
    }

    public ClienteDto(String string, String string2, Object object, int i) {
        
    }

    // Método para calcular o score de crédito
    private Float calcularScoreCredito(Float saldoCc) {
        if (saldoCc == null) {
            return 0f;
        }
        return saldoCc * 0.1f;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setSaldoCc(Float saldoCc) {
        this.saldoCc = saldoCc;
        this.scoreCredito = calcularScoreCredito(saldoCc); // Atualiza o score quando o saldo é alterado
    }

}
