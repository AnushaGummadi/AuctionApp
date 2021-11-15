package main.rest.model;

public class UnicornCreateResponse {
    private Long unicornId;
    public UnicornCreateResponse(Long unicornId){
        this.unicornId =unicornId;
    }

    public Long getUnicornId() {
        return unicornId;
    }

    public void setUnicornId(final Long unicornId) {
        this.unicornId = unicornId;
    }
}
