public class Cafe extends MaquinaCafe {
    @Override
    void adicionarPo() {
        System.out.println("Pó de café selecionado");
    }

    @Override
    void misturar(){
        System.out.println("Misturando o café");
    }

    @Override
    void esquentar() {
        System.out.println("Esquentando o café\n");
    }
}
