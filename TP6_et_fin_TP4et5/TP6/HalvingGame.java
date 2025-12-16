import java.util.Map;

public class HalvingGame {
    private final int N;
    private final Map<Integer, Function<State, String>> policies; // ???

    public HalvingGame(int N) {
        this.N = N;
        this.policies = null // ???
    }

    public int getN() { return this.N; }

    public Map<Integer, Function<State, String>> getPolicies() { return this.policies; }

    public State initialState() { return new State(0, this.getN()); }

    public boolean isOver(State s) { return s.isGoal(); }

    public Action customPolicy(State s) { return null; } // ???

    public Action minimaxPolicy(State s) { return null; } // ???

    public int play() { return 0; } // ???

    public class Action {
        ???
    }
}