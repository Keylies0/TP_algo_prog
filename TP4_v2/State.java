import java.util.LinkedList;

public class State {
    /* -------------------- attributs -------------------- */
    // a state is immutable : all fields are final
    private final LinkedList<Integer> parcours;
    private final int score;


    /* ------------------ constructeur ------------------ */

    public State(LinkedList<Integer> parcours, int score) {
        this.parcours = parcours;
        this.score = score;
    }

    /* -------------------- getteurs -------------------- */

    public LinkedList<Integer> getParcours() { return this.parcours; }
    public int getScore() { return this.score; }

    /** Fournit une description de l'état */
    @Override
    public String toString() {
        StringBuffer description = new StringBuffer();

        description.append("Nombre de villes: ");
        description.append(this.getParcours().size());
        description.append("\n");

        for (int id : this.getParcours())
            description.append(" → " + id);
        
        return description.toString();
    }
}