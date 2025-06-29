package gestionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Daoconvocatoria extends conexionRPLA{
    public boolean registrar(Pojoconvocatoria s){
        boolean prueba=false;
        String cadena="INSERT INTO registro (visa,pasaporte,certificado_ingles,nivel_ingles,cuatrimestre,promedio)"
                + "VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement proceso=super.getConexion().prepareStatement(cadena);
            proceso.setString(1, s.getVisas());
            proceso.setString(2,s.getPasaportes());
            proceso.setString(3,s.getCert());
            proceso.setString(4, s.getNil());
            proceso.setString(5,s.getCuatri());
            proceso.setDouble(6,s.getProm1());
            proceso.executeUpdate();
            prueba=true;    
        }catch(SQLException error){
            System.out.println("ERROR en Alta: "+error.getMessage());
            System.out.println("ERROR en Alta: "+error.toString());
        }
        return prueba;
    }
    //Mostrar los registros
     public ArrayList<Pojoconvocatoria> mostrar() {
    String sql="Select * From registro";
    ArrayList<Pojoconvocatoria> datos= new ArrayList();
    
    try{
    PreparedStatement proceso = super.getConexion().prepareStatement(sql);
    ResultSet registros =proceso.executeQuery();
    
    while(registros.next()){
    Pojoconvocatoria reg=new Pojoconvocatoria(registros.getInt(1),registros.getString(2), 
            registros.getString(3), registros.getString(4), registros.getString(5),
            registros.getString(6), registros.getDouble(7));
            datos.add(reg);
    }
    }catch(SQLException ex){
      System.out.println("ERROR EN MOSTRAR...");
            System.out.println("Inf 1 " + ex.getMessage());
            System.out.println("Inf 1 " + ex.toString());  
    }
    return datos;
    }
     //Eliminar registros
     public boolean eliminar(int id){
       
       boolean baja=false;
       String sql="Delete from registro where id_registro=? ";
       try{
           PreparedStatement proceso= super.getConexion().prepareStatement(sql);
           proceso.setInt(1, id);
           proceso.execute();
           baja=true;
           
       }catch(SQLException ex){
      System.out.println("ERROR AL ELIMINAR...");
            System.out.println("Inf 1 " + ex.getMessage());
            System.out.println("Inf 1 " + ex.toString());  
        }
       return baja;
   }
}

        

