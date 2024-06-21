package br.com.caed.repository;

import java.util.List;

import br.com.caed.model.Tarefa;

public interface TarefaRepository {

	public void criaTarefa(Tarefa tarefa);

	public void alteraTarefa(Tarefa tarefa);

	public void removeTarefa(Tarefa tarefaToDelete);

	public List<Tarefa> buscaTodasTarefasFinalizadas();

	public List<Tarefa> buscaTodasTarefasAbertas();

	public List<Tarefa> buscaTodasTarefasPorProjeto(Long idProjeto);

}
