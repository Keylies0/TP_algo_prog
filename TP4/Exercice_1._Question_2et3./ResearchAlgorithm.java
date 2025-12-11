import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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


    public static Node AStar(TravelProblem problem) {
        int counter = 0;
        PriorityQueue<Node> frontier = new PriorityQueue<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        List<State> memory = new LinkedList<>();

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (memory.contains(currentNode.getState())) continue;
            memory.add(currentNode.getState());
            counter++;
            if (problem.isGoalState(currentNode.getState())) {
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
            }
            for (Node node : currentNode.expand(problem))
                frontier.add(node);
        }
        return null;
    }
}
