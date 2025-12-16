import java.util.List;
import jav.util.function.Function;

public class State {
    private final int N;
    private final int player;

    public State(int player, int N) {
        this.player = player;
        this.N = N;
    }

    public int getN() { return this.N; }
    
    public int getPlayer() { return this.player; }

    public boolean isGoal() { return this.getN() == 0; }

    public int utility() {
        if (this.getPlayer() == 0)
            return 1;

        return -1;
    }

    public List<Action> actions() {
        return List.of(
            new Function<>()
        );
    }

    public State succ(Ation a) {
        return null; // ???
    }

    public void display() {
        return "\n\nPlayer " + this.getPlayer() +
               "\nN = " + this.getN();
    }
}