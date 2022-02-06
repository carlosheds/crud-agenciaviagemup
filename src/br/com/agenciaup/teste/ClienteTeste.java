package br.com.agenciaup.teste;

import br.com.agenciaup.dao.ClienteDAO;
import br.com.agenciaup.model.Cliente;

public class ClienteTeste {

	public static void main(String[] args) {
		ClienteDAO clienteDao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Marcela");
		cliente.setIdade(29);
//		
//		clienteDao.save(cliente);
		
//		clienteDao.removeById(1);
		
		clienteDao.update(cliente,2);

	}

}
