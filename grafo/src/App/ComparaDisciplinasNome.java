package App;
import java.util.Comparator;

public class ComparaDisciplinasNome<T> implements Comparator<T> {

	@Override
	public int compare(T a, T b) {
		Disciplina dA = (Disciplina) a;
		Disciplina dB = (Disciplina) b;
		if (dA.getNome().equals(dB.getNome())) {
			return 0;
		}
		else return 1;
	}
}
