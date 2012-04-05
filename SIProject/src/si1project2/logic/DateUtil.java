package si1project2.logic;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.print.DocFlavor.STRING;

import util.StringUtil;

/**
 * Class ManipulaCalendario
 * @author Andre Yuri, Leonardo Alves, Hemã Vidal;
 */
public class DateUtil {
	/**
	 * Variaveis Staticas fimDeSemana, MAIOR_ANO, MENOR_ANO,
	 * 
	 * OBJETO: calendar
	 */
	static int fimDeSemana ;
	static final int MAIOR_ANO = Integer.MAX_VALUE, MENOR_ANO = Integer.MIN_VALUE;
	static GregorianCalendar calendar = new GregorianCalendar();

	

	public static boolean verificaDataValida(int dia,int mes,int ano)
	/**
	 * @param int dia, int mes, int ano
	 * @return  retorna um boolean indicando se o intervalo da data existe
	 * 
	 */
	{	
		mes--;

		if ( (ano < MENOR_ANO) || (ano > MAIOR_ANO)) {
			return false;
		}else if (dia < 1) {
			return false;
		}else if ( (mes > 12) || (mes < 1)) {
			return false;
		}
		calendar.set(Calendar.MONTH, mes);
		calendar.set(Calendar.YEAR, ano);
		
		if (dia > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
			return false;
		}
		return true;
	}
	
	public static boolean validaData(String data) {
		String[] data1 = data.split("/");
		int dia = Integer.parseInt(data1[0]);
		int mes = Integer.parseInt(data1[1]);
		int ano = Integer.parseInt(data1[2]);
		return verificaDataValida(dia, mes, ano);
	}
	
	public static boolean datajapassou(String data) {
		String[] data1 = data.split("/");
		int dia = Integer.parseInt(data1[0]);
		int mes = Integer.parseInt(data1[1]);
		int ano = Integer.parseInt(data1[2]);
		
		Calendar calendario2 = new GregorianCalendar();
		
		
		calendario2.set(Calendar.DAY_OF_MONTH, dia);
		calendario2.set(Calendar.MONTH, mes+1);
		calendario2.set(Calendar.YEAR, ano);
		if(calendar.compareTo(calendario2) < 0){
			return true;
		}
		return false;
	}

}
