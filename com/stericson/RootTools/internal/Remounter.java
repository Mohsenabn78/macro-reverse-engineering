package com.stericson.RootTools.internal;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.Constants;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.containers.Mount;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class Remounter {
    private void a(Command command) {
        synchronized (command) {
            try {
                if (!command.isFinished()) {
                    command.wait(2000L);
                }
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
        }
    }

    private Mount b(String str) {
        try {
            ArrayList<Mount> mounts = RootTools.getMounts();
            File file = new File(str);
            while (true) {
                Iterator<Mount> it = mounts.iterator();
                while (it.hasNext()) {
                    Mount next = it.next();
                    if (next.getMountPoint().equals(file)) {
                        return next;
                    }
                }
            }
        } catch (IOException e4) {
            if (RootTools.debugMode) {
                e4.printStackTrace();
                return null;
            }
            return null;
        } catch (Exception e5) {
            if (RootTools.debugMode) {
                e5.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public boolean remount(String str, String str2) {
        String str3;
        Remounter remounter = this;
        String str4 = str;
        if (str4.endsWith(RemoteSettings.FORWARD_SLASH_STRING) && !str4.equals(RemoteSettings.FORWARD_SLASH_STRING)) {
            str4 = str4.substring(0, str4.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING));
        }
        boolean z3 = false;
        while (!z3) {
            try {
                Iterator<Mount> it = RootTools.getMounts().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Mount next = it.next();
                    RootTools.log(next.getMountPoint().toString());
                    if (str4.equals(next.getMountPoint().toString())) {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    try {
                        str4 = new File(str4).getParent();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return false;
                    }
                }
            } catch (Exception e5) {
                if (RootTools.debugMode) {
                    e5.printStackTrace();
                }
                return false;
            }
        }
        Mount b4 = remounter.b(str4);
        if (b4 != null) {
            RootTools.log(Constants.TAG, "Remounting " + b4.getMountPoint().getAbsolutePath() + " as " + str2.toLowerCase());
            if (!b4.getFlags().contains(str2.toLowerCase())) {
                try {
                    String[] strArr = new String[17];
                    str3 = Constants.TAG;
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("busybox mount -o remount,");
                        try {
                            sb.append(str2.toLowerCase());
                            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            sb.append(b4.getDevice().getAbsolutePath());
                            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            sb.append(b4.getMountPoint().getAbsolutePath());
                            strArr[0] = sb.toString();
                            strArr[1] = "busybox mount -o remount," + str2.toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str4;
                            strArr[2] = "busybox mount -o " + str2.toLowerCase() + ",remount " + b4.getDevice().getAbsolutePath();
                            strArr[3] = "busybox mount -o " + str2.toLowerCase() + ",remount " + str4;
                            strArr[4] = "toolbox mount -o remount," + str2.toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getDevice().getAbsolutePath() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getMountPoint().getAbsolutePath();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("toolbox mount -o remount,");
                            sb2.append(str2.toLowerCase());
                            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            sb2.append(str4);
                            strArr[5] = sb2.toString();
                            strArr[6] = "toybox mount -o remount," + str2.toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getDevice().getAbsolutePath() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getMountPoint().getAbsolutePath();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("toolbox mount -o ");
                            sb3.append(str2.toLowerCase());
                            sb3.append(",remount ");
                            sb3.append(b4.getDevice().getAbsolutePath());
                            strArr[7] = sb3.toString();
                            strArr[8] = "toolbox mount -o " + str2.toLowerCase() + ",remount " + str4;
                            strArr[9] = "mount -o remount," + str2.toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getDevice().getAbsolutePath() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getMountPoint().getAbsolutePath();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("mount -o remount,");
                            sb4.append(str2.toLowerCase());
                            sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            sb4.append(str4);
                            strArr[10] = sb4.toString();
                            strArr[11] = "mount -o " + str2.toLowerCase() + ",remount " + b4.getDevice().getAbsolutePath();
                            strArr[12] = "mount -o " + str2.toLowerCase() + ",remount " + str4;
                            strArr[13] = "toybox mount -o remount," + str2.toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getDevice().getAbsolutePath() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + b4.getMountPoint().getAbsolutePath();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("toybox mount -o remount,");
                            sb5.append(str2.toLowerCase());
                            sb5.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            sb5.append(str4);
                            strArr[14] = sb5.toString();
                            strArr[15] = "toybox mount -o " + str2.toLowerCase() + ",remount " + b4.getDevice().getAbsolutePath();
                            strArr[16] = "toybox mount -o " + str2.toLowerCase() + ",remount " + str4;
                            Command command = new Command(0, true, strArr);
                            Shell.startRootShell().add(command);
                            remounter = this;
                            remounter.a(command);
                        } catch (Exception unused) {
                            remounter = this;
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str3 = Constants.TAG;
                }
                b4 = remounter.b(str4);
            } else {
                str3 = Constants.TAG;
            }
            if (b4 != null) {
                RootTools.log(str3, b4.getFlags() + " AND " + str2.toLowerCase());
                if (b4.getFlags().contains(str2.toLowerCase())) {
                    RootTools.log(b4.getFlags().toString());
                    return true;
                }
                RootTools.log(b4.getFlags().toString());
                return false;
            }
            RootTools.log("mount is null, file was: " + str4 + " mountType was: " + str2);
            return false;
        }
        RootTools.log("mount is null, file was: " + str4 + " mountType was: " + str2);
        return false;
    }
}
