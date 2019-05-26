package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;

public class Vento extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.vento;
	}
	public String nome()
	{
		return"VENTO";
	}
	public int punti()
	{
		return 1;
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
						po.danneggia(1);
						if(po.morto())a--;
					}
					return true;
				}
				else return false;
			}
		};
	}
}
