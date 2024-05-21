package voleibol.controllers;

import voleibol.model.Equipo;
import voleibol.model.Socio;

public class SocioController extends SuperControladorJPA {

	
	private static SocioController instance = null;
	
	
	public SocioController() {
		super("socio", Socio.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static SocioController getInstance() {
		if (instance == null) {
			instance = new SocioController();
		}
		return instance;
	}
	
}