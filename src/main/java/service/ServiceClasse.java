package service;

import java.util.List;

import dao.DAOClasse;
import model.Classe;

public class ServiceClasse {

	public static List<Classe> getAllClasses() {
		return DAOClasse.getAllClasses();
	}

	public static Classe getClasseById(int id) {	
		return DAOClasse.getClasseById(id);
	}
	
	public static void AddClasse(Classe classe) {	
		DAOClasse.createClasse(classe);
	}
	
	public static void updateClasse(Classe classe) {	
		DAOClasse.updateClasse(classe);
	}

	public static void deleteClasse(Classe myClasse) {
		DAOClasse.deleteClasse(myClasse);	
	}

	public static Classe getClasseByIdEagerly(int id) {
		return DAOClasse.getClasseByIdEagerly(id);
	}

}
