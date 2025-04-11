package dao;

import bancoDados.DataCon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO usuarios (nome, email, senha, telefone, status) VALUES (?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "SELECT * FROM usuarios WHERE id = ?;";

	private static final String SELECT_ALL_USERS = "SELECT * FROM usuarios;";

	private static final String DELETE_USER_SQL = "DELETE FROM usuarios WHERE id = ?;";

	private static final String UPDATE_USER_SQL = "UPDATE usuarios SET nome = ?, email = ?, senha = ?, telefone = ?, status = ? WHERE id = ?;";

	public void insertUsuario(Usuario usuario) {
		try (Connection connection = DataCon.getConnection();	
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setString(4, usuario.getTelefone());
			preparedStatement.setBoolean(5, usuario.isStatus());

			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Usuario selectUsuario(int id) {
		Usuario usuario = null;

		try (Connection connection = DataCon.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setStatus(rs.getBoolean("status"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public List<Usuario> selectAllUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		try (Connection connection = DataCon.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setStatus(rs.getBoolean("status"));
				usuarios.add(usuario);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public boolean deleteUsuario(int id) {
		boolean rowDeleted = false;
		try (Connection connection = DataCon.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public boolean updateUsuario(Usuario usuario) {
		boolean rowUpdated = false;
		try (Connection connection = DataCon.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getSenha());
			statement.setString(4, usuario.getTelefone());
			statement.setBoolean(5, usuario.isStatus());
			statement.setLong(6, usuario.getId());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
}
