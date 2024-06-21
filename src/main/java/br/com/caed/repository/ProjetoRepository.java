package br.com.caed.repository;

import java.util.List;

import br.com.caed.model.Projeto;

public interface ProjetoRepository {
	

	public void criaProjeto(Projeto projeto);
	public Projeto buscaProjetoPorId(Long id);
	public List<Projeto> buscaProjetos();

}
