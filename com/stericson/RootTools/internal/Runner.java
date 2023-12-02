package com.stericson.RootTools.internal;

import android.content.Context;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.RootTools;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Runner extends Thread {

    /* renamed from: a  reason: collision with root package name */
    Context f37546a;

    /* renamed from: b  reason: collision with root package name */
    String f37547b;

    /* renamed from: c  reason: collision with root package name */
    String f37548c;

    public Runner(Context context, String str, String str2) {
        this.f37546a = context;
        this.f37547b = str;
        this.f37548c = str2;
    }

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

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        try {
            str = this.f37546a.getFilesDir().getCanonicalPath();
        } catch (IOException e4) {
            if (RootTools.debugMode) {
                Log.e("RootTools::Runner", "Problem occured while trying to locate private files directory!");
            }
            e4.printStackTrace();
            str = null;
        }
        if (str != null) {
            try {
                Command command = new Command(0, false, str + RemoteSettings.FORWARD_SLASH_STRING + this.f37547b + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f37548c);
                Shell.startRootShell().add(command);
                a(command);
            } catch (Exception unused) {
            }
        }
    }
}
