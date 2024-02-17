package hashing;

import java.util.LinkedList;

public class HashingComPorao implements EstruturaDeDados {
    private LinkedList<Integer>[] tabela;
    private LinkedList<Integer> porao;

    public HashingComPorao() {
        tabela = new LinkedList[1011];
        porao = new LinkedList<>();
    }

    @Override
    public void insert(int chave) {
        int indice = hash(chave);
        if (tabela[indice] == null) {
            tabela[indice] = new LinkedList<>();
        }
        if (tabela[indice].contains(chave)) {
            return; // Evita duplicatas
        }
        if (tabela[indice].size() < 100) {
            tabela[indice].add(chave);
        } else {
            porao.add(chave);
        }
    }

    @Override
    public void delete(int chave) {
        int indice = hash(chave);
        if (tabela[indice] != null && tabela[indice].remove(Integer.valueOf(chave))) {
            return;
        }
        porao.remove(Integer.valueOf(chave));
    }

    @Override
    public boolean search(int chave) {
        int indice = hash(chave);
        if (tabela[indice] != null && tabela[indice].contains(chave)) {
            return true;
        }
        return porao.contains(chave);
    }

    private int hash(int chave) {
        return chave % 1011;
    }
}
