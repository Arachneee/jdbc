package hello.jdbc.exception.basic;

import java.net.ConnectException;
import java.sql.SQLException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckedAppTest {

	static class Controller {

		@Test
		void checked() {
			Controller controller = new Controller();
			Assertions.assertThatThrownBy(() -> controller.request()).isInstanceOf(Exception.class);
		}
		Service service = new Service();

		public void request() throws SQLException, ConnectException {
			service.logic();
		}
	}

	static class Service {
		Repository repository = new Repository();
		NetworkClient networkClient = new NetworkClient();

		public void logic() throws SQLException, ConnectException {
			repository.call();
			networkClient.call();
		}
	}

	static class NetworkClient {
		public void call() throws ConnectException {
			throw new ConnectException();
		}
	}

	static class Repository {
		public void call() throws SQLException {
			throw new SQLException("ex");
		}
	}
}