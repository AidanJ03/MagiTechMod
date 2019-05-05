package aidanj03.magitechmod.energy;

public interface ILumens 
{
	public void consume(float points);
	public void fill(float points);
	public void set(float points);
	
	public float getLumens();
}
