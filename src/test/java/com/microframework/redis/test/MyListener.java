package com.microframework.redis.test;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

public class MyListener extends JedisPubSub{

	
	// 处理订阅的消息
	@Override
	public void onMessage(String channel, String message) {
	
		System.out.println("channel:"+channel+"-----"+"message:"+message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("channel:"+channel+"-----"+"message:"+message);

	}

	// 初始化订阅时候的处理
	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		System.out.println("channel:"+channel+"----"+subscribedChannels);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onUnsubscribe(channel, subscribedChannels);
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		System.out.println("pattern:"+pattern+"----"+subscribedChannels);

	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("订阅 pattern:"+pattern+"----"+subscribedChannels);

	}

	@Override
	public void unsubscribe() {
		// TODO Auto-generated method stub
		super.unsubscribe();
	}

	@Override
	public void unsubscribe(String... channels) {
		// TODO Auto-generated method stub
		super.unsubscribe(channels);
	}

	@Override
	public void subscribe(String... channels) {
		// TODO Auto-generated method stub
		super.subscribe(channels);
	}

	@Override
	public void psubscribe(String... patterns) {
		// TODO Auto-generated method stub
		super.psubscribe(patterns);
	}

	@Override
	public void punsubscribe() {
		// TODO Auto-generated method stub
		super.punsubscribe();
	}

	@Override
	public void punsubscribe(String... patterns) {
		// TODO Auto-generated method stub
		super.punsubscribe(patterns);
	}

	@Override
	public boolean isSubscribed() {
		// TODO Auto-generated method stub
		return super.isSubscribed();
	}

	@Override
	public void proceedWithPatterns(Client client, String... patterns) {
		// TODO Auto-generated method stub
		super.proceedWithPatterns(client, patterns);
	}

	@Override
	public void proceed(Client client, String... channels) {
		// TODO Auto-generated method stub
		super.proceed(client, channels);
	}

	@Override
	public int getSubscribedChannels() {
		// TODO Auto-generated method stub
		return super.getSubscribedChannels();
	}
	
	
	

}
