import java.util.Scanner;

class DoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    // Adiciona um novo nó ao final da lista
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Lista todos os elementos da lista
    public void list() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Remove um nó com um valor específico
    public boolean remove(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                }

                return true;
            }
            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos valores deseja inserir?");
        int N = scanner.nextInt();

        System.out.println("Insira os valores:");
        for (int i = 0; i < N; i++) {
            int value = scanner.nextInt();
            list.add(value);
        }

        System.out.println("Elementos na lista:");
        list.list();

        System.out.println("Qual valor deseja remover?");
        int valueToRemove = scanner.nextInt();

        if (list.remove(valueToRemove)) {
            System.out.println("Elemento removido com sucesso.");
        } else {
            System.out.println("Elemento não encontrado.");
        }

        System.out.println("Elementos restantes na lista:");
        list.list();

        scanner.close();
    }
}
