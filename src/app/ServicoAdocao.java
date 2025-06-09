package app;
import java.util.ArrayList;

public class ServicoAdocao {
    private ArrayList<Adocao> adocoes = new ArrayList<>();

    public boolean realizarAdocao(Pessoa p, Animal a) {
        for (Adocao ad : adocoes) {
            if (ad.getAnimal().equals(a)) return false;
        }
        adocoes.add(new Adocao(p, a));
        p.adicionarAnimal(a);
        return true;
    }

    public void cancelarAdocao(Pessoa p, Animal a) {
        Adocao encontrada = null;
        for (Adocao ad : adocoes) {
            if (ad.getAnimal().equals(a) && ad.getAdotante().equals(p)) {
                encontrada = ad;
                break;
            }
        }
        if (encontrada != null) {
            adocoes.remove(encontrada);
            p.removerAnimal(a);
        }
    }

    public void listarAdocoes() {
        for (Adocao ad : adocoes) {
            ad.exibir();
        }
    }

    public ArrayList<Adocao> getAdocoes() {
        return adocoes;
    }
}
