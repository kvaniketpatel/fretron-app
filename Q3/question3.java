import java.util.*;

public class CastlePath {
    static List<String> paths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of soldiers: ");
        int numSoldiers = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        int[][] soldiers = new int[numSoldiers][2];

        for (int i = 0; i < numSoldiers; i++) {
            System.out.print("Enter coordinates for soldier " + (i + 1) + ": ");
            String[] coordinates = sc.nextLine().split(",");
            
            soldiers[i][0] = Integer.parseInt(coordinates[0]);
            soldiers[i][1] = Integer.parseInt(coordinates[1]);
        }

        int[] castle = new int[2];
        System.out.print("Enter the coordinates for your 'special' castle: ");
        String[] castleCoordinates = sc.nextLine().split(",");
        castle[0] = Integer.parseInt(castleCoordinates[0]);
        castle[1] = Integer.parseInt(castleCoordinates[1]);

        findPaths(castle, soldiers, 0, 0, new ArrayList<>());
        printPaths();
    }

    static void findPaths(int[] castle, int[][] soldiers, int index, int direction, List<String> path) {
        if (index == soldiers.length) {
            StringBuilder sb = new StringBuilder("Start: (" + castle[0] + "," + castle[1] + ")\n");
            for (String step : path) {
                sb.append(step).append("\n");
            }
            paths.add(sb.toString());
            return;
        }

        int dx = soldiers[index][0] - castle[0];
        int dy = soldiers[index][1] - castle[1];
        int nextDirection = (dx == 0) ? 1 : 0;  

        String step = "Kill (" + soldiers[index][0] + "," + soldiers[index][1] + "). Turn " + ((direction == nextDirection) ? "Right" : "Left");
        path.add(step);
        findPaths(soldiers[index], soldiers, index + 1, nextDirection, path);
        path.remove(path.size() - 1);
    }

    static void printPaths() {
        System.out.println("There are " + paths.size() + " unique paths for your 'special_castle'");
        for (int i = 0; i < paths.size(); i++) {
            System.out.println("Path " + (i + 1) + ": =======");
            System.out.println(paths.get(i));
        }
    }
}