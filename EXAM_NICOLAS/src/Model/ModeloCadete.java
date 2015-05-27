package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ModeloCadete {
	// Nombre de los campos de la tabla cadetes de la BD
	private final String ID = "id";
	private final String NOM = "nombre";
	private final String APELL = "apellidos";
	private final String EDAD = "edad";
	private final String NAC = "nacionalidad";
	private final String EQ = "equipo";
	
	private Connection conexion;
	private ResultSet resultado;
	private Statement statement;
	
	public ModeloCadete() {
		//Iniciamos la conexion
		conexion = ConexionDB.getConexion();
	}
	
	public Cadete consultaCadete(int idCadete) {
		Cadete c = new Cadete();//Cadete a devolver
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select * from cadetes where id = "+idCadete+";");// realizamos la consulta
			while (resultado.next()) {
				c.setId(resultado.getInt(ID));// set id a c
				c.setNombre(resultado.getString(NOM));// set nombre a c
				c.setApellidos(resultado.getString(APELL));// set apellidos a c
				c.setEdad(resultado.getInt(EDAD));// set edad a c
				c.setNacionalidad(resultado.getString(NAC));// set nacionalidad a c
				c.setEquipo(resultado.getInt(EQ));// set set equipo a c
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();//cerramos statement
				resultado.close();// cerramos resultset
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;//devolvemos cadete
	}
	
	public ArrayList<Cadete> consutaCadetesEquipo(int idEquipo) { 
		ArrayList<Cadete> cadetes = new ArrayList<Cadete>();// arraylist de cadetes a devolver
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select * from cadetes where equipo = "+idEquipo+";");
			while (resultado.next()) {
				// Sacamos los datos de cada fila
				int id = resultado.getInt(ID);
				String nom = resultado.getString(NOM);
				String apell = resultado.getString(APELL);
				int edad = resultado.getInt(EDAD);
				String nac = resultado.getString(NAC);
				int eq = resultado.getInt(EQ);
				// asignamos los dato a un nuevo cadete
				Cadete c = new Cadete(id, nom, apell, edad, nac, eq);
				// añadimos cadete al aRraylist
				cadetes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();//cerramos statement
				resultado.close();// cerramos resultset
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cadetes;// devolvemos el arraylist de cadetes
	}

}
