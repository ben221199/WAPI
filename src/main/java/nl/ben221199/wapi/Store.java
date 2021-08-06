package nl.ben221199.wapi;

import java.io.File;
import java.io.IOException;

public class Store{

	private String id;
	private JSONSignalStore store = new JSONSignalStore();

	public Store(){}

	public Store(String id,JSONSignalStore store){
		this.id = id;
		this.store = store;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id = id;
	}

	public JSONSignalStore getStore(){
		return this.store;
	}

	public void save() throws IOException{
		Store.saveStore(this.id,this);
	}

	private static JSONSignalStore loadFile(String id) throws IOException{
		return JSONSignalStore.load(new File("configs/"+id+".json"));
	}

	public static Store loadStore(String id) throws IOException{
		Store s = new Store();
		s.id = id;
		s.store = Store.loadFile(id);
		return s;
	}

	private static void saveFile(String id,JSONSignalStore content) throws IOException{
		content.save(new File("configs/"+id+".json"));
	}

	public static void saveStore(String id,Store store) throws IOException{
		Store.saveFile(id,store.store);
	}

}