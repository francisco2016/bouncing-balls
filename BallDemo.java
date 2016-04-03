import java.awt.Color;
import java.util.ArrayList; //-------------------------------------------------- 0100
import java.util.Random; // ----------------------------------------------------- 0100
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
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
        Random aleatorio = new Random(); //-- para que la posición colores y radio sean aleatorios.---------- 0100
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //---0100 creamos una coleccion de objetos BouncingBall() que llamamos bolas.//-----------------------0100
        ArrayList<BouncingBall> bolas = new ArrayList<>(); //-------------------------------------------------0100
        
        Color[] colores = new Color[3];
        colores[0] = Color.BLUE;//-------------------------------------------------0100
        colores[1] = Color.YELLOW;//-------------------------------------------------0100
        colores[2] = Color.RED;//-------------------------------------------------0100
        // crate and show the balls
        //creamos un bucle para ir asignando bolas a la colección. -------------------------------------------0100

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
            //para que boten las bolas creamos un bucle for each que recorra toda la colección y haga moverse a cada bola.0100
            for(BouncingBall bola : bolas){//-----------------------------------------------------------------0100
                bola.move();

                if(bola.getXPosition() >= 550  ) {
                    finished = true;//-----------------------------------------------------------------------0100
                }
            }
          // stop once ball has travelled a certain distance on x axis
        }
    }
    
    /**
     * Metodo que genera bolas dentro de un rectangulo.
     */
    public void boxBounce(int numbolas)
    {
        Random aleatorio = new Random();
        myCanvas.setVisible(true);
        //para dibujar es triángulo
        myCanvas.drawLine(50, 50, 550, 50);// (50 d x y 50 de y) y (550 d x y 50 de y)
        myCanvas.drawLine(550, 50, 550, 400);//barra derecha 550
        myCanvas.drawLine(550, 400, 50, 400);//suelo 400
        myCanvas.drawLine(50, 400, 50, 50);  //izquierda 500

        ArrayList<BoxBall> bolas = new ArrayList<>();
        for (int cont = 0; cont < numbolas; cont++)
        {
            int diametro = aleatorio.nextInt(25)+ 5;//calcula el diametro 
            Color colorA = new Color(aleatorio.nextInt(255),aleatorio.nextInt(255),aleatorio.nextInt(255));

            int ladx = aleatorio.nextInt(2);//elige al direccion aleatoriamente entre 0 y 2
            int lady = aleatorio.nextInt(2);
            if (ladx == 0)
            {
                ladx = -1;
            }
            if (lady == 0)
            {
                lady = -1;
            }

            int posInix = aleatorio.nextInt(500);
            int posIniy = aleatorio.nextInt(350);
            if(posInix < 50)
            {
                posInix = 100;
            }
            if(posIniy < 50)
            {
                posIniy = 100;
            }
            //creamos la  bola
            bolas.add(new BoxBall(posInix, posIniy, diametro, colorA, 
                    400, 50, 50, 550, 
                    ladx, lady, myCanvas));
            bolas.get(cont).draw();
        }

        while(true)
        {
            myCanvas.wait(50);           // small delay hace que se pare la bola durante un instante
            for (int cont = 0;cont<numbolas;cont++)
            {
                bolas.get(cont).move();
            }
        }
    }
}
