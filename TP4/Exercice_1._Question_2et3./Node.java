import java.util.LinkedList;
import java.util.List;
import java.lang.Math;


public class Node implements Comparable<Node> {

    private final State state;  // l'état associé à ce nœud
    private final Node parent;  // le nœud parent
    private final TravelProblem.Action parentAction; // l'action qui a conduit à cet état
    private final int depth;
    private final int cost;
    

    
    /* ------------------ constructeur ------------------ */
    public Node(State state, Node node, TravelProblem.Action action) {
        this.state = state;
        this.parent = node;
        this.parentAction = action;
        if (node == null) {
            this.depth = 0;
            this.cost = 0;
        }
        else {
            this.depth = node.getDepth() + 1;
            this.cost = node.getCost() + action.cout(state);
        }
    }


    /* -------------------- getteurs -------------------- */
    public State getState() { return this.state; }
    public Node getParent() { return parent;     }
    public TravelProblem.Action getParentAction() { return parentAction; }
    public int getDepth() { return this.depth; }
    public int getCost() { return this.cost; }


    /* -------------------- methods --------------------- */
    /** Génère la liste des noeuds enfants */
    public List<Node> expand(TravelProblem problem) {
        List<Node> children = new LinkedList<>();

        for (TravelProblem.Action action : problem.actions()) {
            Node child = this.buildChild(problem, action);
            if (child != null) children.add(child);
        }
        return children;
    }

    /** Vérifie si une action est valide pour ce noeud */
    private boolean isActionValid(TravelProblem.Action action) {
        return !this.getState().getVoyage().contains(action.id);
    }

    /** Génère un nœud enfant pour une action donnée. Si l'action n'est pas valide, retourne null */
    private Node buildChild(TravelProblem problem, TravelProblem.Action action) {
        if (!this.isActionValid(action)) return null;

        State childState = problem.succession(this.state, action);
        return new Node(childState, this, action);
    }

    /** Retourne la liste des noeuds formant le chemin de la racine à ce noeud */
    private List<Node> path() {
        List<Node> path_back = new LinkedList<>();
        Node node = this;
        while (node != null) {
            path_back.add(0, node); // ajoute au début pour inverser l'ordre
            node = node.getParent();
        }
        return path_back;
    }

    /** Affiche la solution menant à ce noeud */
    public void printSolution() {
        List<Node> solutionPath = this.path();
        for (Node node : solutionPath) {
            //System.out.println("Action menant à cet état : " + node.parentAction);
            System.out.println("Score de l'état : " + node.getState().getScore());
            System.out.println(node.getState());
            System.out.println();
        }
    }

/*
    @Override
    public int compareTo(Node that) {
        int nbVerticesThis = 47
        return run() - run();
    }
*/
}