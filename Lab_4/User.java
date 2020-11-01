package Lab_4;

class User implements Comparable<User>{
    private String name;
    private String surname;
    private double id;
    public User(String n, String s, double val){
        name = n;
        surname = s;
        id = val;
    }
    public int compareTo(User u) {
        return Double.compare(id, u.id);
    }
}
