 package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public abstract class Sprite {
	
	/**
	 *  Largura e altura somente de uma imagem da Sprite
	 **/
	private int characterWidth, characterHeigth;
	
	/**
	 *  Imagem de toda a Sprite
	 **/
	protected BufferedImage charecter;
	
	/**
	 * Largura e altura total de sua Imagem Personagem
	 **/
	
	protected int width, heigth;
	
	/**
	 * Corresponde a quantidade de linha e colunas de sua Imagem personagem
	 **/
	
	protected int lines, columns;
	
	/**
	 * Localização x e y da tela
	 **/
	
	private int x, y;
	
	/*
	 * Array de todas as imagens de sua Sprite
	 * Cada valor é um estado(aparencia) diferente da Sprite
	 * */
	
	private BufferedImage[] sprites;
	
	/**
	 * Aparencia atual da sua Sprite.
	 *  Utilizada para sabe qual valor do array das sprites usar
	 * */

	private int appearance;

	/**
	 * @param appearance
	 * @param width
	 * @param heigth
	 * @param columns
	 * @param lines
	 * @param x
	 * @param y
	 * @param address
	 * @throws IOException
	 */
	
	protected Sprite (int appearance, int width, int heigth, int columns, int lines, int x, int y, String address){
		try {
			this.charecter = ImageIO.read(getClass().getClassLoader().getResourceAsStream(address));
			this.appearance = appearance;
			this.width = width;
			this.heigth = heigth;
			
			this.lines = columns;
			this.columns = lines;
			this.x = x;
			this.y = y;
			
			sprites = new BufferedImage[columns * lines];
			
			/**
			 * Recorta sua imagem em varias,
			 * cada recorte significa um estado da Sprite
			 * */
		
//			for(int i = 0; i < columns; i++) {
//				for (int j = 0; j < lines; j++) {
//					sprites[(i * lines) + j] = charecter.getSubimage(i * (width/columns),
//							j * (heigth/lines), width/columns, heigth/lines);
//					}
//				}
			
			for (int i = 0; i < lines; i++) {
				for (int j = 0; j < columns; j++) {

					sprites[(i * columns) + j] = charecter.getSubimage(j * (width / columns),
							i * (heigth / lines), width / columns, heigth / lines);

				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possivel carregar o personagem");
		}
		
		characterWidth = sprites[0].getWidth();
		characterHeigth = sprites[0].getHeight();
	}
	
	/**
	 * Metodo abstrato responsavel por denifir como sera a animação de sua Sprite,
	 * Toda Sprite tem uma animação diferente dependendo da imagem.
	 * @param direcao(direction)
	 * */
	
	public abstract void animate(String direction);
	
	/**
	 * Metodo abstrato responsavel por desenha a Sprite na tela.
	 * @param g
	 * */
	
	public abstract void draw(Graphics g);
	
	/**
	 * Metodo abstrato responsavel por definir como sera o movimento da Sprite
	 * @param direction
	 * */
	
	public abstract void move(String direction);

	
	
	/**
	 * Metodos Getters e Setters
	 * */
	
	public int getCharacterWidth() {
		return characterWidth;
	}

	public void setCharacterWidth(int characterWidth) {
		this.characterWidth = characterWidth;
	}

	public int getCharacterHeigth() {
		return characterHeigth;
	}

	public void setCharacterHeigth(int characterHeigth) {
		this.characterHeigth = characterHeigth;
	}

	public BufferedImage getCharecter() {
		return charecter;
	}

	public void setCharecter(BufferedImage charecter) {
		this.charecter = charecter;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public void setSprites(BufferedImage[] sprites) {
		this.sprites = sprites;
	}

	public int getAppearance() {
		return appearance;
	}

	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x+5, y+5, characterWidth-10, characterHeigth-10);
	}
}

