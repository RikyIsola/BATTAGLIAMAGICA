package com.island.battagliamagica.carte;
import com.island.battagliamagica.carte.magia.*;
import com.island.battagliamagica.carte.mostri.*;
public class Carte
{
	public SlimeBlu SlimeBlu=new SlimeBlu();
	public SlimeRosso SlimeRosso=new SlimeRosso();
	public SlimeVerde SlimeVerde=new SlimeVerde();
	public Mazzo Mazzo=new Mazzo();
	public Serpente Serpente=new Serpente();
	public MagoDelFuoco MagoDelFuoco=new MagoDelFuoco();
	public BacchettaMagica BacchettaMagica=new BacchettaMagica();
	public DistruzionePianeta DistruzionePianeta=new DistruzionePianeta();
	public Fulmine Fulmine=new Fulmine();
	public FungoMagico FungoMagico=new FungoMagico();
	public Gladiatore Gladiatore=new Gladiatore();
	public Golem Golem=new Golem();
	public MagoDellAcqua MagoDellAcqua=new MagoDellAcqua();
	public Moneta Moneta=new Moneta();
	public PallaDiFuoco PallaDiFuoco=new PallaDiFuoco();
	public RobotLaser RobotLaser=new RobotLaser();
	public Sasso Sasso=new Sasso();
	public Vento Vento=new Vento();
	public CinghialeDiRame CinghialeDiRame=new CinghialeDiRame();
	public EvocazioneSlime EvocazioneSlime=new EvocazioneSlime();
	public PozioneRossa PozioneRossa=new PozioneRossa();
	public MagoBordeaux MagoBordeaux=new MagoBordeaux();
	public Morte Morte=new Morte();
	public Cinghiale Cinghiale=new Cinghiale();
	public Banana Banana=new Banana();
	public Umanoide Umanoide=new Umanoide();
	public PallaDiFuocoPortatile PallaDiFuocoPortatile=new PallaDiFuocoPortatile();
	public CartaInfinita CartaInfinita=new CartaInfinita();
	public IronMan IronMan=new IronMan();
	public Scheletro Scheletro=new Scheletro();
	public Cimitero Cimitero=new Cimitero();
	public Fantasma Fantasma=new Fantasma();
	public Carta[]carte=
	{
		SlimeBlu,SlimeRosso,SlimeVerde,Mazzo,Serpente,MagoDelFuoco,BacchettaMagica,DistruzionePianeta,Fulmine,FungoMagico,
		Gladiatore,Golem,MagoDellAcqua,Moneta,PallaDiFuoco,RobotLaser,Sasso,Vento,CinghialeDiRame,EvocazioneSlime,
		PozioneRossa,MagoBordeaux,Morte,Cinghiale,Banana,Umanoide,PallaDiFuocoPortatile,CartaInfinita,IronMan,Scheletro,
		Cimitero,Fantasma
	};
	public Carta[]rarita;
	public Carte()
	{
		int numero=0;
		for(int a=0;a<carte.length;a++)
		{
			carte[a].id=a;
			numero+=4-carte[a].rarita();
		}
		rarita=new Carta[numero];
		int index=0;
		for(int a=0;a<carte.length;a++)for(int b=0;b<4-carte[a].rarita();b++)
		{
			rarita[index]=carte[a];
			index++;
		}
	}
	public Carta trova(String nome)
	{
		for(Carta c:carte)if(c.nome().equals(nome))return c;
		return null;
	}
}
