import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends ScrollWorld
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, 2000, 1000); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ice ice = new Ice();
        addObject(ice,21,506);
        Ice ice2 = new Ice();
        addObject(ice2,60,505);
        Ice ice3 = new Ice();
        addObject(ice3,103,518);
        Ice ice4 = new Ice();
        addObject(ice4,128,518);
        Ice ice5 = new Ice();
        addObject(ice5,148,516);
        Ice ice6 = new Ice();
        addObject(ice6,189,516);
        Ice ice7 = new Ice();
        addObject(ice7,228,516);
        Ice ice8 = new Ice();
        addObject(ice8,257,516);
        Ice ice9 = new Ice();
        addObject(ice9,287,516);
        Ice ice10 = new Ice();
        addObject(ice10,321,516);
        Ice ice11 = new Ice();
        addObject(ice11,366,516);
        Ice ice12 = new Ice();
        addObject(ice12,426,522);
        Ice ice13 = new Ice();
        addObject(ice13,468,522);
        Ice ice14 = new Ice();
        addObject(ice14,508,522);
        Ice ice15 = new Ice();
        addObject(ice15,571,522);
        Ice ice16 = new Ice();
        addObject(ice16,614,521);
        Ice ice17 = new Ice();
        addObject(ice17,659,516);
        Ice ice18 = new Ice();
        addObject(ice18,704,517);
        Ice ice19 = new Ice();
        addObject(ice19,744,522);
        Ice ice20 = new Ice();
        addObject(ice20,776,524);
        Ice ice21 = new Ice();
        addObject(ice21,784,524);
        Ice ice22 = new Ice();
        addObject(ice22,798,524);
        addCameraFollower(new Player(),0,0);
    }
}
