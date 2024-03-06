import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class emb_boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class emb_boss extends Actor
{
    /**
     * Act - do whatever the emb_boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int anim=0;
    private boolean once=false;
    private final int GRAVITY = 1;
    public  int huh=300;
    private int velocity;
    public boolean press=false;
    public boolean direction=true;
    public boolean is_ded=false;
    private int counter=0;
    private int animat=0;
    private int anim_=0;
    public int health=10;
    public int time=0;
    public boolean pressed_space=false;
    private int hm=0;
    public int jada=0;
    public boolean xpressed=false;
    GreenfootSound laught=new GreenfootSound("boss_laught.wav");
    GreenfootSound jump=new GreenfootSound("jump.wav");
    GreenfootSound weh=new GreenfootSound("weh.wav");
    GreenfootSound ded=new GreenfootSound("ded.wav");
    public void act() 
    {
        time++;///reincarcarea pistolului
        if(time>=1300 && !is_ded) getWorld().showText("ACUM POȚI OMORÎ VIRUSUL", 640,50); 
        getWorld().showText("❤ x"+health/10,70,80);//arata viata
        int scored = ((Boss_fight)getWorld()).score;//arata scorul
        ///cutscene
        while (getX()<=240) {
            Greenfoot.delay(1);
            move_it();
        }
        
        if(!once) {
            Greenfoot.delay(50);
            laught.play();
            once=true;
            getWorld().addObject(new blank(), 640, 360);
            Greenfoot.delay(100);
            getWorld().removeObjects(getWorld().getObjects(blank.class));
            getWorld().addObject(new boss(), 1100, 360);
        }
        if (once) controls();
    }
    
    //controls
    public void move_it(){
        setLocation(getX()+5,getY());
            animat++;
            ///animatia caracterului
            if(animat==5){
                setImage("anim1_glo_mask.png");
                
            }
            else if (animat==10){
                setImage("anim2_glo_mask.png");
                
            }
            else if (animat==15){
                setImage("anim3_glo_mask.png");
               
               
            }
            else if(animat==20){
                setImage("anim4_glo_mask.png");
               
            }
            else if (animat==25){
                setImage("anim5_glo_mask.png");
               
            }
            else if(animat==30){
                setImage("anim6_glo_mask.png");
                
            }
            else if (animat==35){
                setImage("anim7_glo_mask.png");
              
            }
            else if (animat==40){
                setImage("anim8_glo_mask.png");
                
                animat=0;
            }
    }
    
    public void controls()
    {
        if(health>0)
        {
        fall();///gravitatia
        
        //jumping
        if(Greenfoot.isKeyDown("space") && getY()>getWorld().getHeight()-huh)
        {
            setImage("player_glo_mask_jump.png");
            jump();
            jump.play();
        }
        
        if(Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("x") && xpressed)
        {
            setLocation(getX()-10,getY());
            anim_++;
            ///animatia caracterului
            if(anim_==5){
                setImage("anim1_inv_glo_mask.png");
                
            }
            else if (anim_==10){
                setImage("anim2_inv_glo_mask.png");
                
            }
            else if (anim_==15){
                setImage("anim3_inv_glo_mask.png");
               
               
            }
            else if(anim_==20){
                setImage("anim4_inv_glo_mask.png");
               
            }
            else if (anim_==25){
                setImage("anim5_inv_glo_mask.png");
               
            }
            else if(anim_==30){
                setImage("anim6_inv_glo_mask.png");
                
            }
            else if (anim_==35){
                setImage("anim7_inv_glo_mask.png");
               
            }
            else if (anim_==40){
                setImage("anim8_inv_glo_mask.png");
               
                anim_=0;
                
            }
            direction=false;
        }
        if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("x") && xpressed) 
        {
            
            setLocation(getX()+10,getY());
            anim++;
            //animatia caracterului
            if(anim==5){
                setImage("anim1_glo_mask.png");
                
            }
            else if (anim==10){
                setImage("anim2_glo_mask.png");
                
            }
            else if (anim==15){
                setImage("anim3_glo_mask.png");
               
               
            }
            else if(anim==20){
                setImage("anim4_glo_mask.png");
               
            }
            else if (anim==25){
                setImage("anim5_glo_mask.png");
            }
            else if(anim==30){
                setImage("anim6_glo_mask.png");
                
            }
            else if (anim==35){
                setImage("anim7_glo_mask.png");
               
            }
            else if (anim==40){
                setImage("anim8_glo_mask.png");
                
                anim=0;
                
            }
           
            
            direction=true;
        }
        if(direction && !Greenfoot.isKeyDown("left") &&  !Greenfoot.isKeyDown("right") && !pressed_space) setImage("player_glo_mask.png");
        
      
        if(!Greenfoot.isKeyDown("x")) press=false;
        if(Greenfoot.isKeyDown("x") && time>1300 && !press){
            if(direction) setImage("player shoot_glo_mask.png");
            else setImage("player shoot_inv_glo_mask.png");
            checkFire();
            press=true;
        }
        if( isTouching(virus_bullet.class) ){
            health-=10;
        }
    
        jada++;
        ///proiectilele virusului
        if(jada==150 && !xpressed)
        {
           if (Greenfoot.getRandomNumber(2)==1)getWorld().addObject(new virus_bullet(),1200,500);
           else getWorld().addObject(new virus_bullet(),1200,110);
           weh.play();
           jada=0;
        }
    }
    else if(hm==0){
        ///moartea caracterului
        Actor bullet = getOneIntersectingObject(virus_bullet.class);
            getWorld().removeObject(bullet);
            ded.play();
            setImage("player_glo_mask_ded.png");
            getWorld().addObject(new g_over(), 640, 200);
            getWorld().addObject(new sad_message(), 640, 240);
            getWorld().addObject(new retry_boss(), 640, 290);
            getWorld().addObject(new main_menu(), 640, 335);
            turn(-90);
            is_ded=true;
            setLocation(getX(),470);
            hm=1;
        }
    }

public void fall()
    {
        ///gravitatia
        setLocation(getX(),getY()+velocity);
        if(getY()>getWorld().getHeight()-huh) 
        {
            velocity=0;
            pressed_space=false;
        }
        else velocity+=GRAVITY;
    }
    public void jump()
    {
        ///saltul caracterului
        velocity=-30;
        pressed_space=true;
    }
    public void checkFire()
    {
        ///trage
        xpressed=true; 
        Greenfoot.playSound("pew.wav");
        getWorld().addObject(new bullet_boss(), getX()+150, getY()-7);
    }
    
}
