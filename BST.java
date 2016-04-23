public class BST {
  protected Node root;

  public BST() {
    root = null;
  }

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

/*
  public boolean remove(int target) {
    Node cursor = root;
    Node parent = null;

    // case #1: root is empty
    if (cursor == null) return false;

    while (true) {
      if (cursor.getData() == target) {
        if (cursor.getLeft() == null) {

          // case #2: target found at root with no left child
          if (cursor == root) {
            root = root.getRight();
            return true;
          }

          // case #3: target found with no left child
          if (cursor == parent.getLeft()) {
            parent.setLeft(cursor.getRight());
          } else {
            parent.setRight(cursor.getRight());
          }
          return true;
        // case #4: there's a left child
        } else {
          cursor.setData(cursor.getLeft().getRightmost().getData());
          cursor.setLeft(cursor.getLeft().removeRightmost());
          return true;
        }
      } else if (target < cursor.getData()) {
        parent = cursor;
        cursor = cursor.getLeft();
      } else {
        parent = cursor;
        cursor = cursor.getRight();
      }

    }

  }
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
