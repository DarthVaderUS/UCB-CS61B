package main;

import browser.NgordnetQueryHandler;
import ngrams.NGramMap;
import ngrams.TimeSeries;
import java.util.Collection;

public class HistoryHandler {
    private final NGramMap nGramMap;

    public HistoryHandler(NGramMap nGramMap) {
        this.nGramMap = nGramMap;
    }

    public TimeSeries getCountHistory(String word, int startYear, int endYear) {
        return nGramMap.countHistory(word, startYear, endYear);
    }

    public TimeSeries getWeightHistory(String word, int startYear, int endYear) {
        return nGramMap.weightHistory(word, startYear, endYear);
    }

    public TimeSeries getSummedWeightHistory(Collection<String> words, int startYear, int endYear) {
        return nGramMap.summedWeightHistory(words, startYear, endYear);
    }

    public TimeSeries getTotalCountHistory() {
        return nGramMap.totalCountHistory();
    }
}