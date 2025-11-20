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
        int[][] grille = new int[this.NB_ROWS][this.NB_COLS];
        for (int i = 0; i < NB_ROWS; i++)
            for (int j = 0; j < NB_COLS; j++)
                grille[i][j] = 0;
        grille[0][0] = 2;
        return new State(grille, new Position(), 1);
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
        // return state.getScore() == NB_ROWS * NB_COLS;
        /** Question 6 */
        return state.getScore() == NB_ROWS * NB_COLS
                && (state.getKnight().x == 2 && state.getKnight().y == 1
                    || state.getKnight().x == 1 && state.getKnight().y == 2);
    }

    /** Retourne l'état successeur après avoir appliqué une action */
    public State succession(State state, Action action){
        // Node.isActionValid se charge de vérifier si l'action est valide pour state
        int[][] grille = new int[NB_ROWS][NB_COLS];
        for (int i = 0; i < NB_ROWS; i++)
            grille[i] = state.getBoard()[i].clone();
        Position oldKnight = state.getKnight();
        Position newKnight = oldKnight.move(action.dx, action.dy);
        grille[oldKnight.x][oldKnight.y] = 1;
        grille[newKnight.x][newKnight.y] = 2;
        return new State(grille, newKnight, state.getScore() + 1);
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
