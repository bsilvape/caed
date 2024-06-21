package br.com.caed.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caed.model.Projeto;
import br.com.caed.model.Tarefa;
import br.com.caed.repository.ProjetoRepository;
import br.com.caed.repository.ProjetoRepositoryImpl;
import br.com.caed.repository.TarefaRepository;
import br.com.caed.repository.TarefaRepositoryImpl;
import br.com.caed.util.FacesUtil;

@ManagedBean
@SessionScoped
public class TarefaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Projeto> projetos;
	private List<Tarefa> tarefas;

	private Tarefa tarefa;
	private Tarefa tarefaSelecionada;

	private Long idProjeto;

	private ProjetoRepository projetoRepository = new ProjetoRepositoryImpl();
	private TarefaRepository tarefaRepository = new TarefaRepositoryImpl();

	public String[] getPrioridades() {
		return new String[] { "MUITO ALTA", "ALTA", "BAIXA", "MUITO BAIXA" };
	}

	@PostConstruct
	public void init() {
		carregaListaProjetos();
		carregaListaTarefas();
	}

	// Limpa form ou prepara objeto para nova inserção
	public String criarNovaTarefa() {
		tarefa = new Tarefa();
		tarefa.setDataCriacao(new Date());

		carregaListaProjetos();

		return "tarefa_form.xhtml";
	}

	public String preparaParaEdicao() {
		tarefa = tarefaSelecionada;

		carregaListaProjetos();

		return "tarefa_form.xhtml";
	}

	public String gravar() {
		if (tarefa.isStatus() && tarefa.getDataConclusao() == null) {
			tarefa.setDataConclusao(new Date());
		}

		if (tarefa.getId() != null) {
			tarefaRepository.alteraTarefa(tarefa);
		} else {
			tarefaRepository.criaTarefa(tarefa);
		}

		carregaListaTarefas();
		return "index.xhtml";
	}

	public void excluir() {
		try {
			tarefaRepository.removeTarefa(tarefaSelecionada);
			tarefas.remove(tarefaSelecionada);
			FacesUtil.addSuccessMessage("Tarefa: " + tarefaSelecionada.getDescricao() + " excluída com sucesso.");
		} catch (Exception ex) {
			FacesUtil.addErrorMessage(ex.getMessage());
		}
	}

	// Filtros
	public void filtrarTodasAbertas() {
		// Aqui carrego a lista, pois o default da lista é todas em aberto
		carregaListaTarefas();
	}

	public void filtrarTodasFinalizadas() {
		tarefas = tarefaRepository.buscaTodasTarefasFinalizadas();
	}

	public void filtrarPorProjeto() {
		tarefas = tarefaRepository.buscaTodasTarefasPorProjeto(idProjeto);
	}

	// Carrega listas
	private void carregaListaProjetos() {
		projetos = projetoRepository.buscaProjetos();
	}

	private void carregaListaTarefas() {
		tarefas = tarefaRepository.buscaTodasTarefasAbertas();
	}

	// Getters and setters
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Tarefa getTarefaSelecionada() {
		return tarefaSelecionada;
	}

	public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
		this.tarefaSelecionada = tarefaSelecionada;
	}

	public Long getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
