class Node {
  private int data;
  private Node left;
  private Node right;

  public Node(int initalData, Node initalLeft, Node initalRight) {
    data = initalData;
    left = initalLeft;
    right = initalRight;
  }

  public int getData() {
    return data;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setData(int newData) {
    data = newData;
  }

  public void setLeft(Node newLeft) {
    left = newLeft;
  }

  public void setRight(Node newRight) {
    right = newRight;
  }

  public boolean isLeaf() {
    if (left == null && right == null) {
      return true;
    } else {
      return false;
    }
  }

  public int getLeftmostData() {
    if (left != null) {
      return left.getLeftmostData();
    } else {
      return this.getData();
    }
  }

  public int getRightmostData() {
    if (right != null) {
      return right.getRightmostData();
    } else {
      return this.getData();
    }
  }

  public Node removeLeftmost() {
    if (left == null) {
      return right;
    } else {
      left = left.removeLeftmost();
      return this;
    }
  }

  public Node removeRightmost() {
    if (right == null) {
      return left;
    } else {
      right = right.removeRightmost();
      return this;
    }
  }

}
