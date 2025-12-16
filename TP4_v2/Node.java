import java.util.LinkedList;
import java.util.List;
import java.lang.Math;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class Node implements Comparable<Node> {

    private final State state;  // l'état associé à ce nœud
    private final Node parent;  // le nœud parent
    private final TravelProblem.Action parentAction; // l'action qui a conduit à cet état
    private final int cost; // cout depuis l'état initial
    private       double kruskalWeight; // poids estimé pour arriver à la fin
    

    
    /* ------------------ constructeur ------------------ */
    public Node(State state, Node node, TravelProblem.Action action) {
        this.state = state;
        this.parent = node;
        this.parentAction = action;
        if (node == null)
            this.cost = 0;
        else
            this.cost = node.getCost() + action.cout(state);

        // calcul kruskWeight
        this.kruskalWeight = 0;
        try {
            List<String> cities = Files.readAllLines(Paths.get("us_capitals.txt"));

            List<Integer> vertices = new LinkedList<>();
            for (int id = 1; id < 6; id++) // CHANGER LE NOMBRE MAXIMUM DE CITIES A LA MAIN :-(
                vertices.add(id);

            List<Integer> thisParcours = this.getState().getParcours();
            vertices.removeAll(thisParcours);
            vertices.add(thisParcours.get(thisParcours.size() - 1));

            List<Edge> edges = new LinkedList<>();
            int vnbr = 0;
            for (int v : vertices) {
                int unbr = 0;
                for (int u : vertices) {
                    if (v < u) {
                        int x1 = Integer.parseInt(cities.get(v).split(" ")[1]);
                        int x2 = Integer.parseInt(cities.get(v).split(" ")[2]);
                        int y1 = Integer.parseInt(cities.get(u).split(" ")[1]);
                        int y2 = Integer.parseInt(cities.get(u).split(" ")[2]);

                        double weight = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
                        edges.add(new Edge(vnbr, unbr, weight));
                    }
                    unbr++;
                }
                vnbr++;
            }

            this.kruskalWeight = Kruskal.run(vertices.size(), edges);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }


    /* -------------------- getteurs -------------------- */
    public State getState() { return this.state; }
    public Node getParent() { return parent;     }
    public TravelProblem.Action getParentAction() { return parentAction; }
    public int getCost() { return this.cost; }
    public int getEstimation() { return this.cost + (int) this.kruskalWeight; }


    /* -------------------- methods --------------------- */
    /** Génère la liste des noeuds enfants */
    public List<Node> expand(TravelProblem problem) {
        List<Node> children = new LinkedList<>();

        for (TravelProblem.Action action : problem.actions()) {
            Node child = this.buildChild(problem, action);
            if (child != null)
                children.add(child);
        }
        return children;
    }

    /** Vérifie si une action est valide pour ce noeud */
    private boolean isActionValid(TravelProblem.Action action) {
        return !this.getState().getParcours().contains(action.id);
    }

    /** Génère un nœud enfant pour une action donnée. Si l'action n'est pas valide, retourne null */
    private Node buildChild(TravelProblem problem, TravelProblem.Action action) {
        if (!this.isActionValid(action))
            return null;

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

    @Override
    public int compareTo(Node that) { return this.getEstimation() - that.getEstimation(); }
}