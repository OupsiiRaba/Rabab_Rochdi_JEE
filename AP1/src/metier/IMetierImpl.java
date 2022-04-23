package metier;

import dao.IDao;

public class IMetierImpl implements IMetier {
    private IDao iDao;//couplage faible

    //pas de new car on cree u objet concret et la on appelle un couplage fort
    //donc la cet objet va etre null
    //va geerer une exception null pointer
    @Override
    public double Calcul() {
        double tmp = iDao.getData();
        double res = tmp * 540 / Math.cos(tmp * Math.PI);

        return res;
    }

    //permet d injecter dans la variable IDao  un objet d une classe qui implemente l interface IDao
    public void setiDao(IDao iDao) {
        this.iDao = iDao;
    }
}
