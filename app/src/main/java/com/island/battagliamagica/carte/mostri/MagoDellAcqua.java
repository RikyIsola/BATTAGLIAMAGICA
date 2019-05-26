package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class MagoDellAcqua extends Mostro
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
		return"MAGO DELL ACQUA";
	}
	public int immagine()
	{
		return R.drawable.magodellacqua;
	}
	public int attacco()
	{
		return 2;
	}
	public int difesa()
	{
		return 4;
	}
	public void usa(final PortaMostro questo)
	{
		questo.t.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro selezionato)
			{
				if(selezionato!=questo&&selezionato.carta!=null)
				{
					selezionato.difesa+=1;
					selezionato.t.inizializzaCampo();
					return true;
				}
				else return false;
			}
		};
	}
	public String tipo()
	{
		return"MAGO";
	}
}
