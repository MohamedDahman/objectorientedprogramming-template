package oop.pset3.model;

import java.util.List;

public interface Move {

    String getName();
    List<Move> whoCanDefeat();



}
