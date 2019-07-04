
public class test {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BinarySortTree tree=new BinarySortTree();
    int[] array= {10,2,6,9,5,4,3};
    for(int count=0;count<7;count++) {
      Node node=new Node(array[count]);
      tree.insert(node);
    }
    System.out.println(tree.printTree());
    System.out.println(tree.search(6).getLeftChild().getValue());
    tree.delete(5);
    System.out.println(tree.printTree());
  }
  
}
