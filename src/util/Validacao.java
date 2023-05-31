package util;

import javax.swing.JOptionPane;

public class Validacao {

	public static final String TEXTO = "[a-zA-Z\\s{2,20}]";
	public static final String DNI = "[0-9]{8}";
	public static final String NUM_HIJOS = "[0-9][1][0]";

	public static final String DESCRICAO = "[a-zA-Z\\s]{3,300}";
	public static final String PRECO = "\\d+[.]\\d";
	public static final String PLACA_CARRO = "[A-Z]{3}\\d{3}";
	public static final String ESTOQUE = "\\d";
	public static final String DATA = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
	public static final String CORREIO_GMAIL = "[a-zA-Z]+(@gmail.com)";

	public static final String NOME = "[a-zA-Z\\s]{3,30}";
	public static final String EDAD = "\\d{2}";
	public static final String SEXO = "[MF]";



}
