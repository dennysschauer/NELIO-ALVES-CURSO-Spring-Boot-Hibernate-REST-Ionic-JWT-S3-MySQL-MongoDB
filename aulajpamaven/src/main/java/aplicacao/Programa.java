package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Pessoa p1 = new Pessoa(null, "Dennys", "dennys.schauer@hotmail.com"); //null, pois o BD vai criar o ID automaticamente, pois ? o definido na classe pessoa
		//Pessoa p2 = new Pessoa(null, "Solange", "solange.schauer@hotmail.com");
		//Pessoa p3 = new Pessoa(null, "Miguel", "miguel.santos@hotmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager(); //conex?o com o BD e a persistencia implementada
		
		//em.getTransaction().begin(); //JPA faz uma transa??o que n?o ? uma simples leitura, precisa criar uma transa??o
		//em.persist(p1); // pega o objeto instanciado para fazer a persistencia no BD
		//em.persist(p2);
		//em.persist(p3);		
		//em.getTransaction().commit(); // confirmar a transa??o feita
		
//		Pessoa p1 = em.find(Pessoa.class, 1);
//		Pessoa p2 = em.find(Pessoa.class, 2);
//		Pessoa p3 = em.find(Pessoa.class, 3);
//		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
		
		//Para remover algum registro, deve primeiro recuperar/buscar esse registro no BD, e fazer o remove
		//TODA transi??o diferente de uma simples consulta, devemos abrir a transa??o e confirmar com commit
		
		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class, 2);
		em.remove(p);
		em.getTransaction().commit();
		
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);

	}

}
