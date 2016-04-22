public class BST {
  protected Node root;

  public BST() {
    root = null;
  }


  public Node insert(int element, Node n) {
    if (root == null) {
      root = new Node(element, null, null);
      return root;
    }

    if (n == null) {
      return new Node(element, null, null);
    } else {
      if (element <= n.getData()) {
        //System.out.println("set left");
        n.setLeft(insert(element, n.getLeft()));
      } else {
        //System.out.println("set right");
        n.setRight(insert(element, n.getRight()));
      }
      return n;
    }
  }

  public boolean remove(int target) {
    Node cursor = root;
    Node parent = null;

    while (true) {

      // case #1: root is empty
      if (cursor == null) return false;

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

        // case #4: there's a left child
        } else {
          cursor.setData(cursor.getLeft().getRightmostData());
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

  /*
  // must be implemented with recursion
  // must be implemented with recursion
  public Node delete(int data) {

  }

  public Node predecessor(int data) {

  }

  public Node successor(int data) {

  }

  public String preOrder() {

  }

  public String inOrder() {

  }

  public String postOrder() {

  }
  */

}

/*
public int getLeftmostData(Node n) {
  if (n.getLeft() != null) {
    return getLeftmostData(n.getLeft());
  } else {
    return n.getData();
  }
}

public int getRightmostData(Node n) {
  if (n.getRight() != null) {
    return getRightmostData(n.getRight());
  } else {
    return n.getData();
  }
}

public Node removeLeftmost(Node n) {
  if (n.getLeft() == null) {
    return n.getRight();
  } else {
    n.setLeft(removeLeftmost(n.getLeft()));
    return n;
  }
}

public Node removeRightmost(Node n) {
  if (n.getRight() == null) {
    return n.getLeft();
  } else {
    n.setRight(removeRightmost(n.getRight()));
    return n;
  }
}
*/
