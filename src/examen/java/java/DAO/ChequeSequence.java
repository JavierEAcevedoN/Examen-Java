package examen.java.java.DAO;

public class ChequeSequence {
    private int next_val;

    public ChequeSequence(int next_val) {
        this.next_val = next_val;
    }

    public int getNext_val() {
        return next_val;
    }

    @Override
    public String toString() {
        return "Valor Siguiente: " + next_val;
    }
}