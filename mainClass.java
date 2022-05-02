import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int userInput = 0;

        // System.out.println("Solution using depth first search: ");
        // st.depth(tree, goal);

        // // test iterative
        // System.out.println("Solution using iterative deepening search: ");
        // st.iterative_deepening(tree, goal);

        // test breadth first search
        // System.out.println("Solution using Breadth");
        // st.breadth(tree, goal);

        // // test Uniform cost search
        // System.out.println("Solution using Uniform cost search: ");
        // st.UniformCostSearch(tree, goal);

        // // test A*
        // System.out.println("Solution using A*: ");
        // st.AStar(tree, goal);

        do {
            table before = new table();
            table goal = new table();

            // make 2 arrays, startMatrix and goalMatrix of size 6 by 6
            int[][] startMatrix = { { 2, 2, 2, 2, 2, 2 },
                    { 2, 1, 1, 1, 2, 2 },
                    { 2, 1, 2, 1, 1, 2 },
                    { 2, 1, 1, 1, 2, 2 },
                    { 2, 0, 2, 1, 1, 2 },
                    { 2, 2, 2, 2, 2, 2 } };

            int[][] goalMatrix = { { 2, 2, 2, 2, 2, 2 },
                    { 2, 1, 1, 1, 2, 2 },
                    { 2, 1, 2, 1, 0, 2 },
                    { 2, 1, 1, 1, 2, 2 },
                    { 2, 1, 2, 1, 1, 2 },
                    { 2, 2, 2, 2, 2, 2 } };

            before.insertMatrix(startMatrix);
            goal.insertMatrix(goalMatrix);

            searchingTechniques st = new searchingTechniques();
            // insert the before table into the multitree
            MultiTree<table> tree = new MultiTree<table>(before);

            // printing a splash screen
            System.out.println("---------------------------------------------------------------");
            System.out.println("|                           Maze Solver                       |");
            System.out.println("---------------------------------------------------------------");

            // printing the maze before the search
            System.out.println("| Initial state of the Maze:                                  |\n");
            System.out.println(before.toString());
            System.out.println("---------------------------------------------------------------");
            
            // The menu
            System.out.println("| Enter which Searching Technique you want to use:            |");
            System.out.println("| 1. Depth First Search                                       |");
            System.out.println("| 2. Iterative Deepening Search                               |");
            System.out.println("| 3. Breadth First Search                                     |");
            System.out.println("| 4. Uniform Cost Search                                      |");
            System.out.println("| 5. A*                                                       |");
            System.out.println("| 6. Exit                                                     |");
            System.out.print("| Your choice: ");
            userInput = input.nextInt();
            System.out.println("---------------------------------------------------------------");

            switch (userInput) {
                case 1:
                    System.out.println("Solution using depth first search: ");
                    st.depth(tree, goal);
                    break;
                case 2:
                    System.out.println("Solution using iterative deepening search: ");
                    st.iterative_deepening(tree, goal);
                    break;
                case 3:
                    System.out.println("Solution using Breadth");
                    st.breadth(tree, goal);
                    break;
                case 4:
                    System.out.println("Solution using Uniform cost search: ");
                    st.UniformCostSearch(tree, goal);
                    break;
                case 5:
                    System.out.println("Solution using A*: ");
                    st.AStar(tree, goal);
                    break;
                case 6:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

            // pause the program for user to see the result
            try {
                System.out.println("The program will pause for 10 seconds for you to see the result");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (userInput != 6);
        input.close();
    }
}
