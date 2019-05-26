package com.island.battagliamagica.carte.magia;
import com.island.*;
import com.island.battagliamagica.*;
public class EvocazioneSlime extends Magia
{
	public int rarita()
	{
		return 1;
	}
	public int immagine()
	{
		return R.drawable.evocazioneslime;
	}
	public String nome()
	{
		return"EVOCAZIONE SLIME";
	}
	public int punti()
	{
		return 3;
	}
	public void usa(final Team questo)
	{
		questo.campo=Lista.aggiungi(questo.campo,new PortaMostro(questo,questo.schermo().carte.SlimeRosso,questo.team));
		questo.campo=Lista.aggiungi(questo.campo,new PortaMostro(questo,questo.schermo().carte.SlimeVerde,questo.team));
		questo.campo=Lista.aggiungi(questo.campo,new PortaMostro(questo,questo.schermo().carte.SlimeBlu,questo.team));
		questo.inizializzaCampo();
	}
}
