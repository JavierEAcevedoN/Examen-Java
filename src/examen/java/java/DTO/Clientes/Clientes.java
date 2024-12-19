package examen.java.java.DTO.Clientes;

import java.sql.Timestamp;

public class Clientes {
    private int idCliente;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private String estado;
    private Timestamp fechaRegistro;
    private Timestamp ultimaActividad;
    
    public Clientes(int idCliente, String identificacion, String nombre, String apellido, String direccion, String telefono,
            String correo, String estado, Timestamp fechaRegistro, Timestamp ultimaActividad) {
        this.idCliente = idCliente;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.ultimaActividad = ultimaActividad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Timestamp getUltimaActividad() {
        return ultimaActividad;
    }

    public void setUltimaActividad(Timestamp ultimaActividad) {
        this.ultimaActividad = ultimaActividad;
    }

    @Override
    public String toString() {
        return "ID Cliente : " + idCliente + "\n Identificacion: " + identificacion + "\n Nombre: " + nombre + "\n Apellido: " + apellido + "\n Direccion: " + direccion + "\n Telefono: " + telefono + "\n Correo: " + correo + "\n Estado: " + estado + "\n Fecha de registro: " + fechaRegistro + "\n Ultima actividad: " + ultimaActividad;
    }
}