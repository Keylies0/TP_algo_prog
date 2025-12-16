public class Exercise {
    public static void main(String[] args) {
        System.out.println("Hello, this program should solve the HalvingGame!");
        HalvingGame problem = new HalvingGame();
        Node solutionNode = ResearchAlgorithm.???????????(problem);
        if (solutionNode != null) {
            System.out.println("Search has found a solution:");
            solutionNode.printSolution();
        } else {
            System.out.println("Could not find a solution.");
        }
    }
}