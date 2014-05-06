/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package godrace;

import java.awt.Image;
import java.util.ArrayList;

/**
 * La clase Animacion maneja una serie de imágenes (cuadros)
 * y la cantidad de tiempo que se muestra cada cuadro.
*/

public class Animacion{
	
        private ArrayList cuadros;
	private int indiceCuadroActual;
	private long tiempoDeAnimacion;
	private long duracionTotal;
        
        /**
         * Constructor por default de la clase <I>Animacion</I>
         */
	public Animacion(){
		cuadros = new ArrayList();
		duracionTotal = 0;
		iniciar();
	}
	
	/**
         * Añade una cuadro a la animación con la duración
         * indicada (tiempo que se muestra la imagen).
         * @param imagen es la imagen de tipo <I>Image</I>
         * @param duracion es la duración del cuadro <I>long</I>
         */	
	public synchronized void sumaCuadro(Image imagen, long duracion){
		duracionTotal += duracion;
		cuadros.add(new cuadroDeAnimacion(imagen, duracionTotal));
	}
	
	/**
         * Método que inicializa la animación.
         */ 
	public synchronized void iniciar(){
		tiempoDeAnimacion = 0;
		indiceCuadroActual = 0;
	}
	
	/**
         * Método que actualiza la imagen (cuadro) actual de la animación,
         * si es necesario.
         * @param tiempoTranscurrido es la diferncia entre el tiempo actual y
         * el tiempo de inicio de la animación
         */
	public synchronized void actualiza(long tiempoTranscurrido){
		if (cuadros.size() > 1){
			tiempoDeAnimacion += tiempoTranscurrido;
			
			if (tiempoDeAnimacion >= duracionTotal){
				tiempoDeAnimacion = tiempoDeAnimacion % duracionTotal;
				indiceCuadroActual = 0; 
			}
			
			while (tiempoDeAnimacion > getCuadro(indiceCuadroActual).tiempoFinal){
				indiceCuadroActual++;
			}
		}
	}
	
	/**
         * Método que regresa la imagen del cuadro actual de la animación
         * @return imagen del cuadro actual de la animación
         */
	public synchronized Image getImagen(){
		if (cuadros.size() == 0){
			return null;
		}
		else {
			return getCuadro(indiceCuadroActual).imagen;
		}
	}
	
        /**
         * Método <I>getCuadro</I> regresa el cuadro siguiente de la animación
         * @param i es el índice del cuadro
         * @return es el cuadro del índice i
         */
	private cuadroDeAnimacion getCuadro(int i){
		return (cuadroDeAnimacion)cuadros.get(i);
	}
	
        /**
         * Clase <I>cuadroDeAnimacion</I> que genera un cuadro con imagen
         * y duración.
         */
	public class cuadroDeAnimacion{
		Image imagen;    // Imagen y tiempo del cuadro
		long tiempoFinal;
		
                /**
                 * Método constructor por default que inicializa con cero y nulo
                 */
		public cuadroDeAnimacion(){
			this.imagen = null;
			this.tiempoFinal = 0;
		}
		
                /**
                 * Método constructor de la clase <I>cuadroDeAnimacion</I>
                 * @param imagen es la imagen del cuadro del tipo <I>Image</I>
                 * @param tiempoFinal es el tiempo de duración del cuadro
                 * del tipo <I>long</I>
                 */
		public cuadroDeAnimacion(Image imagen, long tiempoFinal){
			this.imagen = imagen;
			this.tiempoFinal = tiempoFinal;
		}
		
                /**
                 * Método que regresa la imagen del cuardo
                 * @return es la imagen del cuadro de animación
                 */
		public Image getImagen(){
			return imagen;
		}
		
                /**
                 * Método que regresa la duración del cuadro de animación
                 * @return es el tiempo del cuadro de animación
                 */
		public long getTiempoFinal(){
			return tiempoFinal;
		}
		
                /**
                 * Método que guarda la imagen del cuadro
                 * @param imagen es la imagen del tipo <I>Image</I> que tendrá
                 * el cuadro de animación
                 */
		public void setImagen (Image imagen){
			this.imagen = imagen;
		}
		
                /**
                 * Método que guarda el tiempo de duración del cuadro
                 * @param tiempoFinal es la duración del cuadro de animación
                 * del tipo <I>long</I>
                 */
		public void setTiempoFinal(long tiempoFinal){
			this.tiempoFinal = tiempoFinal;
		}
	}		
}