import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss_fight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss_fight extends World
{

    /**
     * Constructor for objects of class Boss_fight.
     * 
     */
    public int score =0;
    public Boss_fight()
    {    
        /// cream o lume de marimea 1280x720
        super(1280, 720, 1); 
        prepare();
        //setam ordinea actorilor
        setPaintOrder(main_menu.class,g_over.class,retry_boss.class,sad_message.class,virus_bullet.class,bullet_boss.class,emb_boss.class,boss.class,vaccine.class);
        
    }

    /**
     * Prepare the world for the stof the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        emb_boss emb_boss = new emb_boss();
        addObject(emb_boss,0,430);
    }
    
    public void scoret()
    {
        ///returneaza
        score+=10;
        show_score();
    }
    
    public void show_score()
    {
        ///arata scorul pe ecran
        showText("Scor: "+score,70,100);
    }
    
}
