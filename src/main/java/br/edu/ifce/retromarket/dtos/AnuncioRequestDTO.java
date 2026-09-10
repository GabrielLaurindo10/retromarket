package br.edu.ifce.retromarket.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class AnuncioRequestDTO {

    @NotBlank(message = "O título é obrigatório.")
    @Size(max = 150, message = "O titulo deve possuir no máximo 150 caracteres.")
    private String titulo;

    @NotNull(message = "O preço é obrigatório.")
    @Positive(message = "O preço deve ser maior que zero.")
    private BigDecimal preco;

    @NotBlank(message = "A localização é obrigatória.")
    private String localizacao;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    private List<String> urlfotos;

    @NotNull(message = "A categoria é obrigatória.")
    private Long Idcategoria;

    @NotNull(message = "A plataforma é origatória.")
    private Long Idplataforma;

    @NotBlank(message = "A completude é obrigatória.")
    private String codigoCompletude;

    @NotBlank(message = "A condição é obrigatória.")
    private String codigoCondicao;
    
    @NotBlank(message = "O status é obrigatório.")
    private String codigoStatus;
    
    private Long idUsuario;

    public AnuncioRequestDTO(){

    }

    public AnuncioRequestDTO(){
        this.urlfotos = new ArrayList<>();
    }

    public AnuncioRequestDTO (String titulo, BigDecimal preco, String localizacao, String descricao, List<String> urlfotos, Long categoriaId, Long plataformaId, String codigoCompletude, String codigoCondicao, String codigoStatus, Long idUsuario) {
        this.titulo = titulo;
        this.preco = preco;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.urlfotos = urlfotos;
        this.categoriaId = categoriaId;
        this.plataformaId = plataformaId;
        this.codigoCompletude = codigoCompletude;
        this.codigoCondicao = codigoCondicao;
        this.codigoStatus = codigoStatus;
        this.idUsuario = idUsuario;
    } 

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getUrlfotos() {
        return urlfotos;
    }

    public void setUrlfotos(List<String> urlfotos) {
        this.urlfotos = urlfotos;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    