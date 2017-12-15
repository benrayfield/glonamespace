package glonamespace;

/** All peers are servers. The only thing anyone sends to a server is a Name
which is a suggestion for that Server to download the current value of that Name
which may interest the Server to explore related Names and get into
openended interactive evolution of social and technical processes.
Its very important that Server reject any data larger than a Name (such as max 100 bytes)
pushed to that Server and only accept bigger things (Values) that the Server
CHOOSES to download. IP spoofing is impractical since a fake IP cant be contacted,
and all incoming Names are interpreted as from anonymous sender.
<br><br>
Name perserverMoneyVar is a secret name that a Server may give to anyone,
and its value decreases as server resources (such as downloads, ufnode computing, etc)
are consumed. Anyone who has that Name can spend it, though there can be
readonly views of it that happen to be other Name,
such as maybe call it "readonly_"+sha256Base64(perserverMoneyVar).
*/
public interface Server{
	
	public Response event(Request a);
	
	/** Since the rate of spending money (for server resources) on this server varies,
	but the server has a constant amount of hardware resources per moment of time,
	price is scaled by total amount spent, so the total resources available at that moment
	usually equals the total resources available.
	*/
	public double currentPriceMultiplier();
	
	public double moneyDecayPerSecond();
	
	/** The password used by those who dont specify a password that might allow them to use more server resources
	than this more general one.
	*/
	public Name publicPassword();
	
	/** Same as readonlyTargetOfPasswordMoneyVar(publicPassword()).
	The maybe something like "readonly_"+sha256Base64(perserverMoneyVar) of publicPassword()
	for if someone wants to donate to what the public can use here.
	*
	public Name publicPasswordReadonlyTarget();
	*/
	
	/** The maybe something like "readonly_"+sha256Base64(perserverMoneyVar) */
	public Name readonlyTargetOfPasswordMoneyVar(Name perserverMoneyVar);
	
	/** If Val.isMaplist() then there can be Names/Vals inside eachother,
	many of which (by hashname) the anonymous caller may already have.
	*/
	public Val[] get(Name perserverMoneyVar, Name[] n, byte maxRecursiveDepth, long maxTotalBits);
	
	/** This is the main way peers find eachother, by recommending names that eachother might want to download
	and look into related names.
	The server may choose to add to the perserverMoneyVar if later those recommends are useful,
	but normally a perserverMoneyVar's value only decreases,
	except when value is transferred between them.
	*/
	public boolean recommend(Name perserverMoneyVar, Name[] n);
	
	/** moves unsecure "game money" between 2 vars, one being a password that only exists
	at this server and whoever's password it is,
	and the other being a readonly view of the hash of someone else's password,
	so you dont have to know someone's password to send perserverMoney to it.
	perserverMoney has value backed by its ability to use server resources such as bandwidth
	and in-memory storage of new account names and maybe other services to be negotiated later.
	*/
	public boolean pay(Name perserverMoneyVarFrom, Name readonlyViewOfPerserverMoneyVarTo, double amount, double transactionFee);
	
	/** Similar to titForTat.
	This is a slow call compared to the others since it waits for this server to,
	if it chooses to try the given money var, try spending it on the other server,
	if it happens to have any RECOMMENDED Names which can be found on that other server
	(such as hashnames/constants and mutable vars only writable by that server).
	Returns a new password of money that can only be spent on this server, or null if refused.
	*/
	public Name incomingMoneyAndorProofofworkOnRemoteServerAskForMoneyOnThisServer(
		Name perserverMoneyVarOnRemote_optionallyIncluding_proofOfWorkInTheName);
	
	

}
