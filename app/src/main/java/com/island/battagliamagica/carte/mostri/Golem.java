package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;

public class Golem extends Mostro
{
	public int rarita()
	{
		return 2;
	}
	public int punti()
	{
		return 6;
	}
	public String nome()
	{
		return"GOLEM";
	}
	public int immagine()
	{
		return R.drawable.golem;
	}
	public int attacco()
	{
		return 6;
	}
	public int difesa()
	{
		return 7;
	}
}
