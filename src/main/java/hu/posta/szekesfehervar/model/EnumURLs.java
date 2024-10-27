package hu.posta.szekesfehervar.model;

public enum EnumURLs {

    WORKSHEET_URL("/Users/blaskopeter/Desktop/posta1.xlsx"),
    TYPE2("https://example.com/type2"),
    TYPE3("https://example.com/type3");

    private final String url;

    EnumURLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
