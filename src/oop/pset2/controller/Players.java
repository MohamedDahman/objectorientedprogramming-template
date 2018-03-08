package oop.pset2.controller;

import oop.pset2.model.ComputerPlayer;
import oop.pset2.model.HumanPlayer;
import oop.pset2.model.Player;

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
