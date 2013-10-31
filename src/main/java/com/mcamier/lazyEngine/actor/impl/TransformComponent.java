package com.mcamier.lazyEngine.actor.impl;

import javax.vecmath.Vector3f;

import com.mcamier.lazyEngine.actor.ComponentTypeEnum;
import com.mcamier.lazyEngine.actor.IActor;

public class TransformComponent extends Component {

	private Vector3f position;
	private Vector3f scale;
	private Vector3f rotation;
	
	
	public TransformComponent(IActor aActor) {
		super(aActor);
		position = new Vector3f();
		setScale(new Vector3f());
		setRotation(new Vector3f());
	}

	
	@Override
	public ComponentTypeEnum getType() {
		return ComponentTypeEnum.TRANSFORM;
	}


	public final Vector3f getPosition() {
		return position;
	}


	public final void setPosition(final Vector3f position) {
		this.position = position;
	}


	public final Vector3f getScale() {
		return scale;
	}


	public final void setScale(final Vector3f scale) {
		this.scale = scale;
	}


	public final Vector3f getRotation() {
		return rotation;
	}


	public final void setRotation(final Vector3f rotation) {
		this.rotation = rotation;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(int deltaTime) {
		// TODO Auto-generated method stub
		
	}
}
