package unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import si1project.logic.Usuario;

public class TestUsuario {
	
	@Test
	public void testaValidaUsuario() throws Exception {
		Usuario user1 = new Usuario("leonardo", "testando", "Leonardo Alves", "Rua do alem", "leonardo@gmail.com");
		assertTrue("Não esta validando corretamente o login", user1.validaSessao("leonardo", "testando"));
		assertTrue("Deveria ter dado erro ao fazer Login", user1.validaSessao("leonardo", "testando"));
	}
	
	@Test
	public void testGetAtributo(String atributo) throws Exception{
		Usuario user1 = new Usuario("leonardo", "testando", "Leonardo Alves", "Rua do alem", "leonardo@gmail.com");
		String rua = "Rua do alem";
		String nome = "Leonardo Alves";
		String login = "login";
		String senha = "testando";
		String email = "leonardo@gmail.com";
		assertEquals(rua, user1.getAtributo("endereco"));
		assertEquals(nome, user1.getAtributo("nome"));
		assertEquals(login, user1.getAtributo("login"));
		assertEquals(senha, user1.getAtributo("senha"));
		assertEquals(email, user1.getAtributo("email"));
		
	}

}
