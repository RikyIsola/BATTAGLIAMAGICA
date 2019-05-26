package com.island.battagliamagica;
import com.island.*;
import com.island.battagliamagica.carte.*;
public class Descrizione extends Finestra
{
	Descrizione(Schermo schermo,Carta carta,boolean invertito)
	{
		super(schermo,schermo.dimensioni()[0]/2,schermo.dimensioni()[1]/2);
		Gruppo g=new Gruppo(this,1,1).immagine(carta.immagine());
		if(invertito)g.rotazione(180);
		g.aggiorna();
	}
}
