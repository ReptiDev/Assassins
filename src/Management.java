import java.util.ArrayList;

public class Management
{
    public static final int teamMax = 2;
    public static ArrayList<Assassin> playerList = new ArrayList<Assassin>();
    public static ArrayList<Assassin> alivePlayers = new ArrayList<Assassin>();
    public static ArrayList<Assassin> deadPlayers = new ArrayList<Assassin>();
    public static ArrayList<Team> teamList = new ArrayList<Team>();
    public static ArrayList<Team> aliveTeams = new ArrayList<Team>();;
    public static ArrayList<Team> deadTeams = new ArrayList<Team>();;

    public static void assignFromKill(Assassin player, Assassin target)
    {
        player.getTeam().setTarget(target.getTeam().getTarget());
        target.getTeam().setTarget(null);
    }

    public static void endRound() {
        ArrayList<Team> unassigned = new ArrayList<Team>();
        ArrayList<Team> noTarget = new ArrayList<Team>();

        // Loop through all teams currently alive
        // Unassign all targets, add all teams to unassigned list
        for (int i = 0; i < aliveTeams.size(); i++) {
            aliveTeams.get(i).setTarget(null);
            unassigned.add(aliveTeams.get(i));
            noTarget.add(aliveTeams.get(i));
        }

        // Loop through unassigned list, assign teams randomly with following procedure
        // Assign the random
        for (int i = 0; i < noTarget.size(); i++) {
            int random = (int) (Math.random() * (unassigned.size()));
            noTarget.get(i).setTarget(unassigned.get(random));
            unassigned.remove(random);
        }
    }
}
