import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is just an example. You can delete it or change the code.
 * It's not necessary for the scrolling system.
 */
public class Firsty extends ScrollingActor
{
    ///actorul primului nivel
    GreenfootSound cough=new GreenfootSound("cough.wav");
    public boolean press=false;
    public boolean direction=true;
    private int counter=0;
    private int anim=0;
    private int anim_=0;
    public int health=30;
    private int hol=0;
    private int hm=0;
    public boolean touch_it=false;
    public boolean its_down=true;
    GreenfootSound ded=new GreenfootSound("ded.wav");
    public void act() 
    {
       
        getWorld().showText("❤ x"+health/10,70,80);
        int scored = ((Level_1)getWorld()).score;
        if(health>0)
        {
            //apare poza din nivelul 1
            if (isTouching(soap.class)) touch_it=true;
            if (scored==100){
                 if(its_down){
                     getWorld().addObject(new soap(),1180,600); 
                     its_down=false;
                 }
            }
            else {
                ///adaugam virusi random
                hol=Greenfoot.getRandomNumber(200);
                if (hol==50) getWorld().addObject(new virus_1(), 2000, 450);
                else if (hol==60) getWorld().addObject(new virus_1(), 0, 450);
            }
            if(!touch_it)
            {
        if(Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("x"))
        {
            ///mergem in stanga
            setLocation(getX()-10,getY());
            anim_++;
            ///animatii
            if(anim_==5){
                setImage("anim1_inv.png");
                
            }
            else if (anim_==10){
                setImage("anim2_inv.png");
                
            }
            else if (anim_==15){
                setImage("anim3_inv.png");
               
               
            }
            else if(anim_==20){
                setImage("anim4_inv.png");
               
            }
            else if (anim_==25){
                setImage("anim5_inv.png");
               
            }
            else if(anim_==30){
                setImage("anim6_inv.png");
                
            }
            else if (anim_==35){
                setImage("anim7_inv.png");
               
            }
            else if (anim_==40){
                setImage("anim8_inv.png");
                
                anim_=0;
                
            }
            direction=false;
        }
        if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("x")) 
        {
            ///mergem in dreapta
            setLocation(getX()+10,getY());
            anim++;
            ///animatii
            if(anim==5){
                setImage("anim1.png");
                
            }
            else if (anim==10){
                setImage("anim2.png");
                
            }
            else if (anim==15){
                setImage("anim3.png");
               
               
            }
            else if(anim==20){
                setImage("anim4.png");
               
            }
            else if (anim==25){
                setImage("anim5.png");
               
            }
            else if(anim==30){
                setImage("anim6.png");
                
            }
            else if (anim==35){
                setImage("anim7.png");
               
            }
            else if (anim==40){
                setImage("anim8.png");
               
                anim=0;
                
            }
            
            
            direction=true;///directia playerului (true==dreapta)
        }
        if(direction && !Greenfoot.isKeyDown("left") &&  !Greenfoot.isKeyDown("right")) setImage("player.png");
        else if(!direction && !Greenfoot.isKeyDown("left") &&  !Greenfoot.isKeyDown("right")) setImage("player_inv.png");
      
        if(!Greenfoot.isKeyDown("x")) press=false;
        if(Greenfoot.isKeyDown("x") && !press) 
        {
            press=true;
            checkFire();
        }
        if(Greenfoot.isKeyDown("x")){
            if(direction) setImage("player shoot.png");
            else setImage("player shoot_inv.png");
        }
        if(isTouching(virus_1.class)) {
            health-=10;
            if (health>0)cough.play();
        }
       
    }
    else 
    {
       getWorld().addObject(new level1_end(),640,360); 
    }
    
    }
    else if(hm==0){
        ///moartea playerului
            setImage("player_ded.png");
            getWorld().addObject(new g_over(), 640, 200);
            getWorld().addObject(new retry_1(), 640, 260);
            getWorld().addObject(new main_menu(), 640, 305);
            turn(-90);
            setLocation(getX(),getY()+30);
            ded.play();
            hm=1;
            
        }
    }
   
    
    
    public void checkFire()
    {
        ///tragem
        Greenfoot.playSound("pew.wav");
        if(direction) getWorld().addObject(new bullet(), getX()+150, getY()-7);
        else getWorld().addObject(new bullet_left(), getX()-150, getY()-7);
   
    }
}