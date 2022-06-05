import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantRepository;
import dao.LivreRepository;
import entities.Etudiant;
import entities.Livre;


@WebServlet(urlPatterns = {"/Etudiant","/new","/update","/delete","/login"})
public class InitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;
	private EtudiantRepository eRep;
	private LivreRepository lRep;

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
        this.lRep.ajouterLivre(l2);
		this.eRep.ajouterEtudiant(e1);
		this.eRep.ajouterEtudiant(e2);*/
			
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse
			  response) throws ServletException, IOException {
             
				List<Etudiant> listE = this.eRep.retournerTousEtudiant();
				request.setAttribute("listE", listE);
				
				if(request.getParameter("id")==null)
				
				{	request.setAttribute("Etudiant", null); 
				request.getRequestDispatcher("/etudiantCRUD.jsp").forward(request, response); 
				}
					
					else
				{
					Long id=Long.parseLong(request.getParameter("id"));
					Etudiant e =this.eRep.retournerEtudiant(id);
					request.setAttribute("Etudiant", e);
					
					if (request.getServletPath().equals("/delete"))
							{					 
						       
						           this.eRep.supprimerEtudiant(e);
						           request.setAttribute("Etudiant", null); 
						           response.sendRedirect(request.getContextPath() + "/Etudiant");
							
							}
					else
					
					request.getRequestDispatcher("/etudiantCRUD.jsp").forward(request, response);

				}
			
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
		String action = request.getServletPath();
		
          switch (action) {
              case "/new":{
              	String nom = request.getParameter("nom"); 
          		String prenom = request.getParameter("prenom");
          		String login = request.getParameter("login");
          		String pwd = request.getParameter("pwd");
          		Long nbLivreMensuel_Autorise = Long.parseLong(request.getParameter("nbLivreMensuel_Autorise"));
          		Long nbLivreEmprunte = Long.parseLong(request.getParameter("nbLivreEmprunte"));
          		String pack = request.getParameter("pack");
          		String pwdLivre = request.getParameter("pwdLivre");
          		Etudiant e = new Etudiant(nom, prenom,login,pwd, nbLivreMensuel_Autorise ,nbLivreEmprunte,pack,pwdLivre);;
          		eRep.ajouterEtudiant(e); 
          		response.sendRedirect(request.getContextPath() + "/Etudiant");
          		break;
              }
              case "/update":{
              	Long id=Long.parseLong(request.getParameter("id"));
					Etudiant e =this.eRep.retournerEtudiant(id);
					e.setNom(request.getParameter("nom"));
					e.setPrenom(request.getParameter("prenom"));
					e.setLogin(request.getParameter("login"));
					e.setPwd(request.getParameter("pwd"));
					e.setNbLivreMensuel_Autorise(Long.parseLong(request.getParameter("nbLivreMensuel_Autorise")));
					e.setNbLivreEmprunte(Long.parseLong(request.getParameter("nbLivreEmprunte")));
					e.setPack(request.getParameter("pack"));
					e.setPwdLivre(request.getParameter("pwdLivre"));
              	eRep.modifierEtudiant(e); 
          		response.sendRedirect(request.getContextPath() + "/Etudiant");
          		break;
              }
              case "/login":{
                	String login=request.getParameter("login");
                	String pwd=request.getParameter("pwd");
                	
                	TypedQuery< Etudiant > q = (TypedQuery<Etudiant>) entityManager.createQuery("select e from Etudiant e where login =: valeur and pwd=:val "); 
                	q.setParameter("valeur", login); q.setParameter("val", pwd);
                	List< Etudiant > etudiant =  q.getResultList();
                	request.setAttribute("etudiant", etudiant);
                	
  					if(request.getParameter("pwd")==null) {
            		   response.sendRedirect(request.getContextPath() + "/login");
            		}
  					else {
  						 response.sendRedirect(request.getContextPath() + "/AfficherTous");
  					}
            		break;
                }
              	
              }
           
		
	
	}
	
	
	
public void destroy() {
		
		this.entityManagerFactory.close(); 
		this.entityManager.close(); 
		
	}

	}
