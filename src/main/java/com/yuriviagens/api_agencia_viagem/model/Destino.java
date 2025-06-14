package com.yuriviagens.api_agencia_viagem.model;

public class Destino {
    private Long id;
    private double nota;
    private String nome;
    private String localizacao;
    private String descricao;
    private Double precoPacote;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPrecoPacote() { return precoPacote; }
    public void setPrecoPacote(Double precoPacote) { this.precoPacote = precoPacote; }

}
