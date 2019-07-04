import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.InitialContext;

import org.omg.CORBA.PUBLIC_MEMBER;

public class BinarySortTree {
  Node root = null;
  ArrayList<Node> list = new ArrayList<>();
  int hight = 0;
  Node mark_delete_node_father = null;
  int mark_lr=-1;
  /**
   * insert an element into tree
   * @param temp
   */
  public void insert(Node temp) {
    if (root != null) {
      nodeinsert(root, temp);
    } else {
      root = temp;
    }
    list.add(temp);
  }
  public void nodeinsert(Node r, Node c) {
    if (r.getValue() > c.getValue()) {
      //insert into left-sub-tree
      if (r.getLeftChild() != null) {
        nodeinsert(r.getLeftChild(), c);
      } else {
        r.setlchild(c);
      }
    } else {
      //insert into right-sub-tree
      if (r.getRightChild() != null) {
        nodeinsert(r.getRightChild(), c);
      } else {
        r.setrchild(c);
      }
    }
  }
  /**
   * delete the element whose value==temp
   * @param temp
   */
  public void delete(int temp) {
    Node  delete_one = search(temp);
    list.remove(delete_one);
    Node delete_one_rchild=delete_one.getRightChild();
    Node delete_one_lchild=delete_one.getLeftChild();
    if(mark_lr==0) {
    mark_delete_node_father.setlchild(delete_one_lchild);
    Node most_rchild=delete_one_lchild;
    while(most_rchild.getRightChild()!=null) {
      most_rchild=most_rchild.getRightChild();
    }
    most_rchild.setrchild(delete_one_rchild);
    }else if(mark_lr==1) {
      mark_delete_node_father.setrchild(delete_one_rchild);
      Node most_lchild=delete_one_rchild;
      while(most_lchild.getLeftChild()!=null) {
        most_lchild=most_lchild.getLeftChild();
      }
      most_lchild.setlchild(delete_one_lchild);
    }
  }
  /**
   * search the element whose value==temp
   * @param temp
   * @return
   */
  public Node search(int temp) {
    return nodesearch(root, temp);
  }
  public Node nodesearch(Node r, int temp) {
    if (r.getValue() == temp) {
      return r;
    } else if (r.getValue() > temp) {
      mark_delete_node_father = r;
      mark_lr=0;
      return nodesearch(r.lchild, temp);
    } else {
      mark_lr=1;
      mark_delete_node_father = r;
      return nodesearch(r.rchild, temp);
    }
  }
  public String printTree() {
    String mString = "";
    Iterator<Node> iterator = list.iterator();
    while (iterator.hasNext()) {
      Node node = iterator.next();
      mString += node.getValue() + "==";
      if (node.getLeftChild() != null) {
        mString += node.getLeftChild().value + "--";
      }
      if (node.getRightChild() != null) {
        mString += node.getRightChild().value;
      }
      mString += "\n";
    }
    return mString;
  }
}
