package repository;

import java.util.ArrayList;

import model.Pessoa;

public class PessoaRepository {
	
	private static ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public static Pessoa getPessoaById(Integer id) {
		return pessoas.get(id);
	}
	
	public static void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public static ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
}
