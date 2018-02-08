package com.jendoliver.engine.event;

/**
 * Functional interface for listening and react to CollisionEvents
 * 
 * @author Jendoliver
 *
 */
public interface CollisionEventListener
{
	void onCollisionEvent(CollisionEvent e);
}
