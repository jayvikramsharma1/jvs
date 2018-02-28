package com.ak.p.m.devices;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.testkit.javadsl.TestKit;

import java.util.Optional;

import org.junit.Test;

public class Device extends AbstractActor {
	
	private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	final String groupId;
	final String deviceId;
	
	public Device(String groupId, String deviceId) {
		this.groupId = groupId;
		this.deviceId = deviceId;
	}
	
	public static Props props(String groupId, String deviceId) {
		return Props.create(Device.class, groupId, deviceId);
	}
	
	public static final class RecordTemperature {
		final long requestId;
		final double value;
		
		public RecordTemperature(long requestId, double value){
			this.requestId = requestId;
			this.value = value;
		}
	}
	public static final class TemperatureRecorded {
		final long requestId;
		public TemperatureRecorded(long requestId) {
			this.requestId = requestId;
		}
	}
	public static final class ReadTemperature {
		long requestId;
		public ReadTemperature(long requestId) {
			this.requestId = requestId;
		}
	}
	
	public static final class RespondTemperature {
		long requestId;
		Optional<Double> value;
		public RespondTemperature(long requestId, Optional<Double> value) {
			this.requestId = requestId;
			this.value = value;
		}
	}
	
	Optional<Double> lastTemperatureReading = Optional.empty();
	
	@Override
	public void preStart() {
		log.info("Device actor{}-{} Started", groupId, deviceId);
	}
	
	@Override
	public void postStop() {
		log.info("Device actor{}-{} Stopped", groupId, deviceId);
	}
	
	@Override
	public Receive createReceive() {
		return receiveBuilder().match(ReadTemperature.class, r -> {
			getSender().tell(new RespondTemperature(r.requestId, lastTemperatureReading), getSelf());
		}).build();
	}
}
