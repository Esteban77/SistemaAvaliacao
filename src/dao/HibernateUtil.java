/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Senac
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;   

    public HibernateUtil() {
        System.out.println("Aqui ta problem");
    }
    
    
    static {
        try {
            Configuration cfg = new Configuration();  //As classes pais encima dos filhos
            cfg.addAnnotatedClass(entidade.Pessoa.class);
            cfg.addAnnotatedClass(entidade.Consumidor.class);
            cfg.addAnnotatedClass(entidade.Empresa.class);
            cfg.addAnnotatedClass(entidade.RespostaFormulario.class);
            cfg.addAnnotatedClass(entidade.Opcao.class);
            cfg.addAnnotatedClass(entidade.Pergunta.class);
            cfg.addAnnotatedClass(entidade.Resposta.class);
            cfg.addAnnotatedClass(entidade.TipoDeBeneficio.class);
            cfg.addAnnotatedClass(entidade.TipoDeFormulario.class);
            cfg.addAnnotatedClass(entidade.CupomBeneficio.class); 
           
            
            cfg.configure("/dao/hibernate.cfg.xml");
            ServiceRegistryBuilder build = new ServiceRegistryBuilder().
                    applySettings(cfg.getProperties());
            ServiceRegistry serReg = build.buildServiceRegistry();
            sessionFactory = cfg.buildSessionFactory(serReg);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Erro ao construir session factory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession() {
        Session session = sessionFactory.openSession();
        return session;
//        return sessionFactory.openSession();
    }
}
