package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;
public class FungoMagico extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.fungomagico;
	}
	public String nome()
	{
		return"FUNGO MAGICO";
	}
	public int punti()
	{
		return 3;
	}
	public void usa(final Team questo)
	{
		questo.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro p)
			{
				if(p.carta!=null)
				{
					if(p.team==questo.team)p.difesa+=3;
					else p.difesa-=3;
					p.t.inizializzaCampo();
					return true;
				}
				else return false;
			}
		};
	}
}
