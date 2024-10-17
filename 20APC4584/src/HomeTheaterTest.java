// Subsystem classes
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on");
    }

    public void play(String movie) {
        System.out.println("Playing '" + movie + "'");
    }

    public void off() {
        System.out.println("DVD Player is off");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound System is on");
    }

    public void setVolume(int level) {
        System.out.println("Sound System volume set to " + level);
    }

    public void off() {
        System.out.println("Sound System is off");
    }
}

// Facade class
class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem soundSystem) {
        this.dvd = dvd;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        dvd.on();                          // Line 39
        dvd.play(movie);                   // Line 40
        projector.on();                    // Line 41
        projector.wideScreenMode();        // Line 42
        soundSystem.on();                  // Line 43
        soundSystem.setVolume(5);          // Line 44
    }

    public void endMovie() {
        System.out.println("Shutting down the movie theater...");
        dvd.off();                         // Line 49
        projector.off();                   // Line 50
        soundSystem.off();                 // Line 51
    }
}

// Client code
public class HomeTheaterTest {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, soundSystem);
        homeTheater.watchMovie("Inception"); // Line 62
        homeTheater.endMovie();              // Line 63
    }
}
