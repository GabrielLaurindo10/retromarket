package br.edu.ifce.retromarket.dtos;

import java.math.BigDecimal;

public class AnuncioDetalhesDTO {

    private Long id;
    private String titulo;
    private BigDecimal preco;
    private String localizacao;
    prvate String descricao;
    private LocalDate dataPublicacao;
    private List<String> fotos;
    
    private CategoriaResumoDTO categoria;
    private PlataformaResumoDTO plataforma;
    private CondicaoDTO condicao;
    private StatusDTO status;
    private CompletudeDTO completude;
    public AnuncioDetalhesDTO() {
        this.fotos = new ArrayList<>();
    }
    public void setId(Long id) {
        this.id = id;
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
    public prvate getString() {
        return String;
    }
    public void setString(prvate string) {
        String = string;
    }
    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    public List<String> getFotos() {
        return fotos;
    }
    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }
    public CategoriaResumoDTO getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaResumoDTO categoria) {
        this.categoria = categoria;
    }
    public PlataformaResumoDTO getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(PlataformaResumoDTO plataforma) {
        this.plataforma = plataforma;
    }
    public CondicaoDTO getCondicao() {
        return condicao;
    }
    public void setCondicao(CondicaoDTO condicao) {
        this.condicao = condicao;
    }
    public StatusDTO getStatus() {
        return status;
    }
    public void setStatus(StatusDTO status) {
        this.status = status;
    }
    public CompletudeDTO getCompletude() {
        return completude;
    }
    public void setCompletude(CompletudeDTO completude) {
        this.completude = completude;
    }

    
    
}
