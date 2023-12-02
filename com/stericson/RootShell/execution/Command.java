package com.stericson.RootShell.execution;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.stericson.RootShell.RootShell;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Command {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f37442a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f37443b;

    /* renamed from: c  reason: collision with root package name */
    c f37444c;

    /* renamed from: d  reason: collision with root package name */
    Handler f37445d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f37446e;

    /* renamed from: f  reason: collision with root package name */
    boolean f37447f;

    /* renamed from: g  reason: collision with root package name */
    String[] f37448g;

    /* renamed from: h  reason: collision with root package name */
    boolean f37449h;

    /* renamed from: i  reason: collision with root package name */
    boolean f37450i;

    /* renamed from: j  reason: collision with root package name */
    boolean f37451j;

    /* renamed from: k  reason: collision with root package name */
    int f37452k;

    /* renamed from: l  reason: collision with root package name */
    int f37453l;

    /* renamed from: m  reason: collision with root package name */
    int f37454m;
    public int totalOutput;
    public int totalOutputProcessed;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i4 = message.getData().getInt("action");
            String string = message.getData().getString("text");
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        Command command = Command.this;
                        command.commandTerminated(command.f37453l, string);
                        return;
                    }
                    return;
                }
                Command command2 = Command.this;
                command2.commandCompleted(command2.f37453l, command2.f37452k);
                return;
            }
            Command command3 = Command.this;
            command3.commandOutput(command3.f37453l, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final Command f37456a;

        public c(Command command) {
            this.f37456a = command;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Command command = this.f37456a;
            if (command.f37454m > 0) {
                synchronized (command) {
                    try {
                        RootShell.log("Command " + this.f37456a.f37453l + " is waiting for: " + this.f37456a.f37454m);
                        Command command2 = this.f37456a;
                        command2.wait((long) command2.f37454m);
                    } catch (InterruptedException e4) {
                        RootShell.log("Exception: " + e4);
                    }
                    if (!this.f37456a.isFinished()) {
                        RootShell.log("Timeout Exception has occurred for command: " + this.f37456a.f37453l + ".");
                        Command.this.g("Timeout Exception");
                    }
                }
            }
        }
    }

    public Command(int i4, String... strArr) {
        this.f37442a = false;
        this.f37443b = null;
        this.totalOutput = 0;
        this.totalOutputProcessed = 0;
        this.f37444c = null;
        this.f37445d = null;
        this.f37446e = false;
        this.f37447f = false;
        this.f37448g = new String[0];
        this.f37449h = false;
        this.f37450i = false;
        this.f37451j = true;
        this.f37452k = -1;
        this.f37454m = RootShell.defaultCommandTimeout;
        this.f37448g = strArr;
        this.f37453l = i4;
        b(RootShell.handlerEnabled);
    }

    private void b(boolean z3) {
        this.f37451j = z3;
        if (Looper.myLooper() != null && z3) {
            RootShell.log("CommandHandler created");
            this.f37445d = new b();
            return;
        }
        RootShell.log("CommandHandler not created");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        if (!this.f37450i) {
            synchronized (this) {
                Handler handler = this.f37445d;
                if (handler != null && this.f37451j) {
                    Message obtainMessage = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 2);
                    obtainMessage.setData(bundle);
                    this.f37445d.sendMessage(obtainMessage);
                } else {
                    commandCompleted(this.f37453l, this.f37452k);
                }
                RootShell.log("Command " + this.f37453l + " finished.");
                c();
            }
        }
    }

    protected final void c() {
        this.f37447f = false;
        this.f37449h = true;
        notifyAll();
    }

    public void commandOutput(int i4, String str) {
        RootShell.log("Command", "ID: " + i4 + ", " + str);
        this.totalOutputProcessed = this.totalOutputProcessed + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i4, String str) {
        this.totalOutput++;
        Handler handler = this.f37445d;
        if (handler != null && this.f37451j) {
            Message obtainMessage = handler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("text", str);
            obtainMessage.setData(bundle);
            this.f37445d.sendMessage(obtainMessage);
            return;
        }
        commandOutput(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(int i4) {
        synchronized (this) {
            this.f37452k = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f() {
        this.f37446e = true;
        c cVar = new c(this);
        this.f37444c = cVar;
        cVar.setPriority(1);
        this.f37444c.start();
        this.f37447f = true;
    }

    public final void finish() {
        RootShell.log("Command finished at users request!");
        a();
    }

    protected final void g(String str) {
        try {
            Shell.closeAll();
            RootShell.log("Terminating all shells.");
            h(str);
        } catch (IOException unused) {
        }
    }

    public final String getCommand() {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        if (!this.f37442a) {
            while (true) {
                String[] strArr = this.f37448g;
                if (i4 >= strArr.length) {
                    break;
                }
                sb.append(strArr[i4]);
                sb.append('\n');
                i4++;
            }
        } else {
            String path = this.f37443b.getFilesDir().getPath();
            while (i4 < this.f37448g.length) {
                if (Build.VERSION.SDK_INT > 22) {
                    sb.append("export CLASSPATH=");
                    sb.append(path);
                    sb.append("/anbuild.dex;");
                    sb.append(" app_process /system/bin ");
                    sb.append(this.f37448g[i4]);
                } else {
                    sb.append("dalvikvm -cp " + path + "/anbuild.dex com.android.internal.util.WithFramework com.stericson.RootTools.containers.RootClass " + this.f37448g[i4]);
                }
                sb.append('\n');
                i4++;
            }
        }
        return sb.toString();
    }

    public final int getExitCode() {
        return this.f37452k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(String str) {
        synchronized (this) {
            Handler handler = this.f37445d;
            if (handler != null && this.f37451j) {
                Message obtainMessage = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 3);
                bundle.putString("text", str);
                obtainMessage.setData(bundle);
                this.f37445d.sendMessage(obtainMessage);
            } else {
                commandTerminated(this.f37453l, str);
            }
            RootShell.log("Command " + this.f37453l + " did not finish because it was terminated. Termination reason: " + str);
            e(-1);
            this.f37450i = true;
            c();
        }
    }

    public final boolean isExecuting() {
        return this.f37447f;
    }

    public final boolean isFinished() {
        return this.f37449h;
    }

    public final boolean isHandlerEnabled() {
        return this.f37451j;
    }

    public final void terminate() {
        RootShell.log("Terminating command at users request!");
        h("Terminated at users request!");
    }

    public Command(int i4, boolean z3, String... strArr) {
        this.f37442a = false;
        this.f37443b = null;
        this.totalOutput = 0;
        this.totalOutputProcessed = 0;
        this.f37444c = null;
        this.f37445d = null;
        this.f37446e = false;
        this.f37447f = false;
        this.f37448g = new String[0];
        this.f37449h = false;
        this.f37450i = false;
        this.f37451j = true;
        this.f37452k = -1;
        this.f37454m = RootShell.defaultCommandTimeout;
        this.f37448g = strArr;
        this.f37453l = i4;
        b(z3);
    }

    public Command(int i4, int i5, String... strArr) {
        this.f37442a = false;
        this.f37443b = null;
        this.totalOutput = 0;
        this.totalOutputProcessed = 0;
        this.f37444c = null;
        this.f37445d = null;
        this.f37446e = false;
        this.f37447f = false;
        this.f37448g = new String[0];
        this.f37449h = false;
        this.f37450i = false;
        this.f37451j = true;
        this.f37452k = -1;
        boolean z3 = RootShell.debugMode;
        this.f37448g = strArr;
        this.f37453l = i4;
        this.f37454m = i5;
        b(RootShell.handlerEnabled);
    }

    public void commandCompleted(int i4, int i5) {
    }

    public void commandTerminated(int i4, String str) {
    }
}
