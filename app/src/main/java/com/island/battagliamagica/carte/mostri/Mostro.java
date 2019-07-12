package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.carte.*;
import com.island.battagliamagica.*;
public abstract class Mostro extends Carta
{
	public abstract int attacco();
	public abstract int difesa();
	public void inizioAttacco(PortaMostro questo,PortaMostro bersaglio){}
	public void fineAttacco(PortaMostro questo,PortaMostro bersaglio){}
	public void usa(PortaMostro questo){}
	public void evocato(PortaMostro questo,PortaMostro chi){}
	public void distrutto(PortaMostro questo,PortaMostro chi){}
	public void danneggiato(PortaMostro questo,int danni){}
	public boolean guardia(){return false;}
	public boolean trasparente(){return false;}
	public String tipo(){return null;}
}
