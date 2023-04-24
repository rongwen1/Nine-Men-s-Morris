package src;

public class Token {

    private TokenState tokenState;
    private TokenState placing;
    private TokenState moving;
    private TokenState flying;

    private int id;

    public Token(int id) {
        this.id = id;
        placing = new Placing(this);
        moving =  new Moving(this);
        flying = new Flying(this);
    }

    public TokenState getTokenState() { return tokenState; }

    public TokenState getPlacing() { return placing; }

    public TokenState getMoving() { return moving; }

    public TokenState getFlying() { return flying; }

    public int getId() { return id; }

    public void setTokenState(TokenState newTokenState) {
        this.tokenState = newTokenState;
    }

    public ActionList getAllowableActions() {
        return tokenState.getAllowableActions();
    }


}