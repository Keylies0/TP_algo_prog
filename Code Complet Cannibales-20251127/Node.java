import java.util.LinkedList;
import java.util.List;


public class Node {

    private final State state;  // l'état associé à ce nœud
    private final Node parent;  // le nœud parent
    private final CannibalesProblem.Action parentAction; // l'action qui a conduit à cet état

    
    /* ------------------ constructeurs ------------------ */
    public Node(State state, Node node, CannibalesProblem.Action action) {
        this.state = state;
        this.parent = node;
        this.parentAction = action;
    }


    /* -------------------- getteurs -------------------- */
    public State getState() {
        return this.state;
    }
    
    public Node getParent() {
        return parent;
    }

    public CannibalesProblem.Action getParentAction() {
        return parentAction;
    }


    /* -------------------- methods --------------------- */
    /** Génère la liste des noeuds enfants */
    public List<Node> expand(CannibalesProblem problem){
        List<Node> children = new LinkedList<>();

        for (CannibalesProblem.Action action : problem.actions()) {
            Node child = this.buildChild(problem, action);
            if (child != null) {
                children.add(child);
            }
        }
        return children;
    }

    /** Vérifie si une action est valide pour ce noeud */
    private boolean isActionValid(CannibalesProblem.Action action) {
        int newMissionnaires = this.getState().getMissionnaires() + action.dMissionnaires;
        int newCannibales   = this.getState().getCannibales()     + action.dCannibales;
        int newBateau       = this.getState().getBateau()         + action.dBateau;
        return (
               newMissionnaires >= 0 && newMissionnaires <= 3
            && newCannibales    >= 0 && newCannibales   <= 3
            && (newBateau == 0 || newBateau == 1) 
            && (newMissionnaires == 0 || newMissionnaires == 3 || newMissionnaires == newCannibales)
        );
    }

    /** Génère un nœud enfant pour une action donnée. Si l'action n'est pas valide, retourne null */
    private Node buildChild(CannibalesProblem problem, CannibalesProblem.Action action) {
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
            System.out.println("Action menant à cet état : " + node.parentAction);
            System.out.println("Score de l'état : " + node.getState().getScore());
            System.out.println(node.getState());
            System.out.println();
        }
    }
}