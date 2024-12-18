package examen.java.java.DTO.Clientes;

import java.sql.Timestamp;

public class Clientes {
    private int id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private String estado;
    private Timestamp fechaRegistro;
    private Timestamp ultimaActividad;
    
    public Clientes(int id, String identificacion, String nombre, String apellido, String direccion, String telefono,
            String correo, String estado, Timestamp fechaRegistro, Timestamp ultimaActividad) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "ID Cliente : " + id + ", Identificacion: " + identificacion + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Direccion: " + direccion + ", Telefono: " + telefono + ", Correo: " + correo + ", Estado: " + estado + ", Fecha de registro: " + fechaRegistro + ", Ultima actividad: " + ultimaActividad;
    }
}