/**
 * This is the Binary Search Tree (BST) class. It only contains a root. I had
 * thought about including the size and height of the tree, but it was not
 * necessary for this project. All methods in the BST class are recursive.
 */
public class BST {
  protected Node root;

  public BST() {
    root = null;
  }

  /**
   * The contains method will check if a given value is within a BST. This is
   * used to prevent inserting duplicate values and deleting non-existent ones
   */
  public boolean contains(int target, Node n) {
    if (n == null) return false;

    if (n.getData() == target) {
      return true;
    } else if (n.getData() > target) {
      return contains(target, n.getLeft());
    } else {
      return contains(target, n.getRight());
    }
  }

  /**
   * This is my implementation of the predecessor. Although I didn't have it, I
   * implemented recursion into this algorithm because it's good practice.
   */
  public Node predecessor(int target, Node n) {
    if (root == null) return null;
    if (n == root.getLeftmost()) return null;

    if (n.getData() == target) {
      if (n.getLeft() != null) {
        return n.getLeft().getRightmost();
      } else {
        Node temp = n.parent;

        while (temp != null && n == temp.getLeft()) {
          n = temp;
          temp = temp.parent;
        }

        if (temp == null) {
          return null;
        } else {
          return temp;
        }
      }
    } else if (n.getData() > target) {
      return predecessor(target, n.getLeft());
    } else {
      return predecessor(target, n.getRight());
    }
  }

  /**
   * This is my implementation of the successor. It is kind of like a mirrored
   * version of the predecessor method.
   */
  public Node successor(int target, Node n) {
    if (root == null) return null;
    if (n == root.getRightmost()) return null;

    if (n.getData() == target) {
      if (n.getRight() != null) {
        return n.getRight().getLeftmost();
      } else {
        Node temp = n.parent;
        while (temp != null && n == temp.getRight()) {
          n = temp;
          temp = temp.parent;
        }

        if (temp == null) {
          return null;
        } else {
          return temp;
        }
      }
    } else if (n.getData() > target) {
      return successor(target, n.getLeft());
    } else {
      return successor(target, n.getRight());
    }
  }

  /**
   * The insert method will insert a new value starting from the root. It will
   * find the right place in the BST to create a new node containing the value.
   * The implementation of this method is recursive.
   */
  public Node insert(int element, Node n, Node p) {
    if (root == null) {
      root = new Node(element, null, null, null);
      return root;
    }

    if (n == null) {
      return new Node(element, null, null, p);
    } else {
      if (element <= n.getData()) {
        //System.out.println("set left");
        n.setLeft(insert(element, n.getLeft(), n));
      } else {
        //System.out.println("set right");
        n.setRight(insert(element, n.getRight(), n));
      }
      return n;
    }
  }

  /**
   * The delete method will delete a node from the BST based on a given value.
   * This method is also recursive.
   */
  public boolean delete(int target, Node n) {

    // case #1: root is empty
    if (n == null) return false;

    if (n.getData() == target) {
      if (n.getLeft() == null) {

        // case #2: target found at root with no left child
        if (n == root) {
          root = root.getRight();
          return true;
        }

        // case #3: target found with no left child
        if (n == n.parent.getLeft()) {
          n.parent.setLeft(n.getRight());
        } else {
          n.parent.setRight(n.getRight());
        }
        return true;

        // case #4: there's a left child
      } else {
        Node temp = n;
        n.setData(n.getLeft().getRightmost().getData());
        n.setLeft(n.getLeft().removeRightmost());
        return true;
      }
    } else if (n.getData() > target) {
      return delete(target, n.getLeft());
    } else {
      return delete(target, n.getRight());
    }
  }

  /**
   *  This is the method that returns a string of the pre-order of the BST.
   */
  public String preOrder(Node n, String s) {
    String print = s;

    // Process the root.
    if (n != null) {
      print += n.getData() + " ";
    }

    // Process the nodes in the left subtree with a recursive call.
    if (n.getLeft() != null) {
      print += preOrder(n.getLeft(), s);
    }
    // Process the nodes in the right subtree with a recursive call.
    if (n.getRight() != null) {
      print += preOrder(n.getRight(), s);
    }

    return print;
  }

  /**
   *  This is the method that returns a string of the in-order of the BST.
   */
  public String inOrder(Node n, String s) {
    String print = s;

    // Process the nodes in the left subtree with a recursive call.
    if (n.getLeft() != null) {
      print += inOrder(n.getLeft(), s);
    }

    // Process the root.
    if (n != null) {
      print += n.getData() + " ";
    }

    // Process the nodes in the right subtree with a recursive call.
    if (n.getRight() != null) {
      print += inOrder(n.getRight(), s);
    }

    return print;
  }

  /**
   *  This is the method that returns a string of the post-order of the BST. 
   */
  public String postOrder(Node n, String s) {
    String print = s;

    // Process the nodes in the left subtree with a recursive call.
    if (n.getLeft() != null) {
      print += postOrder(n.getLeft(), s);
    }

    // Process the nodes in the right subtree with a recursive call.
    if (n.getRight() != null) {
      print += postOrder(n.getRight(), s);
    }

    // Process the root.
    if (n != null) {
      print += n.getData() + " ";
    }

    return print;
  }

}
