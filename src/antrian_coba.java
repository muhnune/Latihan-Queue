//Ini code latihan dari dosen

class Node {
    int data;
    String Nama;
    Node next, prev;

    public Node(String Nama, int data) {
        this.data = data;
        this.Nama = Nama;
    }
}

public class antrian_coba {
    Node head;
    Node tail;
    int size = 0;

    public void Enqueue(String Nama, int data) {
        Node baru = new Node(Nama, data);

        if (head == null) {
            head = baru;
            tail = baru;
            size++;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
            size++;
        }
    }

    public void Print() {
        Node bantu = head;

        while (bantu != null) {
            System.out.println(bantu.Nama + " " + bantu.data);
            bantu = bantu.next;
        }
        System.out.println();
    }

    public Node Dequeue() {
        Node temp = head;
        if (temp != null) {
            head = head.next;
            temp.next = null;
        }
        size--;
        return temp;
    }

    public int Min() {
        int min;
        Node current = head;

        if (size == 0) {
            return 0;
        } else {
            min = current.data;
            current = current.next;
            while (current != null) {
                if (current.data < min) {
                    min = current.data;
                }
                current = current.next;
            }
            return min;
        }
    }

    public static int Urut(antrian_coba list1, antrian_coba List3, antrian_coba list2) {
        Node current = list1.head;
        Node temp;
        if (list1.size == 0) {
            return 0;
        } else {
            int min = list1.Min();
            while (current != null) {
                temp = list1.Dequeue();
                if (current.data == min) {
                    list2.Enqueue(temp.Nama, temp.data);
                } else {
                    List3.Enqueue(temp.Nama, temp.data);
                }
                current = list1.head;
            }
        }
        return Urut(List3, list1, list2);
    }

    public static void main(String[] args) {
        int min;
        antrian_coba list1 = new antrian_coba();
        antrian_coba list2 = new antrian_coba();
        antrian_coba list3 = new antrian_coba();

        System.out.println("Queue satu: ");

        list1.Enqueue("Jason", 1);
        list1.Enqueue("Meg", 4);
        list1.Enqueue("Piper", 10);
        list1.Enqueue("Thalia", 1);

        list1.Print();
        list1.Dequeue();
        System.out.println();

        System.out.println("Queue Dua: ");
        list2.Enqueue("Jason", 1);

        list2.Print();
        System.out.println();

        System.out.println("Beberapa orang yang terlambat datang ke Queue 1: ");
        list1.Enqueue("Percy", 3);
        list1.Enqueue("Will", 7);
        list1.Enqueue("Connor", 12);
        list1.Enqueue("Travis", 12);
        list1.Enqueue("Nico", 13);
        list1.Print();

        System.out.println("Urutan data yang sudah urut di Queue 2: ");
        Urut(list1, list3, list2);
        list2.Print();
    }
}