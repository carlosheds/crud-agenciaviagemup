package br.com.agenciaup.teste;

import br.com.agenciaup.dao.ClienteDAO;
import br.com.agenciaup.model.Cliente;

public class TesteCrud {

	public static void main(String[] args) {
		ClienteDAO clienteDao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Carlos");
		cliente.setIdade(28);
		
		clienteDao.save(cliente);

	}

}
