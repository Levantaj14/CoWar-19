import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is just an example. You can delete it or change the code.
 * It's not necessary for the scrolling system.
 */
public class Firsty_glo extends ScrollingActor
{
    GreenfootSound ded=new GreenfootSound("ded.wav");
    GreenfootSound cough=new GreenfootSound("cough.wav");
    public boolean press=false;
    public boolean direction=true;
    private int counter=0;
    private int anim=0;
    private int anim_=0;
    public int health=50;
    private int hol=0;
    private int hm=0;
    public boolean touch_it=false;
    public boolean its_down=true;
    public void act() 
    {
       
        getWorld().showText("❤ x"+health/10,70,80);
        int scored = ((Level_3)getWorld()).score;
        if(health>0)
        {
            if (isTouching(mask.class)) touch_it=true;
            if (scored==500){
                 if(its_down){
                     ///aparitia mastii
                     getWorld().addObject(new mask(),1180,600); 
                     its_down=false;
                 }
            }
            else {
                ///adaugarea patogenilor
                hol=Greenfoot.getRandomNumber(200);
                if (hol==50) getWorld().addObject(new virus_2(), 2000, 450);
                else if (hol==60) getWorld().addObject(new virus_2(), 0, 450);
            }
            if(!touch_it)
            {
        if(Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("x"))
        {
            setLocation(getX()-10,getY());
            anim_++;
            //animatia playerului
            if(anim_==5){
                setImage("anim1_inv_glo.png");
                
            }
            else if (anim_==10){
                setImage("anim2_inv_glo.png");
                
            }
            else if (anim_==15){
                setImage("anim3_inv_glo.png");
              
               
            }
            else if(anim_==20){
                setImage("anim4_inv_glo.png");
              
            }
            else if (anim_==25){
                setImage("anim5_inv_glo.png");
               
            }
            else if(anim_==30){
                setImage("anim6_inv_glo.png");
                
            }
            else if (anim_==35){
                setImage("anim7_inv_glo.png");
               
            }
            else if (anim_==40){
                setImage("anim8_inv_glo.png");
               
                anim_=0;
                
            }
            direction=false;
        }
        if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("x")) 
        {
            
            setLocation(getX()+10,getY());
            anim++;
            //animatia playerului
            if(anim==5){
                setImage("anim1_glo.png");
                
            }
            else if (anim==10){
                setImage("anim2_glo.png");
                
            }
            else if (anim==15){
                setImage("anim3_glo.png");
               
               
            }
            else if(anim==20){
                setImage("anim4_glo.png");
               
            }
            else if (anim==25){
                setImage("anim5_glo.png");
               
            }
            else if(anim==30){
                setImage("anim6_glo.png");
                
            }
            else if (anim==35){
                setImage("anim7_glo.png");
               
            }
            else if (anim==40){
                setImage("anim8_glo.png");
                
                anim=0;
                
            }
            
            
            
            direction=true;
        }//intoarcerea caracterului
        if(direction && !Greenfoot.isKeyDown("left") &&  !Greenfoot.isKeyDown("right")) setImage("player_glo.png");
        else if(!direction && !Greenfoot.isKeyDown("left") &&  !Greenfoot.isKeyDown("right")) setImage("player_inv_glo.png");
      
        if(!Greenfoot.isKeyDown("x")) press=false;
        if(Greenfoot.isKeyDown("x") && !press) 
        {
            press=true;
            //trage
            checkFire();
        }
        if(Greenfoot.isKeyDown("x")){
            
            if(direction) setImage("player shoot_glo.png");
            else setImage("player shoot_inv_glo.png");
        }
        if(isTouching(virus_2.class)) {
            //dmg taken
            health-=10;
            if (health>0) cough.play();
        }
       
    }
    else 
    {
        //poza pnetru final de nivel
       getWorld().addObject(new level3_end(),640,360); 
    }
    
    }
    else if(hm==0){
        //moartea caracterului
            setImage("player_glo_ded.png");
            getWorld().addObject(new g_over(), 640, 200);
            getWorld().addObject(new retry_3(), 640, 260);
            getWorld().addObject(new main_menu(), 640, 305);
            turn(-90);
            setLocation(getX(),getY()+30);
            ded.play();
            hm=1;
            
        }
    }
   
    
    
    public void checkFire()
    {
        //trage
        Greenfoot.playSound("pew.wav");
        if(direction) getWorld().addObject(new bullet_soapy(), getX()+150, getY()-7);
        else getWorld().addObject(new bullet_left_soapy(), getX()-150, getY()-7);
   
    }
}