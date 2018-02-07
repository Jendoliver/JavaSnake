package com.jendoliver.engine;

public class Vector2 
{
	public int X;
	public int Y;
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2 other = (Vector2) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		return true;
	}
}
