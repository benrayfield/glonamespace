package glonamespace;

import java.util.function.Consumer;

/** global namespace */
public interface GloNs{
	
	TODO some way to abstract the gametheory of perserverMoney and where to get them etc,
	and just put a priority on which vars want to get and by what time,
	so can use it as a simple global namespace.
	
	/** This is optional (may be null) but in some cases can help to provide value
	(in use of its bandwidth, memory, etc) to other Servers in the p2p net
	which raises the chance of downloading values of the vars you want.
	*/
	public Server myServerOrNull();
	
	public void tryGetAsync(Name n, double priority, double maxWait, Consumer<Name> listener);
	
	//public void cancelTryGetAsync(Name n);
	
	/** used after tryGetAsync when Consumer<Name> listener is called */
	public Val instantGetOrNull(Name n);
	
	/** This is only allowed for Names which
	anyone who sees that name can see it refers to inet address of myServerOrNull(),
	and if a request comes in for it, such local Server will answer with such Val,
	conditional on perserverMoney of the request being enough.
	If Val is null, deletes locally.
	*/
	public void instantWriteLocal(Name n, Val v);
	
	/** All sizes are in bits unless otherwise specified. max bit size of value is encoded in some names */
	public long maxValueSize(Name n);

}