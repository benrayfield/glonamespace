package glonamespace.action;

import glonamespace.Name;

/** Similar to an HttpRequest object, except a different protocol
that may be built on top of HTTP or UDP or in memory of 1 computer or a database
or a variety of possible lower layers.
*/
public class Action{
	
	//TODO rename Action to Request
	
	/** the password, which allows spending of perserverMoney at this server */
	public final Name perserverMoneyVar;
	
	/** This Request/Action only requests something be done if Server.currentPriceMultiplier() is at most this.
	This param balances supply and demand of server resources in realtime.
	*/
	public final double maxPriceMultiplier;
	

}
