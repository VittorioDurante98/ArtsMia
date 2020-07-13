package it.polito.tdp.artsmia.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {
	
	private Graph<ArtObject, DefaultWeightedEdge> grafo;
	private Map<Integer, ArtObject> idMap;
	
	
	public Model() {
		idMap = new HashMap<>();
	}


	public void creaGrafo() {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		ArtsmiaDAO dao = new ArtsmiaDAO();
		dao.listObjects(idMap);
		
		//Aggiungere i vertici
		Graphs.addAllVertices(this.grafo, idMap.values());
		
		//Aggiungere gli archi
		//Approccio 1 --> doppio ciclo for sui vertici, dati due vertici, controllo se sono collegati
		/*for(ArtObject a1: this.grafo.vertexSet()) {
			for(ArtObject a2: this.grafo.vertexSet()) {
				//devo collegare a1 e a2?
				//controllo se l'arco c'è già
				int peso = dao.getPeso(a1, a2);
				if(!this.grafo.containsEdge(a1, a2)) {
					if(peso>0) {
						Graphs.addEdge(this.grafo, a1, a2, peso);
						}
				}
			}
		}*/
		//Approccio 2
		for(Adiacenza a :dao.getAdiacenze()) {
			if(a.getPeso() > 0) {
				Graphs.addEdge(this.grafo, idMap.get(a.getO1()), idMap.get(a.getO2()), a.getPeso());
			}
		}
		
		System.out.println("Grafo creato! Vertici "+this.grafo.vertexSet().size()+", Archi "+this.grafo.edgeSet().size());
		
	}
}
	


