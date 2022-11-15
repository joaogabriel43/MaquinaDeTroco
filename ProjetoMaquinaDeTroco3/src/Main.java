
public class Main {

	public static void main(String[] args) {
		MaquinaDeTroco maquina =  new MaquinaDeTroco();
		maquina.abasteceCaixa();
		System.out.println(maquina.getDinheiroNoCaixa());
		maquina.CalculaTroco(25.50,30.0);
		maquina.Sangria();
		

	}

}
