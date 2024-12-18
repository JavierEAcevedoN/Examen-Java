package examen.java.java.DTO.Cuentas;

import java.sql.Timestamp;

public class Cuentas {
    private int id;
    private int idCliente;
    private String tipo;
    private double saldo;
    private double limiteSaldo;
    private Timestamp fechaApertura;
    private String estado;
    
    public Cuentas(int id, int idCliente, String tipo, double saldo, double limiteSaldo, Timestamp fechaApertura,
            String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.tipo = tipo;
        this.saldo = saldo;
        this.limiteSaldo = limiteSaldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteSaldo() {
        return limiteSaldo;
    }

    public void setLimiteSaldo(double limiteSaldo) {
        this.limiteSaldo = limiteSaldo;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID cuenta: " + id + ", ID Cliente" + idCliente + ", Tipo: " + tipo + ", Saldo: " + saldo + ", Saldo limite: " + limiteSaldo + ", Fecha creacion: " + fechaApertura + ", Estado: " + estado;
    }
}