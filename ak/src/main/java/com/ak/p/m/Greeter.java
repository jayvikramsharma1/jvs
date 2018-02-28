package com.ak.p.m;

import com.ak.p.m.Printer.Greeting;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Greeter extends AbstractActor {
	private final String message;
	private final ActorRef printerActor;
	private String greeting = "";
	
	static public Props props(String message, ActorRef printerActor) {
		return Props.create(Greeter.class, () -> new Greeter(message, printerActor));
	}
	
	public Greeter(String message, ActorRef printerActor) {
		this.message = message;
		this.printerActor = printerActor;
	}
	
	static public class Greet {
		public Greet() {
			
		}
	}
	
	static public class WhoToGreet {
		public final String who;
		public WhoToGreet(String who) {
			this.who = who;
		}
	}
	
	@Override
	public Receive createReceive() {
		return receiveBuilder().match(WhoToGreet.class, wtg -> {
			this.greeting = message + ", " + wtg.who;
		}).match(Greet.class, x -> {
			printerActor.tell(new Greeting(greeting), getSelf());
		}).build();
	}

}
