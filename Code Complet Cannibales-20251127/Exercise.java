import java.util.LinkedList;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        System.out.println("Bonjour, ce programme devrait résoudre le problème des Cannibales !");
        CannibalesProblem problem = new CannibalesProblem();

        Node solutionNode = ResearchAlgorithm.search(problem);
        if (solutionNode != null) {
            System.out.println("La recherche a trouvé une solution :");
            solutionNode.printSolution();
        }
        else
            System.out.println("Impossible de trouver une solution.");
    }
}
