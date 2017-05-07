package io.github.richardmars.hibernate.firstapp;

import org.hibernate.Session;

import io.github.richardmars.hibernate.firstapp.domain.Event;
import io.github.richardmars.hibernate.firstapp.util.HibernateUtil;

import java.util.*;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();

        mgr.createAndStoreEvent("My Event", new Date());
        List<Event> events = mgr.listEvents();
        for (Event event : events) {
			System.out.println(event.getDate());
		}

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }
    
    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

}
