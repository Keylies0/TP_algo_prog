import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {

    public static Node search(CannibalesProblem problem, int profondeur) {
        int counter = 0;
        LinkedList<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);

        LinkedList<State> visites = new LinkedList<>();

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.removeLast();
            if (visites.contains(currentNode.getState()) || currentNode.getProfondeur() > profondeur) continue;

            visites.add(currentNode.getState());

            if (problem.isGoalState(currentNode.getState())) {
                System.out.println("Solution trouvée après évalution de " + counter + " nœuds.");
                return currentNode;
            }
            frontier.addAll(currentNode.expand(problem));
            counter++;
        }

        return null;
    }
}
