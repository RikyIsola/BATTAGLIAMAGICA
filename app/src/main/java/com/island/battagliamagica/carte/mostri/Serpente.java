package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class Serpente extends Mostro
{
	public int rarita()
	{
		return 0;
	}
	public int punti()
	{
		return 2;
	}
	public String nome()
	{
		return"SERPENTE";
	}
	public int immagine()
	{
		return R.drawable.serpente;
	}
	public int attacco()
	{
		return 3;
	}
	public int difesa()
	{
		return 2;
	}
}
