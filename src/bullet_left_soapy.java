import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class bullet_left_soapy extends Actor
{
    /**
     * Act - do whatever the bullet_left wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean touched=false;
    public void act() 
    {
       setLocation(getX() - speed, getY());
       if(isTouching(virus_2.class) ) ((Level_3)getWorld()).scoret();
       if(isTouching(virus_3.class) ) ((Level_2)getWorld()).scoret();
       if(!touched)checkBoundaries();
       if(!touched)destroyEnemies();
    }  
    public void checkBoundaries()
   {
       //verificam daca e la margine, daca da atunci dispare
       if(isAtEdge()) 
           {
               getWorld().removeObject(this);
               touched=true;
            }
       
   }
  //distrugem inamicii
   public void destroyEnemies()
   {
        //"Enemy" orice caracter(clasa) pe care vrei s-o distrugi.  
       Actor enemy = getOneIntersectingObject(virus_2.class);
       Actor enemy_ = getOneIntersectingObject(virus_3.class);
       if(enemy != null) {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
            touched=true;
       }
       else if (enemy_ !=null){
            getWorld().removeObject(enemy_);
            getWorld().removeObject(this);
            touched=true;
       }
   }
 
   private int speed = 40;///viteza proiectilului
}
