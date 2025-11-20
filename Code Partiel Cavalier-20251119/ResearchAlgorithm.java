import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {
    // type de retour List<Node> pour Question 5
    public static Node search(KnightsTourProblem problem){
        int counter = 0;
        LinkedList<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        
        /** Question 5
        List<Node> nodes = new LinkedList<>();
        */

        while(!frontier.isEmpty()){
            //Node currentNode = frontier.remove(0);
            Node currentNode = frontier.removeLast();
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
                /** Question 5
                nodes.add(currentNode);
                */
            }
            frontier.addAll(currentNode.expand(problem));
        }
        return null;
        /** Question 5
        return nodes;
        */
    }
    
}
