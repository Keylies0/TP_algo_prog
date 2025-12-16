import java.util.List;
import java.util.LinkedList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class TravelProblem {
    private final int firstCity;
    private final int lastCity;
    private final int nbCities;

    public TravelProblem(int firstCity, int lastCity, int nbCities) {
        if (nbCities < 3)
            throw new IllegalArgumentException("Nombre de villes limité à au moins 3.");
        if (
            firstCity < 1 || firstCity > nbCities ||
            lastCity  < 1 || lastCity  > nbCities
        )
            throw new IllegalArgumentException("Une ville a un identifiant compris entre 1 et nbCities.");
        if (firstCity == lastCity)
            throw new IllegalArgumentException("Les villes de départ et d'arrivées doivent être différentes.");

        this.firstCity = firstCity;
        this.lastCity = lastCity;
        this.nbCities = nbCities;
    }

    /** getteurs */
    public int getFirstCity() { return this.firstCity; }

    public int getLastCity() { return this.lastCity; }

    public int getNbCities() { return this.nbCities; }

    
    /** Retourne l'état initial */
    public State initialState() {
        LinkedList<Integer> parcours = new LinkedList<>();
        parcours.add(this.getFirstCity());
        parcours.add(this.getLastCity());

        return new State(parcours, 0);
    }

    /** Retourne la liste des actions */
    public List<Action> actions() {
        List<Action> actions = new LinkedList<>();

        for (int id = 1; id <= this.getNbCities(); id++) {
            actions.add(new Action(id));
        }

        return actions;
    }

    /** Vérifie si l'état est terminal */
    public boolean isGoalState(State state) { return state.getParcours().size() == this.getNbCities();}


    /** Retourne l'état successeur après avoir appliqué une action */
    public State succession(State state, Action action) {
        LinkedList<Integer> parcours = new LinkedList<>();
        parcours.addAll(state.getParcours());

        parcours.add(parcours.size() - 1, action.id);

        return new State(parcours, state.getScore() + action.cout(state));
    }


    class Action {
        public final int id;
        
        public Action(int id) { this.id = id; }

        /** Coût de l'action */
        public int cout(State state) {
            try {
                List<String> cities = Files.readAllLines(Paths.get("us_capitals.txt"));

                int stateIdCity = state.getParcours().get(state.getParcours().size() - 1);

                int x1 = Integer.parseInt(cities.get(stateIdCity).split(" ")[1]);
                int x2 = Integer.parseInt(cities.get(stateIdCity).split(" ")[2]);
                int y1 = Integer.parseInt(cities.get(this.id - 1).split(" ")[1]);
                int y2 = Integer.parseInt(cities.get(this.id - 1).split(" ")[2]);

                return (int) Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
            return -1;
        }
    }
}