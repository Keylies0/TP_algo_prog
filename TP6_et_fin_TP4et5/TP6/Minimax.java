import java.lang.Math;

public class Minimax {
    public static minimax(Node s) {
        if (s.getState().isGoalState())
            return u(s);

        if (s.getState().getPlayer() == 0) {
            int v = -2;
            for (Node e : s.expand())
                v = Math.max(v, minimax(e));
            return v;
        }
        
        int v = +2;
        for (Node e : s.expand())
            v = Math.min(v, minimax(e));
        return v;
    }
}