package ia;

import java.util.ArrayList;
import ia.aresta;

public class no {
	private int valorHeuristico;
	public ArrayList<aresta> ligacoes = new ArrayList();
	private char l;
	private boolean objetivo;
	private boolean visitado;
	
	public no(int valorHeuristico, char l, boolean objetivo) {
		this.valorHeuristico = valorHeuristico;
		this.l = Character.toUpperCase(l);
		this.objetivo = objetivo;
		this.visitado = false;
	}
	
	public void addAresta(aresta prAr) {
		ligacoes.add(prAr);
	}
	
	public void setVisitado() {
		visitado = true;
	}
	
	public boolean isVisitado() {
		return visitado;
	}
	
	public int getValorHeuristico() {
		return this.valorHeuristico;
	}
	
	public char getL() {
		return this.l;
	}
	
	public boolean isObjetivo() {
		return objetivo;
	}
	
	
	public no menorHeuristico() {
		int menorValor = ligacoes.get(0).getNo().getValorHeuristico();
		
		no noRetorno = ligacoes.get(0).getNo();
		
		if(ligacoes.size()>1) {
		for(int i=1; i<ligacoes.size(); i++) {
			if(ligacoes.get(i).getNo().isObjetivo() && ligacoes.get(i).getNo().isVisitado()) {
				return ligacoes.get(i).getNo();
			}
			else {
			if(menorValor > ligacoes.get(i).getNo().getValorHeuristico() && 
				ligacoes.get(i).getNo().getValorHeuristico() < this.valorHeuristico) {
				
				menorValor = ligacoes.get(i).getNo().getValorHeuristico();
				noRetorno = ligacoes.get(i).getNo();
			}
			}
		}
		}
		
		return noRetorno;
	}
	
	public int custo() {
		for(int i=0; i<ligacoes.size();i++) {
			if(ligacoes.get(i).getNo().equals(menorHeuristico())) {
				return ligacoes.get(i).getValor();
			}
		}
		return 0;
	}
	
}
