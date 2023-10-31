public class Friend {
    private int idno;
    private String name, hpno, email;

    public Friend(int id, String n, String hp, String em) {
        this.idno = id;
        this.name = n;
        this.hpno = hp;
        this.email = em;
    }

    public int getId() {
        return this.idno;
    }

    public String getName() {
        return this.name;
    }

    public String getHP() {
        return this.hpno;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setHP(String hp) {
        this.hpno = hp;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String toString() {
        return "ID: " + this.idno + "\nName: " + this.name + "\nHP: " + this.hpno + "\nEmail: " + this.email;
    }
    
}