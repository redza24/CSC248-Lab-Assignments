public class Land {
    private String id;
    private String ownerName;
    private char type;
    public double area;

    public Land(){
        this.id = "";
        this.ownerName = "";
        this.type = ' ';
        this.area = 0;
    }

    public Land(String id, String ownerName, char type, double area){
        this.id = id;
        this.ownerName = ownerName;
        this.type = type;
        this.area = area;
    }

    public String getId(){
        return this.id;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public char getType(){
        return this.type;
    }

    public double getArea(){
        return this.area;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public void setType(char type){
        this.type = type;
    }

    public void setArea(double area){
        this.area = area;
    }

    public String toString(){
        return ("ID: " + id + "\nName: " + ownerName + "\nType: " + type + "\nArea: " + area);
    }

    public double calcTax(){
        double taxRate = 0;

        switch (type) {
            case 't':
            case 'T':
                taxRate = 10;
                break;
            case 's':
            case 'S':
                taxRate = 15;
                break;
            case 'b':
            case 'B':
                taxRate = 20;
                break;
            case 'c':
            case 'C':
                taxRate = 30;
                break;
            default:
                System.out.println("Invalid type");
                break;
        }

        return (area * taxRate);
    }

}