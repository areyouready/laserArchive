package de.ayr.laserdb.infrastructure.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.ayr.laserdb.infrastructure.entity.LaserDisc;

@Stateless
public class LaserService {
	
	private LaserDisc laserDisc;
	
	@PersistenceContext(unitName = "LaserDB")
	EntityManager em;
	
	public LaserService() {
	}

	public void createDefaultDisc() {
		laserDisc = new LaserDisc("testDisc");
		em.persist(laserDisc);
	}
	
	public List<LaserDisc> fetchAllDiscs() {
//		String fetchingPasswordDate = "select u.passwordDate FROM User u WHERE u.email = :Nameselect";
//
//        Date passwordDate = em.createQuery(fetchingPasswordDate, Date.class)
//                .setParameter("Nameselect", username).getSingleResult();
		
		return (List<LaserDisc>) em.createQuery(
			      "select laserDisc from LaserDisc laserDisc ORDER BY laserDisc.title asc", LaserDisc.class)
			      .getResultList();
	}

	
	
}
