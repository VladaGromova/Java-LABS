package Lab_4;

public class Main {
    public static void main(String[] args) {
        BinarySortingTree<Integer> tree = new BinarySortingTree<Integer>();
        tree.add(15);
        tree.add(30);
        tree.add(10);
        tree.add(20);
        tree.add(35);
        tree.add(12);
        tree.add(7);
        tree.delete(8);
        tree.delete(30);
        tree.delete(15);
        System.out.println(tree.find(15));
        tree.LeftRootRight();
        tree.RootLeftRight();
        tree.LeftRightRoot();
        BinarySortingTree<User> users = new BinarySortingTree<User>();
        User u1 = new User("N1", "M1", 1.32);
        User u2 = new User("N2", "M2", 2.33);
        User u3 = new User("N3", "M3", 3.02);
        User u4 = new User("N4", "M4", 4.32);
        User u5 = new User("N5", "M5", 5.162);
        User u6 = new User("N6", "M6", 6.0001);
        users.add(u3);
        users.add(u5);
        users.add(u6);
        users.add(u4);
        users.add(u2);
        users.add(u1);
        users.LeftRootRight();
    }
}
