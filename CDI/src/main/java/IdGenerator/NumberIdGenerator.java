package IdGenerator;

import IdGenerator.Qualifiers.NumberIdentificator;

@NumberIdentificator
public class NumberIdGenerator implements IdGenerator {
	
	public int lastId;
	
	public NumberIdGenerator() {
		this.lastId = 0;
	}
	
	public String getId() {
		String newId =  new Integer(this.lastId).toString();
		this.lastId++;
		return newId;
	}

}
