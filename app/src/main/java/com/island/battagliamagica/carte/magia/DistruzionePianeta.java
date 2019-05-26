package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;
public class DistruzionePianeta extends Magia
{
	public int rarita()
	{
		return 3;
	}
	public int immagine()
	{
		return R.drawable.distruzionepianeta;
	}
	public String nome()
	{
		return"DISTRUZIONE PIANETA";
	}
	public int punti()
	{
		return 10;
	}
	public void usa(final Team questo)
	{
		questo.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro p)
			{
				if(p.team!=questo.team)
				{
					for(int a=0;a<p.t.campo.length;a++)
					{
						PortaMostro po=p.t.campo[a];
						po.danneggia(po.difesa-po.danni);
						a--;
					}
					return true;
				}
				else return false;
			}
		};
	}
}
