package br.com.agenciaup.teste;

import br.com.agenciaup.dao.PassagemDAO;
import br.com.agenciaup.model.Passagem;

public class PassagemTeste {

	public static void main(String[] args) {
		PassagemDAO passagemDao = new PassagemDAO();
		
		Passagem passagem = new Passagem();
		passagem.setId_cliente(3);
		passagem.setId_destino(1);
		passagem.setPreco(1340.20);	
//		passagemDao.save(passagem);
		
//		passagemDao.removeById(1);
		
		passagemDao.update(passagem,2);
		
		for (Passagem p : passagemDao.getPassagens()) {
		System.out.print("Id_passagem: " + p.getId_passagem());
		System.out.format(" | Preço R$: %.2f\n", p.getPreco());
		System.out.print("Id_cliente: " + p.getId_cliente());
		System.out.println(" | Nome: " + p.getCliente().getNome());
		System.out.print("Id_destino: " + p.getId_destino());
		System.out.print(" | Cidade: " + p.getDestino().getCidade());
		System.out.print(" | Estado: " + p.getDestino().getEstado());
		System.out.print(" | País: " + p.getDestino().getPais());
		}
	}

}
