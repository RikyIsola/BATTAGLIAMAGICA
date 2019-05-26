package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;

public class IronMan extends Mostro
{
	public int rarita()
	{
		return 0;
	}
	public int punti()
	{
		return 5;
	}
	public String nome()
	{
		return"IRON MAN";
	}
	public int immagine()
	{
		return R.drawable.ironman;
	}
	public int attacco()
	{
		return 4;
	}
	public int difesa()
	{
		return 7;
	}
}
