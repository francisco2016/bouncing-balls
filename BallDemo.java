import java.awt.Color;
import java.util.ArrayList; //-------------------------------------------------- 0100
import java.util.Random; // ----------------------------------------------------- 0100
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
        Random aleatorio = new Random(); //-- para que la posici�n colores y radio sean aleatorios.---------- 0100
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //---0100 creamos una coleccion de objetos BouncingBall() que llamamos bolas.//-----------------------0100
        ArrayList<BouncingBall> bolas = new ArrayList<>(); //-------------------------------------------------0100
        
        Color[] colores = new Color[3];
        colores[0] = Color.BLUE;//-------------------------------------------------0100
        colores[1] = Color.YELLOW;//-------------------------------------------------0100
        colores[2] = Color.RED;//-------------------------------------------------0100
        // crate and show the balls
        //creamos un bucle para ir asignando bolas a la colecci�n. -------------------------------------------0100

        for(int i = 0; i < numBolas; i++){//-----------------------------------------------------------------0100
            int numColor = aleatorio.nextInt(colores.length);//-------------------------------------------------0100
            int posicion = aleatorio.nextInt(150);//-------------------------------------------------0100
            int radio = aleatorio.nextInt(30);//-------------------------------------------------0100
          // bolas.add(new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas));
            bolas.add(new BouncingBall(posicion, posicion, radio, colores[numColor], ground, myCanvas));
            bolas.get(i).draw();
        }

        // make them bounce ----------------( que boten  )
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            //para que boten las bolas creamos un bucle for each que recorra toda la colecci�n y haga moverse a cada bola.0100
            for(BouncingBall bola : bolas){//-----------------------------------------------------------------0100
                bola.move();

                if(bola.getXPosition() >= 550  ) {
                    finished = true;//-----------------------------------------------------------------------0100
                }
            }
          // stop once ball has travelled a certain distance on x axis
        }
    }
}
