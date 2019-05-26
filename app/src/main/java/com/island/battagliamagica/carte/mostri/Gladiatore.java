package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class Gladiatore extends Mostro
{
	public int rarita()
	{
		return 1;
	}
	public int punti()
	{
		return 4;
	}
	public String nome()
	{
		return"GLADIATORE";
	}
	public int immagine()
	{
		return R.drawable.gladiatore;
	}
	public int attacco()
	{
		return 4;
	}
	public int difesa()
	{
		return 4;
	}
	public boolean guardia()
	{
		return true;
	}
}
