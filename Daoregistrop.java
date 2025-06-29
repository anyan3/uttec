package gestionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Daoregistrop extends conexionRPLA {

    public boolean registrar(Pojoregistrop s) {
        boolean prueba = false;
        String cadena = "INSERT INTO persona (nombre, apellidop, apellidom, matricula, correo, password)"
                      + " VALUES(?, ?, ?, ?, ?, ?)";
        try {
            // Obtener la conexión
            PreparedStatement proceso = super.getConexion().prepareStatement(cadena, PreparedStatement.RETURN_GENERATED_KEYS);
            
            // Establecer los valores de los parámetros
            proceso.setString(1, s.getUsr());
            proceso.setString(2, s.getApp());
            proceso.setString(3, s.getApm());
            proceso.setString(4, s.getMat());
            proceso.setString(5, s.getCor());
            proceso.setString(6, s.getContra());

            // Ejecutar la inserción
            int rowsAffected = proceso.executeUpdate();
            
            if (rowsAffected > 0) {
                // Si se insertó correctamente, obtener el ID generado automáticamente
                ResultSet rs = proceso.getGeneratedKeys();
                if (rs.next()) {
                    // Obtener el ID generado (suponiendo que es un campo de tipo SERIAL o AUTO_INCREMENT)
                    int generatedId = rs.getInt(1);
                    s.setId(generatedId);  // Asignar el ID generado al objeto
                    prueba = true;
                }
                rs.close();
            }
            
        } catch (SQLException error) {
            System.out.println("ERROR en Alta: " + error.getMessage());
            System.out.println("ERROR en Alta: " + error.toString());
        }
        return prueba;
    }
    
    public Pojoregistrop verificar(String matricula, String contra){
        Pojoregistrop ingreso= null;
        String sql="select * from persona where matricula= '"+ matricula +"' and password='"+ contra +"'";
        try{
          PreparedStatement proceso=super.getConexion().prepareStatement(sql);
          ResultSet resultado=proceso.executeQuery();
          
          if(resultado.next()){
              System.out.println("Registro encontrado");
          ingreso=new Pojoregistrop(resultado.getInt(1),resultado.getString(2), 
          resultado.getString(3), resultado.getString(4), resultado.getString(5), 
           resultado.getString(6), resultado.getString(7));
          
          }else{
              System.out.println("ERROR no se encontraron datos");
          }
        }catch(Exception SQLError){
            System.out.println(SQLError.toString());
            System.out.println(SQLError.getMessage());
        }
        return ingreso;
    }
    
    //Actualizar los datos
   public boolean cambiar(Pojoregistrop objS){
        boolean cambio=false;
        String sql="UPDATE persona SET id_persona=?, nombre=?, apellidop=?, apellidom=? ,correo=?,password=? "
                + "WHERE matricula=? ";
        try{
            PreparedStatement proceso=super.getConexion().prepareStatement(sql);
            proceso.setInt(1, objS.getId());
            proceso.setString(2, objS.getUsr());
            proceso.setString(3, objS.getApp());
            proceso.setString(4, objS.getApm());
            proceso.setString(5, objS.getCor());
            proceso.setString(6, objS.getContra());
            proceso.setString(7, objS.getMat());
            
            
            proceso.executeUpdate();
            cambio=true;
        }catch(SQLException ex){
            System.out.println("ERROR EN ACTUALIZAR...");
            System.out.println("Inf 1 " + ex.getMessage());
            System.out.println("Inf 1 " + ex.toString());
        }
        return cambio;
    }

}
