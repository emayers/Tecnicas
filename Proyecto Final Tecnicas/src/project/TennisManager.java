package project;

import java.io.*;
import java.util.Scanner;

public class TennisManager {
	private static Scanner op, add, aux; //Scanners utilizados en cada funcion
	static boolean flag = true; //Flag en caso de que se introduzca una opcion no valida
	static File filePlayers = new File("previousMatch.csv"); /*File que contiene 
																el partido anterior*/
	static String FileHeadPlay = "Jugador, Jugada, Puntaje"; //Cabecera del juego
	static Player player1, player2, winner = null; //Jugadores del partido actual
	static int score1 = 0, score2 = 0; /*Score que van teniendo los jugadores 1 y 2
	 									respectivamente*/
	
	/*Función para agregar un partido nuevo. 
	 * Retorna el jugador ganador del partido. */
	public static void addMatch(){
		add = new Scanner(System.in);
		
		//Comprueba si ya existe un partido creado. Si es así, lo elimina o no
		if(checkFile()){
			String select = "";
			System.out.println("\nExiste un partido guardado. "
					+ "Si añade otro, perderá el anterior. ¿Desea añadirlo aún así?");
			System.out.println("Presione 'Y' para sí");
			System.out.println("Presione 'N' para no");
			select = add.nextLine();
			
			while(flag){
				switch(select.toUpperCase()){
					case "Y":
						filePlayers.delete();
						flag = false;
						break;
					
					case "N":
						main(null);
						
					default:
						System.out.println("\nOpción inválida. Por favor seleccione otra\n");
						break;
				}
			}
		}
		
		//Variables utilizadas por la funcion addMatch()
		String name1, name2, jugada;
		int i = 1, j = 1;
		Games game;
		Sets set;
		Matches match;
		flag = true;
		
		System.out.println("\nIntroduzca el nombre del 1er jugador:");
		name1 = add.nextLine().toUpperCase();
		System.out.println("\nIntroduzca el nombre del 2do jugador:");
		name2 = add.nextLine().toUpperCase();
		String FileHeadMatch = name1 + " VS " + name2, FileHeadSets, FileHeadGame;
		
		player1 = new Player();
		player2 = new Player();
		player1.setName(name1);
		player2.setName(name2);
		player1.setScore(score1);
		player2.setScore(score2);
		set = new Sets();
		set.setPlayer1(player1);
		set.setPlayer2(player2);
		match = new Matches();
		match.setPlayer1(player1);
		match.setPlayer2(player2);
		game = new Games();
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		
		//Confirma que el archivo exista, y si no lo crea
		if(!checkFile()){
			try{
				filePlayers.createNewFile();
				FileWriter fw = new FileWriter(filePlayers, true);
				fw.append(FileHeadMatch);
				fw.append('\n');
				fw.append('\n');
				fw.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		else{
			try{
				FileWriter fw = new FileWriter(filePlayers, true);
				fw.append('\n');
				fw.append(FileHeadMatch);
				fw.append('\n');
				fw.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
		//Loop para el conteo de los match de cada jugador
		while(match.player1.SetsList.size() < 2 && match.player2.SetsList.size() < 2){
			FileHeadSets = "Set #" + i;
			try{
				FileWriter fw = new FileWriter(filePlayers, true);
				fw.append(FileHeadSets);
				fw.append('\n');
				fw.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
			
			//Loop para el conteo de los sets de cada jugador
			while(set.player1.GamesList.size() < 6 && set.player2.GamesList.size() < 6){
				FileHeadGame = "Juego #" + j;
				try{
					FileWriter fw = new FileWriter(filePlayers, true);
					fw.append(FileHeadGame);
					fw.append('\n');
					fw.close();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				
				/*Loop para el conteo de los juegos de cada jugador, detallando
				 * las jugadas y los puntos de cada uno */
				while(game.player1.score < 4 && game.player2.score < 4){
					int select;
					System.out.println("\nSeleccione el jugador que anotó puntos:\n");
					System.out.println("Presione '1' para el jugador " + player1.name);
					System.out.println("Presione '2' para el jugador " + player2.name);
					
					while(flag){
						select = add.nextInt();
						
						System.out.println("\nSeleccione la jugada hecha:\n");
						System.out.println("1. Serve");
						System.out.println("2. Forehand");
						System.out.println("3. Backhand");
						System.out.println("4. Volley");
						System.out.println("5. Half-Volley");
						System.out.println("6. Lob");
						System.out.println("7. Overhead-Smash");
						System.out.println("8. Drop-Shot");
						System.out.println("9. Counter Drop-Shot");
						
						aux = new Scanner(System.in);
						int play;
						
						switch(select){
						case 1:
							play = aux.nextInt();
							
							while(play < 1 || play > 9){
								System.out.println("\nOpción inválida. "
										+ "Por favor seleccione otra\n");
								play = aux.nextInt();
							}
							
							jugada = plays(player1, play);
							score1++;
							player1.setScore(score1);
							
							try{
								FileWriter fw = new FileWriter(filePlayers, true);
								fw.append(FileHeadPlay);
								fw.append('\n');
								fw.append(player1.name + "," + jugada + "," 
								+ Integer.toString((player1.score * 15)));
								fw.append('\n');
								fw.close();
							}
							catch(IOException ex){
								ex.printStackTrace();
							}
							
							flag = false;
							break;
							
						case 2:
							play = aux.nextInt();
							
							while(play < 1 || play > 9){
								System.out.println("\nOpción inválida. "
										+ "Por favor seleccione otra\n");
								play = aux.nextInt();
							}
							jugada = plays(player2, play);
							score2++;
							player2.setScore(score2);
							
							try{
								FileWriter fw = new FileWriter(filePlayers, true);
								fw.append(FileHeadPlay);
								fw.append('\n');
								fw.append(player2.name + "," + jugada + "," 
								+ Integer.toString((player2.score * 15)));
								fw.append('\n');
								fw.close();
							}
							catch(IOException ex){
								ex.printStackTrace();
							}
							
							flag = false;
							break;
							
						default: 
							System.out.println("\nOpción inválida. Por favor seleccione otra\n");
							break;
						}
					}
					
					flag = true;
					
					System.out.println("\nPuntos de " + player1.name + ": " 
					+ (player1.score * 15));
					System.out.println("Puntos de " + player2.name + ": " 
					+ (player2.score * 15));
					
					//Chequea si se produjo un Deuce
					if(player1.score == 3 && player2.score == 3){
						System.out.println("Deuce");
						score1 = score1 - 1;
						player1.setScore(score1);
						score2 = score2 - 1;
						player2.setScore(score2);
						
						try{
							FileWriter fw = new FileWriter(filePlayers, true);
							fw.append("Deuce");
							fw.append('\n');
							fw.close();
						}
						catch(IOException ex){
							ex.printStackTrace();
						}
					}
				}
				
				//Determina cual jugador gano el juego y reinicia el conteo de puntos
				if(player1.score == 4){
					player1.GamesList.add(game);
					System.out.println("\nEl ganador del juego #" + j + " es " + player1.name);
					System.out.println("\n");
					try{
						FileWriter fw = new FileWriter(filePlayers, true);
						fw.append("Ganador juego #" + j + ": " + player1.name);
						fw.append('\n');
						fw.append('\n');
						fw.close();
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
				}
				else{
					player2.GamesList.add(game);
					System.out.println("\nEl ganador del juego #" + j + " es " + player2.name);
					System.out.println("\n");
					try{
						FileWriter fw = new FileWriter(filePlayers, true);
						fw.append("Ganador juego #" + j + ": " + player2.name);
						fw.append('\n');
						fw.append('\n');
						fw.close();
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
				}
				score1 = score2 = 0;
				player1.setScore(score1);
				player2.setScore(score2);
				j++;
			}
			
			//Determina cual jugador gano el set y reinicia el conteo de los juegos
			if(player1.GamesList.size() == 6){
				player1.SetsList.add(set);
				System.out.println("El ganador del set #" + i + " es " + player1.name);
				System.out.println("\n");
				try{
					FileWriter fw = new FileWriter(filePlayers, true);
					fw.append("Ganador set #" + i + ": " + player1.name);
					fw.append('\n');
					fw.append('\n');
					fw.close();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
			else{
				player2.SetsList.add(set);
				System.out.println("El ganador del set #" + i + " es " + player2.name);
				System.out.println("\n");
				try{
					FileWriter fw = new FileWriter(filePlayers, true);
					fw.append("Ganador set #" + i + ": " + player2.name);
					fw.append('\n');
					fw.append('\n');
					fw.close();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
			player1.GamesList.clear();
			player2.GamesList.clear();
			j = 1;
			i++;
			
			System.out.println("\nSets de " + player1.name + " : " + player1.SetsList.size());
			System.out.println("Sets de " + player2.name + " : " + player2.SetsList.size());
			
			//Chequea si se produce un Tiebreaker y lo maneja
			if(player1.SetsList.size() == 1 && player2.SetsList.size() == 1){
				System.out.println("Tiebreaker");
				score1 = score2 = 0;
				player1.setScore(score1);
				player2.setScore(score2);
				
				try{
					FileWriter fw = new FileWriter(filePlayers, true);
					fw.append("Tiebreaker");
					fw.append('\n');
					fw.close();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				
				tiebreaker(player1, player2).SetsList.add(set);
				break;
			}
		}
		
		//Determina cual jugador gano el partido
		winner = winner();
		winner.MatchesList.add(match);
		
		System.out.println("\nEl ganador del partido es " + winner.name);
		
		try{
			FileWriter fw = new FileWriter(filePlayers, true);
			fw.append('\n');
			fw.append("Ganador partido: " + winner.name);
			fw.append('\n');
			fw.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		main(null);
	}
	
	/*Metodo auxiliar de la funcion addMatch()
	 * Maneja la seleccion de jugadas hechas por el jugador que anoto */
	static String plays(Player player, int select){

			switch(select){
				case 1:
					return "Serve";
					
				case 2:
					return "Forehand";
					
				case 3:
					return "Backhand";
				
				case 4:
					return "Voley";
				
				case 5:
					return "Half-Volley";
				
				case 6:
					return "Lob";
				
				case 7:
					return "Overhead-Smash";
				
				case 8:
					return "Drop-Shot";
					
				case 9:
					return "Counter Drop-Shot";
				
				default:
					return "";
		}
	}
	
	/*Metodo auxiliar de la funcion addMatch()
	 * Maneja el escenario en el que ocurre un tiebreaker */
	static Player tiebreaker(Player player1, Player player2){
		
		while(player1.score < 7 && player2.score < 7){
			int select;
			String jugada;
			System.out.println("\nSeleccione el jugador que anoto puntos:\n");
			System.out.println("Presione '1' para el jugador " + player1.name);
			System.out.println("Presione '2' para el jugador " + player2.name);
			
			while(flag){
				select = add.nextInt();
				
				System.out.println("\nSeleccione la jugada hecha:\n");
				System.out.println("1. Serve");
				System.out.println("2. Forehand");
				System.out.println("3. Backhand");
				System.out.println("4. Volley");
				System.out.println("5. Half-Volley");
				System.out.println("6. Lob");
				System.out.println("7. Overhead-Smash");
				System.out.println("8. Drop-Shot");
				System.out.println("9. Counter Drop-Shot");
				
				aux = new Scanner(System.in);
				int play;
				
				switch(select){
				case 1:
					play = aux.nextInt();
					
					while(play < 1 || play > 9){
						System.out.println("\nOpción inválida."
								+ " Por favor seleccione otra\n");
						play = aux.nextInt();
					}
					
					jugada = plays(player1, play);
					score1++;
					player1.setScore(score1);
					
					try{
						FileWriter fw = new FileWriter(filePlayers, true);
						fw.append(FileHeadPlay);
						fw.append('\n');
						fw.append(player1.name + "," + jugada + "," 
						+ Integer.toString(player1.score));
						fw.append('\n');
						fw.close();
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
					
					flag = false;
					break;
					
				case 2:
					play = aux.nextInt();
					
					while(play < 1 || play > 9){
						System.out.println("\nOpción inválida. "
								+ "Por favor seleccione otra\n");
						play = aux.nextInt();
					}
					
					jugada = plays(player2, play);
					score2++;
					player2.setScore(score2);
					
					try{
						FileWriter fw = new FileWriter(filePlayers, true);
						fw.append(FileHeadPlay);
						fw.append('\n');
						fw.append(player2.name + "," + jugada + "," 
						+ Integer.toString(player2.score));
						fw.append('\n');
						fw.close();
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
					
					flag = false;
					break;
					
				default: 
					System.out.println("\nOpción inválida. Por favor seleccione otra\n");
					break;
				}
			}
			flag = true;
			
			System.out.println("\nPuntos de " + player1.name + ": " + player1.score);
			System.out.println("Puntos de " + player2.name + ": " + player2.score);
		}
		
		if(player1.score == 7){
			return player1;
		}
		else
			return player2;
	}
	
	/*Metodo auxiliar de la funcion addMatch()
	 * Determina cual jugador es el ganador del partido. */
	static Player winner(){
		
		if(player1.SetsList.size() == 2)
			return player1;
		else if(player2.SetsList.size() == 2)
			return player2;
		else
			return null;
	}
	
	//Funcion para imprimir el partido anteriormente guardado
	public static void previousMatch(){
		
		//Verifica si existe un partido guardado. De no ser así, lo maneja
		if(!checkFile()){
			System.out.println("\nNo existe un partido previo. Eliga otra opción.\n");
			main(null);
		}
		
		//Lee e imprime toda la información en el archivo guardado
		System.out.println("\nHISTORIAL PARTIDO:");
		try {
			BufferedReader r = new BufferedReader(new FileReader(filePlayers));
		
			String line = null;
			while ((line = r.readLine()) != null) {
			    System.out.print(line);
			    System.out.println();
			}
			
			r.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		main(null);
	}
	
	/*Metodo auxiliar de la funciones addMatch() y previousMatch()
	 * Verifica si existe o no un archivo creado con un partido anterior */
	static boolean checkFile(){
		return filePlayers.exists();
	}
	
	//Funcion para terminar la ejecucion
	public static void exit(){
		System.out.println("\nHa salido exitósamente.\n");
		System.exit(0);
	}
	
	//main()
	public static void main(String[] args) {
		op = new Scanner(System.in);
		
		int opcion;
		    
	    System.out.println("\nSeleccione una opción:");
	    System.out.println("1. Añadir un partido");
		System.out.println("2. Ver el partido anterior");
		System.out.println("3. Salir");
	    opcion = op.nextInt();
	    
	    switch (opcion) {
	    
	    case 1: addMatch();
	    break;
	    
	    case 2: previousMatch();
	    break;
	    
	    case 3: exit();
	    break;
	    
	    default: System.out.println("\nOpción inválida. Selecione otra opción.\n");
	    main(null);
	    break;
	    }
	}
}
