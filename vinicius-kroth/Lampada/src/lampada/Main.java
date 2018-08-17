package lampada;

public class Main {

	public static void main(String args[]) {

		LampadaFluorescente lampadaFluorescente = new LampadaFluorescente();
		LampadaIncandescente lampadaIncandescente = new LampadaIncandescente();

		GerenteDeLampada gerenteFluorescente = new GerenteDeLampada(lampadaFluorescente);
		GerenteDeLampada gerenteIncandescente = new GerenteDeLampada(lampadaIncandescente);

		System.out.println("########### OPERAÇÕES LAMPADA FLUORESCENTE ###########");
		System.out.println(gerenteFluorescente.informacoesDaLampada());
		System.out.println(gerenteFluorescente.estadoDaLampada());
		System.out.println(gerenteFluorescente.switchDaLampada());
		System.out.println(gerenteFluorescente.switchDaLampada());
		
		
		
		System.out.println("\n########### OPERAÇÕES LAMPADA INCADESCENTE ###########");
		System.out.println(gerenteIncandescente.informacoesDaLampada());
		System.out.println(gerenteIncandescente.estadoDaLampada());
		System.out.println(gerenteIncandescente.switchDaLampada());
		System.out.println(gerenteIncandescente.switchDaLampada());
		
		

	}
}
