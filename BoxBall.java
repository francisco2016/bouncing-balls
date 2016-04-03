
import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int posicionSuelo;      // suelo del rectangulo
    private final int posicionTecho;    //
    private final int posicionParezIz;    //  
    private final int posicionParezDe;//
    private Canvas canvas;                  // el lienzo donde dibujar las bolas
    private int ySpeed;                 //
    private int xSpeed;                     //velocidad en el eje y.

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, 
                   int groundPos, int techPos, int izPos, int dePos, 
                   int xSpe, int ySpe, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        posicionSuelo = groundPos;
        posicionTecho = techPos;
        posicionParezIz = izPos;
        posicionParezDe = dePos;
        canvas = drawingCanvas;
        ySpeed = ySpe;
        xSpeed = xSpe;
    }
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()//este mt borra la bola del lienzo, luego la vuelve a crear
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (posicionSuelo - diameter)) { //comprueba si la bola golpea un lado del rectangulo (suelo)
            yPosition = (int)(posicionSuelo - diameter);//si toca el suelo
            ySpeed = -1;//hace invertir la dirección de la bola
        }
        
        if(yPosition <= (posicionTecho)) {
            yPosition = (int)(posicionTecho);
            ySpeed = 1;
        }
        
        if(xPosition >= (posicionParezDe - diameter)) {
            xPosition = (int)(posicionParezDe - diameter);
            xSpeed = -1;
        }
        
        if(xPosition <= (posicionParezIz)) {
            xPosition = (int)(posicionParezIz);
            xSpeed = 1;
        }

        // draw again at new position
        draw();   //pinta la bola.
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
