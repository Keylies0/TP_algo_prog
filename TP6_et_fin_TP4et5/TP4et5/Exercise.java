public class Exercise {
    public static void main(String[] args) {
        System.out.println("Hello, this program should solve the Travel Problem!");

        int firstCity = 1;
        int lastCity = 2;
        int nbCities = 6;
        TravelProblem problem = new TravelProblem(firstCity, lastCity, nbCities);

        Node solutionNode = ResearchAlgorithm.AStar(problem);
        if (solutionNode != null) {
            System.out.println("Search has found a solution:");
            solutionNode.printSolution();
        } else {
            System.out.println("Could not find a solution.");
        }
    }
}
