public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList(){
        head = null;
    }

    public void add(int value){
        System.out.println("Adding "+value+" to Linked List.");
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null){
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove(){
        System.out.println("Removing node from the end.");
        if(head != null){
            Node runner = this.head;
            while(runner.next.next != null){
                runner = runner.next;
            }
            runner.next = null;
        } else {
            System.out.println("Head does not exist. Nothing to remove.");
        }
    }
    public void printValues(){
        System.out.println("Printing Values...");
        if(head != null){
            Node runner = this.head;
            while(runner.next != null){
                System.out.println(runner.value);
                runner = runner.next;
            }
            System.out.println(runner.value);
        } else {
            System.out.println("Uh Oh! List has no nodes!");
        }
    }
}