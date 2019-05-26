package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;

public class SlimeRosso extends Mostro
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
		return"SLIME ROSSO";
	}
	public int immagine()
	{
		return R.drawable.slimerosso;
	}
	public int attacco()
	{
		return 1;
	}
	public int difesa()
	{
		return 2;
	}
	public void inizioAttacco(PortaMostro questo,PortaMostro bersaglio)
	{
		if(bersaglio.carta==bersaglio.t.schermo().carte.SlimeVerde)questo.attacco=2;
	}
	public void fineAttacco(PortaMostro questo,PortaMostro bersaglio)
	{
		if(questo.attacco==2)questo.attacco=1;
	}
}
