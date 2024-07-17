package model.dto;

public class Usuario {
	
	private int id;
	private String correo;
	private String nick;
	private String nombre;
	private String password;
	private int peso;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String correo, String nick, String nombre, String password, int peso) {
		super();
		this.id = id;
		this.correo = correo;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
	}
	
	public Usuario( String correo, String nick, String nombre, String password, int peso) {
		super();
		this.correo = correo;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
	}
	
	public Usuario( String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correo=" + correo + ", nick=" + nick + ", nombre=" + nombre + ", password="
				+ password + ", peso=" + peso + "]";
	}
	
	
	
	

}
