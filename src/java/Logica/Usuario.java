package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    //Atributos
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    int idUsuario;
    @Basic
    String nombreUser;
    String password;
    
    //Constructores
    public Usuario() {
    }
    
    public Usuario(String nombreUser, String password) {
        this.nombreUser = nombreUser;
        this.password = password;
    }
    
    public Usuario(int idUsuario, String nombreUser, String password) {
        this.idUsuario = idUsuario;
        this.nombreUser = nombreUser;
        this.password = password;
    }
    
    //Getter and setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
