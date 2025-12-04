import java.util.List;
import java.util.LinkedList;
import java.lang.Math;

public class TravelProblem {

    private final int[][] coord = {
        {6734, 1453},
        {2233,   10},
        {5530, 1424},
        { 401,  841},
        {3082, 1644},
        {7608, 4458},
        {7573, 3716},
        {7265, 1268},
        {6898, 1885},
        {1112, 2049},
        {5468, 2606},
        {5989, 2873},
        {4706, 2674},
        {4612, 2035},
        {6347, 2683},
        {6107,  669},
        {7611, 5184},
        {7462, 3590},
        {7732, 4723},
        {5900, 3561},
        {4483, 3369},
        {6101, 1110},
        {5199, 2182},
        {1633, 2809},
        {4307, 2322},
        { 675, 1006},
        {7555, 4819},
        {7541, 3981},
        {3177,  756},
        {7352, 4506},
        {7545, 2801},
        {3245, 3305},
        {6426, 3173},
        {4608, 1198},
        {  23, 2216},
        {7248, 3779},
        {7762, 4595},
        {7392, 2244},
        {3484, 2829},
        {6271, 2135},
        {4985,  140},
        {1916, 1569},
        {7280, 4899},
        {7509, 3239},
        {  10, 2676},
        {6807, 2993},
        {5185, 3258},
    };

    /** Retourne l'état initial */
    public State initialState() { return new State(new LinkedList<Integer>(), 0); }

    /** Retourne la liste des actions */
    public List<Action> actions() {
        List<Action> actions = new LinkedList<>();
        for (int id = 0; i < 48; i++)
            actions.add(new Action(id));
        return actions;
    }

    /** Vérifie si l'état est terminal */
    public boolean isGoalState(State state) { return state.getVoyage().getSize() == 48; }

    /** Retourne l'état successeur après avoir appliqué une action */
    public State succession(State state, Action action) {
        // Node.isActionValid se charge de vérifier si l'action est valide pour state
        return new State(state.getVoyage().add(action.id), state.getScore() + action.cout(state));
    }


    class Action {
        public final int id;
        
        public Action(int id) {
            this.id = id;
        }

        /** Coût de l'action */
        public int cout(State state) {
            if (state.getVoyage().isEmpty())
                return 0;

            return Marth.sqrt(Math.pow(coord[this.id][0] - coord[state.getVoyage().getLast()][0], 2)                            
                              + Math.pow(coord[this.id][1] - coord[state.getVoyage().getLast()][2], 2)); }
    }
}
