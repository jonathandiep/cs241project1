import java.util.Scanner;
import java.util.Arrays;

class Project1 {
  public static void main(String args[]) {
    System.out.println("Please enter the initial sequence of values:");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String[] inputArr = input.split(" ");

    // convert user's input of ints to an int array
    int[] initTree = new int[inputArr.length];
    for (int i = 0; i < inputArr.length; i++) {
      try {
        initTree[i] = Integer.parseInt(inputArr[i]);
      } catch (NumberFormatException nfe) {
        System.out.println(nfe);
      }
    }

    // create a BST using the int array
    BST tree = new BST();
    for (int i = 0; i < initTree.length; i++) {
      tree.insert(initTree[i], tree.root, null);
    }

    System.out.println();
    System.out.println("Pre-order:  " + tree.preOrder(tree.root, ""));
    System.out.println("In-order:   " + tree.inOrder(tree.root, ""));
    System.out.println("Post-order: " + tree.postOrder(tree.root, ""));
    System.out.println();
    commandList();
    System.out.println();

    // while loop to ask for commands
    while (input.charAt(0) != 'E') {
      System.out.print("> ");
      input = sc.nextLine().toUpperCase();
      System.out.println();

      inputArr = input.split(" ");

      // used a switch-case because it seems intuitive for a given set of
      // commands compared to a long if-else statement
      switch(input.charAt(0)) {
        case 'I' :
          int insert = Integer.parseInt(inputArr[1]);
          if (!tree.contains(insert, tree.root)) {
            tree.insert(insert, tree.root, null);
            System.out.println("In-order: " + tree.inOrder(tree.root, ""));
          } else {
            System.out.println(insert + " already exists, ignore.");
          }
          break;
        case 'D' :
          int delete = Integer.parseInt(inputArr[1]);
          if (tree.contains(delete, tree.root)) {
            tree.delete(delete, tree.root);
            System.out.println("In-order: " + tree.inOrder(tree.root, ""));
          } else {
            System.out.println(delete + " does not exist!");
          }
          break;
        case 'P' :
          System.out.println(tree.predecessor(Integer.parseInt(inputArr[1]), tree.root).getData());
          break;
        case 'S' :
          String[] successor = input.split(" ");
          System.out.println(tree.successor(Integer.parseInt(inputArr[1]), tree.root).getData());
          break;
        case 'H' :
          commandList();
          break;
        case 'E' :
          break;
        default :
          System.out.println("That is an unrecognizable command :/");
      }
      System.out.println();

    }

    System.out.println("Thanks for using my program :)");

  }

  // separated the list of commands
  public static void commandList() {
    System.out.println("I   Insert a value");
    System.out.println("D   Delete a value");
    System.out.println("P   Find predecessor");
    System.out.println("S   Find successor");
    System.out.println("H   Display this message");
    System.out.println("E   Exit the program");
  }
}
