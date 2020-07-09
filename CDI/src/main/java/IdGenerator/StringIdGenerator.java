package IdGenerator;

import IdGenerator.Qualifiers.StringIdentificator;

@StringIdentificator
public class StringIdGenerator implements IdGenerator{
	
	private int asciiPointer;
	
	public StringIdGenerator() {
		this.asciiPointer = 0;
	}
	
	public String getId() {
		String result = "ABS-1A" + (char) this.asciiPointer;
		this.asciiPointer++;
		
		return result;
	}

}
