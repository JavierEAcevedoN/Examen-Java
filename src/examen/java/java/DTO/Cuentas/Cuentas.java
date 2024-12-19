package examen.java.java.DTO.Cuentas;

import java.sql.Timestamp;

public class Cuentas {
    private int idCuenta;
    private int idCliente;
    private String tipo;
    private double saldo;
    private double limiteSaldo;
    private Timestamp fechaApertura;
    private String estado;
    
    public Cuentas(int idCuenta, int idCliente, String tipo, double saldo, double limiteSaldo, Timestamp fechaApertura,
            String estado) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.tipo = tipo;
        this.saldo = saldo;
        this.limiteSaldo = limiteSaldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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
        return "ID Cuenta: " + idCuenta + "\n ID Cliente" + idCliente + "\n Tipo: " + tipo + "\n Saldo: " + saldo + "\n Saldo limite: " + limiteSaldo + "\n Fecha creacion: " + fechaApertura + "\n Estado: " + estado;
    }
}