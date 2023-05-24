
package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosModel {
Connection MyConexion;
ResultSet result;


public ResultSet ListarDatos()
{
    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from empleados");  
       return result;
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
        return result;
    }
}


public void Actualizar(int codigo, String apellido, String nombre, String telefono)
{
        try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Update empleados set apellido ="+"'"+apellido+"',nombre="+"'"+nombre+"',telefono="+"'"+telefono+"' where codigo="+"'"+codigo+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Actualizar..."+ex.getMessage());
        }
          
}

public void Guardar(int codigo, String apellido, String nombre, String telefono)
{
     try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Insert into empleados values ("+"'"+codigo+"',"+"'"+apellido+"',"+"'"+nombre+"'"+"'"+telefono+"')");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }
}
}
