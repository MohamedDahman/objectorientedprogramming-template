package oop.pset3.controller;

import oop.pset3.model.ComputerPlayer;
import oop.pset3.model.HumanPlayer;
import oop.pset3.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Players {
    public List<Player> getTwoPlayers(){
        List<Player> players=new ArrayList<>();
        players.add(new HumanPlayer());
        players.add(new ComputerPlayer());
        return  players;
    }
}
