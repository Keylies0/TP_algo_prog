public class Exercise {
    public static void main(String[] args) {
        System.out.println("Hello, this program should solve the Travel Problem!");
        TravelProblem problem = new TravelProblem();
        Node solutionNode = ResearchAlgorithm.AStar(problem);
        if (solutionNode != null) {
            System.out.println("Search has found a solution:");
            solutionNode.printSolution();
        } else {
            System.out.println("Could not find a solution.");
        }
    }
}
