package App;
import java.util.Comparator;

public class ComparaLivrosNome<T> implements Comparator<T> {

	@Override
	public int compare(T a, T b) {
		Livro dA = (Livro) a;
		Livro dB = (Livro) b;
		if (dA.getNome().equals(dB.getNome())) {
			return 0;
		}
		else return 1;
	}
}
