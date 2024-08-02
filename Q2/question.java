import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppleDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int RAM_PAID = 50;
        final int SHAM_PAID = 30;
        final int RAHIM_PAID = 20;
        final int TOTAL_PAID = RAM_PAID + SHAM_PAID + RAHIM_PAID;

        List<Integer> ramApples = new ArrayList<>();
        List<Integer> shamApples = new ArrayList<>();
        List<Integer> rahimApples = new ArrayList<>();

        System.out.println("Enter apple weight in grams (-1 to stop):");
        List<Integer> appleWeights = new ArrayList<>();
        int appleWeight = scanner.nextInt();

        while (appleWeight != -1) {
            appleWeights.add(appleWeight);
            appleWeight = scanner.nextInt();
        }

        // Sort apples in descending order
        appleWeights.sort((a, b) -> b - a);

        int totalWeight = appleWeights.stream().mapToInt(Integer::intValue).sum();
        int ramTarget = (RAM_PAID * totalWeight) / TOTAL_PAID;
        int shamTarget = (SHAM_PAID * totalWeight) / TOTAL_PAID;
        int rahimTarget = (RAHIM_PAID * totalWeight) / TOTAL_PAID;

        int ramTotalWeight = 0;
        int shamTotalWeight = 0;
        int rahimTotalWeight = 0;

        for (int weight : appleWeights) {
            if (ramTotalWeight + weight <= ramTarget && (ramTarget - ramTotalWeight >= weight || shamTotalWeight >= shamTarget && rahimTotalWeight >= rahimTarget)) {
                ramApples.add(weight);
                ramTotalWeight += weight;
            } else if (shamTotalWeight + weight <= shamTarget && (shamTarget - shamTotalWeight >= weight || ramTotalWeight >= ramTarget && rahimTotalWeight >= rahimTarget)) {
                shamApples.add(weight);
                shamTotalWeight += weight;
            } else {
                rahimApples.add(weight);
                rahimTotalWeight += weight;
            }
        }

        System.out.println("Distribution Result:");
        System.out.print("Ram: ");
        for (int weight : ramApples) {
            System.out.print(weight + " ");
        }
        System.out.println();

        System.out.print("Sham: ");
        for (int weight : shamApples) {
            System.out.print(weight + " ");
        }
        System.out.println();

        System.out.print("Rahim: ");
        for (int weight : rahimApples) {
            System.out.print(weight + " ");
        }
        System.out.println();

        scanner.close();
    }
}