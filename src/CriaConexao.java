import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CriaConexao {
	
	public DataSource dataSource;
	
	public CriaConexao() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("gabriel");
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
		
		return this.dataSource.getConnection();
	}

}
