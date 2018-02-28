package com.ak.p.m;

import java.io.IOException;

import com.ak.p.m.Greeter.Greet;
import com.ak.p.m.Greeter.WhoToGreet;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class PrintActorMain {
	public static void main(String[] args) throws IOException {
		final ActorSystem system = ActorSystem.create("Akkap1");
		
		final ActorRef printerActor = system.actorOf(Printer.props(), "printerActor");
		final ActorRef howdyGreeter = system.actorOf(Greeter.props("Howdy", printerActor), "howdyGreeter");
		final ActorRef helloGreeter = system.actorOf(Greeter.props("Hello", printerActor), "helloGreeter");
		final ActorRef goodDayGreeter = system.actorOf(Greeter.props("Good day", printerActor), "goodDayGreeter");
		
		howdyGreeter.tell(new WhoToGreet("Akka"), ActorRef.noSender());
		howdyGreeter.tell(new Greet(), ActorRef.noSender());
		howdyGreeter.tell(new WhoToGreet("Jay"), ActorRef.noSender());
		howdyGreeter.tell(new Greet(), ActorRef.noSender());
		
		helloGreeter.tell(new WhoToGreet("Jay"), ActorRef.noSender());
		helloGreeter.tell(new Greet(), ActorRef.noSender());
		
		goodDayGreeter.tell(new WhoToGreet("Jay"), ActorRef.noSender());
		goodDayGreeter.tell(new Greet(), ActorRef.noSender());
		System.out.println("Press Enter to exit");
		System.in.read();
	}
}
