package com.island.battagliamagica;
import com.island.*;
import com.island.battagliamagica.*;
import com.island.battagliamagica.carte.*;
import com.island.battagliamagica.carte.mostri.*;
public class PortaMostro
{
	public Mostro carta;
	public int difesa,attacco,team,danni;
	public Team t;
	public boolean attaccare;
	public PortaMostro(Team t,Carta carta,int team)
	{
		if(carta!=null)
		{
			this.carta=(Mostro)carta;
			difesa=this.carta.difesa();
			attacco=this.carta.attacco();
		}
		this.team=team;
		this.t=t;
	}
	public void danneggia(int danno)
	{
		danni+=danno;
		carta.danneggiato(this,danno);
		if(danni>=difesa)
		{
			t.campo=Lista.rimuovi(t.campo,this);
			for(Team t:t.battaglia.giocatori)for(PortaMostro po:t.campo)po.carta.distrutto(po,this);
		}
		t.inizializzaCampo();
	}
	public boolean morto()
	{
		return danni>=difesa;
	}
}
