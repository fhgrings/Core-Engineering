package main.java.com.github.fhgrings._biblioteca;

import java.util.Comparator;

public class ClienteHistoricoComparador implements Comparator<Cliente> {
    @Override
    public int compare(Cliente c, Cliente c2) {
        return c2.getHistAluguel() - c.getHistAluguel();
    }
}
