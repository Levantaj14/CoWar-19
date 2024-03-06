import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public abstract class ScrollingActor extends Player
{
    private boolean scrollingCenter;
    
    public ScrollingActor() {
        scrollingCenter = true;
    }
    public ScrollingActor(boolean scrollingCenter) {
        this.scrollingCenter = scrollingCenter;
    }
    
    public final void addedToWorld(World world) {
        if (scrollingCenter) {
            List<ScrollingActor> scrollingActors = getWorld().getObjects(ScrollingActor.class);
            if (scrollingActors != null && !scrollingActors.isEmpty()) {
                for (ScrollingActor scrollingActor : scrollingActors) {
                    if (!scrollingActor.equals(this)) {
                        scrollingActor.setScrollingCenter(false);
                    }
                }
            }
        }
    }
    
    //O extensie a comezii setLocation.
    public final void setLocation(int x, int y) {
        super.setLocation(x, y);
        if (scrollingCenter) {
            getWorld().resetPlayersPosition(this);
        }
    }
    //O extensie a comezii setLocation, care foloseste valori double pentru coordonate.
    public final void setLocation(double x, double y) {
        super.setLocation(x, y);
        if (scrollingCenter) {
            getWorld().resetPlayersPosition(this);
        }
    }
    //O extensie a comezii setLocation, care foloseste valori double pentru coordonate si nu-l reseteaza de fiecare data.
    public final void setLocation(double x, double y, boolean resetPosition) {
        super.setLocation(x, y);
        if (scrollingCenter && resetPosition) {
            getWorld().resetPlayersPosition(this);
        }
    }
    
    public final boolean isScrollingCenter() {
        return scrollingCenter;
    }
    public final void setScrollingCenter(boolean scrollingCenter) {
        this.scrollingCenter = scrollingCenter;
    }
}