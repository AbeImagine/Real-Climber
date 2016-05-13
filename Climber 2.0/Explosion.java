import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends ScrollActor
{
    private GifImage gif = new GifImage("explosion.gif");
    private int count = 0;
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        checkCollision();
        if(count > 15){
            this.getWorld().removeObject(this);
        }
        count+=1;
    }    
    
    private void checkCollision(){
        if(isTouching(Player.class)){
            Actor pl = getOneIntersectingObject(Player.class);
            Player player = (Player) pl;
            player.death();
            removeTouching(Player.class);
        }
    }
}
