import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Block
{
    private GreenfootImage bomb1 = new GreenfootImage("Block_bomb_1.png");
    private GreenfootImage bomb2 = new GreenfootImage("Block_bomb_2.png");
    private int frame = 1;
    private int explosion = 0;
    private boolean ready = false;
    
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkPlayer();
        if(ready){
            blowUp();
        }
    }    
    
    private void checkPlayer(){
        if(isTouching(Player.class)){
            ready = true;
        }
    }
    
    private void blowUp(){
        if(explosion % 5 == 0){
            blowUpAnimation();
        }
        if(explosion == 35){
            Explosion e = new Explosion();
            this.getWorld().addObject(e, this.getX(), this.getY());
            this.getWorld().removeObject(this);
        }
        explosion++;
    }
    
    private void blowUpAnimation(){
        if(frame == 1){
            setImage(bomb1);
        }
        if(frame == 2){
            setImage(bomb2);
            frame = 0;
        }        
        frame++;
    }
}
