package pyland.model;

public class Room implements IRoom {
    private IPlayer visitor;

    public Room() {
        visitor = null;
    }

    @Override
    public IPlayer getVisitor() {
        return visitor;
    }

    @Override
    public void setVisitor(IPlayer player) {
        if (visitor == null &&
                player != null && !player.hasLeft() &&
                (player.getLocation() == null || player.getLocation() == this)) {
            visitor = player;
            //player.setLocation(this);
        } else {
            throw new AssertionError();
        }
    }

    @Override
    public void unsetVisitor() {
        if (visitor != null && !getVisitor().hasLeft()) {
            //visitor.unsetLocation();
            visitor = null;
        } else {
            throw new AssertionError();
        }
    }
}
