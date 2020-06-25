package ec.edu.espe.calculadoracompleta;

public class Numero {

    private double num;

    public Numero(float num) {
        this.num = num;
    }
    public Numero() {
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "numero{" +
                "num=" + num +
                '}';
    }
}
