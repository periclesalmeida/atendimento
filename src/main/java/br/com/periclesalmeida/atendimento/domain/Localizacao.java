package br.com.periclesalmeida.atendimento.domain;

import br.com.periclesalmeida.atendimento.util.StringUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Document(collection = "localizacao")
public class Localizacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotBlank(message="Obrigatório informar a descrição")
    private String descricao;

    @NotNull(message = "Obrigatório informar o tipo")
    private TipoLocalizacao tipo;

    @NotNull
    private Boolean ativo;

    @NotNull(message="Obrigatório informar pelo menos um serviço")
    @DBRef
    private Set<Servico> servicos;

    public Localizacao(String id, String descricao, Boolean ativo) {
        this.id = id;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Localizacao(String id, String descricao, TipoLocalizacao tipo, Boolean ativo, Set<Servico> servicos) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.ativo = ativo;
        this.servicos = servicos;
    }

    public Localizacao() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = StringUtil.setarUpperCase(descricao) ;
    }

    public TipoLocalizacao getTipo() {
        return tipo;
    }
    public void setTipo(TipoLocalizacao tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Set<Servico> getServicos() {
        return servicos;
    }
    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
