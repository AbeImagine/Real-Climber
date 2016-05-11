import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ScrollActor
{
    
    private int vSpeed = 0;
    private int acceleration = 1;
    private boolean jumping;
    private int jumpStrength = 15;
    private int speed = 4;
    private int frame = 1;
    
    private GreenfootImage run1 = new GreenfootImage("Human_side_1.png");
    private GreenfootImage run2 = new GreenfootImage("Human_side_2.png");
    private GreenfootImage run3 = new GreenfootImage("Human_side_3.png");
    private GreenfootImage run4 = new GreenfootImage("Human_side_4.png");
    private GreenfootImage run5 = new GreenfootImage("Human_side_5.png");
    private GreenfootImage run6 = new GreenfootImage("Human_side_6.png");
    private GreenfootImage run7 = new GreenfootImage("Human_side_7.png");
    private GreenfootImage run8 = new GreenfootImage("Human_side_8.png");
    
    private GreenfootImage run1_l = new GreenfootImage("Human_side_1_l.png");
    private GreenfootImage run2_l = new GreenfootImage("Human_side_2_l.png");
    private GreenfootImage run3_l = new GreenfootImage("Human_side_3_l.png");
    private GreenfootImage run4_l = new GreenfootImage("Human_side_4_l.png");
    private GreenfootImage run5_l = new GreenfootImage("Human_side_5_l.png");
    private GreenfootImage run6_l = new GreenfootImage("Human_side_6_l.png");
    private GreenfootImage run7_l = new GreenfootImage("Human_side_7_l.png");
    private GreenfootImage run8_l = new GreenfootImage("Human_side_8_l.png");
    
    
    private int animationCounter = 0;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkFall();
        checkKey();
        platformAbove();
        
        animationCounter++;
    }    
    
    private void checkKey(){
        if(Greenfoot.isKeyDown("z") && jumping == false){
            jump();
        }
        if(Greenfoot.isKeyDown("right")){
            moveRight();
        }
        if(Greenfoot.isKeyDown("left")){
            moveLeft();
        }
    }
    
    private void moveRight(){
        getWorld().setCameraLocation(getGlobalX() + speed, getGlobalY());
        
        if(animationCounter % 4 == 0){
            animateRight();
        }
    }
    
    private void animateRight(){
        if(frame == 1){
            setImage(run1);
        }
        else if(frame == 2){
            setImage(run2);
        }
        else if(frame == 3){
            setImage(run3);
        }
        else if(frame == 4){
            setImage(run4);
        }
        else if(frame == 5){
            setImage(run5);
        }
        else if(frame == 6){
            setImage(run6);
        }
        else if(frame == 7){
            setImage(run7);
        }
        else if(frame == 8){
            setImage(run8);
            frame =1;
            return;
        }
        frame ++;
    }
    
    private void animateLeft(){
        if(frame == 1){
            setImage(run1_l);
        }
        else if(frame == 2){
            setImage(run2_l);
        }
        else if(frame == 3){
            setImage(run3_l);
        }
        else if(frame == 4){
            setImage(run4_l);
        }
        else if(frame == 5){
            setImage(run5_l);
        }
        else if(frame == 6){
            setImage(run6_l);
        }
        else if(frame == 7){
            setImage(run7_l);
        }
        else if(frame == 8){
            setImage(run8_l);
            frame =1;
            return;
        }
        frame ++;
    }
    
    private void moveLeft(){
        getWorld().setCameraLocation(getGlobalX() - speed, getGlobalY());
        
        if(animationCounter % 4 == 0){
            animateLeft();
        }
    }
    
    /**
     * 
     */
    private void fall(){
        getWorld().setCameraLocation(getGlobalX(), getGlobalY() + vSpeed);
        vSpeed = vSpeed + acceleration;
        jumping = true;
    }
    
    /**
     * 
     */
    private boolean onGround(){
        int spriteHeight = getImage().getHeight();
        int lookForGround = (int)(spriteHeight/2) + 2;
        
        Actor groundA = getOneObjectAtOffset(0, lookForGround, Block.class);
        ScrollActor ground = (ScrollActor)groundA;
        
        if(ground == null){
            jumping = true;
            return false;
        }
        else{
            moveToGround(ground);
            return true;
        }
    }
    
    private boolean platformAbove(){
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        
        Actor ceilingA = getOneObjectAtOffset(0, yDistance, Block.class);
        ScrollActor ceiling = (ScrollActor)ceilingA;
        
        if(ceiling != null){
            vSpeed = 1;
            bopHead(ceiling);
            return true;
        }
        else{
            return false;
        }
    }
    
    private void bopHead(ScrollActor ceiling){
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getGlobalY() + (ceilingHeight + getImage().getHeight())/2;
        
        getWorld().setCameraLocation(getGlobalX(), newY);
    }
    
    /**
     * 
     */
    private void moveToGround(ScrollActor ground){
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getGlobalY() - (groundHeight + getImage().getHeight())/2;
        
        getWorld().setCameraLocation(getGlobalX(), newY);
        jumping = false;
    }
    
    /**
     * 
     */
    private void checkFall(){
        if(onGround()){
            vSpeed = 0;
        }
        else{
            fall();
        }
    }
    
    private void jump(){
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    public void death(){
        
    }
}
