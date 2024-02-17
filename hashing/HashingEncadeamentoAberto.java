package hashing;

import java.util.LinkedList;

public class HashingEncadeamentoAberto implements EstruturaDeDados {
    private LinkedList<Integer>[] tabela;

    public HashingEncadeamentoAberto() {
        tabela = new LinkedList[1011];
    }

    @Override
    public void insert(int chave) {
        int indice = hash(chave);
        if (tabela[indice] == null) {
            tabela[indice] = new LinkedList<>();
        }
        if (!tabela[indice].contains(chave)) {
            tabela[indice].add(chave);
        }
    }

    @Override
    public void delete(int chave) {
        int indice = hash(chave);
        if (tabela[indice] != null) {
            tabela[indice].remove(Integer.valueOf(chave));
        }
    }

    @Override
    public boolean search(int chave) {
        int indice = hash(chave);
        return tabela[indice] != null && tabela[indice].contains(chave);
    }

    private int hash(int chave) {
        return chave % 1011;
    }
}
