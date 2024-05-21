package voleibol.controllers;

import voleibol.model.Equipo;

public class EquipoController extends SuperControladorJPA {

	
	private static EquipoController instance = null;
	
	
	public EquipoController() {
		super("equipo", Equipo.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static EquipoController getInstance() {
		if (instance == null) {
			instance = new EquipoController();
		}
		return instance;
	}
	
}