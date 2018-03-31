package tunglt;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class PlayAlarm extends JFrame {
    AudioClip click;

    public PlayAlarm() {
        URL urlClick = PlayAlarm.class.getResource("alarma.wav");
        click = Applet.newAudioClip(urlClick);
        click.play();
    }
}