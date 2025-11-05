import classes.Guitarist;

public class MainClass {

    public static void main(String[] args) {
        Guitarist bro = new Guitarist(
            "Darshan",
            Genre.Folk,
            2,
            GuitarType.Classical
        );

        if (bro.lastRecording.isPresent()) {
            System.out.println(
                bro.name + " was last recording " + bro.lastRecording
            );
        }
    }
}
