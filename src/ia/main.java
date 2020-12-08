package ia;

import ia.no;
import java.util.ArrayList;
import ia.aresta;

public class main {
	public static void main(String[] args) {
	ArrayList<no> grafo1 = criaGrafo1();
	System.out.println("custo: "+hillClimbing(grafo1));
	
	System.out.println();
	
	ArrayList<no> grafoCaixeiro = criaGrafoCaixeiro();
	System.out.println("custo do grafoCaixeiro: "+hillClimbing(grafoCaixeiro));
	}
	
	public static int hillClimbing(ArrayList<no> graf) {
		no atual = graf.get(0);
		int custo = 0;
		do{
			System.out.print("-> "+atual.getL());
			custo += atual.custo();
			graf.get(graf.indexOf(atual)).setVisitado();
			atual = atual.menorHeuristico();
			if(atual.isObjetivo() && todosVisitados(graf)) {
				break;
			}
		}while(!atual.ligacoes.isEmpty());
		
		 System.out.println("-> "+atual.getL());
		 return custo;
	}
	
	public static void novaLigacao(ArrayList<no> graf, aresta novaAresta, char nDestino) {
		nDestino = Character.toUpperCase(nDestino);
		for(int i=0; i<graf.size();i++) {
			if(graf.get(i).getL() == nDestino) {
				graf.get(i).addAresta(novaAresta);
				return;
			}
	}
		System.out.println("Não existe esse o no "+nDestino+" no grafo");
		return;
	}
	
	
	public static int retornaIndice(ArrayList<no> graf, char nDestino) {
		nDestino = Character.toUpperCase(nDestino);
		for(int i=0; i<graf.size();i++) {
			if(graf.get(i).getL() == nDestino) {
				return i;
			}
	}
		System.out.println("Não existe esse o no "+nDestino+" no grafo");
		return -1;
	}
	
	public static boolean todosVisitados(ArrayList<no> graf) {
		for(int i=0; i<graf.size();i++) {
			if(!(graf.get(i).isVisitado())) {
				return false;
			}
	}
		return true;
	}
	
	
	
	//Função para criar o grafo
	public static ArrayList<no> criaGrafo1() {
		
		ArrayList<no> grafo1 = new ArrayList();
		
		no novoNo = null;
		aresta nAresta = null;
	
		//Adicionando o primeiro nó
		novoNo = new no(30, 'A', false);
		grafo1.add(novoNo);
	
		//Adicionando o nó B
		novoNo = new no(26, 'B', false);
		nAresta = new aresta(12, novoNo);
		novaLigacao(grafo1, nAresta, 'A');
		grafo1.add(novoNo);
		
		//Adicionando o nó C
		novoNo = new no(21, 'C', false);
		nAresta = new aresta(14, novoNo);
		novaLigacao(grafo1, nAresta, 'A');
		nAresta = new aresta(9, novoNo);
		novaLigacao(grafo1, nAresta, 'B');
		grafo1.add(novoNo);
	
		//Adicionando o nó D
		novoNo = new no(7, 'D', false);
		nAresta = new aresta(38, novoNo);
		novaLigacao(grafo1, nAresta, 'B');
		nAresta = new aresta(24, novoNo);
		novaLigacao(grafo1, nAresta, 'C');
		grafo1.add(novoNo);
	
		//Adicionando o nó E
		novoNo = new no(22, 'E', false);
		nAresta = new aresta(7, novoNo);
		novaLigacao(grafo1, nAresta, 'C');
		grafo1.add(novoNo);
		novoNo = grafo1.get(retornaIndice(grafo1, 'D'));
		nAresta = new aresta(13, novoNo);
		novaLigacao(grafo1, nAresta, 'E');
	
		//Adicionando o nó F
		novoNo = new no(36, 'F', true);
		nAresta = new aresta(9, novoNo);
		novaLigacao(grafo1, nAresta, 'E');
		grafo1.add(novoNo);
	
		//Adicionando o nó G
		novoNo = new no(0, 'G', false);
		nAresta = new aresta(29, novoNo);
		novaLigacao(grafo1, nAresta, 'E');
		nAresta = new aresta(9, novoNo);
		novaLigacao(grafo1, nAresta, 'D');
		grafo1.add(novoNo);
		
		return grafo1;
		}
	
	
public static ArrayList<no> criaGrafoCaixeiro() {
		
		ArrayList<no> grafoCaixeiro = new ArrayList();
		
		no novoNo = null;
		aresta nAresta = null;
	
		//Adicionando o primeiro nó
		novoNo = new no(21, 'A', true);
		grafoCaixeiro.add(novoNo);
		
		//Adicionando o nó B
		novoNo = new no(18, 'B', false);
		nAresta = new aresta(11, novoNo);
		novaLigacao(grafoCaixeiro, nAresta, 'A');
		grafoCaixeiro.add(novoNo);
		
		//Adicionando o nó C
		novoNo = new no(15, 'C', false);
		nAresta = new aresta(1, novoNo);
		novaLigacao(grafoCaixeiro, nAresta, 'A');
		grafoCaixeiro.add(novoNo);
		novoNo = grafoCaixeiro.get(retornaIndice(grafoCaixeiro, 'B'));
		nAresta = new aresta(15, novoNo);
		novaLigacao(grafoCaixeiro, nAresta, 'C');
		
		//Adicionando o nó D
		novoNo = new no(7, 'D', false);
		nAresta = new aresta(7, novoNo);
		novaLigacao(grafoCaixeiro, nAresta, 'C');
		grafoCaixeiro.add(novoNo);
		novoNo = grafoCaixeiro.get(retornaIndice(grafoCaixeiro, 'B'));
		nAresta = new aresta(4, novoNo);
		novaLigacao(grafoCaixeiro, nAresta, 'D');
		
		//Adicionando o nó E
		novoNo = new no(0, 'E', false);
		nAresta = new aresta(9, novoNo);
		novaLigacao(grafoCaixeiro, nAresta, 'B');
		grafoCaixeiro.add(novoNo);
		novoNo = grafoCaixeiro.get(retornaIndice(grafoCaixeiro, 'A'));
		nAresta = new aresta(5, novoNo);
		novaLigacao(grafoCaixeiro, nAresta, 'E');
		
		return grafoCaixeiro;
}
}
