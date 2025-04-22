package dao;

import bancoDados.DataCon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Produto;


public class ProdutoDAO {
	
	private static final String INSERT_PRODUTO_SQL = "INSERT INTO prosutos (nome, descricao, marca, valorUnitario, status) VALUES (?, ?, ?, ?, ?);";

	private static final String SELECT_PRODUTO_BY_ID = "SELECT * FROM produtos WHERE id = ?;";

	private static final String SELECT_ALL_PRODUTO = "SELECT * FROM produtos;";

	private static final String DELETE_PRODUTO_SQL = "DELETE FROM produtos WHERE id = ?;";

	private static final String UPDATE_PRODUTO_SQL = "UPDATE produtos SET nome = ?, descricao = ?, marca = ?, valorUnitario = ?, status = ? WHERE id = ?;";
	
	public void insertProduto(Produto produto) {
		try (Connection connection = DataCon.getConnection();	
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUTO_SQL)) {

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
			preparedStatement.setString(3, produto.getMarca());
			preparedStatement.setDouble(4, produto.getValorUnitario());
			preparedStatement.setBoolean(5, produto.isStatus());

			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Produto selectProduto(int id) {
		Produto produto = null;

		try (Connection connection = DataCon.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUTO_BY_ID)) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setMarca(rs.getString("marca"));
				produto.setValorUnitario(rs.getDouble("valorUnitario"));
				produto.setStatus(rs.getBoolean("status"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return produto;
	}

	public List<Produto> selectAllProduto() {
		List<Produto> produtos = new ArrayList<>();
		try (Connection connection = DataCon.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUTO);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setMarca(rs.getString("marca"));
				produto.setValorUnitario(rs.getDouble("valorUnitario"));
				produto.setStatus(rs.getBoolean("status"));
				produtos.add(produto);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	public boolean deleteProduto(int id) {
		boolean rowDeleted = false;
		try (Connection connection = DataCon.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUTO_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public boolean updateProduto(Produto produto) {
		boolean rowUpdated = false;
		try (Connection connection = DataCon.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUTO_SQL)) {
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setString(3, produto.getMarca());
			statement.setDouble(4, produto.getValorUnitario());
			statement.setBoolean(5, produto.isStatus());
			statement.setLong(6, produto.getId());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

}
