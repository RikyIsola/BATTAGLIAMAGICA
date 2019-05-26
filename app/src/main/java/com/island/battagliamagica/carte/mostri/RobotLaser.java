package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;

public class RobotLaser extends Mostro
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
		return"ROBOT LASER";
	}
	public int immagine()
	{
		return R.drawable.robotlaser;
	}
	public int attacco()
	{
		return 7;
	}
	public int difesa()
	{
		return 5;
	}
	public void usa(final PortaMostro questo)
	{
		questo.t.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro selezionato)
			{
				if(selezionato!=questo&&selezionato.carta!=null)
				{
					selezionato.danneggia(3);
					return true;
				}
				else return false;
			}
		};
	}
}
