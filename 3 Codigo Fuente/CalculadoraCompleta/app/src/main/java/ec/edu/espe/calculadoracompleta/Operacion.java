package ec.edu.espe.calculadoracompleta;

public class Operacion {
    private String operacion;

    public Operacion(String operacion) {
        this.operacion = operacion;
    }
    public Operacion() {
    }
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        return "operacion{" +
                "operacion='" + operacion + '\'' +
                '}';
    }
}
