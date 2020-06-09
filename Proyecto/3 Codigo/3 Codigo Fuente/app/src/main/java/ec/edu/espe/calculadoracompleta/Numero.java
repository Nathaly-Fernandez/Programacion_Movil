package ec.edu.espe.calculadoracompleta;

public class Numero {
    private float num;

    public Numero(float num) {
        this.num = num;
    }
    public Numero() {
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "numero{" +
                "num=" + num +
                '}';
    }
}
