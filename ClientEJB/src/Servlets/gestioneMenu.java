package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utilita.JSONResponse;



/**
 * Servlet implementation class gestioneMenu
 */
@WebServlet("/gestioneMenu")
public class gestioneMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestioneMenu() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Controllo dei privilegi di accesso
    	if( !JSONResponse.UserAccessControl(request, response, JSONResponse.PRIV_Administrator) ){
    		return;
    	}
    	
    	
    	String node = request.getParameter("node");
		if(node == null){
			JSONResponse.WriteOutput(response, false, "Richiesta non valida");	return;
		}
		
		try{
			if(node.equals("root")){
				
			}else if(node.startsWith("C")){
				
			}else if(node.equals("V")){
				
			}
			
			
		}catch(Exception e){
			JSONResponse.WriteOutput(response, false, "Eccezione generale");	return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Controllo dei privilegi di accesso
    	if( !JSONResponse.UserAccessControl(request, response, JSONResponse.PRIV_Administrator) ){
    		return;
    	}
    	
    	
    	try{
			//CREATE
    		if(request.getParameter("action").equals("create")){
    			
    		//UPDATE
    		}else if(request.getParameter("action").equals("update")){
    			
    		//DELETE
    		}else if(request.getParameter("action").equals("delete")){
    			
    		}
			
    		//Caso del delete di default del datasource
    		JSONResponse.WriteOutput(response, true, "OK"); return;
			
		}catch(Exception e){
			JSONResponse.WriteOutput(response, false, "Eccezione generale");	return;
		}
    	
	}
}
