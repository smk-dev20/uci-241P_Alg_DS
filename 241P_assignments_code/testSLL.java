public class testSLL {
    public static void main(String[] args) {
        singlyLinkedList list = new singlyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        //list.add(60);
        System.out.println("Initial List");
        list.traverse();
        list.reverse();
        System.out.println();
        System.out.println("Reversed List");
        list.traverse();
        System.out.println();
        list.findMiddle();
    }
}
