public class mainClass {
    public static void main(String[] args) {
        // // test the table class
        // table t1 = new table();

        // // test the insertMatrix method
        // int[][] b = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        // t1.insertMatrix(b);

        // // print table t1
        // System.out.println("Table t1: ");
        // System.out.println(t1);

        // // test the insertTable method
        // int[][] a = new int[3][3];
        // table t2 = new table(a);
        // t2.insertTable(t1);
        // System.out.println("Table t2: \n" + t2);

        // // test the findEntry method
        // t1.findEntry(0);
        // System.out.println("The entry 0 is at row " + t1.i + " and column " + t1.j);

        // // test isEqual method
        // if (t1.isEqual(t2)) {
        //     System.out.println("Table t1 and table t2 are equal");
        // } else {
        //     System.out.println("Table t1 and table t2 are not equal");
        // }

        // testing the searchingTechniques class
        searchingTechniques st = new searchingTechniques();
        table goal = new table();
        int[][] goalMatrix = { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
        goal.insertMatrix(goalMatrix);

        // testing the apply method
        table before = new table();
        int[][] beforeMatrix = { { 2, 0, 3 }, { 1, 6, 4 }, { 8, 7, 5 } };
        before.insertMatrix(beforeMatrix);
        // table after = st.apply('u', before);
        // if (after == null) {
        //     System.out.println("The move is not valid");
        // } else
        //     System.out.println("After applying 'u' to table before, the table after is: \n" + after);

        // insert the before table into the multitree
        MultiTree<table> tree = new MultiTree<table>(before);
        System.out.println("Solution using depth first search: ");
        // st.depth(tree, goal);

        // test iterative
        System.out.println("Solution using iterative deepening search: ");
        // st.iterative_deepening(tree, goal);

        // test breadth first search
        System.out.println("Solution using Breadth");
        // st.breadth(tree, goal);

        // test Uniform cost search 
        System.out.println("Solution using Uniform cost search: ");
        // st.UniformCostSearch(tree, goal);

        // test A*
        System.out.println("Solution using A*: ");
        st.AStar(tree, goal);

    }

}
