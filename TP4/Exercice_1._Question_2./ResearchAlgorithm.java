import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {

    public static Node search(TravelProblem problem){
        int counter = 0;
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        List<State> memory = new LinkedList<>();
        
        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(0);
            if (memory.contains(currentNode.getState()))
                continue;
            memory.add(currentNode.getState());
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
            }
            frontier.addAll(currentNode.expand(problem));
        }
        return null;
    }

    public static Node DFS(TravelProblem problem){
        int counter = 0;
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        List<State> memory = new LinkedList<>();
        
        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(frontier.size() - 1);
            if (memory.contains(currentNode.getState()))
                continue;
            memory.add(currentNode.getState());
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
            }
            frontier.addAll(currentNode.expand(problem));
        }
        return null;
    }

    public static Node IteratedDFS(TravelProblem problem){
        int l = 0;
        while (true) {
            l++;
            int counter = 0;
            List<Node> frontier = new LinkedList<>();
            Node root = new Node(problem.initialState(), null, null);
            frontier.add(root);
            List<State> memory = new LinkedList<>();

            while(!frontier.isEmpty()){
                Node currentNode = frontier.remove(frontier.size() - 1);
            if (memory.contains(currentNode.getState()))
                continue;
            memory.add(currentNode.getState());
                if (currentNode.getDepth() >= l)
                    continue;
                counter += 1;
                if (problem.isGoalState(currentNode.getState())){
                    System.out.println("Found a solution after evaluating " + counter + " nodes.");
                    return currentNode;
                }
                frontier.addAll(currentNode.expand(problem));
            }
        }
    }


}
