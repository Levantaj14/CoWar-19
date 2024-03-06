import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class home extends World
{

    /**
     * Constructor for objects of class home.
     * 
     */
    public home()
    {    
        super(1280, 720, 1);
        setBackground(new GreenfootImage("background_.png"));
        prepare();
        getBackground().drawImage(new GreenfootImage("CoWar-19", 60, null,null),60,40); 
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //adaugam actorii necesari pentru a creea meniul principal
        ember_e ember_e = new ember_e();
        addObject(ember_e,506,235);
        play play = new play();
        addObject(play,105,125);
        ajutor ajutor = new ajutor();
        addObject(ajutor,105,160);
        ember_e.setLocation(791,454);
    }
}
