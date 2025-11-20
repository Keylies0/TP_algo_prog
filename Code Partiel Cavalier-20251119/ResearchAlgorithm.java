import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {

    public static List<Node> search(KnightsTourProblem problem){
        int counter = 0;
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        
        List<Node> nodes = new LinkedList<>(); // Q5

        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(0);
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                //System.out.println("Found a solution after evaluating " + counter + " nodes.");
                //return currentNode;
                nodes.add(currentNode); // Q5
            }
            frontier.addAll(currentNode.expand(problem));
        }
        //return null;
        return nodes; // Q5
    }
    
}
