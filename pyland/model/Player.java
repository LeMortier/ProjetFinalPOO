package pyland.model;

public class Player implements IPlayer {
    private IRoom location;
    private boolean hasLeft;


    public Player() {
        location = null;
        hasLeft = false;
    }

    @Override
    public IRoom getLocation() {
        return location;
    }

    public boolean hasLeft() {
        return hasLeft;
    }

    @Override
    public void leave() {
        if (hasLeft()){
            throw new AssertionError();
        }
        hasLeft = true;
    }



    @Override
    public void setLocation(IRoom r) {
        if(!hasLeft() &&
                (getLocation() == null && r != null) &&
                (r.getVisitor() == null || r.getVisitor() == this)) {
            location = r;
            r.setVisitor(this);
        } else {
            throw new AssertionError();
        }
    }


    @Override
    public void unsetLocation() {
        if(!hasLeft() && getLocation() != null) {
            getLocation().unsetVisitor();
            location = null;
        } else {
            throw new AssertionError();
        }
    }
}
