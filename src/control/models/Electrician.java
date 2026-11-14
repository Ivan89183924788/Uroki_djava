package control.models;

public class Electric implements Mechanic{
    private String name;
    private int opit;
    private int razryad;

    @Override
    public String toString() {
        return "Electic{" +
                "name='" + name + '\'' +
                ", opit=" + opit +
                ", razryad=" + razryad +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getOpit() {
        return opit;
    }

    public int getRazryad() {
        return razryad;
    }

    public Electric(String name, int opit, int razryad) {
        this.name = name;
        this.opit = opit;
        this.razryad = razryad;
    }
    @Override
    public void mechanic(){
        System.out.println("Моторист делает двигатель, имя "+getName());
    }
}