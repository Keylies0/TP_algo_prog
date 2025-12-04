import java.util.List;

public class CannibalesProblem {

    /** Retourne l'état initial */
    public State initialState() { return new State(3, 3, 0, 0); }

    /** Retourne la liste des actions */
    public List<Action> actions() {
        return List.of(
            new Action(-1,  0, +1),
            new Action(-2,  0, +1),
            new Action( 0, -1, +1),
            new Action( 0, -2, +1),
            new Action(-1, -1, +1),
            new Action(+1,  0, -1),
            new Action(+2,  0, -1),
            new Action( 0, +1, -1),
            new Action( 0, +2, -1),
            new Action(+1, +1, -1)
        );
    }

    /** Vérifie si l'état est terminal */
    public boolean isGoalState(State state) { return state.getMissionnaires() == 0 && state.getCannibales() == 0; }

    /** Retourne l'état successeur après avoir appliqué une action */
    public State succession(State state, Action action) {
        // Node.isActionValid se charge de vérifier si l'action est valide pour state
        return new State(
            state.getMissionnaires() + action.dMissionnaires,
            state.getCannibales()    + action.dCannibales,
            state.getBateau()        + action.dBateau,
            state.getScore() + 1
        );
    }


    class Action {
        public final int dMissionnaires;
        public final int dCannibales;
        public final int dBateau;
        
        public Action(int nbMissionnaires, int nbCannibales, int psBateau) {
            this.dMissionnaires = nbMissionnaires;
            this.dCannibales    = nbCannibales;
            this.dBateau        = psBateau;
        }

        /** Coût de l'action (toujours 1 dans ce problème) */
        public int cout() { return 1; }
    }
}
