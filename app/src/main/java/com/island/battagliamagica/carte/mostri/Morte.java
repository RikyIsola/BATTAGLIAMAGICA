package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class Morte extends Mostro
{
	public int rarita()
	{
		return 2;
	}
	public int punti()
	{
		return 7;
	}
	public String nome()
	{
		return"MORTE";
	}
	public int immagine()
	{
		return R.drawable.morte;
	}
	public int attacco()
	{
		return 4;
	}
	public int difesa()
	{
		return 3;
	}
	public void usa(final PortaMostro questo)
	{
		questo.t.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro selezionato)
			{
				if(selezionato!=questo&&selezionato.carta!=null)
				{
					selezionato.danneggia(selezionato.difesa-selezionato.danni);
					return true;
				}
				else return false;
			}
		};
	}
}
