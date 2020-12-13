public class singlyLinkedList {

    private class Node{
        private int item;
        private Node next;

        private Node(int element){
            this.item = element;
            this.next=null;
        }
    }

    Node first;    //reference to first node

    public void add(int item){
        Node newNode = new Node(item);

        if(first==null){
            first = newNode;
        }
        else{
            newNode.next = first;
            first= newNode;
        }
    }

    public void reverse(){
        if(first==null || first.next==null)
            return;
        
        Node current = first;
        Node previous = first;
        Node initial = first; 

        current=current.next;
        while(current != null){
            first=current;
            current=current.next;
            first.next = previous;
            previous = first;
        }
        initial.next = null;
    }

    public void traverse(){
        if(first==null)
            return;
        Node current=first;
        while(current!=null){
            System.out.print(" "+current.item+" ");
            current=current.next;
        }    
    }  

    public int findLength(){
        if(first==null)
            return -1;
            int count=0;
            Node current = first;
            while(current!= null){
                count++;
                current = current.next;
            }
            return count;
    }

    public void findMiddle(){
        if(first == null)
            return;
        int totalLength = this.findLength();
        int middleIndex = -1;
        if(totalLength %2 == 0)
            middleIndex = totalLength/2;
        else
            middleIndex = totalLength/2 +1;
        
        int index = 0;
        Node current = first;
        while(current != null){
            index++;
            if(index == middleIndex){
                System.out.println("Middle element is "+current.item);
                return;
            }
            current = current.next;
        }
                    
    }
}
