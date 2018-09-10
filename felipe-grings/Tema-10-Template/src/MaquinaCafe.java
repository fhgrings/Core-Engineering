public abstract class MaquinaCafe {

    abstract void adicionarPo();
    abstract void misturar();
    abstract void esquentar();


    public void prepararBebida() {
        adicionarPo();

        misturar();

        esquentar();
    }


}
