import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* Essa classe implementa um sistema de iluminação composto por diversas lâmpadas
no construtor é necessário inicializar o sistema com uma lâmpada, demais lâmapadas podem ser adicionadas
depois. Adicionar lâmpadas de classes diferentes deixará explícita a motivação do uso de interfaces
*/
public class LightingSystem {
    private LinkedList<Lampada> lampadas = new LinkedList<>();
    //Construtor inicializando o sistema com uma lâmpada
    public LightingSystem(Lampada lampada){
        lampadas.add(lampada);
    }
    //adiciona uma nova lâmpada
    public void addLampada(Lampada lampada){
        this.lampadas.add(lampada);
        System.out.println("Lampada inserida com sucesso");
    }
    //mostra o numero de lampadas inseridas para confirmar se todas foram inseridas corretamente
    public void showNumLampadas() {
        System.out.println(this.lampadas.size());
    }
    //Método switch que troca o estado da lâmpada com o índice passado por parâmetro pelo usuário
    public void switchTarzan(int index){ //switch não foi possível por ser palavra reservada do Java
        if(index < lampadas.size()){
            if(lampadas.get(index).isTurnedOn()){
                lampadas.get(index).off();
            }else{
                lampadas.get(index).on();
            }
        }else
            System.out.println("O indice fornecido ultrapassa o número de lampadas");
    }
}
