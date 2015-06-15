package arvore.binaria;

public class ArvoreDePesquisa {

	NoArvore busca(NoArvore raiz, int info) {
		if (raiz == null)
			return null;
		if (raiz.info == info)
			return raiz;

		if (raiz.info > info)
			return busca(raiz.esq, info);
		else
			return busca(raiz.dir, info);
	}

	NoArvore buscaSetPai(NoArvore tree, int dado, NoArvore pai) {
		if (tree == null) {
			pai = null;
			return null;
		}

		if (tree.info == dado)
			return tree;

		if (tree.info > dado) {
			pai = tree;
			return buscaSetPai(tree.esq, dado, pai);
		} else {
			pai = tree;
			return buscaSetPai(tree.dir, dado, pai);
		}
	}

	boolean inserir(NoArvore tree, int item) {
		boolean ok;
		// Se a raiz for nula, ent‹o insere na raiz
		if (tree == null) {
			tree = new NoArvore();
			tree.info = item;
			return true;
		}

		if (tree.info < item)
			ok = inserir(tree.dir, item);
		else if (tree.info > item)
			ok = inserir(tree.esq, item);
		else
			ok = false;
		return ok;
	}

	boolean remover(NoArvore tree, int item) {
		NoArvore no;
		NoArvore pai = null;
		NoArvore sub;
		NoArvore paiSuce = null;
		NoArvore suce;
		no = tree;
		no = buscaSetPai(tree, item, paiSuce);
		if (no == null)
			return false;
		if (no.esq == null)
			sub = no.dir;
		else {
			if (no.dir == null)
				sub = no.esq;
			else {
				paiSuce = no;
				sub = no.dir;
				suce = sub.esq;
				while (suce != null) {
					paiSuce = sub;
					sub = suce;
					suce = sub.esq;
				}
				if (paiSuce != no) {
					paiSuce.esq = sub.dir;
					sub.dir = no.dir;
				}

				sub.esq = no.esq;
			}
		}

		if (pai == null)
			tree = sub;
		else if (no == pai.esq)
			pai.esq = sub;
		else
			pai.dir = sub;
		return true;
	}
}
