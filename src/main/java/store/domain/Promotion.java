package store.domain;

public class Promotion {
    private String name;
    private int buy;
    private int get;
    private String start_date;
    private String end_date;

    public Promotion(String name, int buy, int get, String start_date, String end_date) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
