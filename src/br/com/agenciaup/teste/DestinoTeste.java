package br.com.agenciaup.teste;

import br.com.agenciaup.dao.DestinoDAO;
import br.com.agenciaup.model.Destino;

public class DestinoTeste {

	public static void main(String[] args) {
		DestinoDAO destinoDao = new DestinoDAO();
		
		Destino destino = new Destino();
		destino.setCidade("Santos");
		destino.setEstado("São Paulo");
		destino.setPais("Brasil");
//		
//		destinoDao.save(destino);
		
//		destinoDao.removeById(2);
		
		destinoDao.update(destino,3);
		
		for (Destino c : destinoDao.getDestinos()) {
		System.out.print("Id: " + c.getId_destino());
		System.out.print(" | Cidade: " + c.getCidade());
		System.out.print(" | Estado: " + c.getEstado());
		System.out.println(" | País: " + c.getPais());
		}
	}

}
