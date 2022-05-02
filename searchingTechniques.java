import java.util.LinkedList;
import java.util.Queue;

public class searchingTechniques {

  final int character = 0;
  final int walkable = 1;
  final int wall = 2;
  final int walked = 3;

  MultiTree<table> tree = new MultiTree<table>();
  public int depthvalue = 0;

  public table apply(char op, table before) {
    table after = new table();
    after.insertMatrix(before.getA());
    before.findentry(0);
    int i = before.getI();
    int j = before.getJ();
    if (op == 'U') {
      if (after.getA()[i - 1][j] == walkable) {
        after.getA()[i][j] = walked;
        after.getA()[i - 1][j] = character;
        after.findentry(0);
        after.action = "Up";
        return after;
      } else {
        return null;
      }
    } else if (op == 'D') {
      if (after.getA()[i + 1][j] == walkable) {
        after.getA()[i][j] = walked;
        after.getA()[i + 1][j] = character;
        after.findentry(0);
        after.action = "Down";
        return after;
      } else {
        return null;
      }
    } else if (op == 'L') {
      if (after.getA()[i][j - 1] == walkable) {
        after.getA()[i][j] = walked;
        after.getA()[i][j - 1] = character;
        after.findentry(0);
        after.action = "Left";
        return after;
      } else {
        return null;
      }
    } else if (op == 'R') {
      if (after.getA()[i][j + 1] == walkable) {
        after.getA()[i][j] = walked;
        after.getA()[i][j + 1] = character;
        after.findentry(0);
        after.action = "Right";
        return after;
      } else {
        return null;
      }

    }
    return null;
  }

  public void depth(MultiTree<table> tr, table goal) {
    tree = tr;
    multinode<table> table = tree.root;
    depth(table, goal, 0);
  }

  boolean found = false;

  public void depth(multinode<table> node, table goal, int c) {
    c++;

    if (c > 100 || found) {
      return;
    }
    table table_node = (table) node.data;

    if (table_node.isEqual(goal)) {
      System.out.println("Starting the Maze Solver");
      tree.display_solution(node);
      System.out.println("Maze Solver finished");
      found = true;
      return;
    } else {
      table new_table_Left = apply('L', table_node);
      table new_table_Right = apply('R', table_node);
      table new_table_Up = apply('U', table_node);
      table new_table_Down = apply('D', table_node);

      if (new_table_Left != null) {
        tree.insertnode(new_table_Left, node.id);
        depth(tree.search_data(new_table_Left), goal, c);
      }
      if (new_table_Right != null) {
        tree.insertnode(new_table_Right, node.id);
        depth(tree.search_data(new_table_Right), goal, c);
      }
      if (new_table_Up != null) {
        tree.insertnode(new_table_Up, node.id);
        depth(tree.search_data(new_table_Up), goal, c);
      }
      if (new_table_Down != null) {
        tree.insertnode(new_table_Down, node.id);
        depth(tree.search_data(new_table_Down), goal, c);
      }
    }
  }

  public void iterative_deepening(MultiTree<table> tr, table goal) {
    tree = tr;
    for (int i = 1; i <= 100; i++) {
      depthvalue++;
      iterative_deepening(tree.root, goal, 0);
    }
  }

  boolean found1 = false;

  public void iterative_deepening(multinode<table> node, table goal, int c) {
    c++;

    if (c > depthvalue || found1) {
      return;
    }
    table table_node = (table) node.data;

    if (table_node.isEqual(goal)) {
      System.out.println("Starting the Maze Solver");
      tree.display_solution(node);
      System.out.println("Maze Solver finished");
      found1 = true;
      return;
    } else {
      table new_table_Left = apply('L', table_node);
      table new_table_Right = apply('R', table_node);
      table new_table_Up = apply('U', table_node);
      table new_table_Down = apply('D', table_node);

      if (new_table_Left != null) {
        tree.insertnode(new_table_Left, node.id);
        depth(tree.search_data(new_table_Left), goal, c);
      }
      if (new_table_Right != null) {
        tree.insertnode(new_table_Right, node.id);
        depth(tree.search_data(new_table_Right), goal, c);
      }
      if (new_table_Up != null) {
        tree.insertnode(new_table_Up, node.id);
        depth(tree.search_data(new_table_Up), goal, c);
      }
      if (new_table_Down != null) {
        tree.insertnode(new_table_Down, node.id);
        depth(tree.search_data(new_table_Down), goal, c);
      }
    }
  }

  public void breadth(MultiTree<table> tree, table goal) {
    Queue<multinode<table>> queue = new LinkedList<multinode<table>>();
    queue.add(tree.root);

    while (!queue.isEmpty()) {
      multinode<table> node = queue.remove();
      if (found){
        break;
      }
      table table_node = (table) node.data;

      if (table_node.isEqual(goal)) {
        System.out.println("Starting the Maze Solver");
        tree.display_solution(node);
        System.out.println("Maze Solver finished");
        found = true;
        break;
      } else {
        table new_table_Left = apply('L', table_node);
        table new_table_Right = apply('R', table_node);
        table new_table_Up = apply('U', table_node);
        table new_table_Down = apply('D', table_node);

        if (new_table_Left != null) {
          tree.insertnode(new_table_Left, node.id);
          queue.add(tree.search_data(new_table_Left));
        }
        if (new_table_Right != null) {
          tree.insertnode(new_table_Right, node.id);
          queue.add(tree.search_data(new_table_Right));
        }
        if (new_table_Up != null) {
          tree.insertnode(new_table_Up, node.id);
          queue.add(tree.search_data(new_table_Up));
        }
        if (new_table_Down != null) {
          tree.insertnode(new_table_Down, node.id);
          queue.add(tree.search_data(new_table_Down));
        }
      }
    }
  }

  public int getGN(multinode<table> node, table goal) {
    int counter = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (node.data.a[i][j] != goal.a[i][j]) {
          counter++;
        }
      }
    }
    return counter;
  }

  public void UniformCostSearch(MultiTree<table> tre, table goal) {
    this.tree = tre;
    PriorityQueue<multinode<table>> pqueue = new PriorityQueue<multinode<table>>();
    pqueue.enqueue(tree.root, getGN(tree.root, goal));

    while (!pqueue.isEmpty()) {
      multinode<table> node = pqueue.dequeue();
      if (found) {
        break;
      }
      table table_node = (table) node.data;

      if (table_node.isEqual(goal)) {
        System.out.println("Starting the Maze Solver");
        tree.display_solution(node);
        System.out.println("Maze Solver finished");
        found = true;
        break;
      } else {
        table new_table_Left = apply('L', table_node);
        table new_table_Right = apply('R', table_node);
        table new_table_Up = apply('U', table_node);
        table new_table_Down = apply('D', table_node);

        if (new_table_Left != null) {
          tree.insertnode(new_table_Left, node.id);
          pqueue.enqueue(tree.search_data(new_table_Left), getGN(tree.search_data(new_table_Left), goal));
        }
        if (new_table_Right != null) {
          tree.insertnode(new_table_Right, node.id);
          pqueue.enqueue(tree.search_data(new_table_Right), getGN(tree.search_data(new_table_Right), goal));

        }
        if (new_table_Up != null) {
          tree.insertnode(new_table_Up, node.id);
          pqueue.enqueue(tree.search_data(new_table_Up), getGN(tree.search_data(new_table_Up), goal));
        }
        if (new_table_Down != null) {
          tree.insertnode(new_table_Down, node.id);
          pqueue.enqueue(tree.search_data(new_table_Down), getGN(tree.search_data(new_table_Down), goal));
        }
      }
    }
  }

  public int getHN(multinode<table> node, table goal) {
    int sum = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (node.data.a[i][j] != goal.a[i][j]) {
          goal.findentry(node.data.a[i][j]);
          sum += Math.abs(goal.i - i) + Math.abs(goal.j - j);
        }
      }
    }
    return sum;
  }

  public void AStar(MultiTree<table> tre, table goal) {
    this.tree = tre;
    PriorityQueue<multinode<table>> pqueue = new PriorityQueue<multinode<table>>();
    pqueue.enqueue(tree.root, (getHN(tree.root, goal) + getGN(tree.root, goal)));

    while (!pqueue.isEmpty()) {
      multinode<table> node = pqueue.dequeue();
      if (found) {
        break;
      }
      table table_node = (table) node.data;

      if (table_node.isEqual(goal)) {
        System.out.println("Starting the Maze Solver");
        tree.display_solution(node);
        System.out.println("Maze Solver finished");
        found = true;
        break;
      } else {
        table new_table_Left = apply('L', table_node);
        table new_table_Right = apply('R', table_node);
        table new_table_Up = apply('U', table_node);
        table new_table_Down = apply('D', table_node);

        if (new_table_Left != null) {
          tree.insertnode(new_table_Left, node.id);
          pqueue.enqueue(tree.search_data(new_table_Left),
              (getHN(tree.search_data(new_table_Left), goal) + getGN(tree.search_data(new_table_Left), goal)));
        }
        if (new_table_Right != null) {
          tree.insertnode(new_table_Right, node.id);
          pqueue.enqueue(tree.search_data(new_table_Right),
              (getHN(tree.search_data(new_table_Right), goal) + getGN(tree.search_data(new_table_Right), goal)));

        }
        if (new_table_Up != null) {
          tree.insertnode(new_table_Up, node.id);
          pqueue.enqueue(tree.search_data(new_table_Up),
              (getHN(tree.search_data(new_table_Up), goal) + getGN(tree.search_data(new_table_Up), goal)));
        }
        if (new_table_Down != null) {
          tree.insertnode(new_table_Down, node.id);
          pqueue.enqueue(tree.search_data(new_table_Down),
              (getHN(tree.search_data(new_table_Down), goal) + getGN(tree.search_data(new_table_Down), goal)));
        }
      }
    }
  }
}
