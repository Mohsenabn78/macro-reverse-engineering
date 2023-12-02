package com.stericson.RootTools.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.Constants;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.containers.Mount;
import com.stericson.RootTools.containers.Permissions;
import com.stericson.RootTools.containers.Symlink;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

/* loaded from: classes6.dex */
public final class RootToolsInternalMethods {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends Command {
        a(int i4, boolean z3, String... strArr) {
            super(i4, z3, strArr);
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 9) {
                RootTools.log(str);
                String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                InternalVariables.f37520h.add(new Symlink(new File(split[split.length - 3]), new File(split[split.length - 1])));
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ String f37525n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ String f37526o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4, boolean z3, String[] strArr, String str, String str2) {
            super(i4, z3, strArr);
            this.f37525n = str;
            this.f37526o = str2;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (this.f37525n.endsWith("toolbox")) {
                if (!str.contains("no such tool")) {
                    InternalVariables.f37514b = true;
                }
            } else if (this.f37525n.endsWith("busybox") && str.contains(this.f37526o)) {
                RootTools.log("Found util!");
                InternalVariables.f37514b = true;
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ String f37528n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i4, boolean z3, String[] strArr, String str) {
            super(i4, z3, strArr);
            this.f37528n = str;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (str.contains(this.f37528n)) {
                InternalVariables.f37515c = true;
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ String f37530n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i4, boolean z3, String[] strArr, String str) {
            super(i4, z3, strArr);
            this.f37530n = str;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (str.contains(this.f37530n)) {
                Matcher matcher = InternalVariables.f37523k.matcher(str);
                try {
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        String str2 = InternalVariables.f37518f + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + group;
                        InternalVariables.f37518f = str2;
                        InternalVariables.f37518f = str2.trim();
                        RootTools.log("Found pid: " + group);
                    } else {
                        RootTools.log("Matching in ps command failed!");
                    }
                } catch (Exception e4) {
                    RootTools.log("Error with regex!");
                    e4.printStackTrace();
                }
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ List f37532n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i4, boolean z3, String[] strArr, List list) {
            super(i4, z3, strArr);
            this.f37532n = list;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 3 && !str.trim().equals("") && !str.trim().contains("not found") && !str.trim().contains("file busy")) {
                this.f37532n.add(str);
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ List f37534n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i4, boolean z3, String[] strArr, List list) {
            super(i4, z3, strArr);
            this.f37534n = list;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 3 && !str.trim().equals("") && !str.trim().contains("not found") && !str.trim().contains("file busy")) {
                this.f37534n.add(str);
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class g extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ StringBuilder f37536n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i4, boolean z3, String[] strArr, StringBuilder sb) {
            super(i4, z3, strArr);
            this.f37536n = sb;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            String trim = str.trim();
            if (i4 == 4) {
                RootTools.log("Version Output: " + trim);
                String[] split = trim.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (split.length > 1 && split[1].contains("v1.")) {
                    this.f37536n.append(split[1]);
                    RootTools.log("Found Version: " + this.f37536n.toString());
                }
            }
            super.commandOutput(i4, trim);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ StringBuilder f37538n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i4, boolean z3, String[] strArr, StringBuilder sb) {
            super(i4, z3, strArr);
            this.f37538n = sb;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            String trim = str.trim();
            if (i4 == 4) {
                RootTools.log("Version Output: " + trim);
                String[] split = trim.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (split.length > 1 && split[1].contains("v1.")) {
                    this.f37538n.append(split[1]);
                    RootTools.log("Found Version: " + this.f37538n.toString());
                }
            }
            super.commandOutput(i4, trim);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i extends Command {
        i(int i4, boolean z3, String... strArr) {
            super(i4, z3, strArr);
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 5 && !str.trim().equals("") && Character.isDigit(str.trim().substring(0, 1).toCharArray()[0])) {
                InternalVariables.f37521i = str.trim().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)[0];
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class j extends Command {
        j(int i4, boolean z3, String... strArr) {
            super(i4, z3, strArr);
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 1) {
                String str2 = "";
                if (str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)[0].length() != 10) {
                    super.commandOutput(i4, str);
                    return;
                }
                RootTools.log("Line " + str);
                try {
                    String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (split[split.length - 2].equals("->")) {
                        RootTools.log("Symlink found.");
                        str2 = split[split.length - 1];
                    }
                } catch (Exception unused) {
                }
                try {
                    Permissions permissions = RootToolsInternalMethods.this.getPermissions(str);
                    InternalVariables.f37522j = permissions;
                    if (permissions != null) {
                        permissions.setSymlink(str2);
                    }
                } catch (Exception e4) {
                    RootTools.log(e4.getMessage());
                }
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k extends Command {
        k(int i4, boolean z3, String... strArr) {
            super(i4, z3, strArr);
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 8) {
                RootTools.log(str);
                String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                InternalVariables.f37519g.add(new Mount(new File(split[0]), new File(split[1]), split[2], split[3]));
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class l extends Command {
        l(int i4, boolean z3, String... strArr) {
            super(i4, z3, strArr);
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 6 && str.contains(InternalVariables.f37517e.trim())) {
                InternalVariables.f37516d = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            super.commandOutput(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class m extends Command {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ List f37544n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(int i4, boolean z3, String[] strArr, List list) {
            super(i4, z3, strArr);
            this.f37544n = list;
        }

        @Override // com.stericson.RootShell.execution.Command
        public void commandOutput(int i4, String str) {
            if (i4 == 7 && !str.trim().equals("")) {
                this.f37544n.add(str);
            }
            super.commandOutput(i4, str);
        }
    }

    protected RootToolsInternalMethods() {
    }

    private void a(Shell shell, Command command) throws Exception {
        while (!command.isFinished()) {
            RootTools.log(Constants.TAG, shell.getCommandQueuePositionString(command));
            RootTools.log(Constants.TAG, "Processed " + command.totalOutputProcessed + " of " + command.totalOutput + " output from command.");
            synchronized (command) {
                try {
                    if (!command.isFinished()) {
                        command.wait(2000L);
                    }
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
            }
            if (!command.isExecuting() && !command.isFinished()) {
                boolean z3 = shell.isExecuting;
                if (!z3 && !shell.isReading) {
                    Log.e(Constants.TAG, "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + command.getCommand());
                    Exception exc = new Exception();
                    exc.setStackTrace(Thread.currentThread().getStackTrace());
                    exc.printStackTrace();
                } else if (z3 && !shell.isReading) {
                    Log.e(Constants.TAG, "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + command.getCommand());
                    Exception exc2 = new Exception();
                    exc2.setStackTrace(Thread.currentThread().getStackTrace());
                    exc2.printStackTrace();
                } else {
                    Log.e(Constants.TAG, "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + command.getCommand());
                    Exception exc3 = new Exception();
                    exc3.setStackTrace(Thread.currentThread().getStackTrace());
                    exc3.printStackTrace();
                }
            }
        }
    }

    public static void getInstance() {
        RootTools.setRim(new RootToolsInternalMethods());
    }

    public boolean checkUtil(String str) {
        String num;
        List<String> findBinary = RootShell.findBinary(str, true);
        if (findBinary.size() > 0) {
            for (String str2 : findBinary) {
                Permissions filePermissionsSymlinks = RootTools.getFilePermissionsSymlinks(str2 + RemoteSettings.FORWARD_SLASH_STRING + str);
                if (filePermissionsSymlinks != null) {
                    if (Integer.toString(filePermissionsSymlinks.getPermissions()).length() > 3) {
                        num = Integer.toString(filePermissionsSymlinks.getPermissions()).substring(1);
                    } else {
                        num = Integer.toString(filePermissionsSymlinks.getPermissions());
                    }
                    if (num.equals("755") || num.equals("777") || num.equals("775")) {
                        RootTools.utilPath = str2 + RemoteSettings.FORWARD_SLASH_STRING + str;
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        if (r13.getExitCode() == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0088, code lost:
        if (r13.getExitCode() == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008a, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008c, code lost:
        r10 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean copyFile(java.lang.String r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stericson.RootTools.internal.RootToolsInternalMethods.copyFile(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0097 A[Catch: Exception -> 0x000d, TRY_LEAVE, TryCatch #0 {Exception -> 0x000d, blocks: (B:4:0x0007, B:7:0x0010, B:10:0x001b, B:12:0x004e, B:22:0x0097, B:13:0x0052, B:15:0x0058, B:17:0x005e, B:19:0x0091), top: B:26:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean deleteFileOrDirectory(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "busybox"
            java.lang.String r1 = "rm"
            r2 = 0
            if (r9 == 0) goto L10
            java.lang.String r3 = "RW"
            com.stericson.RootTools.RootTools.remount(r8, r3)     // Catch: java.lang.Exception -> Ld
            goto L10
        Ld:
            r8 = move-exception
            goto L9e
        L10:
            java.lang.String r3 = "toolbox"
            boolean r3 = r7.hasUtil(r1, r3)     // Catch: java.lang.Exception -> Ld
            java.lang.String r4 = "target not exist or unable to delete file"
            r5 = 1
            if (r3 == 0) goto L52
            java.lang.String r0 = "rm command is available!"
            com.stericson.RootTools.RootTools.log(r0)     // Catch: java.lang.Exception -> Ld
            com.stericson.RootShell.execution.Command r0 = new com.stericson.RootShell.execution.Command     // Catch: java.lang.Exception -> Ld
            java.lang.String[] r1 = new java.lang.String[r5]     // Catch: java.lang.Exception -> Ld
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld
            r3.<init>()     // Catch: java.lang.Exception -> Ld
            java.lang.String r6 = "rm -r "
            r3.append(r6)     // Catch: java.lang.Exception -> Ld
            r3.append(r8)     // Catch: java.lang.Exception -> Ld
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Ld
            r1[r2] = r3     // Catch: java.lang.Exception -> Ld
            r0.<init>(r2, r2, r1)     // Catch: java.lang.Exception -> Ld
            com.stericson.RootShell.execution.Shell r1 = com.stericson.RootShell.execution.Shell.startRootShell()     // Catch: java.lang.Exception -> Ld
            r1.add(r0)     // Catch: java.lang.Exception -> Ld
            com.stericson.RootShell.execution.Shell r1 = com.stericson.RootShell.execution.Shell.startRootShell()     // Catch: java.lang.Exception -> Ld
            r7.a(r1, r0)     // Catch: java.lang.Exception -> Ld
            int r0 = r0.getExitCode()     // Catch: java.lang.Exception -> Ld
            if (r0 == 0) goto L95
            com.stericson.RootTools.RootTools.log(r4)     // Catch: java.lang.Exception -> Ld
            goto L94
        L52:
            boolean r3 = r7.checkUtil(r0)     // Catch: java.lang.Exception -> Ld
            if (r3 == 0) goto L95
            boolean r0 = r7.hasUtil(r1, r0)     // Catch: java.lang.Exception -> Ld
            if (r0 == 0) goto L95
            java.lang.String r0 = "busybox rm command is available!"
            com.stericson.RootTools.RootTools.log(r0)     // Catch: java.lang.Exception -> Ld
            com.stericson.RootShell.execution.Command r0 = new com.stericson.RootShell.execution.Command     // Catch: java.lang.Exception -> Ld
            java.lang.String[] r1 = new java.lang.String[r5]     // Catch: java.lang.Exception -> Ld
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld
            r3.<init>()     // Catch: java.lang.Exception -> Ld
            java.lang.String r6 = "busybox rm -rf "
            r3.append(r6)     // Catch: java.lang.Exception -> Ld
            r3.append(r8)     // Catch: java.lang.Exception -> Ld
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Ld
            r1[r2] = r3     // Catch: java.lang.Exception -> Ld
            r0.<init>(r2, r2, r1)     // Catch: java.lang.Exception -> Ld
            com.stericson.RootShell.execution.Shell r1 = com.stericson.RootShell.execution.Shell.startRootShell()     // Catch: java.lang.Exception -> Ld
            r1.add(r0)     // Catch: java.lang.Exception -> Ld
            com.stericson.RootShell.execution.Shell r1 = com.stericson.RootShell.execution.Shell.startRootShell()     // Catch: java.lang.Exception -> Ld
            r7.a(r1, r0)     // Catch: java.lang.Exception -> Ld
            int r0 = r0.getExitCode()     // Catch: java.lang.Exception -> Ld
            if (r0 == 0) goto L95
            com.stericson.RootTools.RootTools.log(r4)     // Catch: java.lang.Exception -> Ld
        L94:
            r5 = 0
        L95:
            if (r9 == 0) goto L9c
            java.lang.String r9 = "RO"
            com.stericson.RootTools.RootTools.remount(r8, r9)     // Catch: java.lang.Exception -> Ld
        L9c:
            r2 = r5
            goto La1
        L9e:
            r8.printStackTrace()
        La1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stericson.RootTools.internal.RootToolsInternalMethods.deleteFileOrDirectory(java.lang.String, boolean):boolean");
    }

    public void fixUtil(String str, String str2) {
        try {
            RootTools.remount("/system", "rw");
            List<String> findBinary = RootShell.findBinary(str, true);
            if (findBinary.size() > 0) {
                Iterator<String> it = findBinary.iterator();
                while (it.hasNext()) {
                    Command command = new Command(0, false, str2 + " rm " + it.next() + RemoteSettings.FORWARD_SLASH_STRING + str);
                    RootShell.getShell(true).add(command);
                    a(RootShell.getShell(true), command);
                }
                Command command2 = new Command(0, false, str2 + " ln -s " + str2 + " /system/bin/" + str, str2 + " chmod 0755 /system/bin/" + str);
                RootShell.getShell(true).add(command2);
                a(RootShell.getShell(true), command2);
            }
            RootTools.remount("/system", TranslateLanguage.ROMANIAN);
        } catch (Exception unused) {
        }
    }

    public boolean fixUtils(String[] strArr) throws Exception {
        for (String str : strArr) {
            if (!checkUtil(str)) {
                if (checkUtil("busybox")) {
                    if (hasUtil(str, "busybox")) {
                        fixUtil(str, RootTools.utilPath);
                    }
                } else if (!checkUtil("toolbox")) {
                    return false;
                } else {
                    if (hasUtil(str, "toolbox")) {
                        fixUtil(str, RootTools.utilPath);
                    }
                }
            }
        }
        return true;
    }

    public List<String> getBusyBoxApplets(String str) throws Exception {
        if (str != null && !str.endsWith(RemoteSettings.FORWARD_SLASH_STRING) && !str.equals("")) {
            str = str + RemoteSettings.FORWARD_SLASH_STRING;
        } else if (str == null) {
            throw new Exception("Path is null, please specifiy a path");
        }
        ArrayList arrayList = new ArrayList();
        e eVar = new e(3, false, new String[]{str + "busybox --list"}, arrayList);
        RootShell.getShell(false).add(eVar);
        a(RootShell.getShell(false), eVar);
        if (arrayList.size() <= 0) {
            f fVar = new f(3, false, new String[]{str + "busybox --list"}, arrayList);
            RootShell.getShell(true).add(fVar);
            a(RootShell.getShell(true), fVar);
        }
        return arrayList;
    }

    public String getBusyBoxVersion(String str) {
        StringBuilder sb = new StringBuilder();
        if (!str.equals("") && !str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = str + RemoteSettings.FORWARD_SLASH_STRING;
        }
        try {
            g gVar = new g(4, false, new String[]{str + "busybox"}, sb);
            RootTools.log("Getting BusyBox Version without root");
            Shell shell = RootTools.getShell(false);
            shell.add(gVar);
            a(shell, gVar);
            if (sb.length() <= 0) {
                h hVar = new h(4, false, new String[]{str + "busybox"}, sb);
                RootTools.log("Getting BusyBox Version with root");
                Shell shell2 = RootTools.getShell(true);
                shell2.add(hVar);
                a(shell2, hVar);
            }
            RootTools.log("Returning found version: " + sb.toString());
            return sb.toString();
        } catch (Exception unused) {
            RootTools.log("BusyBox was not found, more information MAY be available with Debugging on.");
            return "";
        }
    }

    public long getConvertedSpace(String str) {
        double d4;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int i4 = 0;
            while (true) {
                if (i4 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i4);
                if (!Character.isDigit(charAt) && charAt != '.') {
                    if (charAt != 'm' && charAt != 'M') {
                        if (charAt == 'g' || charAt == 'G') {
                            d4 = 1048576.0d;
                        }
                    }
                    d4 = 1024.0d;
                } else {
                    stringBuffer.append(str.charAt(i4));
                    i4++;
                }
            }
            d4 = 1.0d;
            return (long) Math.ceil(Double.valueOf(stringBuffer.toString()).doubleValue() * d4);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public Permissions getFilePermissionsSymlinks(String str) {
        RootTools.log("Checking permissions for " + str);
        if (RootTools.exists(str)) {
            RootTools.log(str + " was found.");
            try {
                j jVar = new j(1, false, "ls -l " + str, "busybox ls -l " + str, "/system/bin/failsafe/toolbox ls -l " + str, "toolbox ls -l " + str);
                RootShell.getShell(true).add(jVar);
                a(RootShell.getShell(true), jVar);
                return InternalVariables.f37522j;
            } catch (Exception e4) {
                RootTools.log(e4.getMessage());
            }
        }
        return null;
    }

    public String getInode(String str) {
        try {
            i iVar = new i(5, false, "/data/local/ls -i " + str);
            Shell.startRootShell().add(iVar);
            a(Shell.startRootShell(), iVar);
            return InternalVariables.f37521i;
        } catch (Exception unused) {
            return "";
        }
    }

    public String getMountedAs(String str) throws Exception {
        ArrayList<Mount> mounts = getMounts();
        InternalVariables.f37519g = mounts;
        if (mounts != null) {
            Iterator<Mount> it = mounts.iterator();
            while (it.hasNext()) {
                Mount next = it.next();
                String absolutePath = next.getMountPoint().getAbsolutePath();
                if (absolutePath.equals(RemoteSettings.FORWARD_SLASH_STRING)) {
                    if (str.equals(RemoteSettings.FORWARD_SLASH_STRING)) {
                        return (String) next.getFlags().toArray()[0];
                    }
                } else {
                    if (!str.equals(absolutePath)) {
                        if (str.startsWith(absolutePath + RemoteSettings.FORWARD_SLASH_STRING)) {
                        }
                    }
                    RootTools.log((String) next.getFlags().toArray()[0]);
                    return (String) next.getFlags().toArray()[0];
                }
            }
            throw new Exception();
        }
        throw new Exception();
    }

    public ArrayList<Mount> getMounts() throws Exception {
        ArrayList<Mount> arrayList = new ArrayList<>();
        InternalVariables.f37519g = arrayList;
        if (arrayList.isEmpty()) {
            Shell shell = RootTools.getShell(true);
            k kVar = new k(8, false, "cat /proc/mounts");
            shell.add(kVar);
            a(shell, kVar);
        }
        return InternalVariables.f37519g;
    }

    public Permissions getPermissions(String str) {
        String str2 = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)[0];
        if (str2.length() == 10) {
            if (str2.charAt(0) == '-' || str2.charAt(0) == 'd' || str2.charAt(0) == 'l') {
                if (str2.charAt(1) == '-' || str2.charAt(1) == 'r') {
                    if (str2.charAt(2) == '-' || str2.charAt(2) == 'w') {
                        RootTools.log(str2);
                        Permissions permissions = new Permissions();
                        permissions.setType(str2.substring(0, 1));
                        RootTools.log(permissions.getType());
                        permissions.setUserPermissions(str2.substring(1, 4));
                        RootTools.log(permissions.getUserPermissions());
                        permissions.setGroupPermissions(str2.substring(4, 7));
                        RootTools.log(permissions.getGroupPermissions());
                        permissions.setOtherPermissions(str2.substring(7, 10));
                        RootTools.log(permissions.getOtherPermissions());
                        StringBuilder sb = new StringBuilder();
                        sb.append(parseSpecialPermissions(str2));
                        sb.append(parsePermissions(permissions.getUserPermissions()));
                        sb.append(parsePermissions(permissions.getGroupPermissions()));
                        sb.append(parsePermissions(permissions.getOtherPermissions()));
                        permissions.setPermissions(Integer.parseInt(sb.toString()));
                        return permissions;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public long getSpace(String str) {
        String[] strArr;
        int i4;
        String[] strArr2;
        InternalVariables.f37517e = str;
        RootTools.log("Looking for Space");
        try {
            l lVar = new l(6, false, "df " + str);
            Shell.startRootShell().add(lVar);
            a(Shell.startRootShell(), lVar);
        } catch (Exception unused) {
        }
        if (InternalVariables.f37516d != null) {
            RootTools.log("First Method");
            boolean z3 = false;
            for (String str2 : InternalVariables.f37516d) {
                RootTools.log(str2);
                if (z3) {
                    return getConvertedSpace(str2);
                }
                if (str2.equals("used,")) {
                    z3 = true;
                }
            }
            RootTools.log("Second Method");
            if (InternalVariables.f37516d[0].length() <= 5) {
                i4 = 2;
            } else {
                i4 = 3;
            }
            int i5 = 0;
            for (String str3 : InternalVariables.f37516d) {
                RootTools.log(str3);
                if (str3.length() > 0) {
                    RootTools.log(str3 + "Valid");
                    if (i5 == i4) {
                        return getConvertedSpace(str3);
                    }
                    i5++;
                }
            }
        }
        RootTools.log("Returning -1, space could not be determined.");
        return -1L;
    }

    public String getSymlink(String str) {
        RootTools.log("Looking for Symlink for " + str);
        try {
            ArrayList arrayList = new ArrayList();
            m mVar = new m(7, false, new String[]{"ls -l " + str}, arrayList);
            Shell.startRootShell().add(mVar);
            a(Shell.startRootShell(), mVar);
            String[] split = ((String) arrayList.get(0)).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (split.length > 2 && split[split.length - 2].equals("->")) {
                RootTools.log("Symlink found.");
                if (!split[split.length - 1].equals("") && !split[split.length - 1].contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                    List<String> findBinary = RootShell.findBinary(split[split.length - 1], true);
                    if (findBinary.size() > 0) {
                        return findBinary.get(0) + split[split.length - 1];
                    }
                    return split[split.length - 1];
                }
                return split[split.length - 1];
            }
        } catch (Exception e4) {
            if (RootTools.debugMode) {
                e4.printStackTrace();
            }
        }
        RootTools.log("Symlink not found");
        return "";
    }

    public ArrayList<Symlink> getSymlinks(String str) throws Exception {
        if (checkUtil("find")) {
            InternalVariables.f37520h = new ArrayList<>();
            a aVar = new a(0, false, "find " + str + " -type l -exec ls -l {} \\;");
            Shell.startRootShell().add(aVar);
            a(Shell.startRootShell(), aVar);
            ArrayList<Symlink> arrayList = InternalVariables.f37520h;
            if (arrayList != null) {
                return arrayList;
            }
            throw new Exception();
        }
        throw new Exception();
    }

    public String getWorkingToolbox() {
        if (RootTools.checkUtil("busybox")) {
            return "busybox";
        }
        if (RootTools.checkUtil("toolbox")) {
            return "toolbox";
        }
        return "";
    }

    public boolean hasEnoughSpaceOnSdCard(long j4) {
        RootTools.log("Checking SDcard size and that it is mounted as RW");
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (j4 >= statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) {
            return false;
        }
        return true;
    }

    public boolean hasUtil(String str, String str2) {
        StringBuilder sb;
        InternalVariables.f37514b = false;
        if (!str2.endsWith("toolbox") && !str2.endsWith("busybox")) {
            return false;
        }
        try {
            String[] strArr = new String[1];
            if (str2.endsWith("toolbox")) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(str);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(" --list");
            }
            strArr[0] = sb.toString();
            b bVar = new b(0, false, strArr, str2, str);
            RootTools.getShell(true).add(bVar);
            a(RootTools.getShell(true), bVar);
            if (InternalVariables.f37514b) {
                RootTools.log("Box contains " + str + " util!");
                return true;
            }
            RootTools.log("Box does not contain " + str + " util!");
            return false;
        } catch (Exception e4) {
            RootTools.log(e4.getMessage());
            return false;
        }
    }

    public boolean installBinary(Context context, int i4, String str, String str2) {
        try {
            return new com.stericson.RootTools.internal.a(context).d(i4, str, str2);
        } catch (IOException e4) {
            if (RootTools.debugMode) {
                e4.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public boolean isAppletAvailable(String str, String str2) {
        try {
            for (String str3 : getBusyBoxApplets(str2)) {
                if (str3.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e4) {
            RootTools.log(e4.toString());
            return false;
        }
    }

    public boolean isBinaryAvailable(Context context, String str) {
        try {
            return new com.stericson.RootTools.internal.a(context).e(str);
        } catch (IOException e4) {
            if (RootTools.debugMode) {
                e4.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public boolean isNativeToolsReady(int i4, Context context) {
        RootTools.log("Preparing Native Tools");
        InternalVariables.f37513a = false;
        try {
            com.stericson.RootTools.internal.a aVar = new com.stericson.RootTools.internal.a(context);
            if (aVar.e("nativetools")) {
                InternalVariables.f37513a = true;
            } else {
                InternalVariables.f37513a = aVar.d(i4, "nativetools", "700");
            }
            return InternalVariables.f37513a;
        } catch (IOException e4) {
            if (RootTools.debugMode) {
                e4.printStackTrace();
            }
            return false;
        }
    }

    public boolean isProcessRunning(String str) {
        RootTools.log("Checks if process is running: " + str);
        InternalVariables.f37515c = false;
        try {
            c cVar = new c(0, false, new String[]{"ps"}, str);
            RootTools.getShell(true).add(cVar);
            a(RootTools.getShell(true), cVar);
        } catch (Exception e4) {
            RootTools.log(e4.getMessage());
        }
        return InternalVariables.f37515c;
    }

    public boolean killProcess(String str) {
        RootTools.log("Killing process " + str);
        InternalVariables.f37518f = "";
        InternalVariables.f37515c = true;
        try {
            d dVar = new d(0, false, new String[]{"ps"}, str);
            RootTools.getShell(true).add(dVar);
            a(RootTools.getShell(true), dVar);
            String str2 = InternalVariables.f37518f;
            if (str2.equals("")) {
                return true;
            }
            try {
                Command command = new Command(0, false, "kill -9 " + str2);
                RootTools.getShell(true).add(command);
                a(RootTools.getShell(true), command);
                return true;
            } catch (Exception e4) {
                RootTools.log(e4.getMessage());
                return false;
            }
        } catch (Exception e5) {
            RootTools.log(e5.getMessage());
            return false;
        }
    }

    public void offerBusyBox(Activity activity) {
        RootTools.log("Launching Market for BusyBox");
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox")));
    }

    public void offerSuperUser(Activity activity) {
        RootTools.log("Launching Play Store for SuperSU");
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=eu.chainfire.supersu")));
    }

    public int parsePermissions(String str) {
        int i4;
        int i5;
        int i6;
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.charAt(0) == 'r') {
            i4 = 4;
        } else {
            i4 = 0;
        }
        RootTools.log("permission " + i4);
        RootTools.log("character " + lowerCase.charAt(0));
        if (lowerCase.charAt(1) == 'w') {
            i5 = i4 + 2;
        } else {
            i5 = i4 + 0;
        }
        RootTools.log("permission " + i5);
        RootTools.log("character " + lowerCase.charAt(1));
        if (lowerCase.charAt(2) != 'x' && lowerCase.charAt(2) != 's' && lowerCase.charAt(2) != 't') {
            i6 = i5 + 0;
        } else {
            i6 = i5 + 1;
        }
        RootTools.log("permission " + i6);
        RootTools.log("character " + lowerCase.charAt(2));
        return i6;
    }

    public int parseSpecialPermissions(String str) {
        int i4;
        if (str.charAt(2) == 's') {
            i4 = 4;
        } else {
            i4 = 0;
        }
        if (str.charAt(5) == 's') {
            i4 += 2;
        }
        if (str.charAt(8) == 't') {
            i4++;
        }
        RootTools.log("special permissions " + i4);
        return i4;
    }

    public Intent offerBusyBox(Activity activity, int i4) {
        RootTools.log("Launching Market for BusyBox");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox"));
        activity.startActivityForResult(intent, i4);
        return intent;
    }

    public Intent offerSuperUser(Activity activity, int i4) {
        RootTools.log("Launching Play Store for SuperSU");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=eu.chainfire.supersu"));
        activity.startActivityForResult(intent, i4);
        return intent;
    }
}
