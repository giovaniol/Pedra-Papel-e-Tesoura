package Model;

public class Papel extends Coisa {

    @Override
    public boolean batalha(Coisa escolha) {
        if (escolha instanceof Pedra) {
            return true;
        } else if (escolha instanceof Papel) {
            
            return false;
        }
        return false;
    }

}
