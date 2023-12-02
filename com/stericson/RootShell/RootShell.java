package com.stericson.RootShell;

import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class RootShell {
    public static boolean debugMode = false;
    public static int defaultCommandTimeout = 20000;
    public static boolean handlerEnabled = true;
    public static final String version = "RootShell v1.6";

    /* loaded from: classes6.dex */
    public enum LogLevel {
        VERBOSE,
        ERROR,
        DEBUG,
        WARN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ List f37424n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, boolean z3, String[] strArr, List list) {
            super(i4, z3, strArr);
            this.f37424n = list;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            RootShell.log(str);
            this.f37424n.add(str);
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ List f37425n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4, boolean z3, String[] strArr, List list) {
            super(i4, z3, strArr);
            this.f37425n = list;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            RootShell.log(str);
            this.f37425n.add(str);
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ String f37426n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ List f37427o;

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ String f37428p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i4, boolean z3, String[] strArr, String str, List list, String str2) {
            super(i4, z3, strArr);
            this.f37426n = str;
            this.f37427o = list;
            this.f37428p = str2;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (str.contains("File: ") && str.contains(this.f37426n)) {
                this.f37427o.add(this.f37428p);
                RootShell.log(this.f37426n + " was found here: " + this.f37428p);
            }
            RootShell.log(str);
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ Set f37429n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i4, boolean z3, String[] strArr, Set set) {
            super(i4, z3, strArr);
            this.f37429n = set;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 158) {
                this.f37429n.addAll(Arrays.asList(str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)));
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37430a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f37430a = iArr;
            try {
                iArr[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37430a[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37430a[LogLevel.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37430a[LogLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static void a(Shell shell, Command command) throws Exception {
        while (!command.isFinished()) {
            log(version, shell.getCommandQueuePositionString(command));
            log(version, "Processed " + command.totalOutputProcessed + " of " + command.totalOutput + " output from command.");
            synchronized (command) {
                try {
                    if (!command.isFinished()) {
                        command.wait(2000L);
                    }
                } catch (InterruptedException unused) {
                }
            }
            if (!command.isExecuting() && !command.isFinished()) {
                boolean z3 = shell.isExecuting;
                if (!z3 && !shell.isReading) {
                    log(version, "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + command.getCommand());
                    new Exception().setStackTrace(Thread.currentThread().getStackTrace());
                } else if (z3 && !shell.isReading) {
                    log(version, "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + command.getCommand());
                    new Exception().setStackTrace(Thread.currentThread().getStackTrace());
                } else {
                    log(version, "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + command.getCommand());
                    new Exception().setStackTrace(Thread.currentThread().getStackTrace());
                }
            }
        }
    }

    public static void closeAllShells() throws IOException {
        Shell.closeAll();
    }

    public static void closeCustomShell() throws IOException {
        Shell.closeCustomShell();
    }

    public static void closeShell(boolean z3) throws IOException {
        if (z3) {
            Shell.closeRootShell();
        } else {
            Shell.closeShell();
        }
    }

    public static boolean exists(String str) {
        return exists(str, false);
    }

    public static List<String> findBinary(String str, boolean z3) {
        return findBinary(str, null, z3);
    }

    public static Shell getCustomShell(String str, int i4) throws IOException, TimeoutException, RootDeniedException {
        return getCustomShell(str, i4);
    }

    public static List<String> getPath() {
        return Arrays.asList(System.getenv("PATH").split(":"));
    }

    public static Shell getShell(boolean z3, int i4, Shell.ShellContext shellContext, int i5) throws IOException, TimeoutException, RootDeniedException {
        if (z3) {
            return Shell.startRootShell(i4, shellContext, i5);
        }
        return Shell.startShell(i4);
    }

    public static boolean isAccessGiven() {
        return isAccessGiven(0, 3);
    }

    public static boolean isBusyboxAvailable() {
        return isBusyboxAvailable(false);
    }

    public static boolean isRootAvailable() {
        if (findBinary("su", true).size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean islog() {
        return debugMode;
    }

    public static void log(String str) {
        log(null, str, LogLevel.DEBUG, null);
    }

    public static boolean exists(String str, boolean z3) {
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("ls ");
        sb.append(z3 ? "-d " : MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        String sb2 = sb.toString();
        a aVar = new a(0, false, new String[]{sb2 + str}, arrayList);
        try {
            getShell(false).add(aVar);
            a(getShell(false), aVar);
            for (String str2 : arrayList) {
                if (str2.trim().equals(str)) {
                    return true;
                }
            }
            arrayList.clear();
            b bVar = new b(0, false, new String[]{sb2 + str}, arrayList);
            try {
                getShell(true).add(bVar);
                a(getShell(true), bVar);
                for (String str3 : new ArrayList(arrayList)) {
                    if (str3.trim().equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e4) {
                log("Exception: " + e4);
                return false;
            }
        } catch (Exception e5) {
            log("Exception: " + e5);
            return false;
        }
    }

    public static List<String> findBinary(String str, List<String> list, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            list = getPath();
        }
        log("Checking for " + str);
        boolean z4 = false;
        try {
            for (String str2 : list) {
                if (!str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    str2 = str2 + RemoteSettings.FORWARD_SLASH_STRING;
                }
                String str3 = str2;
                a(getShell(false), getShell(false).add(new c(0, false, new String[]{"stat " + str3 + str}, str, arrayList, str3)));
                if (arrayList.size() > 0 && z3) {
                    break;
                }
            }
            z4 = !arrayList.isEmpty();
        } catch (Exception unused) {
            log(str + " was not found, more information MAY be available with Debugging on.");
        }
        if (!z4) {
            log("Trying second method");
            for (String str4 : list) {
                if (!str4.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    str4 = str4 + RemoteSettings.FORWARD_SLASH_STRING;
                }
                if (exists(str4 + str)) {
                    log(str + " was found here: " + str4);
                    arrayList.add(str4);
                    if (arrayList.size() > 0 && z3) {
                        break;
                    }
                } else {
                    log(str + " was NOT found here: " + str4);
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static boolean isAccessGiven(int i4, int i5) {
        HashSet<String> hashSet = new HashSet();
        try {
            log("Checking for Root access");
            d dVar = new d(158, false, new String[]{"id"}, hashSet);
            Shell startRootShell = Shell.startRootShell(i4, i5);
            startRootShell.add(dVar);
            a(startRootShell, dVar);
            for (String str : hashSet) {
                log(str);
                if (str.toLowerCase().contains("uid=0")) {
                    log("Access Given");
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isBusyboxAvailable(boolean z3) {
        return z3 ? findBinary("busybox", true).size() > 0 || findBinary("toybox", true).size() > 0 : findBinary("busybox", true).size() > 0;
    }

    public static void log(String str, String str2) {
        log(str, str2, LogLevel.DEBUG, null);
    }

    public static Shell getShell(boolean z3, int i4, Shell.ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, i4, shellContext, 3);
    }

    public static void log(String str, LogLevel logLevel, Exception exc) {
        log(null, str, logLevel, exc);
    }

    public static Shell getShell(boolean z3, Shell.ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, 0, shellContext, 3);
    }

    public static void log(String str, String str2, LogLevel logLevel, Exception exc) {
        if (str2 == null || str2.equals("") || !debugMode) {
            return;
        }
        if (str == null) {
            str = version;
        }
        int i4 = e.f37430a[logLevel.ordinal()];
        if (i4 == 2) {
            Log.e(str, str2, exc);
        } else if (i4 != 4) {
        } else {
            Log.w(str, str2);
        }
    }

    public static Shell getShell(boolean z3, int i4) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, i4, Shell.defaultContext, 3);
    }

    public static Shell getShell(boolean z3) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, 0);
    }
}
