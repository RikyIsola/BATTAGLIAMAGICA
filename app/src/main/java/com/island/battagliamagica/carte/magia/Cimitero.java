package com.island.battagliamagica.carte.magia;
import com.island.*;
import com.island.battagliamagica.*;

public class Cimitero extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.cimitero;
	}
	public String nome()
	{
		return"CIMITERO";
	}
	public int punti()
	{
		return 1;
	}
	public void usa(final Team questo)
	{
		questo.campo=Lista.aggiungi(questo.campo,new PortaMostro(questo,questo.schermo().carte.Scheletro,questo.team));
		questo.campo=Lista.aggiungi(questo.campo,new PortaMostro(questo,questo.schermo().carte.Scheletro,questo.team));
		questo.inizializzaCampo();
	}
}
