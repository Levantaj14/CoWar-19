import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enter extends World
{
    int counter=0;
    /**
     * Constructor for objects of class enter.
     * 
     */
    public enter()
    {    
        super(1280, 720, 1);
        prepare();
    }
    
    private void prepare()
    {
        ///adaugam caracterul din animatia meniului principal 
        int x=790, y=455;
        addObject(new ember_h(),x,y);
    }
}
