import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class searchingTechniques {

  final int character = 0;
  final int walkable = 1;
  final int wall = 2;
  final int walked = 3;


  MultiTree<table> tree = new MultiTree<table>();
  public int depthvalue = 0;

  // apply(char op, table before): table
  // this method is to move the 0 cell up and down and to the right and left

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
      }else {
        return null;
      }
    } else if (op == 'D') {
      if (after.getA()[i + 1][j] == walkable) {
        after.getA()[i][j] = walked;
        after.getA()[i + 1][j] = character;
        after.findentry(0);
        after.action = "Down";
        return after;
      }else {
        return null;
      }
    } else if (op == 'L') {
      if (after.getA()[i][j - 1] == walkable) {
        after.getA()[i][j] = walked;
        after.getA()[i][j - 1] = character;
        after.findentry(0);
        after.action = "Left";
        return after;
      }else {
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
    /*switch (op) {
      case 'L':
        if (after.getA()[i][j] == character && after.getA()[i][j - 1] == walkable && after.getA()[i][j - 1] != wall) {
          after.a[i][j] = character;
          after.a[i][j - 1] = walkable;
        } else {
          return null;
        }
        break;
      case 'R':
        if (after.getA()[i][j] == character  && after.getA()[i][j + 1] == walkable && after.getA()[i][j + 1] != wall) {
          after.a[i][j] = character;
          after.a[i][j + 1] = walkable;
        } else {
          return null;
        }
        break;
      case 'D':
        if (after.getA()[i][j] == character  && before.getA()[i + 1][j] != wall && after.getA()[i + 1][j] == walkable) {
          after.a[i][j] = character;
          after.a[i + 1][j] = walkable;
        } else {
          return null;
        }
        break;
      case 'U':
        if (after.getA()[i][j] == character  && before.getA()[i - 1][j] != wall && after.getA()[i - 1][j] == walkable) {
          after.a[i][j] = character;
          after.a[i - 1][j] = walkable;
        } else {
          return null;
        }
        break;
      default:
        return null;
    }
    */
    return null;
  }

  // find the solution of the 8 puzzle problem using depth first search
  // depth(MultiTree<table> tree, table goal): void
  public void depth(MultiTree<table> tr, table goal) {
    tree = tr;
    depth(tree.root, goal, 0);
  }

  boolean found = false;

  // depth(MultiTree<table> tree, table goal, int depth): void
  public void depth(multinode<table> node, table goal, int c) {
    c++;

    if (c > 100 || found) {
      return;
    }
    table table_node = (table) node.data;


    if (table_node.isEqual(goal)) {
      System.out.println("start");
      tree.display_solution(node);
      System.out.println("end");
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

  // find the solution of the 8 puzzle problem using iterative deepening search
  // iterative_deepening(MultiTree<table> tree, table goal): void
  public void iterative_deepening(MultiTree<table> tr, table goal) {
    tree = tr;
    for (int i = 1; i <= 20000; i++) {
      depthvalue++;
      iterative_deepening(tree.root, goal, 0);
    }
  }

  // iterative_deepening(MultiTree<table> tree, table goal, int depth): void
  boolean found1 = false;

  // depth(MultiTree<table> tree, table goal, int depth): void
  public void iterative_deepening(multinode<table> node, table goal, int c) {
    c++;

    if (c > depthvalue || found1) {
      return;
    }
    table table_node = (table) node.data;

    if (table_node.isequal(goal)) {
      System.out.println("start");
      tree.display_solution(node);
      System.out.println("end");
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

  // solving the 8 puzzle problem using breadth first search
  // using queues
  // breadth(MultiTree<table> tree, table goal): void
  // using only one method
  public void breadth(MultiTree<table> tree, table goal) {
    Queue<multinode<table>> queue = new LinkedList<multinode<table>>();
    queue.add(tree.root);

    while (!queue.isEmpty()) {
      multinode node = queue.remove();
      if (found) {
        break;
      }
      table table_node = (table) node.data;

      if (table_node.isequal(goal)) {
        System.out.println("start");
        tree.display_solution(node);
        System.out.println("end");
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

  // calculate g(n) to use in UCS
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

  // solving the 8 pizzle problem using Uniform Cost Search (UCS)
  // using priority queues
  // it similiar to breadth
  public void UniformCostSearch(MultiTree<table> tre, table goal) {
    this.tree = tre;
    PriorityQueue<multinode<table>> pqueue = new PriorityQueue<multinode<table>>();
    pqueue.enqueue(tree.root, getGN(tree.root, goal));

    while (!pqueue.isEmpty()) {
      multinode node = pqueue.dequeue();
      if (found) {
        break;
      }
      table table_node = (table) node.data;

      if (table_node.isequal(goal)) {
        System.out.println("start");
        tree.display_solution(node);
        System.out.println("end");
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

  // calculate g(n) to use in UCS
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

  // using A*
  public void AStar(MultiTree<table> tre, table goal) {
    this.tree = tre;
    PriorityQueue<multinode<table>> pqueue = new PriorityQueue<multinode<table>>();
    pqueue.enqueue(tree.root, (getHN(tree.root, goal) + getGN(tree.root, goal)));

    while (!pqueue.isEmpty()) {
      multinode node = pqueue.dequeue();
      if (found) {
        break;
      }
      table table_node = (table) node.data;


      if (table_node.isequal(goal)) {
        System.out.println("start");
        tree.display_solution(node);
        System.out.println("end");
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
