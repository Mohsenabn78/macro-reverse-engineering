package com.stericson.RootTools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.containers.Permissions;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class SanityCheckRootTools extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ScrollView f37487a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f37488b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressDialog f37489c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SanityCheckRootTools.this.f37487a.fullScroll(130);
        }
    }

    /* loaded from: classes6.dex */
    private class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Handler f37491a;

        /* loaded from: classes6.dex */
        class a extends Command {
            a(int i4, String... strArr) {
                super(i4, strArr);
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandOutput(int i4, String str) {
                b bVar = b.this;
                bVar.b(3, str + "\n");
                super.commandOutput(i4, str);
            }
        }

        /* renamed from: com.stericson.RootTools.SanityCheckRootTools$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0216b extends Command {
            C0216b(int i4, int i5, String... strArr) {
                super(i4, i5, strArr);
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandOutput(int i4, String str) {
                b bVar = b.this;
                bVar.b(3, str + "\n");
                super.commandOutput(i4, str);
            }
        }

        /* loaded from: classes6.dex */
        class c extends Command {
            c(int i4, String... strArr) {
                super(i4, strArr);
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandOutput(int i4, String str) {
                b bVar = b.this;
                bVar.b(3, str + "\n");
                super.commandOutput(i4, str);
            }
        }

        /* loaded from: classes6.dex */
        class d extends Command {
            d(int i4, String... strArr) {
                super(i4, strArr);
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandOutput(int i4, String str) {
                b bVar = b.this;
                bVar.b(3, str + "\n");
                super.commandOutput(i4, str);
            }
        }

        /* loaded from: classes6.dex */
        class e extends Command {
            e(int i4, String... strArr) {
                super(i4, strArr);
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandOutput(int i4, String str) {
                b bVar = b.this;
                bVar.b(3, str + "\n");
                super.commandOutput(i4, str);
            }
        }

        /* loaded from: classes6.dex */
        class f extends Command {

            /* renamed from: n  reason: collision with root package name */
            boolean f37498n;

            f(int i4, boolean z3, String... strArr) {
                super(i4, z3, strArr);
                this.f37498n = false;
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandCompleted(int i4, int i5) {
                synchronized (SanityCheckRootTools.this) {
                    this.f37498n = true;
                    b.this.b(4, "All tests complete.");
                    b.this.b(2, null);
                    try {
                        RootTools.closeAllShells();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandOutput(int i4, String str) {
                if (this.f37498n) {
                    RootTools.log("CAUGHT!!!");
                }
                super.commandOutput(i4, str);
            }

            @Override // com.stericson.RootShell.execution.Command
            public void commandTerminated(int i4, String str) {
                synchronized (SanityCheckRootTools.this) {
                    this.f37498n = true;
                    b.this.b(4, "All tests complete.");
                    b.this.b(2, null);
                    try {
                        RootTools.closeAllShells();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }

        public b(Context context, Handler handler) {
            this.f37491a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i4, String str) {
            Message obtainMessage = this.f37491a.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("action", i4);
            bundle.putString("text", str);
            obtainMessage.setData(bundle);
            this.f37491a.sendMessage(obtainMessage);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b(1, null);
            b(4, "Testing getPath");
            b(3, "[ getPath ]\n");
            try {
                Iterator<String> it = RootTools.getPath().iterator();
                while (it.hasNext()) {
                    b(3, it.next() + " k\n\n");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            b(4, "Testing A ton of commands");
            b(3, "[ Ton of Commands ]\n");
            for (int i4 = 0; i4 < 100; i4++) {
                RootTools.exists("/system/xbin/busybox");
            }
            b(4, "Testing Find Binary");
            boolean isRootAvailable = RootTools.isRootAvailable();
            b(3, "[ Checking Root ]\n");
            b(3, isRootAvailable + " k\n\n");
            b(4, "Testing file exists");
            b(3, "[ Checking Exists() ]\n");
            b(3, RootTools.exists("/system/sbin/[") + " k\n\n");
            b(4, "Testing Is Access Given");
            boolean isAccessGiven = RootTools.isAccessGiven();
            b(3, "[ Checking for Access to Root ]\n");
            b(3, isAccessGiven + " k\n\n");
            b(4, "Testing Remount");
            boolean remount = RootTools.remount("/system", "rw");
            b(3, "[ Remounting System as RW ]\n");
            b(3, remount + " k\n\n");
            b(4, "Testing CheckUtil");
            b(3, "[ Checking busybox is setup ]\n");
            b(3, RootTools.checkUtil("busybox") + " k\n\n");
            b(4, "Testing getBusyBoxVersion");
            b(3, "[ Checking busybox version ]\n");
            b(3, RootTools.getBusyBoxVersion("/system/xbin/") + " k\n\n");
            try {
                b(4, "Testing fixUtils");
                b(3, "[ Checking Utils ]\n");
                b(3, RootTools.fixUtils(new String[]{"ls", "rm", "ln", "dd", "chmod", "mount"}) + " k\n\n");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                b(4, "Testing getSymlink");
                b(3, "[ Checking [[ for symlink ]\n");
                b(3, RootTools.getSymlink("/system/bin/[[") + " k\n\n");
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            b(4, "Testing getInode");
            b(3, "[ Checking Inodes ]\n");
            b(3, RootTools.getInode("/system/bin/busybox") + " k\n\n");
            b(4, "Testing GetBusyBoxapplets");
            try {
                b(3, "[ Getting all available Busybox applets ]\n");
                Iterator<String> it2 = RootTools.getBusyBoxApplets("/data/data/stericson.busybox/files/bb/busybox").iterator();
                while (it2.hasNext()) {
                    b(3, it2.next() + " k\n\n");
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            b(4, "Testing GetBusyBox version in a special directory!");
            try {
                b(3, "[ Testing GetBusyBox version in a special directory! ]\n");
                String busyBoxVersion = RootTools.getBusyBoxVersion("/data/data/stericson.busybox/files/bb/");
                b(3, busyBoxVersion + " k\n\n");
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            b(4, "Testing getFilePermissionsSymlinks");
            Permissions filePermissionsSymlinks = RootTools.getFilePermissionsSymlinks("/system/xbin/busybox");
            b(3, "[ Checking busybox permissions and symlink ]\n");
            if (filePermissionsSymlinks != null) {
                b(3, "Symlink: " + filePermissionsSymlinks.getSymlink() + " k\n\n");
                b(3, "Group Permissions: " + filePermissionsSymlinks.getGroupPermissions() + " k\n\n");
                b(3, "Owner Permissions: " + filePermissionsSymlinks.getOtherPermissions() + " k\n\n");
                b(3, "Permissions: " + filePermissionsSymlinks.getPermissions() + " k\n\n");
                b(3, "Type: " + filePermissionsSymlinks.getType() + " k\n\n");
                b(3, "User Permissions: " + filePermissionsSymlinks.getUserPermissions() + " k\n\n");
            } else {
                b(3, "Permissions == null k\n\n");
            }
            b(4, "Testing output capture");
            b(3, "[ busybox ash --help ]\n");
            try {
                Shell shell = RootTools.getShell(true);
                shell.add(new a(0, "busybox ash --help"));
                b(4, "getevent - /dev/input/event0");
                b(3, "[ getevent - /dev/input/event0 ]\n");
                shell.add(new C0216b(0, 0, "getevent /dev/input/event0"));
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            b(4, "Switching RootContext - SYSTEM_APP");
            b(3, "[ Switching Root Context - SYSTEM_APP ]\n");
            try {
                Shell shell2 = RootTools.getShell(true, Shell.ShellContext.SYSTEM_APP);
                shell2.add(new c(0, "id"));
                b(4, "Testing PM");
                b(3, "[ Testing pm list packages -d ]\n");
                shell2.add(new d(0, "sh /system/bin/pm list packages -d"));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            b(4, "Switching RootContext - UNTRUSTED");
            b(3, "[ Switching Root Context - UNTRUSTED ]\n");
            try {
                RootTools.getShell(true, Shell.ShellContext.UNTRUSTED_APP).add(new e(0, "id"));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            b(4, "Testing df");
            long space = RootTools.getSpace("/data");
            b(3, "[ Checking /data partition size]\n");
            b(3, space + "k\n\n");
            try {
                RootTools.getShell(true).add(new f(42, false, "echo done"));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.getData().getInt("action");
            String string = message.getData().getString("text");
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            SanityCheckRootTools.this.f37489c.setMessage(string);
                            return;
                        }
                        return;
                    }
                    SanityCheckRootTools.this.c(string);
                    return;
                }
                if (string != null) {
                    SanityCheckRootTools.this.c(string);
                }
                SanityCheckRootTools.this.f37489c.hide();
                return;
            }
            SanityCheckRootTools.this.f37489c.show();
            SanityCheckRootTools.this.f37489c.setMessage("Running Root Library Tests...");
        }

        /* synthetic */ c(SanityCheckRootTools sanityCheckRootTools, a aVar) {
            this();
        }
    }

    protected void c(CharSequence charSequence) {
        this.f37488b.append(charSequence);
        this.f37487a.post(new a());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        RootTools.debugMode = true;
        TextView textView = new TextView(this);
        this.f37488b = textView;
        textView.setText("");
        ScrollView scrollView = new ScrollView(this);
        this.f37487a = scrollView;
        scrollView.addView(this.f37488b);
        setContentView(this.f37487a);
        c("SanityCheckRootTools \n\n");
        if (RootTools.isRootAvailable()) {
            c("Root found.\n");
        } else {
            c("Root not found");
        }
        try {
            Shell.startRootShell();
        } catch (RootDeniedException e4) {
            c("[ ROOT DENIED EXCEPTION! ]\n");
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (TimeoutException e6) {
            c("[ TIMEOUT EXCEPTION! ]\n");
            e6.printStackTrace();
        }
        try {
            if (!RootTools.isAccessGiven()) {
                c("ERROR: No root access to this device.\n");
                return;
            }
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f37489c = progressDialog;
            progressDialog.setCancelable(false);
            this.f37489c.setProgressStyle(0);
            new b(this, new c(this, null)).start();
        } catch (Exception unused) {
            c("ERROR: could not determine root access to this device.\n");
        }
    }
}
