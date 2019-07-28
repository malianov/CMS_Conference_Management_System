package model.entity;

public enum Role {
    ADMIN, MODERATOR, SPEAKER, PARTICIPANT;

    public int getRoleID(){
        return ordinal();
    }

    public static Role getRoleById(int id){

        return values()[id];
    }

}
