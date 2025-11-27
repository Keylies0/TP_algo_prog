import java.util.LinkedList;
import java.util.List;

public class Exercise {

    public static void main(String[] args) {
        System.out.println("Bonjour, ce programme devrait résoudre le problème des Cannibales !");
        CannibalesProblem problem = new CannibalesProblem();

        int LIMIT = 20;
        int profondeur = 2;

        while (profondeur <= LIMIT) {
            System.out.println("Recherche avec une profondeur de " + profondeur);
            Node solutionNode = ResearchAlgorithm.search(problem, profondeur);
            if (solutionNode != null) {
                System.out.println("La recherche a trouvé une solution :");
                solutionNode.printSolution();
                return;
            }
            else
                System.out.println("Impossible de trouver une solution");

            profondeur++;
        }
    }
}
