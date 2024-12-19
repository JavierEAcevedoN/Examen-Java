package examen.java.java.DTO.Cheques;

import java.sql.Date;
import java.sql.Timestamp;

public class Cheques {
    private int idCheque;
    private String numeroCheque;
    private int idCuenta;
    private String beneficiario;
    private double monto;
    private String montoLetras;
    private String prioridad;
    private String firmaDigital;
    private String estado;
    private String razonRechazo;
    private Date fechaEmision;
    private Timestamp fechaProceso;
    private boolean cobrado;
    private double cuentaSaldomomento;
    private Timestamp fechaModificacion;
    private String usuarioModificacion;

    public Cheques(int idCheque, String numeroCheque, int idCuenta, String beneficiario, double monto,
            String montoLetras, String prioridad, String firmaDigital, String estado, String razonRechazo,
            Date fechaEmision, Timestamp fechaProceso, boolean cobrado, double cuentaSaldomomento,
            Timestamp fechaModificacion, String usuarioModificacion) {
        this.idCheque = idCheque;
        this.numeroCheque = numeroCheque;
        this.idCuenta = idCuenta;
        this.beneficiario = beneficiario;
        this.monto = monto;
        this.montoLetras = montoLetras;
        this.prioridad = prioridad;
        this.firmaDigital = firmaDigital;
        this.estado = estado;
        this.razonRechazo = razonRechazo;
        this.fechaEmision = fechaEmision;
        this.fechaProceso = fechaProceso;
        this.cobrado = cobrado;
        this.cuentaSaldomomento = cuentaSaldomomento;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    public int getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(int idCheque) {
        this.idCheque = idCheque;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMontoLetras() {
        return montoLetras;
    }

    public void setMontoLetras(String montoLetras) {
        this.montoLetras = montoLetras;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(String firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRazonRechazo() {
        return razonRechazo;
    }

    public void setRazonRechazo(String razonRechazo) {
        this.razonRechazo = razonRechazo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Timestamp getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Timestamp fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public double getCuentaSaldomomento() {
        return cuentaSaldomomento;
    }

    public void setCuentaSaldomomento(double cuentaSaldomomento) {
        this.cuentaSaldomomento = cuentaSaldomomento;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    @Override
    public String toString() {
        return "ID Cheque: " + idCheque + "\n Numero Cheque: " + numeroCheque + "ID Cuenta: " + idCuenta + "\n Beneficiario: " + "\n Monto: " + monto + "\n Monto en Letras: " + montoLetras + "\n Prioridad: " + prioridad + "\n Firma Digital: " + "\n Estado: " + estado + "\n Razon de Rechazo: " + razonRechazo + "\n Fecha de Emizion: " + fechaEmision + "\n Fecha de Proceso: " + fechaProceso + "\n Cobrado: " + cobrado + "\n Saldo de la cuenta en el momento: " + cuentaSaldomomento + "\n Fecah de Modificacion: " + fechaModificacion + "\n Usuario Modificaion: " + usuarioModificacion;
    }
}