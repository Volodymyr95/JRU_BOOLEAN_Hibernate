package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import project.config.SessionFactoryProvider;
import project.entity.City;

import java.util.List;
import java.util.Optional;

public class CityDao implements CrudDao<City, Long> {

    private static final CityDao INSTANCE = new CityDao();

    private CityDao() {

    }

    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    @Override
    public List<City> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from City ");
        return query.getResultList();
    }

    @Override
    public Optional<City> findById(Long id) {
        Session session = sessionFactory.openSession();
        return Optional.ofNullable(session.find(City.class, id));
    }

    @Override
    public void save(City city) {

    }

    @Override
    public void update(City city) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public Optional<City> findByName(String name) {
        Query query = sessionFactory.openSession().createQuery("from City  where name = ?", City.class);
        query.setParameter(0, name);
        return Optional.ofNullable((City) query.getSingleResult());
    }

    public static CityDao getInstance() {
        return INSTANCE;
    }
}
