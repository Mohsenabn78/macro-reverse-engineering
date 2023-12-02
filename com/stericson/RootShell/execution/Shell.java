package com.stericson.RootShell.execution;

import android.content.Context;
import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class Shell {

    /* renamed from: t  reason: collision with root package name */
    private static Shell f37458t;

    /* renamed from: u  reason: collision with root package name */
    private static Shell f37459u;

    /* renamed from: v  reason: collision with root package name */
    private static Shell f37460v;

    /* renamed from: a  reason: collision with root package name */
    private int f37462a;

    /* renamed from: b  reason: collision with root package name */
    private ShellType f37463b;

    /* renamed from: c  reason: collision with root package name */
    private ShellContext f37464c;

    /* renamed from: d  reason: collision with root package name */
    private String f37465d;

    /* renamed from: e  reason: collision with root package name */
    private final Process f37466e;

    /* renamed from: f  reason: collision with root package name */
    private final BufferedReader f37467f;

    /* renamed from: g  reason: collision with root package name */
    private final BufferedReader f37468g;

    /* renamed from: h  reason: collision with root package name */
    private final OutputStreamWriter f37469h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Command> f37470i;
    public boolean isClosed;
    public boolean isExecuting;
    public boolean isReading;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37471j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f37472k;

    /* renamed from: l  reason: collision with root package name */
    private int f37473l;

    /* renamed from: m  reason: collision with root package name */
    private int f37474m;

    /* renamed from: n  reason: collision with root package name */
    private int f37475n;

    /* renamed from: o  reason: collision with root package name */
    private int f37476o;

    /* renamed from: p  reason: collision with root package name */
    private int f37477p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f37478q;

    /* renamed from: r  reason: collision with root package name */
    private Runnable f37479r;

    /* renamed from: s  reason: collision with root package name */
    private Runnable f37480s;

    /* renamed from: w  reason: collision with root package name */
    private static String[] f37461w = {null, null};
    public static ShellContext defaultContext = ShellContext.NORMAL;

    /* loaded from: classes6.dex */
    public enum ShellContext {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0"),
        SUPERSU("u:r:supersu:s0");
        
        private String value;

        ShellContext(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes6.dex */
    public enum ShellType {
        NORMAL,
        ROOT,
        CUSTOM
    }

    /* loaded from: classes6.dex */
    protected static class Worker extends Thread {
        public int exit;
        public Shell shell;

        /* synthetic */ Worker(Shell shell, a aVar) {
            this(shell);
        }

        private void a() {
            Class cls;
            Field declaredField;
            try {
                try {
                    declaredField = this.shell.f37466e.getClass().getDeclaredField("pid");
                } catch (NoSuchFieldException unused) {
                    declaredField = cls.getDeclaredField("id");
                }
                declaredField.setAccessible(true);
                int intValue = ((Integer) declaredField.get(this.shell.f37466e)).intValue();
                OutputStreamWriter outputStreamWriter = this.shell.f37469h;
                outputStreamWriter.write("(echo -17 > /proc/" + intValue + "/oom_adj) &> /dev/null\n");
                this.shell.f37469h.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.shell.f37469h.flush();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.shell.f37469h.write("echo Started\n");
                this.shell.f37469h.flush();
                while (true) {
                    String readLine = this.shell.f37467f.readLine();
                    if (readLine != null) {
                        if (!"".equals(readLine)) {
                            if (!"Started".equals(readLine)) {
                                this.shell.f37465d = "unknown error occurred.";
                            } else {
                                this.exit = 1;
                                a();
                                return;
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            } catch (IOException e4) {
                this.exit = -42;
                if (e4.getMessage() == null) {
                    this.shell.f37465d = "RootAccess denied?.";
                    return;
                }
                this.shell.f37465d = e4.getMessage();
            }
        }

        private Worker(Shell shell) {
            this.exit = -911;
            this.shell = shell;
        }
    }

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Command command;
            while (true) {
                try {
                    try {
                        synchronized (Shell.this.f37470i) {
                            while (!Shell.this.f37471j && Shell.this.f37475n >= Shell.this.f37470i.size()) {
                                Shell shell = Shell.this;
                                shell.isExecuting = false;
                                shell.f37470i.wait();
                            }
                        }
                        if (Shell.this.f37475n >= Shell.this.f37473l) {
                            while (Shell.this.f37474m != Shell.this.f37475n) {
                                RootShell.log("Waiting for read and write to catch up before cleanup.");
                            }
                            Shell.this.w();
                        }
                        if (Shell.this.f37475n < Shell.this.f37470i.size()) {
                            Shell shell2 = Shell.this;
                            shell2.isExecuting = true;
                            try {
                                command = (Command) shell2.f37470i.get(Shell.this.f37475n);
                            } catch (Exception unused) {
                                command = null;
                            }
                            if (command != null) {
                                command.f();
                                RootShell.log("Executing: " + command.getCommand() + " with context: " + Shell.this.f37464c);
                                Shell.this.f37469h.write(command.getCommand());
                                Shell.this.f37469h.flush();
                                Shell.this.f37469h.write("\necho F*D^W@#FGF " + Shell.this.f37476o + " $?\n");
                                Shell.this.f37469h.flush();
                                Shell.m(Shell.this);
                                Shell.v(Shell.this);
                            }
                        } else if (Shell.this.f37471j) {
                            Shell shell3 = Shell.this;
                            shell3.isExecuting = false;
                            shell3.f37469h.write("\nexit 0\n");
                            Shell.this.f37469h.flush();
                            RootShell.log("Closing shell");
                            return;
                        }
                    } catch (IOException | InterruptedException e4) {
                        RootShell.log(e4.getMessage(), RootShell.LogLevel.ERROR, e4);
                        return;
                    }
                } finally {
                    Shell.this.f37475n = 0;
                    Shell shell4 = Shell.this;
                    shell4.y(shell4.f37469h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends Thread {
        b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (Shell.this.f37470i) {
                Shell.this.f37470i.notifyAll();
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
            r9.f37485a.f37466e.waitFor();
            r9.f37485a.f37466e.destroy();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
            r9.f37485a.processErrors(r1);
            r4 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0121, code lost:
            if (r1 == null) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
            if (r1.totalOutput <= r1.totalOutputProcessed) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
            if (r4 != 0) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x012b, code lost:
            r4 = r4 + 1;
            com.stericson.RootShell.RootShell.log("Waiting for output to be processed. " + r1.totalOutputProcessed + " Of " + r1.totalOutput);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x014d, code lost:
            monitor-enter(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0150, code lost:
            wait(2000);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0153, code lost:
            monitor-exit(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0158, code lost:
            r5 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0159, code lost:
            com.stericson.RootShell.RootShell.log(r5.getMessage());
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0161, code lost:
            continue;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 466
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stericson.RootShell.execution.Shell.c.run():void");
        }
    }

    private Shell(String str, ShellType shellType, ShellContext shellContext, int i4) throws IOException, TimeoutException, RootDeniedException {
        this.f37462a = PluginInstanceData.MAXIMUM_BUNDLE_SIZE_BYTES;
        this.f37463b = null;
        ShellContext shellContext2 = ShellContext.NORMAL;
        this.f37464c = shellContext2;
        this.f37465d = "";
        this.f37470i = new ArrayList();
        this.f37471j = false;
        this.f37472k = null;
        this.isExecuting = false;
        this.isReading = false;
        this.isClosed = false;
        this.f37473l = 5000;
        this.f37474m = 0;
        this.f37475n = 0;
        this.f37476o = 0;
        this.f37477p = 0;
        this.f37478q = false;
        this.f37479r = new a();
        this.f37480s = new c();
        RootShell.log("Starting shell: " + str);
        RootShell.log("Context: " + shellContext.getValue());
        RootShell.log("Timeout: " + i4);
        this.f37463b = shellType;
        this.f37462a = i4 <= 0 ? this.f37462a : i4;
        this.f37464c = shellContext;
        if (shellContext == shellContext2) {
            this.f37466e = Runtime.getRuntime().exec(str);
        } else {
            String z3 = z(false);
            String z4 = z(true);
            if (isSELinuxEnforcing() && z3 != null && z4 != null && z3.endsWith("SUPERSU") && Integer.valueOf(z4).intValue() >= 190) {
                str = str + " --context " + this.f37464c.getValue();
            } else {
                RootShell.log("Su binary --context switch not supported!");
                RootShell.log("Su binary display version: " + z3);
                RootShell.log("Su binary internal version: " + z4);
                RootShell.log("SELinuxEnforcing: " + isSELinuxEnforcing());
            }
            this.f37466e = Runtime.getRuntime().exec(str);
        }
        this.f37467f = new BufferedReader(new InputStreamReader(this.f37466e.getInputStream(), "UTF-8"));
        this.f37468g = new BufferedReader(new InputStreamReader(this.f37466e.getErrorStream(), "UTF-8"));
        this.f37469h = new OutputStreamWriter(this.f37466e.getOutputStream(), "UTF-8");
        Worker worker = new Worker(this, null);
        worker.start();
        try {
            worker.join(this.f37462a);
            int i5 = worker.exit;
            if (i5 != -911) {
                if (i5 != -42) {
                    Thread thread = new Thread(this.f37479r, "Shell Input");
                    thread.setPriority(5);
                    thread.start();
                    Thread thread2 = new Thread(this.f37480s, "Shell Output");
                    thread2.setPriority(5);
                    thread2.start();
                    return;
                }
                try {
                    this.f37466e.destroy();
                } catch (Exception unused) {
                }
                x(this.f37467f);
                x(this.f37468g);
                y(this.f37469h);
                throw new RootDeniedException("Root Access Denied");
            }
            try {
                this.f37466e.destroy();
            } catch (Exception unused2) {
            }
            x(this.f37467f);
            x(this.f37468g);
            y(this.f37469h);
            throw new TimeoutException(this.f37465d);
        } catch (InterruptedException unused3) {
            worker.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    public static void closeAll() throws IOException {
        RootShell.log("Request to close all shells!");
        closeShell();
        closeRootShell();
        closeCustomShell();
    }

    public static void closeCustomShell() throws IOException {
        RootShell.log("Request to close custom shell!");
        Shell shell = f37460v;
        if (shell == null) {
            return;
        }
        shell.close();
    }

    public static void closeRootShell() throws IOException {
        RootShell.log("Request to close root shell!");
        Shell shell = f37458t;
        if (shell == null) {
            return;
        }
        shell.close();
    }

    public static void closeShell() throws IOException {
        RootShell.log("Request to close normal shell!");
        Shell shell = f37459u;
        if (shell == null) {
            return;
        }
        shell.close();
    }

    static /* synthetic */ int e(Shell shell) {
        int i4 = shell.f37477p;
        shell.f37477p = i4 + 1;
        return i4;
    }

    public static Shell getOpenShell() {
        Shell shell = f37460v;
        if (shell != null) {
            return shell;
        }
        Shell shell2 = f37458t;
        if (shell2 != null) {
            return shell2;
        }
        return f37459u;
    }

    public static boolean isAnyShellOpen() {
        if (f37459u == null && f37458t == null && f37460v == null) {
            return false;
        }
        return true;
    }

    public static boolean isCustomShellOpen() {
        if (f37460v == null) {
            return true;
        }
        return false;
    }

    public static boolean isRootShellOpen() {
        if (f37458t == null) {
            return true;
        }
        return false;
    }

    public static boolean isShellOpen() {
        if (f37459u == null) {
            return true;
        }
        return false;
    }

    static /* synthetic */ int m(Shell shell) {
        int i4 = shell.f37475n;
        shell.f37475n = i4 + 1;
        return i4;
    }

    static /* synthetic */ int q(Shell shell) {
        int i4 = shell.f37474m;
        shell.f37474m = i4 + 1;
        return i4;
    }

    public static Command runCommand(Command command) throws IOException, TimeoutException {
        return startShell().add(command);
    }

    public static Command runRootCommand(Command command) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell().add(command);
    }

    public static Shell startCustomShell(String str) throws IOException, TimeoutException, RootDeniedException {
        return startCustomShell(str, 0);
    }

    public static Shell startRootShell() throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(0, 3);
    }

    public static Shell startShell() throws IOException, TimeoutException {
        return startShell(0);
    }

    static /* synthetic */ int v(Shell shell) {
        int i4 = shell.f37476o;
        shell.f37476o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f37478q = true;
        int i4 = this.f37473l;
        int abs = Math.abs(i4 - (i4 / 4));
        RootShell.log("Cleaning up: " + abs);
        for (int i5 = 0; i5 < abs; i5++) {
            this.f37470i.remove(0);
        }
        this.f37474m = this.f37470i.size() - 1;
        this.f37475n = this.f37470i.size() - 1;
        this.f37478q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }

    private synchronized String z(boolean z3) {
        char c4;
        String str;
        if (z3) {
            c4 = 0;
        } else {
            c4 = 1;
        }
        if (f37461w[c4] == null) {
            String str2 = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                if (z3) {
                    str = "su -V";
                } else {
                    str = "su -v";
                }
                Process exec = runtime.exec(str, (String[]) null);
                exec.waitFor();
                ArrayList<String> arrayList = new ArrayList();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        }
                    } catch (IOException unused) {
                    }
                    try {
                        break;
                    } catch (IOException unused2) {
                    }
                }
                bufferedReader.close();
                exec.destroy();
                for (String str3 : arrayList) {
                    if (!z3) {
                        if (str3.contains(".")) {
                        }
                    } else {
                        try {
                        } catch (NumberFormatException unused3) {
                            continue;
                        }
                        if (Integer.parseInt(str3) > 0) {
                        }
                    }
                    str2 = str3;
                }
                f37461w[c4] = str2;
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            } catch (InterruptedException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return f37461w[c4];
    }

    protected void A() {
        new b().start();
    }

    public Command add(Command command) throws IOException {
        if (!this.f37471j) {
            if (!command.f37446e) {
                do {
                } while (this.f37478q);
                this.f37470i.add(command);
                A();
                return command;
            }
            throw new IllegalStateException("This command has already been executed. (Don't re-use command instances.)");
        }
        throw new IllegalStateException("Unable to add commands to a closed shell");
    }

    public void close() throws IOException {
        RootShell.log("Request to close shell!");
        int i4 = 0;
        while (this.isExecuting) {
            RootShell.log("Waiting on shell to finish executing before closing...");
            i4++;
            if (i4 > 10000) {
                break;
            }
        }
        synchronized (this.f37470i) {
            this.f37471j = true;
            A();
        }
        RootShell.log("Shell Closed!");
        if (this == f37458t) {
            f37458t = null;
        } else if (this == f37459u) {
            f37459u = null;
        } else if (this == f37460v) {
            f37460v = null;
        }
    }

    public int getCommandQueuePosition(Command command) {
        return this.f37470i.indexOf(command);
    }

    public String getCommandQueuePositionString(Command command) {
        return "Command is in position " + getCommandQueuePosition(command) + " currently executing command at position " + this.f37475n + " and the number of commands is " + this.f37470i.size();
    }

    public synchronized boolean isSELinuxEnforcing() {
        boolean z3;
        if (this.f37472k == null) {
            Boolean bool = null;
            if (new File("/sys/fs/selinux/enforce").exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                    try {
                        if (fileInputStream.read() == 49) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        bool = Boolean.valueOf(z3);
                        fileInputStream.close();
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                } catch (Exception unused) {
                }
            }
            if (bool == null) {
                bool = true;
            }
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            this.f37472k = bool;
        }
        return this.f37472k.booleanValue();
    }

    public void processErrors(Command command) {
        String readLine;
        while (this.f37468g.ready() && command != null && (readLine = this.f37468g.readLine()) != null) {
            try {
                command.d(command.f37453l, readLine);
            } catch (Exception e4) {
                RootShell.log(e4.getMessage(), RootShell.LogLevel.ERROR, e4);
                return;
            }
        }
    }

    public Shell switchRootShellContext(ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        if (this.f37463b == ShellType.ROOT) {
            try {
                closeRootShell();
            } catch (Exception unused) {
                RootShell.log("Problem closing shell while trying to switch context...");
            }
            return startRootShell(this.f37462a, shellContext, 3);
        }
        RootShell.log("Can only switch context on a root shell!");
        return this;
    }

    public final void useCWD(Context context) throws IOException, TimeoutException, RootDeniedException {
        add(new Command(-1, false, "cd " + context.getApplicationInfo().dataDir));
    }

    public static Shell startCustomShell(String str, int i4) throws IOException, TimeoutException, RootDeniedException {
        if (f37460v == null) {
            RootShell.log("Starting Custom Shell!");
            f37460v = new Shell(str, ShellType.CUSTOM, ShellContext.NORMAL, i4);
        } else {
            RootShell.log("Using Existing Custom Shell!");
        }
        return f37460v;
    }

    public static Shell startRootShell(int i4) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(i4, 3);
    }

    public static Shell startShell(int i4) throws IOException, TimeoutException {
        try {
            if (f37459u == null) {
                RootShell.log("Starting Shell!");
                f37459u = new Shell("/system/bin/sh", ShellType.NORMAL, ShellContext.NORMAL, i4);
            } else {
                RootShell.log("Using Existing Shell!");
            }
            return f37459u;
        } catch (RootDeniedException unused) {
            throw new IOException();
        }
    }

    public static Shell startRootShell(int i4, int i5) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(i4, defaultContext, i5);
    }

    public static Shell startRootShell(int i4, ShellContext shellContext, int i5) throws IOException, TimeoutException, RootDeniedException {
        int i6;
        Shell shell = f37458t;
        if (shell == null) {
            RootShell.log("Starting Root Shell!");
            int i7 = 0;
            while (f37458t == null) {
                try {
                    RootShell.log("Trying to open Root Shell, attempt #" + i7);
                    f37458t = new Shell("su", ShellType.ROOT, shellContext, i4);
                } catch (RootDeniedException e4) {
                    i6 = i7 + 1;
                    if (i7 >= i5) {
                        RootShell.log("RootDeniedException, could not start shell");
                        throw e4;
                    }
                    i7 = i6;
                } catch (IOException e5) {
                    i6 = i7 + 1;
                    if (i7 >= i5) {
                        RootShell.log("IOException, could not start shell");
                        throw e5;
                    }
                    i7 = i6;
                } catch (TimeoutException e6) {
                    i6 = i7 + 1;
                    if (i7 >= i5) {
                        RootShell.log("TimeoutException, could not start shell");
                        throw e6;
                    }
                    i7 = i6;
                }
            }
        } else if (shell.f37464c != shellContext) {
            try {
                RootShell.log("Context is different than open shell, switching context... " + f37458t.f37464c + " VS " + shellContext);
                f37458t.switchRootShellContext(shellContext);
            } catch (RootDeniedException e7) {
                if (i5 <= 0) {
                    RootShell.log("RootDeniedException, could not switch context!");
                    throw e7;
                }
            } catch (IOException e8) {
                if (i5 <= 0) {
                    RootShell.log("IOException, could not switch context!");
                    throw e8;
                }
            } catch (TimeoutException e9) {
                if (i5 <= 0) {
                    RootShell.log("TimeoutException, could not switch context!");
                    throw e9;
                }
            }
        } else {
            RootShell.log("Using Existing Root Shell!");
        }
        return f37458t;
    }
}
