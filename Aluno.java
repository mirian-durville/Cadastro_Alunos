import java.util.*;

import javax.swing.JOptionPane;


public class Aluno {

	public static List<Integer> ListaCodigo = new ArrayList<Integer> ();
	public static List<String> ListaNome = new ArrayList<String> ();
	public static List<String> ListaEmail = new ArrayList<String> ();
	public static List<String> ListaCidade= new ArrayList<String> ();
	public static List<String> ListaUf = new ArrayList<String> ();
	
	public static void main(String[] args) {
		String opcao = "";
		
		while(!opcao.equals("6") ) {
		opcao = entradaDeDadosTexto("Menu de opções \n\n"
					+ "1 - Cadastrar \n"
					+ "2 - Consultar \n"
					+ "3 - Atualizar \n"
					+ "4 - Excluir \n"
					+ "5 - Listar \n"
					+ "6 - Sair \n\n"
					+ "Escolha a sua opção: ",
					true
					);
			
			switch (opcao) {
			case "1": 
				cadastrarAluno();
				break;			
			case "2": 
				consultarAluno();
				break;
			case "3": 
				atualizarAluno();
				break;
			case "4": 
				excluirAluno();
				break;	
			case "5": 
				listarAluno();
				break;		
			}
		}	

	}
	
	public static String entradaDeDadosTexto(
			String texto,
			boolean obrigatorio) {
		JOptionPane tela =  new JOptionPane(); 
		
		String dado = "";
		
		do {
			dado = tela.showInputDialog(texto);
			
			if(dado.trim().isEmpty() && obrigatorio)
				mensagem("Campo de preenchimento obrigatório");
			
		}	while (dado.isEmpty() && obrigatorio);
		
		return dado;

	}	
	
	public static int entradaDeDadosInteiro(
			String texto,
			boolean obrigatorio) {
		JOptionPane tela =  new JOptionPane(); 
		
		String dado;
		
		do {
			dado = tela.showInputDialog(texto);
			
			if(!dado.matches("[0-9]+") && obrigatorio == true)
				mensagem("Campo de preenchimento com numero inteiro");
			
		}	while (!dado.matches("[0-9]+") && obrigatorio == true);
		
		return Integer.parseInt(dado);

	}
	
	
	public static void mensagem (String valor) {
		JOptionPane tela = new JOptionPane();
		
		tela.showMessageDialog(null, valor, "Atenção!", 3);
	}
	
	public static void cadastrarAluno() {
		
		
		int entradaMatricula = entradaDeDadosInteiro("Informe a matrícula do aluno", true);
		int indice = ListaCodigo.indexOf(entradaMatricula);
		if (indice != -1)
			mensagem("Matrícula já cadastrada!");
			
		else {
			
	
		
			String nomeEntrada = entradaDeDadosTexto("Informe nome:", true);
			String emailEntrada = entradaDeDadosTexto("Informe e-mail:", false);
			String cidadeEntrada = entradaDeDadosTexto("Informe cidade:", false);
			String ufEntrada = entradaDeDadosTexto("Informe uf:", false);
			
		
			
			ListaCodigo.add(entradaMatricula);
			ListaNome.add(nomeEntrada);
			ListaEmail.add(emailEntrada);
			ListaCidade.add(cidadeEntrada);
			ListaUf.add(ufEntrada);
			
			mensagem("O aluno foi cadastrado com sucesso!");	
			
		}
	}
	
	public static void excluirAluno() {

		int entradaMatricula = entradaDeDadosInteiro("Informe a matrícula do aluno", true);
		
				
		int indice = ListaCodigo.indexOf(entradaMatricula);
		
		if (indice != -1) {
			ListaCodigo.remove(indice);
			ListaNome.remove(indice);
			ListaEmail.remove(indice);
			ListaCidade.remove(indice);
			ListaUf.remove(indice);
			
			mensagem("Aluno excluído com sucesso!");
		}	
		else {
			mensagem("Matrícula não encontrada!");
		}
	}
	
	public static void consultarAluno() {
		
		
		
				int entradaMatricula = entradaDeDadosInteiro("Informe a matrícula do aluno", true);				
				int indice = ListaCodigo.indexOf(entradaMatricula);
				if (indice != -1) {
					String exibir ="\nAluno: " + ListaNome.get(indice) + "\n" +
							 "E-mail: " + ListaEmail.get(indice) + "\n" +
							 "Cidade: " + ListaCidade.get(indice) + "\n" +
							 "Uf: " + ListaUf.get(indice);	
				
					mensagem(exibir);
				}	
				else {
					mensagem("Matrícula não encontrada!");
				}
	}
	
	public static void listarAluno() {
		String exibir = "";
		
		for(int indice = 0; indice < ListaCodigo.size(); indice ++) {
			exibir +="\nAluno: " + ListaNome.get(indice) + "\n" +
					 "E-mail: " + ListaEmail.get(indice) + "\n" +
					 "Cidade: " + ListaCidade.get(indice) + "\n" +
					 "Uf: " + ListaUf.get(indice) + "\n";	
			
		};
		
		mensagem(exibir);
	}
	public static void atualizarAluno() {
		
		int entradaMatricula = entradaDeDadosInteiro("Informe a matrícula do aluno", true);
		int indice = ListaCodigo.indexOf(entradaMatricula);
		
		if (indice != -1) {						
			
			String nomeEntrada = entradaDeDadosTexto("Informe nome:", true);
			String emailEntrada = entradaDeDadosTexto("Informe e-mail:", false);
			String cidadeEntrada = entradaDeDadosTexto("Informe cidade:", false);
			String ufEntrada = entradaDeDadosTexto("Informe uf:", false);
			
			ListaCodigo.set(indice, entradaMatricula);
			ListaNome.set(indice, nomeEntrada);
			ListaEmail.set(indice, emailEntrada);
			ListaCidade.set(indice, cidadeEntrada);
			ListaUf.set(indice, ufEntrada);
		}	
		
		
		
	}
	
	
}
