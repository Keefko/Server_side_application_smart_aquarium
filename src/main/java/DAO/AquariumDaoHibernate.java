package DAO;

import com.bachelor.smartaquarium.entity.Aquarium;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class AquariumDaoHibernate implements AquariumDAO {

    private EntityManager entityManager;

    @Autowired
    public AquariumDaoHibernate(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Aquarium> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Aquarium> theQuery = currentSession.createQuery("",Aquarium.class);

        List<Aquarium> aquariums = theQuery.getResultList();
        return aquariums;
    }
}
