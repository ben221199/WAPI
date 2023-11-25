package nl.ben221199.wapi.fun.token;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractList extends Token{
	protected String className = "AbstractList";

	protected short length;
	protected List<Token> items = new ArrayList<>();

	public AbstractList(byte token){
		super(token);
	}

	public List<Token> getItems(){
		return this.items;
	}

	@Override
	public String toString() {
		return className +
				"length=" + length +
				", items=" + items +
				'}';
	}

}