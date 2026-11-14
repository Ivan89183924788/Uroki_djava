package autoservice.enum_a;

public enum Srochnosty {
    OBICHNIY("Обычный"),
    SROCHNO("Срочный"),
    EXPRESS("Экспресс");
    private final String title;

    Srochnosty(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }
}
