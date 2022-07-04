import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class CaixaDialogoTipoConversor {

	public static void main(String[] args) {
		
		conversorMoedas();
		desejaContinuar();

	}

	private static void desejaContinuar() {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "information", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if(resposta == 0) {
			conversorMoedas();
			desejaContinuar();
		}if(resposta == 1) {
			JOptionPane.showMessageDialog(null, "Programa finalizado.");
		} if(resposta == 2) {
			JOptionPane.showMessageDialog(null, "Programa concluído.");
		}

	}

	public static void converteRealDolar(double valor) {
		
		double valorConvertido = valor / 5.25;
		
		String cifra = "$ ";
		mostraMensagem(valorConvertido, cifra);
	}

	public static void converteDolarReal(double valor) {
		double valorConvertido = valor * 5.25;
		String cifra = "R$";
		mostraMensagem(valorConvertido, cifra);
	}

	public static void converteRealEuro(double valor) {
		double valorConvertido = valor / 5.45;
		String cifra = "¢ ";
		mostraMensagem(valorConvertido, cifra);
	}

	public static void converteEuroReal(double valor) {
		double valorConvertido = valor * 5.45;
		String cifra = "R$ ";
		mostraMensagem(valorConvertido, cifra);
	}

	public static void converteRealLibra(double valor) {
		double valorConvertido = valor / 6.32;
		String cifra = "£ ";
		mostraMensagem(valorConvertido, cifra);
	}

	public static void converteLibraReal(double valor) {
		double valorConvertido = valor * 6.32;
		String cifra = "R$";
		mostraMensagem(valorConvertido, cifra);
	}

	public static void mostraMensagem(double valorConvertido, String cifra) {		
		String val = new DecimalFormat("#,##0.00").format(valorConvertido);
		String msg = cifra;
		JOptionPane.showMessageDialog(null, "O valor convertido é "+ msg + val);
	}

	public static boolean validaInput(String input) {
		if (input.matches("[+-]?\\d*(\\.\\d+)?")&& !(input == null))
			return true;

		return false;
	}

	public static void conversorMoedas() {

		Object moeda = JOptionPane.showInputDialog(null,
				"Escolha a moeda para a qual você deseja converter seu dinheiro", "Moedas",
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "De Reais a Dólares", "De Reais a Euros",
						"De Reais a Libras", "De Dólares a Reais", "De Euros a Reais", "De Libras a Reais" },
				"Escolha");
		
		System.out.println(moeda);
		String input = JOptionPane.showInputDialog("Insira um valor");

		boolean inputValido = validaInput(input);

		if (!inputValido) {
			input = JOptionPane.showInputDialog("Por favor, digite um valor válido!");
		} 

		Double valor = Double.parseDouble(input);

		System.out.println(moeda);

		if (moeda.equals("De Reais a Dólares")) {
			converteRealDolar(valor);
		}
		if (moeda.equals("De Dólares a Reais")) {
			converteDolarReal(valor);
		}
		if (moeda.equals("De Reais a Euros")) {
			converteRealEuro(valor);
		}
		if (moeda.equals("De Euros a Reais")) {
			converteEuroReal(valor);
		}
		if (moeda.equals("De Reais a Libras")) {
			converteRealLibra(valor);
		}
		if (moeda.equals("De Libras a Reais")) {
			converteLibraReal(valor);
		}if(moeda.equals(null)) {
			JOptionPane.showMessageDialog(null, "Programa finalizado.");
		}
	}

}
