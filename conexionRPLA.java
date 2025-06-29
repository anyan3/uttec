package gestionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionRPLA {
    private Connection conexion;

    public conexionRPLA() {
        String dirDB = "jdbc:postgresql://localhost:5432/uttecinterchange";
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(dirDB, "postgres", "root");
            System.out.println("Conexion exitosa con base de datos uttec ...");
        }catch(Exception mal){
            System.out.println("ERROR"+mal.getMessage());
            System.out.println("ERROR"+mal.toString());
        }
            
    }

    public Connection getConexion() {
        return conexion;
    }
    
}
