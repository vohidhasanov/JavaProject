package Func.MyWorks.CallingBack;

import javax.swing.*;

public class SomeClass {
    String replayTo;

    interface CallBack {
        void callingBack(String s);
    }

    CallBack callBack;

    public void registerCallBack (CallBack callBack) {
        this.callBack = callBack;
    }

    void dosomething () {
       // JOptionPane.showMessageDialog (null, "Are you developer");
        int reply = JOptionPane.showConfirmDialog(null, "Are you a developer", "Poll", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.NO_OPTION) {
            replayTo = "No";
        }
        if (reply == JOptionPane.YES_OPTION) {
            replayTo = "Yes";
        }
        callBack.callingBack(replayTo);

    }
}
