import java.util.List;

public class KnightsTourProblem {
    private final int NB_ROWS;
    private final int NB_COLS;

    public KnightsTourProblem(int n, int m){
        if (n <= 0 || m <= 0){
            throw new IllegalArgumentException("Number of rows and columns must be positive.");
        }
        this.NB_ROWS = n;
        this.NB_COLS = m;
    }
    
    /** Retourne l'état initial : une grille vide avec le cavalier sur un coin */
    public State initialState(){
        return new State(new int[this.NB_ROWS][this.NB_COLS], new Position(), 0);
    }

    /** Retourne la liste des actions */
    public List<Action> actions(){
        return List.of(
            new Action(+2, +1),
            new Action(+1, +2),
            new Action(-1, +2),
            new Action(-2, +1),
            new Action(-2, -1),
            new Action(-1, -2),
            new Action(+1, -2),
            new Action(+2, -1)
    );
    }

    /** Vérifie si l'état est terminal */
    public boolean isGoalState(State state){
        return state.getScore() != this.NB_ROWS * this.NB_COLS ? false : true;
    }


    /** Retourne l'état successeur après avoir appliqué une action */
    public State succession(State state, Action action){
        throw new UnsupportedOperationException("You must implement the succession() method !");
    }


    class Action {
        public final int dx;
        public final int dy;
        
        public Action(int nbRows, int nbCols){
            this.dx = nbRows;
            this.dy = nbCols;
        }

        /** Coût de l'action (toujours 1 dans ce problème) */
        public int cout(){
            return 1;
        }
    }
}
