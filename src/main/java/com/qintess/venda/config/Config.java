package com.qintess.venda.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.venda.classes.Venda_Itens;
import com.qintess.venda.classes.Produto;
import com.qintess.venda.classes.Venda;
import com.qintess.venda.classes.Fornecedor;
import com.qintess.venda.classes.Fornecedor_Has_Produto;

public class Config {

	private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

		if(sessionFactory == null) {

			try {
				Configuration configuration = new Configuration();

				Properties prop = new Properties();

				//config de conexao ao banco de dados
				prop.put(Environment.DRIVER, "org.h2.Driver");
				prop.put(Environment.URL, "jdbc:h2:~/Venda");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");

				//prop.put(Environment.SHOW_SQL, "true");
				//prop.put(Environment.HBM2DDL_AUTO, "update");
				prop.put(Environment.SHOW_SQL, "false");
                prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				configuration.setProperties(prop);

				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Venda.class);
				configuration.addAnnotatedClass(Venda_Itens.class);
				configuration.addAnnotatedClass(Fornecedor.class);
				configuration.addAnnotatedClass(Fornecedor_Has_Produto.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.build();

				sessionFactory = configuration. buildSessionFactory(serviceRegistry);
							
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sessionFactory;
	}
}