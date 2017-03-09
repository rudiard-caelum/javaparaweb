package br.com.javaparaweb.financeiro.categoria;

import java.util.List;

import br.com.javaparaweb.financeiro.usuario.Usuario;
import br.com.javaparaweb.financeiro.util.DAOFactory;

public class CategoriaRN {

	private CategoriaDAO categoriaDAO;

	public CategoriaRN() {
		this.categoriaDAO = DAOFactory.criarCategoriaDAO();
	}

	public List<Categoria> listar(Usuario usuario) {
		return this.categoriaDAO.listar(usuario);
	}

	public Categoria salvar(Categoria categoria) {
		Categoria pai = categoria.getPai();
		if (pai == null) {
			String msg = "A Categoria " + categoria.getDescricao() + " deve ter um pai definido.";
			throw new IllegalArgumentException(msg);
		}

		boolean mudouFator = pai.getFator() != categoria.getFator();

		categoria.setFator(pai.getFator());
		categoria = this.categoriaDAO.salvar(categoria);

		if (mudouFator) {
			categoria = this.carregar(categoria.getCodigo());
			this.replicarFator(categoria, categoria.getFator());
		}
		return categoria;
	}

	private void replicarFator(Categoria categoria, int fator) {
		if (categoria.getFilhos() != null) {
			for (Categoria filho : categoria.getFilhos()) {
				filho.setFator(fator);
				this.categoriaDAO.salvar(filho);
				this.replicarFator(filho, fator);
			}
		}
	}

	public void excluir(Categoria categoria) {
		this.categoriaDAO.excluir(categoria);
	}

	public void excluir(Usuario usuario) {
		List<Categoria> lista = this.listar(usuario);
		for (Categoria categoria : lista) {
			this.categoriaDAO.excluir(categoria);
		}
	}

	public Categoria carregar(Integer categoria) {
		return this.categoriaDAO.carregar(categoria);
	}

	public void salvaEstruturaPadrao(Usuario usuario) {

		/* DESPESAS */
		Categoria despesas = new Categoria(null, usuario, "DESPESAS", -1);
		despesas = this.categoriaDAO.salvar(despesas);
		/* Casa */
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Financiamento", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Aluguel", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Condomínio", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - IPTU", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Água", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Energia Elétrica", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Gás", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Telefone", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Decoração", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Reforma", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Limpeza", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - TV a Cabo", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Internet", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Despensa", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Seguro", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Lavanderia", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Utensílios Domésticos", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Jardinagem", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Material de Escritório", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Casa - Diversos", -1));
		/* Apartamento */
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - Financiamento", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - Condomínio", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - IPTU", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - Água", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - Energia Elétrica", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - Gás", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - Reforma", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Apto - Diversos", -1));
		/* Ve�culo */
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Financiamento", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - IPVA", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - DPVAT", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Licenciamento", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Multas de Trânsito", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Mecânico", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Auto-Elétrico", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Funilaria", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Inspeção Veicular", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Seguro", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Despachante", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Lava Rápido", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Pedágio", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Estacionamento", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Combustível", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Veículo - Diversos", -1));
		/* Pessoal */
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Saúde", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Perfumaria", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Vestuário", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Alimentaçãoo", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Diversão", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Celular", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Transporte", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Educação", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Presentes", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Documentações", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - IRPF", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Moeda Estrangeira", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Academia", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Clube de Férias", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Seguro", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Pessoal - Diversos", -1));
		/* Bancos */
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Bancos - Manutenção", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Bancos - Tarifas - Envio Extrato", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Bancos - IOF", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Bancos - Tarifas - DOC/TED", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Bancos - Seguro", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Bancos - Juros", -1));
		/* Cart�es de Cr�dito */
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Cartões - Juros e Multas", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Cartões - Variação Cambial", -1));
		/* Empresa */
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - Contabilidade", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - ISS", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - INSS", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - CSLL", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - IRPJ", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - TEF", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - PIS", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - COFINS", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - Tarifas Bancárias", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - Contribuição Sindical", -1));
		this.categoriaDAO.salvar(new Categoria(despesas, usuario, "Empresa - Gastos Administrativos", -1));

		/* RECEITAS */
		Categoria receitas = new Categoria(null, usuario, "RECEITAS", 1);
		receitas = this.categoriaDAO.salvar(receitas);
		this.categoriaDAO.salvar(new Categoria(receitas, usuario, "Salário", 1));
		this.categoriaDAO.salvar(new Categoria(receitas, usuario, "Reembolsos", 1));
		this.categoriaDAO.salvar(new Categoria(receitas, usuario, "Restituições", 1));
		this.categoriaDAO.salvar(new Categoria(receitas, usuario, "Rendimentos", 1));
		this.categoriaDAO.salvar(new Categoria(receitas, usuario, "Receitas - Empresa", 1));
		this.categoriaDAO.salvar(new Categoria(receitas, usuario, "Outras", 1));

	}

}
