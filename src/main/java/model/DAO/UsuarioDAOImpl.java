package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.connection.Conexion;
import model.dto.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void create(Usuario u) {
		try {

			Connection c = Conexion.getCon();

			Statement s = c.createStatement();

			String query = "insert into usuarios (correo,nick,nombre,password,peso) values('" + u.getCorreo() + "','"
					+ u.getNick() + "','" + u.getNombre() + "','" + u.getPassword() + "'," + u.getPeso() + ")";
			s.execute(query);
		} catch (SQLException e) {

			System.out.println("ERROR en el metodo create");
			e.printStackTrace();
		}

	}

	@Override
	public List<Usuario> read() {

		List<Usuario> usuarios = new ArrayList<>();

		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select correo,nick,nombre,password,peso from usuarios";
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {

				Usuario u = new Usuario();
				u.setCorreo(rs.getString("correo"));
				u.setNick(rs.getString("nick"));
				u.setNombre(rs.getString("nombre"));
				u.setPassword(rs.getString("password"));
				u.setPeso(rs.getInt("peso"));

				usuarios.add(u);
			}
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo List read");
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario read(int id) {

		Usuario u = new Usuario();

		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select correo, nick, nombre, password, peso from usuarios where id=" + id;
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				u.setCorreo(rs.getString("correo"));
				u.setNick(rs.getString("nick"));
				u.setNombre(rs.getString("nombre"));
				u.setPassword(rs.getString("password"));
				u.setPeso(rs.getInt("peso"));

				return u;
			}
		} catch (SQLException e) {
			System.out.print("ERROR en el metodo id read");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void update(Usuario u) {

		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "update corre, nick, nombre, password, peso values('" + u.getCorreo() + "','" + u.getNick()
					+ "','" + u.getNombre() + "','" + u.getPassword() + "'," + u.getPeso() + ") from usuarios where id="
					+ u.getId();
			s.execute(query);
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo update");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			Connection c= Conexion.getCon();
			Statement s = c.createStatement();
			String query = "delete correo, nick, nombre, password, peso from usuarios where id="+id;
			s.execute(query);
		}catch(SQLException e) {
			System.out.println("ERROR en metodo delete");
			e.printStackTrace();
		}

	}

}
