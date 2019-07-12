package com.island.battagliamagica.carte;
import com.island.battagliamagica.*;

public abstract class Carta
{
	public abstract int immagine();
	public abstract String nome();
	public abstract int punti();
	public abstract int rarita();
	int id;
	public int id()
	{
		return id;
	}
}
