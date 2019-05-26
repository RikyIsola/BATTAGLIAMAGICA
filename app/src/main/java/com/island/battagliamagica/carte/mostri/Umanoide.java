package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class Umanoide extends Mostro
{
	public int rarita()
	{
		return 2;
	}
	public int punti()
	{
		return 5;
	}
	public String nome()
	{
		return"UMANOIDE";
	}
	public int immagine()
	{
		return R.drawable.umanoide;
	}
	public int attacco()
	{
		return 0;
	}
	public int difesa()
	{
		return 5;
	}
	public void danneggiato(PortaMostro questo,int danni)
	{
		questo.attacco++;
		questo.t.inizializzaCampo();
	}
}
