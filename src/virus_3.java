import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class virus_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class virus_3 extends Actor
{
    /**
     * Act - do whatever the virus_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean touched=false;
    public boolean it_was=true;
    public void act() 
    {
        if (it_was){
            setImage(new GreenfootImage(getSplashes()[Greenfoot.getRandomNumber(getSplashes().length)]));
            it_was=false;
        }
        if( isTouching(Firsty_soapy.class)) 
        {
            //daca atingem caracterul, disparem
            getWorld().removeObject(this);
            touched=true;
        }
    } 
    public static String[] getSplashes()
    {
        ///schimbam random imaginea
        String[] splashes = {"virus2_3.png", "virus2_silly.png", "virus2_smile.png"};
        return splashes;
    }
}
