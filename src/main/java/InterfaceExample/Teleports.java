package InterfaceExample;

public interface Teleports {
    String teleport();

}

class CanTeleport implements  Teleports {
    public  String teleport() {
        return "Can teleport";
    }
}

class CantTeleport implements  Teleports {
    public  String teleport() {
        return "Can not teleport";
    }


}
