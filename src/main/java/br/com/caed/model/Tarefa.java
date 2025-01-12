package br.com.caed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prj_tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_criacao", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date dataCriacao;

	@Column(name = "data_conclusao", columnDefinition = "TIMESTAMP")
	private Date dataConclusao;

	@Column(columnDefinition = "TEXT")
	private String titulo;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Column(columnDefinition = "TEXT")
	private String prioridade;
	
	@Column(columnDefinition = "TEXT")
	private String estimativaHoras;

	@Column(columnDefinition = "TEXT")
	private String observacoes;

	@Column(columnDefinition = "TINYINT(1) NOT NULL")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "id_projeto")
	private Projeto projeto;

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getEstimativaHoras() {
		return estimativaHoras;
	}

	public void setEstimativaHoras(String estimativaHoras) {
		this.estimativaHoras = estimativaHoras;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	// Hash and code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", dataCricao=" + dataCriacao + ", dataConclusao=" + dataConclusao
				+ ",descricao=\"\n" + "				+ descricao + \", titulo=" + titulo + ",prioridade=\"\n"
				+ "				+ prioridade + \",estimativaHoras=\\\"\\n\"\n"
				+ "				+ \"				+ estimativaHoras + \\\", observacoes=" + observacoes + ", status="
				+ status + ", projeto=" + projeto + "]";
	}

}
