package InterfaceExample;

public class TesterInterface {

    public static void main(String[] args) {
        Warrior wr = new Warrior();
        wr.setTeleportAbility(new CantTeleport());
        System.out.println(wr.teleporting());
        System.out.println(wr.teleportType);

    }
}
