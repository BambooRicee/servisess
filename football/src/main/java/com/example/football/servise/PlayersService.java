package com.example.football.servise;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.example.football.model.Players;
@Service
public class PlayersService {
	public Players getPlayers(String footballId, String playersId) {
		Players players = new Players();
		players.setId(new Random().nextInt(1000));
		players.setPlayersId(playersId);
		players.setFootballId(footballId);
		players.setName("Сальников Кирилл Иванович");
		players.setPosition("Вратарь");
		players.setDateOfBirth("21.01.2000");
		players.setHeight("182");
		players.setHeight("72");
		return players;
		}
	public String createPlayers(Players players, String footballId){
		String responseMessage = null;
		if(players != null) {
			players.setFootballId(footballId);
			responseMessage = String.format("This is the post and the object is: %s",
					players.toString());
			}
		return responseMessage;
		}
	public String updatePlayers(Players players, String 
			footballId){
		String responseMessage = null;
		if (players != null) {
			players.setFootballId(footballId);
			responseMessage = String.format("This is the put and the object is: %s", 
					players.toString());
			}
		return responseMessage;
		}
	public String deletePlayers(String footballId, String playersId){
		String responseMessage = null;
		responseMessage = String.format("Deleting license with id %s for the football team %s",
				playersId, footballId);
		return responseMessage;
		}
}
