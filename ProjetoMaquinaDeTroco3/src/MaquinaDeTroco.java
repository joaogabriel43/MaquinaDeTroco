import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MaquinaDeTroco {
	
	private double moeda5,moeda10, moeda25, moeda50,moeda1,troco,dinheiroNoCaixa,moedas;
	
	public double getMoeda5() {
		return moeda5;
	}
	public void setMoeda5(double moeda5) {
		this.moeda5 = moeda5;
	}
	public double getMoeda10() {
		return moeda10;
	}
	public void setMoeda10(double moeda10) {
		this.moeda10 = moeda10;
	}
	public double getMoeda25() {
		return moeda25;
	}
	public void setMoeda25(double moeda25) {
		this.moeda25 = moeda25;
	}
	public double getMoeda50() {
		return moeda50;
	}
	public void setMoeda50(double moeda50) {
		this.moeda50 = moeda50;
	}
	public double getMoeda1() {
		return moeda1;
	}
	public void setMoeda1(double moeda1) {
		this.moeda1 = moeda1;
	}
	public double getTroco() {
		return troco;
	}
	public void setTroco(double troco) {
		this.troco = troco;
	}
	public double getDinheiroNoCaixa() {
		return dinheiroNoCaixa;
	}
	public void setDinheiroNoCaixa(double dinheiroNoCaixa) {
		this.dinheiroNoCaixa = dinheiroNoCaixa;
	}
	public double getMoedas() {

		return moedas;
	}
	public void setMoedas(double moedas) {
		this.moedas = moedas;
	}
	
	public MaquinaDeTroco() {
		this.moeda5 = 0.0;
		this.moeda10 = 0.0;
		this.moeda25 = 0.0;
		this.moeda50 = 0.0;
		this.moeda1 = 0.0;
		this.dinheiroNoCaixa = 0.0;
	}
	public double calculaDinheiroCaixa() {
		this.dinheiroNoCaixa = moeda10 * 0.1 + moeda25 * 0.25 + moeda50*0.5 + moeda1 +moeda5 *0.05;
		return dinheiroNoCaixa;
	}
	public double abasteceCaixa() {
		int quant = 0,opcao = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual moeda deseja inserir?\n 1) 05 centavos\n 2) 10 centavos\n 3) 25 centavos \n 4) 50 centavos\n 5) 1 real\n 6) sair");
		System.out.println("Digite a opção desejada:");
		opcao = sc.nextInt();
		while(true) {
			switch(opcao) {
				case 1:
					System.out.println("Digite a quantidade de moedas que deseja depositar:");
					quant = sc.nextInt();
					this.moeda5 = moeda5+quant;
					break;
				case 2:
					System.out.println("Digite a quantidade de moedas que deseja depositar:");
					quant = sc.nextInt();
					this.moeda10 = moeda10+quant;
					break;
					
				case 3:
					System.out.println("Digite a quantidade de moedas que deseja depositar:");
					quant = sc.nextInt();
					this.moeda25 = moeda25+quant;
					break;
					
				case 4:
					System.out.println("Digite a quantidade de moedas que deseja depositar:");
					quant = sc.nextInt();
					this.moeda50 = moeda50+quant;
					break;
					
				case 5:
					System.out.println("Digite a quantidade de moedas que deseja depositar:");
					quant = sc.nextInt();
					this.moeda1 = moeda1+quant;
					break;
				case 6:
					 System.out.println("Dinheiro no caixa atualizado:"+ calculaDinheiroCaixa());
					 return calculaDinheiroCaixa();
				default:
					System.out.println("Opção incorreta, Digite uma opção valida");
				}	
			System.out.println("Deseja continuar abastecendo o caixa?");
			System.out.println("Se sim digite a moeda que deseja colocar, Para sair digite 6\n "
					+ "1) 5 centavos\n "
					+ "2) 10 centavos\n "
					+ "3) 25 real\n "
					+ "4) 50 centavos\n "
					+ "5) 1 real\n "
					+ "6) Sair");
			opcao = sc.nextInt();
			}
		
	}
	public boolean sangria() throws IllegalArgumentException, IOException {
		if(dinheiroNoCaixa>= 0 )
			System.out.println("Foram retiradas: "
					+moeda10+" moedas de 10 centavos // "
					+moeda25+" moedas de 25 centavos // "
					+moeda50+" moedas de 50 centavos // "
					+moeda1+" moedas de 1 real");
			this.dinheiroNoCaixa = dinheiroNoCaixa- moeda10 * 0.1 - moeda25 * 0.25 - moeda50*0.5 - moeda1;
			this.moeda10 = 0.0;
			this.moeda25 = 0.0;
			this.moeda50 = 0.0;
			this.moeda1 = 0.0;
			if(dinheiroNoCaixa>= 0 ) {
				System.out.println("Caixa esvaziado.");
				return true;
			}
			else {
				System.out.println("O caixa nao pode ser negativo.");
				return false;
			}
	}

	public double calculaTroco(double valorDoProduto,double valorRecebido) {

		double aux = 0.0, aux2 = 0.0;
		if(valorDoProduto <= valorRecebido) {
			troco = valorRecebido - valorDoProduto;
			aux2 = troco;
			if(dinheiroNoCaixa >= troco) {
				while(true) {					
					if(troco == aux || troco -0.000000000000001 == aux || troco -0.000000000000002 == aux || troco -0.000000000000003 == aux || troco -0.000000000000004 == aux 
						|| troco -0.000000000000005 == aux || troco -0.000000000000006 == aux || troco -0.000000000000007 == aux || troco -0.000000000000008 == aux || troco -0.000000000000009 == aux) {
						System.out.println("Troco realizado com sucesso:"+ troco);
						return troco;
					}
					else if(aux <= troco-1 && moeda1 != 0) {
						aux = aux+1.0;
						aux2= aux2-1.0;
						moeda1= moeda1-1.0;
					}
					else if(aux <= troco-0.5 && moeda50 !=0) {
						aux =aux+ 0.5;
						aux2=aux2-0.5;
						moeda50=moeda50-0.5;
					}
					else if(aux <= troco-0.25 && moeda25 !=0) {
						aux =aux+ 0.25;
						aux2=aux2-0.25;
						moeda25=moeda25-0.25;
					}
					else if(aux <= troco-0.10 && moeda10 !=0) {
						aux =aux+ 0.10;
						aux2=aux2-0.10;
						moeda10=moeda10-0.10;
					}
					else if(aux <= troco-0.05 && moeda5 !=0) {
						aux =aux+ 0.05;
						aux2=aux2-0.05;
						moeda5=moeda5-0.05;
					}
					else {
						System.out.println("Troco insuficiente");
						return 0.0;
					}
				}
			}
			else {
			System.out.println("Troco inSsuficiente");
			return 0.0;
			}
		}
		else {
			System.out.println("Dinheiro insuficiente para pagar pelo produto!");
			return 0.0;
		}
	}
	
	public void salvaCaixa()throws IOException, IllegalArgumentException{
		int i = 0;
		if(dinheiroNoCaixa == 0)
			throw new IllegalArgumentException();
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("dinheiroNoCaixa.txt"));
			String y = "";
				//Moeda 1 real
					bw.write(moeda1+y);
					moeda1 = 0;
					bw.newLine();
				
				//Moeda 50 centavos
					bw.write(moeda50+y);
					moeda50 = 0;
					bw.newLine();
				//Moeda 25 centavos
					bw.write(moeda25+y);
					moeda25 = 0;
					bw.newLine();
					
				//Moeda 10 centavos
					bw.write(moeda10+y);
					moeda10 = 0;
					bw.newLine();
					
				//Moeda 5 centavos
					bw.write(moeda5+y);
					moeda5 = 0;
					bw.newLine();
				calculaDinheiroCaixa();
			bw.close();
			System.out.println("Caixa Salvo");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void resgataCaixa()throws IOException, IllegalArgumentException {
		int cont = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader("dinheiroNoCaixa.txt"));
				String line =  br.readLine();
			while(br.ready()){
					if(cont == 0) {
						moeda1 = moeda1+Double.parseDouble(line);
						cont++;
					}
					else if(cont == 1) {
						moeda50 = moeda50+Double.parseDouble(line);
						cont++;
					}
					else if(cont == 2) {
						moeda25 = moeda25+Double.parseDouble(line);
						cont++;
					}
					else if(cont == 3) {
						moeda10 = moeda10+Double.parseDouble(line);
						cont++;
					}
					else if(cont == 4) {
						moeda5 = moeda5+Double.parseDouble(line);
						br.close();
						calculaDinheiroCaixa();
					}
					else {
						return;
					}
				line  = br.readLine();
			}	
			BufferedWriter bw = new BufferedWriter(new FileWriter("dinheiroNoCaixa.txt"));
			String y = "";
				//Moeda 1 real
					for (int j = 0; j < 5; j++) {
						bw.write(0+y);
						bw.newLine();
					}
			bw.close();
			System.out.println("Caixa Não salvo");
			}catch(IOException e){
				e.printStackTrace();
		}
	}
}
			
		
	
