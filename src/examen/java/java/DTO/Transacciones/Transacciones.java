package examen.java.java.DTO.Transacciones;

import java.sql.Timestamp;

public class Transacciones {
    private int idTransaccion;
    private int idCuenta;
    private String tipo;
    private double monto;
    private Timestamp fechaRegistro;
    private String referencia;
    private double saldoAnterior;
    private double saldoNuevo;
    private String estado;
    
    public Transacciones(int idTransaccion, int idCuenta, String tipo, double monto, Timestamp fechaRegistro, String referencia,
            double saldoAnterior, double saldoNuevo, String estado) {
        this.idTransaccion = idTransaccion;
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.fechaRegistro = fechaRegistro;
        this.referencia = referencia;
        this.saldoAnterior = saldoAnterior;
        this.saldoNuevo = saldoNuevo;
        this.estado = estado;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getSaldoNuevo() {
        return saldoNuevo;
    }

    public void setSaldoNuevo(double saldoNuevo) {
        this.saldoNuevo = saldoNuevo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID Transaccion: " + idTransaccion + ", ID Cuenta: " + idCuenta + ", Tipo: " + tipo + ", monto: " + monto + ", Fecha de Registro: " + fechaRegistro + ", Referencia: " + referencia + ", Saldo Anterior: " + saldoAnterior + ", Saldo nuevo: " + saldoNuevo + ", Estado: " + estado;
    }
}