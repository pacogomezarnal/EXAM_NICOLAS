import Model.ConexionDB;
import vistas.VentanaPrincipal;


public class Main {

	public static void main(String[] args) {
		
		boolean conectado = ConexionDB.getInstance().connectDB();//Realizamos la conexion
		if (conectado) {
			VentanaPrincipal.getInstance();//Iniciamos la aplicacion
		}
		else {
			System.out.println("ERROR AL CONECTAR A LA BDs");
		}
	}

}
