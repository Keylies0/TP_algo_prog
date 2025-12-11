import java.util.LinkedList;

public class State {
    /* -------------------- attributs -------------------- */
    // a state is immutable : all fields are final
    private final LinkedList<Integer> voyage;
    private final int score;


    /* ------------------ constructeur ------------------ */

    public State(LinkedList<Integer> voyage, int score) {
        this.voyage = voyage;
        this.score = score;
    }

    public State(int firstId, int lastId) {
        this.voyage = new LinkedList<Integer>();
        this.voyage.add(firstId);
        this.voyage.add(lastId);
        this.score = 0;
    }

    /* -------------------- getteurs -------------------- */

    public LinkedList<Integer> getVoyage() { return this.voyage; }
    public int getScore() { return this.score; }

    /** Fournit une description de l'état */
    @Override
    public String toString() {
        StringBuffer description = new StringBuffer();
        description.append("Nombre de villes: ");
        description.append(this.getVoyage().size());
        description.append("\n");
        for (int id : this.getVoyage()) {
            description.append("→");
            description.append(id);
        }
        return description.toString();
    }
}