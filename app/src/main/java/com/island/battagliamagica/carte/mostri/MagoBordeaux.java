package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class MagoBordeaux extends Mostro
{
	public int rarita()
	{
		return 1;
	}
	public int punti()
	{
		return 3;
	}
	public String nome()
	{
		return"MAGO BORDEAUX";
	}
	public int immagine()
	{
		return R.drawable.magobordeaux;
	}
	public int attacco()
	{
		return 3;
	}
	public int difesa()
	{
		return 3;
	}
	public String tipo()
	{
		return"MAGO";
	}
	public void usa(PortaMostro questo)
	{
		for(PortaMostro p:questo.t.campo)if(p!=questo&&p.team==questo.team&&"MAGO".equals(p.carta.tipo()))
		{
			questo.attacco++;
			questo.difesa++;
		}
	}
	public void evocato(PortaMostro questo,PortaMostro chi)
	{
		if(questo!=chi&&questo.team==chi.team&&"MAGO".equals(chi.carta.tipo()))
			{
				questo.attacco++;
				questo.difesa++;
			}
	}
	public void distrutto(PortaMostro questo,PortaMostro chi)
	{
		if(questo!=chi&&questo.team==chi.team&&"MAGO".equals(chi.carta.tipo()))
		{
			questo.attacco--;
			questo.difesa--;
		}
	}
}
