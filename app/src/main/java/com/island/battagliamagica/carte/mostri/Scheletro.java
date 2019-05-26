package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class Scheletro extends Mostro
{
	public int rarita()
	{
		return 0;
	}
	public int punti()
	{
		return 1;
	}
	public String nome()
	{
		return"SCHELETRO";
	}
	public int immagine()
	{
		return R.drawable.scheletro;
	}
	public int attacco()
	{
		return 0;
	}
	public int difesa()
	{
		return 2;
	}
	public boolean guardia()
	{
		return true;
	}
}
