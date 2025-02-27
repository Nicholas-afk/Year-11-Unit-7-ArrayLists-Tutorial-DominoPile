import java.util.ArrayList;
import java.util.Random;

public class DominoPile {
    private ArrayList<Domino> pile;

    public DominoPile() {
        pile = new ArrayList<Domino>();
    }

    public void newStack6() {
        pile.clear();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                pile.add(new Domino(i, j));
            }
        }
    }

    public ArrayList<Domino> getPile() {
        return pile;
    }

    public void shuffle() {
        ArrayList<Domino> newPile = new ArrayList<Domino>();
        Random random = new Random();

        while (!pile.isEmpty()) {
            int randomIndex = random.nextInt(pile.size());
            newPile.add(pile.remove(randomIndex));
        }

        pile = newPile;
    }

    public void shuffleAlternative() {
        Random random = new Random();
        int numSwaps = pile.size() * 3;

        for (int i = 0; i < numSwaps; i++) {
            int index1 = random.nextInt(pile.size());
            int index2 = random.nextInt(pile.size());

            Domino temp = pile.get(index1);
            pile.set(index1, pile.get(index2));
            pile.set(index2, temp);
        }
    }

    public void addDomino(Domino d) {
        pile.add(d);
    }

    public Domino getDomino(int index) {
        if (index >= 0 && index < pile.size()) {
            return pile.get(index);
        }
        return null;
    }

    public int size() {
        return pile.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pile.size(); i++) {
            sb.append(i + 1).append(". ").append(pile.get(i)).append("\n");
        }
        return sb.toString();
    }
}
