package Model;

public class Tesoura extends Coisa {

    @Override
    public boolean batalha(Coisa escolha) {
        if (escolha instanceof Papel) {
            return true;
        } else if (escolha instanceof Tesoura) {

            return false;
        }
        return false;
    }

}
