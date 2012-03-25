package si1project.tests;

import java.util.ArrayList;
import java.util.List;

import easyaccept.EasyAcceptFacade;

public class SistemaCaronasTest {
	public static void main(String[] args) {
		 List<String> files = new ArrayList<String>();
         
		 //Put the testScript1 file into the "test scripts" list
         files.add("scripts/US01.txt");
         files.add("scripts/US02.txt");
         files.add("scripts/US03.txt");
         files.add("scripts/US04.txt");
         files.add("scripts/US05.txt");
         
         //Instantiate your software facade
	     SistemaCaronasTestFacade sis1 = new SistemaCaronasTestFacade();
	     
	     //Instantiate EasyAccept facade
	     EasyAcceptFacade eaFacade = new EasyAcceptFacade(sis1, files);
	     
	     //Execute the tests
	     eaFacade.executeTests();
	     
	     //Print the tests execution results
         System.out.println(eaFacade.getCompleteResults());
	}
}
