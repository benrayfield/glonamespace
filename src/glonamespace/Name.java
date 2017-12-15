package glonamespace;

import java.util.function.Consumer;

/** A name can be both isHashname and isUrl to suggest that the value of such a hashname,
and values of related hashnames, might be found at that url.
byteSize() of a Name is the size of the name, not its allowed sizes of values.
*/
public interface Name extends Ob{
	
	/** True if points at a constant data */
	public boolean isHashname();
	
	/** True if is a mutable var that refers to the current contents of a certain url,
	writable only by the software running at ipOrWebsitename:port,
	with implied permission for everyone in the network to redundantly mirror that value in realtime.
	The timerange means the server at that url only offers itself during that timerange,
	instead of necessarily to become a permanent part of the network. Such timerange
	could optionally be now plus/minus a million years to practically be permanent. 
	<br><br>
	Make sure to obey robots.txt to avoid accidentally helping to create DoSAttacks.
	*/
	public boolean isUrlAtTimeRange();
	
	/** Example: Value of max time that was digsigned by a certain pubkey. Example: ufnode goalFuncNamespace name */
	public boolean isFuzzyRecog();
	
	/** All sizes are in bits. Some Names specify limits on what the values can be */
	public long maxValueSize();
	
	public void tryGetAsync(double priority, double maxWait, Consumer<Name> listener);
	
	/** Inused after tryGetAsync when Consumer<Name> listener is called */
	public Val instantGetOrNull();

}