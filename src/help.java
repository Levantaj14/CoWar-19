import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class help extends World
{

    /**
     * Constructor for objects of class help.
     * 
     */
    public help()
    {    
        super(1280, 720, 1);
        //setam backgroundul
        getBackground().drawImage(new GreenfootImage("Ajutor", 60, null,null),62,40); 
        prepare();
        // scriem instructiunile pe ecran
        getBackground().drawImage(new GreenfootImage("Misiunea ta este de a învinge virusul pentru a-l putea folosi la crearea unui vaccin.\nIntrând în spital, te vei confrunta cu patogeni, iar tu trebuie să îi elimini cu un pistol cu apă.\nPentru a trage, apasă butonul x de pe tastatură.\nÎți poți mișca caracterul folosind butoanele ←, →.\nÎn ultimul nivel, înainte să poți învinge virusul mortal, trebuie să aștepți, până când ți se reîncarcă pistolul..\nÎn timp ce aștepți, virusul va trage spre tine (și de sus și de jos),\nși tu va trebui să te ferești folosind tasta SPACE.\nDacă te nimerește, vei fi eliminat instant.\nÎți urăm baftă! Lumea contează pe tine!", 30, null,null),62,170);
    }
    private void prepare()
    {
        main_menu main_menu = new main_menu();
        addObject(main_menu,182,125);
    }
}
