class Project1 {
  public static void main(String args[]) {
    BST tree = new BST();
    tree.insert(4, tree.root, null);
    tree.insert(1, tree.root, null);
    tree.insert(2, tree.root, null);
    tree.insert(6, tree.root, null);
    tree.insert(5, tree.root, null);
    tree.insert(0, tree.root, null);
    tree.insert(3, tree.root, null);

    System.out.println("root: " + tree.root.getData());
    System.out.println("leftmost: " + tree.root.getLeftmost().getData());
    System.out.println("successor of 3: " + tree.successor(3, tree.root).getData());

    tree.delete(2, tree.root);
    System.out.println(tree.root.getLeft().getRight().getData());

    /*
    System.out.println("leftmost: " + tree.getLeftmostData(tree.root));
    System.out.println("rightmost: " + tree.getRightmostData(tree.root));
    tree.removeLeftmost(tree.root);
    System.out.println("leftmost: " + tree.getLeftmostData(tree.root));
    tree.removeRightmost(tree.root);
    System.out.println("rightmost: " + tree.getRightmostData(tree.root));
    */

  }
}
