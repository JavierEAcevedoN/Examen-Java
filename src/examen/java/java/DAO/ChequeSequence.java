package examen.java.java.DAO;

public class ChequeSequence {
    private int nextVal;

    public ChequeSequence(int nextVal) {
        this.nextVal = nextVal;
    }

    public int getNext_val() {
        return nextVal;
    }

    @Override
    public String toString() {
        return "Valor Siguiente: " + nextVal;
    }
}