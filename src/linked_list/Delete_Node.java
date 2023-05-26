package linked_list;

public class Delete_Node {
    int val;
    Delete_Node next;
    public void deleteNode(Delete_Node node) {
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }


}
