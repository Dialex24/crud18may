
package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosModel {
Connection MyConexion;
ResultSet result;


public DefaultTableModel ListarDatos()
{
    //realizar la conexion
    
    //limpiar la tabla vista empleados
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
    //prepara ek modelo de la tabla
    
    TablaModelo.addColumn("codigo");
    TablaModelo.addColumn("apellido");
    TablaModelo.addColumn("nombre");
    TablaModelo.addColumn("telefono");
    
    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from empleados");  
       //return result;
       
       while(result.next())
       {
           TablaModelo.addRow(new Object[]{result.getInt("codigo"), result.getString("apellido"), result.getString("nombre"), result.getString("telefono")});
       }
       return TablaModelo;
    }
    
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
        return TablaModelo;
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
        sentencia.executeQuery("Insert into empleados values ("+"'"+codigo+"',"+"'"+apellido+"',"+"'"+nombre+"',"+"'"+telefono+"')");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }
         
     
    }

    public void Eliminar(int codEliminar) throws SQLException
     {
         try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Delete from empleados where codigo="+"'"+codEliminar+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Eliminar..."+ex.getMessage());
        }
     }
}
