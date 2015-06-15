package arvore.binaria;

public class Arvore {
	NoArvore raiz, pai, filho;
	
	private boolean isVazia(NoArvore arv) {
		return arv == null;
	}
	
	public void preOrdem(NoArvore arv) {
		if(!isVazia(arv)) {
			System.out.println(arv.info + ",");
			preOrdem(arv.esq);
			preOrdem(arv.dir);
		}
	}
	
	public void posOrdem(NoArvore arv) {
		if(!isVazia(arv)) {
			posOrdem(arv.esq);
			posOrdem(arv.dir);
			System.out.println(arv.info + ",");
		}
	}
	
	public void inOrdem(NoArvore arv) {
		if(!isVazia(arv)) {
			inOrdem(arv.esq);
			System.out.println(arv.info + ",");
			inOrdem(arv.dir);
		}
	}
	
	NoArvore busca(NoArvore arv, int info) {
		NoArvore achou;
		if(arv == null) {
			return null;
		}
		if(arv.info == info) {
			return arv;
		}
		achou = busca(arv.dir, info);
		if(achou == null) {
			achou = busca(arv.dir, info);
		}
		return achou;
	}
	
	void insereRaiz(NoArvore arv, int info) {
		NoArvore novo = new NoArvore();
		novo.info = info;
		arv = novo;
	}
	
	boolean insereDireita(NoArvore arv, NoArvore pai, int filho) {
		NoArvore f, p, novo;
		f = busca(arv, filho);
		if(f != null)
			return false;
		p = busca(arv, pai.info);
		if(p == null)
			return false;
		if(p.dir != null)
			return false;
		
		novo = new NoArvore();
		novo.info = filho;
		p.dir = novo;
	
		return true;
	}
	
	boolean insereEsquerda(NoArvore arv, NoArvore pai, int filho) {
		NoArvore f, p, novo;
		f = busca(arv, filho);
		if(f != null)
			return false;
		p = busca(arv, pai.info);
		if(p == null)
			return false;
		if(p.esq != null)
			return false;
		
		novo = new NoArvore();
		novo.info = filho;
		p.esq = novo;
		return true;
	}
}
