package com.island.battagliamagica;
import com.island.*;
public class Vittoria extends Finestra
{
	private Battaglia battaglia;
	Vittoria(Schermo schermo,Battaglia battaglia,boolean[]vincitori)
	{
		super(schermo,android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		this.battaglia=battaglia;
		Gruppo g=new Gruppo(this,1,2);
		new Testo(g,0,1,1,2,(vincitori[0]?"HAI VINTO":"HAI PERSO")).carattere(0.3);
		new Testo(g,0,0,1,1,(vincitori[1]?"HAI VINTO":"HAI PERSO")).carattere(0.3).rotazione(180);
		g.aggiorna();
	}
	public void onStop()
	{
		battaglia.cancel();
		super.onStop();
	}
}
