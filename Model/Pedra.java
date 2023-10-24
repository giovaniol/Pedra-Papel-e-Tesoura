package Model;

public class Pedra extends Coisa {

    @Override
    public boolean batalha(Coisa escolha) {
        if (escolha instanceof Tesoura) {
            return true;
        } else if (escolha instanceof Pedra) {
    
            return false;
        }
        return false;
    }

}
