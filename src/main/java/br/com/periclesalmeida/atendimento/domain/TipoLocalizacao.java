package br.com.periclesalmeida.atendimento.domain;

import br.com.periclesalmeida.atendimento.util.StringUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Document(collection = "tipolocalizacao")
public class TipoLocalizacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String sequencial;

    @NotBlank(message = "Obrigatório informar a descrição")
    private String descricao;

    public TipoLocalizacao() {
    }

    public TipoLocalizacao(String id) {
        this.sequencial = id;
    }

    public String getSequencial() {
        return sequencial;
    }
    public void setSequencial(String sequencial) {
        this.sequencial = sequencial;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = StringUtil.setarUpperCase(descricao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoLocalizacao that = (TipoLocalizacao) o;
        return Objects.equals(sequencial, that.sequencial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequencial);
    }
}
