package oop.pset1;

import oop.pset1.controller.MovieDatabaseSummarizer;
import oop.pset1.model.Summary;
import oop.pset1.view.SummaryDisplayer;


public class Pset1Main {

    public static void main(String[] args) {
        MovieDatabaseSummarizer summarizer = new MovieDatabaseSummarizer();

        SummaryDisplayer displayer = new SummaryDisplayer();

        Summary summary = new Summary();
        summary = summarizer.summarize();
        displayer.display(summary);


/*
        Optional<Summary> summary = new Summary;
        if(summary.isPresent()){
            displayer.display(summary.get());
        } else {
            displayer.display();
        }
    }*/
    }
}

