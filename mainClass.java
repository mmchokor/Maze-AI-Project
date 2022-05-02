public class mainClass {
    public static void main(String[] args) {

        table before = new table();
        table goal = new table();

        // make 2 arrays, startMatrix and goalMatrix of size 6 by 6
        int[][] startMatrix =
                { { 2, 2, 2, 2, 2, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 1, 2, 1, 1, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 0, 2, 1, 1, 2 },
                { 2, 2, 2, 2, 2, 2 }};

        int[][] goalMatrix =
                { { 2, 2, 2, 2, 2, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 1, 2, 1, 0, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 1, 2, 1, 1, 2 },
                { 2, 2, 2, 2, 2, 2 }};

        before.insertMatrix(startMatrix);
        goal.insertMatrix(goalMatrix);

        searchingTechniques st = new searchingTechniques();
        // insert the before table into the multitree
        MultiTree<table> tree = new MultiTree<table>(before);
        System.out.println("Solution using depth first search: ");
        st.depth(tree, goal);

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

    }

}
