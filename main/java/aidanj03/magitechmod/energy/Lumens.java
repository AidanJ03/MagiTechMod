package aidanj03.magitechmod.energy;

public class Lumens implements ILumens
{
	private float lumens = 500.0F;

	public void consume(float points)
	{
		this.lumens -= points;

		if (this.lumens < 0.0F) this.lumens = 0.0F;
	}

	public void fill(float points)
	{
		this.lumens += points;
	}

	public void set(float points)
	{
		this.lumens = points;
	}

	public float getLumens()
	{
		return this.lumens;
	}
}