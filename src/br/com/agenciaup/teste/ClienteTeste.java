package br.com.agenciaup.teste;

import br.com.agenciaup.dao.ClienteDAO;
import br.com.agenciaup.model.Cliente;

public class ClienteTeste {

	public static void main(String[] args) {
		ClienteDAO clienteDao = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Carlos");
		cliente.setIdade(28);
//		
		clienteDao.save(cliente);
		
//		clienteDao.removeById(1);
		
//		clienteDao.update(cliente,2);
		
		for (Cliente c : clienteDao.getClientes()) {
			System.out.print("Id: " + c.getId_cliente());
		System.out.print(" | Nome: " + c.getNome());
		System.out.println(" | Idade: " + c.getIdade());
		}
	}

}
