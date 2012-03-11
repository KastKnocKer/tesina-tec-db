package Servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.business.BusinessConti;
import com.exceptions.DatabaseException;
import com.orb.Conto;
import com.orb.VoceMenu;
import com.orb.gestioneOggetti.GestioneComanda;
import com.orb.gestioneOggetti.GestioneConto;
import com.restaurant.TreeNodeVoceMenu;
import com.restaurant.WrapperComanda;
import com.restaurant.WrapperConto;
import com.restaurant.WrapperVariazione;

import Utilita.JSONResponse;


@WebServlet("/gestioneConti")
public class gestioneConti extends HttpServlet {
	
	@EJB
	private BusinessConti businessConti;
	@EJB
	private GestioneComanda gestioneComanda;
	private static final long serialVersionUID = 1L;
       
    
    public gestioneConti() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( !JSONResponse.UserAccessControl(request, response, JSONResponse.PRIV_Cameriere))
			return;

		int idTavolo = 0;
		if(request.getParameter("idTavolo")!= null)
			idTavolo = Integer.parseInt(request.getParameter("idTavolo"));
		
		if(request.getParameter("action").equals("GET_CONTO")) {
			
			/* ******************************************************************
			 * Richiedo la lista di tutte le ordinazioni alla logica di business 
			 ********************************************************************/
			
			try {
				
				List<WrapperComanda> listaComande = businessConti.getConto(idTavolo);
				JSONArray jsonArrayComande = new JSONArray();
				
				for(WrapperComanda comanda : listaComande) {
					
					TreeNodeVoceMenu voceMenu = 
							gestioneComanda.getVoceMenuByComanda(comanda.getIdComanda());
					
					
					JSONObject jsonObjectComanda = new JSONObject();
					
					/* ********************************************************
					 * Informazioni necessarie relative al conto da passare
					 * al client:
					 * - idRemoto comanda
					 * - nome della voce di menu associata
					 * - note
					 * - stato 
					 * - array degli id delle variazioni (le variazioni hanno gli
					 * 	stessi id sia su client che su server
					 * - quantità
					 ***********************************************************/
					
					jsonObjectComanda.put("idRemoto", comanda.getIdComanda());
					jsonObjectComanda.put("idVoceMenu", voceMenu.getIdVoceMenu());
					jsonObjectComanda.put("note", comanda.getNote());
					jsonObjectComanda.put("quantita", comanda.getQuantita());
					jsonObjectComanda.put("stato", comanda.getStato());
					
					/* **********************************************************
					 * Costruisco l'array degli id delle variazioni associate 
					 * alla comanda che sto considerando
					 ************************************************************/
					JSONArray jsonArrayVariazioni = new JSONArray();
					
					
					for(Integer idVariazione : comanda.getListIdVariazioni()) {
						JSONObject jsonObjectIdVariazione = new JSONObject();
						jsonObjectIdVariazione.put("id", idVariazione);
						jsonArrayVariazioni.put(jsonObjectIdVariazione);
					}
					
					jsonObjectComanda.put("variazioni", jsonArrayVariazioni);
					jsonArrayComande.put(jsonObjectComanda);
				}
				
				JSONResponse.WriteOutput(response,true, "", "comande", jsonArrayComande);
				
			} catch (DatabaseException e) {
				JSONResponse.WriteOutput(response,  false, e.toString());
				
			}
		}
	}
}
