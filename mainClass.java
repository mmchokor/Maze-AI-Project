public class mainClass {
    public static void main(String[] args) {

        final int player = 0;
        final int walkable = 1;
        final int wall = 2;
        // WIP
        final int startPos = 4;
        final int endPos = 5;

        searchingTechniques st = new searchingTechniques();

        table goal = new table();
        // int[][] startMatrix =
        // { { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        // { 2, 1, 2, 1, 2, 1, 2, 1, 1, 2 },
        // { 2, 0, 2, 1, 1, 1, 2, 1, 2, 2 },
        // { 2, 1, 1, 1, 2, 2, 2, 1, 1, 2},
        // { 2, 1, 2, 1, 1, 1, 1, 1, 2, 2},
        // { 2, 1, 2, 1, 2, 2, 2, 1, 2, 2},
        // { 2, 1, 2, 1, 2, 1, 1, 1, 2, 2},
        // { 2, 1, 2, 1, 2, 2, 2, 1, 2, 2},
        // { 2, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        // { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

        // };
        // make a similiar array to startMatrix but its size is 6 by 6
        int[][] startMatrix = { { 2, 2, 2, 2, 2, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 1, 2, 1, 1, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 0, 2, 1, 1, 2 },
                { 2, 2, 2, 2, 2, 2 }
        };

        int[][] goalMatrix = { { 2, 2, 2, 2, 2, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 1, 2, 1, 0, 2 },
                { 2, 1, 1, 1, 2, 2 },
                { 2, 1, 2, 1, 1, 2 },
                { 2, 2, 2, 2, 2, 2 }
        };
        // int[][] goalMatrix =
        // { { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        // { 2, 1, 2, 1, 2, 1, 2, 1, 1, 2 },
        // { 2, 1, 2, 1, 1, 1, 2, 1, 2, 2 },
        // { 2, 1, 1, 1, 2, 2, 2, 1, 0, 2},
        // { 2, 1, 2, 1, 1, 1, 1, 1, 2, 2},
        // { 2, 1, 2, 1, 2, 2, 2, 1, 2, 2},
        // { 2, 1, 2, 1, 2, 1, 1, 1, 2, 2},
        // { 2, 1, 2, 1, 2, 2, 2, 1, 2, 2},
        // { 2, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        // { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

        // };
        goal.insertMatrix(goalMatrix);

        // testing the apply method
        table before = new table();
        before.insertMatrix(startMatrix);

        System.out.println(before.toString());
        table after = st.apply('U', before);
        System.out.println(after.toString());
        table after2 = st.apply('R', after);
        System.out.println(after2.toString());

        // insert the before table into the multitree
        MultiTree<table> tree = new MultiTree<table>(before);
        // System.out.println("Solution using depth first search: ");
        // st.depth(tree, goal);

        // // test iterative
        System.out.println("Solution using iterative deepening search: ");
        st.iterative_deepening(tree, goal);

        // test breadth first search
        // System.out.println("Solution using Breadth");
        // st.breadth(tree, goal);

        // // test Uniform cost search
        // System.out.println("Solution using Uniform cost search: ");
        // // st.UniformCostSearch(tree, goal);

        // // test A*
        // System.out.println("Solution using A*: ");
        // st.AStar(tree, goal);

    }

}
