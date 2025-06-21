package Modelos;

public class Titulo {
    private String titulo;
    private int anoDePublicacao;
    private String autor;
    private String descricao;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescricao() {
        return descricao;
    }
}