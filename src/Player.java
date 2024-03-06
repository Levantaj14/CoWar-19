import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
import java.util.List;

public abstract class Player extends Actor
{
    protected double exactX;
    protected double exactY;
    protected double velX;
    protected double velY;
    
    //Seteaza locatia caracterului.
    public void setLocation(int x, int y) {
        if (ScrollingWorld.WORLD_WIDTH != 0) {
            if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() > ScrollingWorld.WORLD_WIDTH/2) {
                x = (int) (getStartingPoint().getX() + ScrollingWorld.WORLD_WIDTH/2);
            }
            else if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() < -ScrollingWorld.WORLD_WIDTH/2) {
                x = (int) (getStartingPoint().getX() - ScrollingWorld.WORLD_WIDTH/2);
            }
        }
        if (ScrollingWorld.WORLD_HEIGHT != 0) {
            if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() > ScrollingWorld.WORLD_HEIGHT/2) {
                y = (int) (getStartingPoint().getY() + ScrollingWorld.WORLD_HEIGHT/2);
            }
            else if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() < -ScrollingWorld.WORLD_HEIGHT/2) {
                y = (int) (getStartingPoint().getY() - ScrollingWorld.WORLD_HEIGHT/2);
            }
        }
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }
    //Seteaza locatia caracterului.
    public void setLocation(double x, double y) {
        if (ScrollingWorld.WORLD_WIDTH != 0) {
            if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() > ScrollingWorld.WORLD_WIDTH/2) {
                x = getStartingPoint().getX() + ScrollingWorld.WORLD_WIDTH/2;
            }
            else if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() < -ScrollingWorld.WORLD_WIDTH/2) {
                x = getStartingPoint().getX() - ScrollingWorld.WORLD_WIDTH/2;
            }
        }
        if (ScrollingWorld.WORLD_HEIGHT != 0) {
            if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() > ScrollingWorld.WORLD_HEIGHT/2) {
                y = getStartingPoint().getY() + ScrollingWorld.WORLD_HEIGHT/2;
            }
            else if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() < -ScrollingWorld.WORLD_HEIGHT/2) {
                y = getStartingPoint().getY() - ScrollingWorld.WORLD_HEIGHT/2;
            }
        }
        exactX = x;
        exactY = y;
        super.setLocation((int) x, (int) y);
    }
    
    //Returneaza distanta pana la ScrollingActor.
    public double getDistanceToScrollingActor() {
        List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
        if (actors != null && !actors.isEmpty()) {
            ScrollingActor actor = null;
            for (ScrollingActor scrollingActor : actors) {
                if (scrollingActor.isScrollingCenter()) {
                    actor = scrollingActor;
                }
            }
            if (actor == null) {
                System.err.println("No scrollingActor in the world.");
                return 0;
            }
            return Math.hypot(getExactX() - actor.getExactX(), getExactY() - actor.getExactY());
        }
        return 0;
    }
    //Returneaza ori componentul x ori componentul y pana la distanta ScrollingActorului.
    public double getDistanceToScrollingActor(char component) throws IllegalArgumentException {
        if (component == 'x') {
            List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
            if (actors != null && !actors.isEmpty()) {
                ScrollingActor actor = null;
                for (ScrollingActor scrollingActor : actors) {
                    if (scrollingActor.isScrollingCenter()) {
                        actor = scrollingActor;
                    }
                }
                if (actor == null) {
                    System.err.println("Nu exista ScrollingActor in aceasta lume.");
                    return 0;
                }
                return getExactX() - actor.getExactX();
            }
        }
        else if (component == 'y') {
            List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
            if (actors != null && !actors.isEmpty()) {
                ScrollingActor actor = null;
                for (ScrollingActor scrollingActor : actors) {
                    if (scrollingActor.isScrollingCenter()) {
                        actor = scrollingActor;
                    }
                }
                if (actor == null) {
                    System.err.println("Nu exista ScrollingActor in aceasta lume.");
                    return 0;
                }
                return getExactY() - actor.getExactY();
            }
        }
        else {
            throw new IllegalArgumentException("componentul (" + component + ") trebuie sa fie ori 'x' ori 'y'");
        }
        return 0;
    }
    
    //Returneaza pozitia inceperii.
    public java.awt.Point getStartingPoint() {
        List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
        if (actors != null && !actors.isEmpty()) {
            ScrollingActor actor = null;
            for (ScrollingActor scrollingActor : actors) {
                if (scrollingActor.isScrollingCenter()) {
                    actor = scrollingActor;
                }
            }
            if (actor == null) {
                System.err.println("Nu exista ScrollingActor in aceasta lume.");
                return null;
            }
            int x = actor.getX() + getWorld().getTotalXMovement();
            int y = actor.getY() + getWorld().getTotalYMovement();
            return new Point(x, y);
        }
        return null;
    }
    
    //Returneaza pozitia exacta a caracterului pe axa x.
    public double getExactX(){
        return exactX;
    }
    //Returneaza pozitia exacta a caracterului pe axa y.
    public double getExactY(){
        return exactY;
    }
    
    //Returneaza pozitia exacta a caracterului pe axa x din lumea miscatoare.
    public double getScrollingX() {
        return getDistanceToScrollingActor('x') - getWorld().getTotalXMovement();
    }
    //Returneaza pozitia exacta a caracterului pe axa y din lumea miscatoare.
    public double getScrollingY() {
        return getDistanceToScrollingActor('y') - getWorld().getTotalYMovement();
    }
    
    //Projecteaza lumea curenta ScrollingWorldlui.
    public ScrollingWorld getWorld() {
        return ((ScrollingWorld) super.getWorld());
    }
}