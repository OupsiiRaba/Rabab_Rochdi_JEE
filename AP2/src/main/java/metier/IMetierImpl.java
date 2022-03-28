package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//instanciation
@Component("metier")
public class IMetierImpl implements IMetier {
    //pour faire  l'injection des dependances
    //demader a spring au moment ou il va faire l instanciation de la classe
    //chercher un objet de type IDAO et l injecter dans la variable idao


    //@Autowired
    private IDao iDao;//couplage faible
    //injection via constructeur

    public IMetierImpl(IDao iDao) {
        this.iDao = iDao;
    }

    //pas de new car on cree u objet concret et la on appelle un couplage fort
    //donc la cet objet va etre null
    //va geerer une exception null pointer
    @Override
    public double Calcul() {
        double tmp= iDao.getData();
        double res = tmp*540/Math.cos(tmp*Math.PI);

        return res;
    }
    //permet d injecter dans la variable IDao  un objet d une classe qui implemente l interface IDao
    public void setiDao(IDao iDao) {
        this.iDao = iDao;
    }
}
