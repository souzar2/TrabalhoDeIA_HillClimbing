package ia;

import ia.no;

public class aresta {
	private int valor;
	private no prox;

public aresta(int valor, no prox) {
	this.valor = valor;
	this.prox = prox;
}

public int getValor() {
	return valor;
}

public no getNo() {
	return prox;
}
}
