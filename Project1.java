class Project1 {
  public static void main(String args[]) {
    BST tree = new BST();
    tree.insert(4, tree.root);
    tree.insert(1, tree.root);
    tree.insert(6, tree.root);
    tree.insert(5, tree.root);
    tree.insert(0, tree.root);

    System.out.println("root: " + tree.root.getData());
    System.out.println("leftmost: " + tree.root.getLeftmostData());
    tree.root.removeLeftmost();
    System.out.println("leftmost: " + tree.root.getLeftmostData());
    System.out.println("rightmost: " + tree.root.getRightmostData());
    tree.root.removeRightmost();
    System.out.println("rightmost: " + tree.root.getRightmostData());

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
