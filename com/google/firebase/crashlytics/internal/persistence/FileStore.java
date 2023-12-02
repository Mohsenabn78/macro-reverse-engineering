package com.google.firebase.crashlytics.internal.persistence;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class FileStore {

    /* renamed from: a  reason: collision with root package name */
    private final File f29973a;

    /* renamed from: b  reason: collision with root package name */
    private final File f29974b;

    /* renamed from: c  reason: collision with root package name */
    private final File f29975c;

    /* renamed from: d  reason: collision with root package name */
    private final File f29976d;

    /* renamed from: e  reason: collision with root package name */
    private final File f29977e;

    /* renamed from: f  reason: collision with root package name */
    private final File f29978f;

    public FileStore(Context context) {
        String str;
        String processName;
        File filesDir = context.getFilesDir();
        this.f29973a = filesDir;
        if (h()) {
            StringBuilder sb = new StringBuilder();
            sb.append(".com.google.firebase.crashlytics.files.v2");
            sb.append(File.pathSeparator);
            processName = Application.getProcessName();
            sb.append(g(processName));
            str = sb.toString();
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File c4 = c(new File(filesDir, str));
        this.f29974b = c4;
        this.f29975c = c(new File(c4, "open-sessions"));
        this.f29976d = c(new File(c4, "reports"));
        this.f29977e = c(new File(c4, "priority-reports"));
        this.f29978f = c(new File(c4, "native-reports"));
    }

    private void a(File file) {
        if (file.exists() && e(file)) {
            Logger logger = Logger.getLogger();
            logger.d("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private File b(String str) {
        return d(new File(this.f29975c, str));
    }

    private static synchronized File c(File file) {
        synchronized (FileStore.class) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                Logger logger = Logger.getLogger();
                logger.d("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                Logger logger2 = Logger.getLogger();
                logger2.e("Could not create Crashlytics-specific directory: " + file);
            }
            return file;
        }
    }

    private static File d(File file) {
        file.mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                e(file2);
            }
        }
        return file.delete();
    }

    private static <T> List<T> f(@Nullable T[] tArr) {
        if (tArr == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(tArr);
    }

    @VisibleForTesting
    static String g(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static boolean h() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public void cleanupPreviousFileSystems() {
        a(new File(this.f29973a, ".com.google.firebase.crashlytics"));
        a(new File(this.f29973a, ".com.google.firebase.crashlytics-ndk"));
        if (h()) {
            a(new File(this.f29973a, ".com.google.firebase.crashlytics.files.v1"));
        }
    }

    @VisibleForTesting
    public void deleteAllCrashlyticsFiles() {
        e(this.f29974b);
    }

    public boolean deleteSessionFiles(String str) {
        return e(new File(this.f29975c, str));
    }

    public List<String> getAllOpenSessionIds() {
        return f(this.f29975c.list());
    }

    public File getCommonFile(String str) {
        return new File(this.f29974b, str);
    }

    public List<File> getCommonFiles(FilenameFilter filenameFilter) {
        return f(this.f29974b.listFiles(filenameFilter));
    }

    public File getNativeReport(String str) {
        return new File(this.f29978f, str);
    }

    public List<File> getNativeReports() {
        return f(this.f29978f.listFiles());
    }

    public File getNativeSessionDir(String str) {
        return d(new File(b(str), "native"));
    }

    public File getPriorityReport(String str) {
        return new File(this.f29977e, str);
    }

    public List<File> getPriorityReports() {
        return f(this.f29977e.listFiles());
    }

    public File getReport(String str) {
        return new File(this.f29976d, str);
    }

    public List<File> getReports() {
        return f(this.f29976d.listFiles());
    }

    public File getSessionFile(String str, String str2) {
        return new File(b(str), str2);
    }

    public List<File> getSessionFiles(String str, FilenameFilter filenameFilter) {
        return f(b(str).listFiles(filenameFilter));
    }
}
