package org.example;

public class Player {

    private int playerId;
    private String name;
    private int points;

    public Player(int id){
        this.playerId = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    public int compareTo(Player other)
    {
        if (this.getPoints() == other.getPoints())
        {
            return 0;
        }
        else if (this.getPoints() > other.getPoints())
        {
            return 1;
        }
        else
            return -1;
    }
}
