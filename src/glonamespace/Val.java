package glonamespace;

/** Can be a literal bytestring (after a 1 byte prefix) (including float[], int[], etc)
or maplist or other basics that more complex structured types are made of.
There should be a very small number of core types, like theres a very small number of
types that can occur in json, except this is binary.
*/
public interface Val extends Ob{
	
	public boolean isPrimitiveNDimArray();
	
	/** If so, can contain any Obs, such as other Name.
	To contain a Val, it would wrap that Val in a Name with a 1 byte prefix so its size is 1+val.byteSize(),
	or could use a sha256 hashname.
	*/
	public boolean isMaplist();
	
	/** If this value [TODO which do I mean: is or contains] only 1 thing and its a name */
	public boolean isName();
	
	//public boolean isString();
	
	//public boolean isNumber();

}
