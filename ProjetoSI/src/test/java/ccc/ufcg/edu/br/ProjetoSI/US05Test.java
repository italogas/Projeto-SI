package ccc.ufcg.edu.br.ProjetoSI;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import ccc.ufcg.edu.br.ProjetoSI.SistemaCaronas;

import easyaccept.EasyAcceptFacade;

public class US05Test extends TestCase {

	public US05Test(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(US05Test.class);
	}

	public void testarEasyAcceptScript() {

		List<String> files = new ArrayList<String>();
		// Put the us1.txt file into the "test scripts" list
		files.add("scripts/US05.txt");

		// Instantiate the Monopoly Game fa�ade
		SistemaCaronas fachada =  new SistemaCaronas();

		// Instantiate EasyAccept fa�ade
		EasyAcceptFacade eaFacade = new EasyAcceptFacade(fachada, files);

		// Execute the tests
		eaFacade.executeTests();

		// Print the tests execution results
		System.out.println(eaFacade.getCompleteResults());


		assertTrue(eaFacade.getTotalNumberOfNotPassedTests() == 0);
	}

	public static void main(String[] args) throws Exception {

		List<String> files = new ArrayList<String>();
		// Put the us1.txt file into the "test scripts" list
		files.add("scripts/US05.txt");

		// Instantiate the Monopoly Game fa�ade
		SistemaCaronas fachada = new SistemaCaronas();

		// Instantiate EasyAccept fa�ade
		EasyAcceptFacade eaFacade = new EasyAcceptFacade(fachada, files);

		// Execute the tests
		eaFacade.executeTests();

		// Print the tests execution results
		System.out.println(eaFacade.getCompleteResults());
	}

}