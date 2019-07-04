
public class Node{
  int value;
  Node lchild;
  Node rchild;
  public Node(int value) {
   this.value=value;
  }
  public int getValue() {
    return this.value;
  }
  public void setlchild(Node child) {
    this.lchild=child;
  }
  public void setrchild(Node child) {
    this.rchild=child;
  }
  public Node getLeftChild() {
    return this.lchild;
  }
  public Node getRightChild() {
    return this.rchild;
  }
}
