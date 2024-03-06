import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

//Aceasta lume contine sistemul de scrolling.
public abstract class ScrollingWorld extends World
{
    //Marimea maxima a lumii.
    public static int WORLD_WIDTH;
    public static int WORLD_HEIGHT;
    
    protected int totalXMovement = 0;
    protected int totalYMovement = 0;
    
    public int knower = 4;
    
    //Aceasta imagine este fundalul jocului.
   
    public GreenfootImage textur = new GreenfootImage("long_hallway.png");
    public ScrollingWorld(int screenWidth, int screenHeight) {
        super(1080, 720, 1, false);
        WORLD_WIDTH = 0;
        WORLD_HEIGHT = 0;
    }
    public ScrollingWorld(int screenWidth, int screenHeight, int cellSize) {
        super(screenWidth, screenHeight, cellSize, false);
        WORLD_WIDTH = 0;
        WORLD_HEIGHT = 0;
    }
    public ScrollingWorld(int screenWidth, int screenHeight, int scrollingWidth, int scrollingHeight) {
        super(screenWidth, screenHeight, 1, false);
        WORLD_WIDTH = scrollingWidth;
        WORLD_HEIGHT = scrollingHeight;
    }
    public ScrollingWorld(int screenWidth, int screenHeight, int cellSize, int scrollingWidth, int scrollingHeight) {
        super(screenWidth, screenHeight, cellSize, false);
        WORLD_WIDTH = scrollingWidth;
        WORLD_HEIGHT = scrollingHeight;
    }
    
    //Reseteaza pozitia caracterului.
    public final void resetPlayersPosition(ScrollingActor scrollingActor) {
        int xMovement = (int) ((double) getWidth()/2 - scrollingActor.getExactX());
        int yMovement = (int) ((double) 2*getHeight()/3 - scrollingActor.getExactY());
        totalXMovement += xMovement;
        totalYMovement += yMovement;
        List<Actor> actors = getObjects(Actor.class);
        for (Actor actor : actors) {
            if (actor instanceof ScrollingActor) {
                ((ScrollingActor) actor).setLocation(actor.getX() + xMovement, actor.getY() + yMovement, false);
            }
            else {
                actor.setLocation(actor.getX() + xMovement, actor.getY() + yMovement);
            }
        }
        createTextur();
    }
    
    //Creeaza o textura miscatoare pentru fundal.
    protected final void createTextur() {
        int x=830;
        int y;
        if (totalXMovement > 0) {
            for (x = totalXMovement; x > 0; x -= textur.getWidth()) {
                ;
            }
        }
        else {
            for (x = totalXMovement; x < 0; x += textur.getWidth()) {
                ;
            }
            x -= textur.getWidth();
        }
        if (totalYMovement > 0) {
            for (y = totalYMovement; y > 0; y -= textur.getHeight()) {
                ;
            }
        }
        else {
            for (y = totalYMovement; y < 0; y += textur.getHeight()) {
                ;
            }
            y -= textur.getHeight();
        }
        getBackground().clear();
        for (int i = x; i < getWidth(); i += textur.getWidth()) {
            for (int j = y; j < getHeight(); j += textur.getHeight()) {
                getBackground().drawImage(textur, i, j);
            }
        }
        
    }
    
    //Retuneaza lungimea lumii.
    public int getScrollingWidth() {
        return WORLD_WIDTH;
    }
    //Retuneaza inaltimea lumii.
    public int getScrollingHeight() {
        return WORLD_HEIGHT;
    }
 
    //Returneaza totalitatea miscarilor in directia x.
    public int getTotalXMovement() {
        return totalXMovement;
    }
    //Returneaza totalitatea miscarilor in directia y.
    public int getTotalYMovement() {
        return totalYMovement;
    }
}