package model.entity;

public enum Role {
    ADMIN(0),
    MODERATOR(1),
    SPEAKER(2),
    USER(3);

    private int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
