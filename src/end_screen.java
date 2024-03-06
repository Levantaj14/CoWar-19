import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class end_screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class end_screen extends World
{

    /**
     * Constructor for objects of class end_screen.
     * 
     */
    public end_screen()
    {    
        super(1280, 720, 1); 
        //adaugam actorul pentru meniul principal
        addObject(new main_menu(),200,500);
    }
}
