package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class Layer{
	public  int map[][];
	public  BufferedImage layer;
	private BufferedImage tileSet;
	private int mapaWidth;
	private int mapaHeight;
	private int tileWidth;
	private int tileHeight;

	public Layer(int mapaWidth, int mapaHeight, int tileWidth, int tileHeight, String img, String arquivo) {
		this.mapaWidth=mapaWidth;
		this.mapaHeight=mapaHeight;
		this.tileWidth=tileWidth;
		this.tileHeight=tileHeight;
		
		map = new int[mapaWidth][mapaHeight];
		map = loadMatrix(map, arquivo);
		
		try {
			tileSet = ImageIO.read(new File(img));
		} catch (IOException e) {
			System.out.println("Erro no MAPA.\nEncerrando a Aplicação");
			System.exit(0);
		}
	}

	public int[][] loadMatrix(int[][] matz, String arquivo) {
		ArrayList<String> linhasMatrizCamada = new ArrayList<String>();
		InputStream is = getClass().getClassLoader().getResourceAsStream (arquivo);
		BufferedReader br = new BufferedReader (new InputStreamReader (is));   
		String linha="";
		try {

			while ((linha = br.readLine()) != null){
				System.out.println(linha);
				linhasMatrizCamada.add(linha);
			}
			int j = 0;
			for (int i = 0; i < linhasMatrizCamada.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhasMatrizCamada.get(i), ",");

				while (token.hasMoreElements()) {
					matz[i][j] = Integer.parseInt(token.nextToken());
					j++;
				}
				j = 0;
			}
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("nao carregou arquivo mapa");
			System.exit(0);
		}
		catch (IOException ioException) {
			System.out.println("erro na leitura do mapa");
			System.exit(0);
		}
		return matz;
	}

	public void assembleMap() {

		int lar = tileWidth * mapaWidth;
		int alt = tileHeight * mapaHeight;
		
		layer = new BufferedImage(lar, alt, BufferedImage.TYPE_4BYTE_ABGR);
		layer.createGraphics();

		int tile;
		int tileRow;
		int tileCol;
		int colunasTileSet=tileSet.getWidth()/tileWidth;
//		System.out.println(colunasTileSet);
		
		for (int i = 0; i < mapaWidth; i++) {
			for (int j = 0; j < mapaHeight; j++) {
				tile = (map[i][j] != 0) ? (map[i][j]-1) : 43;
				tileRow = (tile / (colunasTileSet)) | 0;
				tileCol = (tile % (colunasTileSet)) | 0;
				layer.getGraphics().drawImage(tileSet, (j * tileHeight), (i * tileWidth), (j * tileHeight) + tileHeight,
						(i * tileWidth) + tileWidth, (tileCol * tileHeight), (tileRow * tileWidth),
						(tileCol * tileHeight) + tileHeight, (tileRow * tileWidth) + tileWidth, null);
			}
		}
	}
	
	/**
	 * @return lista de Rectangle para calculo da colisÃ£o 
	 */
	public List<Rectangle> montarColisao() {
		List<Rectangle> tmp = new ArrayList<Rectangle>();
		for (int i = 0; i < mapaWidth; i++) {
			for (int j = 0; j < mapaHeight; j++) {
				if(map[i][j] != 0) {
					tmp.add(new Rectangle( (j * tileHeight), (i * tileWidth), tileWidth-3, tileHeight-30));
				}		
			}
		}
		tmp.add(new Rectangle(0, 0, 640, 1)); // topo
		tmp.add(new Rectangle(0, 640, 640, 1)); // baixo
		tmp.add(new Rectangle(0, 0, 1, 640)); // esquerda
		tmp.add(new Rectangle(645, 0, 1, 645)); // direita
		return tmp;
	}
}