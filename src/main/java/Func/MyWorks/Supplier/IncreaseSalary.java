package Func.MyWorks.Supplier;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Consumer;

interface FocusEventProducerMixin {
    void addFocusListener (FocusListener l);

    default void addFocusGainedListener (Consumer <FocusEvent>c) {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                c.accept(e);
            }
                    });
            }

    default void addFocusLostListener (Consumer <FocusEvent> c) {
        addFocusListener(new FocusAdapter() {
            public void focusLost (FocusEvent e) {c.accept(e);}
        });
    }
}

 class JButtonLamda extends JButton implements FocusEventProducerMixin  {

    public JButtonLamda() {};
    public JButtonLamda (Icon icon) {super (icon);}
    public JButtonLamda (String text) {super(text);}
    public JButtonLamda (Action a) {super (a);}
    public JButtonLamda (String text, Icon icon) {super(text, icon);}


}


