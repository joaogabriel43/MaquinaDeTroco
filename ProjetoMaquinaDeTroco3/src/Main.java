import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		MaquinaDeTroco maquina =  new MaquinaDeTroco();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		while(true) {
			System.out.println("1) abastece o caixa "
					+ "\n2) Mostra dinheiro no caixa "
					+ "\n3) Esvazia o caixa "
					+ "\n4) Salva caixa"
					+ "\n5) Resgata o caixa"
					+ "\n6) Finaliza o programa.");
			System.out.println("Digite a opção desejada:");
		opcao = sc.nextInt();
		switch(opcao) {
		
		case(1):
			maquina.abasteceCaixa();
			break;
		case(2):
			System.out.println("========================================\n"
					+ "Existem: " + maquina.getMoeda5() + " Moedas de 5 centavos \n"
					+ "Existem: " + maquina.getMoeda10()+ " Moedas de 10 centavos \n"
					+ "Existem: " + maquina.getMoeda25()+ " Moedas de 25 centavos \n"
					+ "Existem: " + maquina.getMoeda50()+ " Moedas de 50 centavos \n"
					+ "Existem: " + maquina.getMoeda1()+ " Moedas de 1 real \n"
					+ "========================================");
			System.out.println("Tem " + maquina.calculaDinheiroCaixa() + "$ no Caixa");
			break;
		case(3):
			maquina.sangria();
			break;
		case(4):
			maquina.salvaCaixa();
			break;
		case(5):
			maquina.resgataCaixa();
			break;	
		case(6):
			System.out.println("Programa finalizado");
				return;
		default:
			
			System.out.println("==================== Digite uma opção valida ===============");
		}
		}
	}
}
