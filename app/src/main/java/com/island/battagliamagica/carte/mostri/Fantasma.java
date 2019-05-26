package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;

public class Fantasma extends Mostro
{
	public int rarita()
	{
		return 1;
	}
	public int punti()
	{
		return 5;
	}
	public String nome()
	{
		return"FANTASMA";
	}
	public int immagine()
	{
		return R.drawable.fantasma;
	}
	public int attacco()
	{
		return 7;
	}
	public int difesa()
	{
		return 3;
	}
	public boolean trasparente()
	{
		return true;
	}
}
