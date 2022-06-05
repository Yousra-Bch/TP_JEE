import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantRepository;
import dao.LivreRepository;
import entities.Etudiant;
import entities.Livre;

@WebServlet(urlPatterns = {"/Livre","/Lnew","/Lupdate","/Ldelete","/AfficherTous"})
public class ServletGestionLivres extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;
	private LivreRepository lRep;
	private EtudiantRepository eRep;

	public void init() {

		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
		this.entityManager = entityManagerFactory.createEntityManager();
		this.transaction = entityManager.getTransaction();
		this.eRep = new EtudiantRepository(this.entityManager, this.transaction);
		this.lRep = new LivreRepository(this.entityManager, this.transaction);

		/*Etudiant e1 = new Etudiant("Mohamed", "Ahmed","Mo_hamed","12345", 10L ,0L,"standard");
		Etudiant e2 = new Etudiant("Kaci", "Chanez","Ch_Ka","12345", 20L ,0L,"premium");
		Livre l1 = new Livre("Analyse","Math");
		Livre l2 = new Livre("Langage C#","Informatique");
		Livre l3 = new Livre("Java","Informatique");
		

        this.lRep.ajouterLivre(l1);
        this.lRep.ajouterLivre(l2);
        this.lRep.ajouterLivre(l3);
		this.eRep.ajouterEtudiant(e1);
		this.eRep.ajouterEtudiant(e2);*/
			
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			  response) throws ServletException, IOException {
             
				List<Livre> listL = this.lRep.retournerTousLivre();
				request.setAttribute("listL", listL);
				
				List<Livre> listl = this.lRep.retournerTousLivre();
				request.setAttribute("listl", listl);
				if (request.getServletPath().equals("/AfficherTous"))
				{	
				request.getRequestDispatcher("/AfficherTous.jsp").forward(request, response);}
				
				if(request.getParameter("id")==null)
				
				{	request.setAttribute("Livre", null); 
				request.getRequestDispatcher("/livreCRUD.jsp").forward(request, response);
				}
					
					else
				{
					Long id=Long.parseLong(request.getParameter("id"));
					Livre l =this.lRep.retournerLivre(id);
					request.setAttribute("Livre", l);
					
					if (request.getServletPath().equals("/Ldelete"))
							{					 
						       
						           this.lRep.supprimerLivre(l);
						           request.setAttribute("Livre", null); 
						           response.sendRedirect(request.getContextPath() + "/Livre");
							
							}
					else
					
					request.getRequestDispatcher("/livreCRUD.jsp").forward(request, response);

				}
			
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
		String action = request.getServletPath();
		
          switch (action) {
              case "/Lnew":{
              	String nom = request.getParameter("nom"); 
          		String domaine = request.getParameter("domaine");
          		String url = request.getParameter("url");
          		
          		Livre l = new Livre(nom, domaine,url);
          		lRep.ajouterLivre(l); 
          		response.sendRedirect(request.getContextPath() + "/Livre");
          		break;
              }
              case "/Lupdate":{
              	Long id=Long.parseLong(request.getParameter("id"));
					Livre l =this.lRep.retournerLivre(id);
					l.setNom(request.getParameter("nom"));
					l.setDomaine(request.getParameter("domaine"));
					l.setUrl(request.getParameter("url"));
              	lRep.modifierLivre(l); 
          		response.sendRedirect(request.getContextPath() + "/Livre");
          		break;
              }
              	
              }
           
		
	
	}
	
	
	
public void destroy() {
		
		this.entityManagerFactory.close(); 
		this.entityManager.close(); 
		
	}

	}
