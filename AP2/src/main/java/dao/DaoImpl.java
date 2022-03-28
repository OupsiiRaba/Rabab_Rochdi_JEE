package dao;

import org.springframework.stereotype.Component;
//au demarrage lorsequ'il trouve l 'annotation componement il va l'instancier

@Component("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("Version Base de données ");
        //Se connecter a la base de donees pour recuperer la temperature
        double temp= Math.random()*40;

        return temp;
    }
}
