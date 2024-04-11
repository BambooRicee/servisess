package com.example.football.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.football.model.Players;
import com.example.football.servise.PlayersService;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
@RestController
@RequestMapping(value="v1/football/{footballId}/players")
public class PlayersController {
	@Autowired
	private PlayersService playersService;
	@RequestMapping(value="/{playersId}", method = RequestMethod.GET)
	public ResponseEntity<Players> getPlayers(
			@PathVariable("footballId") String footballId,
	        @PathVariable("playersId") String playersId) {
		Players players = playersService.getPlayers(playersId,footballId);
		players.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
				PlayersController.class).getPlayers(footballId, players.getPlayersId())).withSelfRel(),
		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayersController.class)
				.createPlayers(footballId, players))
		.withRel("createPlayers"),
	WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayersController.class)
			.updatePlayers(footballId, players))
	.withRel("updatePlayers"),
	WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayersController.class)
			.deletePlayers(footballId, players.getPlayersId()))
	.withRel("deletePlayers"));
		return ResponseEntity.ok(players);
		}

	@PutMapping
	public ResponseEntity<String> updatePlayers(
			@PathVariable("footballId") String footballId,
			@RequestBody Players request) {
		return ResponseEntity.ok(playersService.updatePlayers(request, footballId));
		}
	@PostMapping
	public ResponseEntity<String> createPlayers(
			@PathVariable("footballId") String footballId,
			@RequestBody Players request) {
		return ResponseEntity.ok(playersService.createPlayers(request, footballId));
		}
	@DeleteMapping(value="/{playersId}")
	public ResponseEntity<String> deletePlayers(
			@PathVariable("footballId") String footballId,
			@PathVariable("playersId") String playersId) {
		return ResponseEntity.ok(playersService.deletePlayers(playersId, footballId));
		}
	}