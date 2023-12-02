package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Environment;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public class FilesDumperPlugin implements DumperPlugin {
    private static final String NAME = "files";
    private final Context mContext;

    public FilesDumperPlugin(Context context) {
        this.mContext = context;
    }

    private void addFiles(ZipOutputStream zipOutputStream, byte[] bArr, File[] fileArr) throws IOException {
        for (File file : fileArr) {
            if (file.isDirectory()) {
                addFiles(zipOutputStream, bArr, file.listFiles());
            } else {
                zipOutputStream.putNextEntry(new ZipEntry(relativizePath(getBaseDir(this.mContext).getParentFile(), file)));
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    copy(fileInputStream, zipOutputStream, bArr);
                } finally {
                    fileInputStream.close();
                }
            }
        }
    }

    private static void copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private void doDownload(PrintStream printStream, Iterator<String> it) throws DumpUsageException {
        String nextArg = ArgsHelper.nextArg(it, "Must specify output file or '-'");
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(resolvePossibleAppStoragePath(this.mContext, it.next()));
        }
        try {
            OutputStream fileOutputStream = "-".equals(nextArg) ? printStream : new FileOutputStream(resolvePossibleSdcardPath(nextArg));
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
            byte[] bArr = new byte[2048];
            if (arrayList.size() > 0) {
                addFiles(zipOutputStream, bArr, (File[]) arrayList.toArray(new File[arrayList.size()]));
            } else {
                addFiles(zipOutputStream, bArr, getBaseDir(this.mContext).listFiles());
            }
            try {
                zipOutputStream.close();
            } catch (IOException e4) {
                Util.close(fileOutputStream, false);
                throw e4;
            }
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    private void doLs(PrintStream printStream) throws DumpUsageException {
        File baseDir = getBaseDir(this.mContext);
        if (baseDir.isDirectory()) {
            printDirectoryText(baseDir, "", printStream);
        }
    }

    private void doTree(PrintStream printStream) throws DumpUsageException {
        printDirectoryVisual(getBaseDir(this.mContext), 0, printStream);
    }

    private void doUsage(PrintStream printStream) {
        printStream.println("Usage: dumpapp files <command> [command-options]");
        printStream.println("       dumpapp files ls");
        printStream.println("       dumpapp files tree");
        printStream.println("       dumpapp files download <output.zip> [<path>...]");
        printStream.println();
        printStream.println("dumpapp files ls: List files similar to the ls command");
        printStream.println();
        printStream.println("dumpapp files tree: List files similar to the tree command");
        printStream.println();
        printStream.println("dumpapp files download: Fetch internal application storage");
        printStream.println("    <output.zip>: Output location or '-' for stdout");
        printStream.println("    <path>: Fetch only those paths named (directories fetch recursively)");
    }

    private static File getBaseDir(Context context) {
        return context.getFilesDir().getParentFile();
    }

    private static void printDirectoryText(File file, String str, PrintStream printStream) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                printDirectoryText(file2, str + file2.getName() + RemoteSettings.FORWARD_SLASH_STRING, printStream);
            } else {
                printStream.println(str + file2.getName());
            }
        }
    }

    private static void printDirectoryVisual(File file, int i4, PrintStream printStream) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            printHeaderVisual(i4, printStream);
            printStream.print("+---");
            printStream.print(file2.getName());
            printStream.println();
            if (file2.isDirectory()) {
                printDirectoryVisual(file2, i4 + 1, printStream);
            }
        }
    }

    private static void printHeaderVisual(int i4, PrintStream printStream) {
        for (int i5 = 0; i5 < i4; i5++) {
            printStream.print("|   ");
        }
    }

    private static String relativizePath(File file, File file2) {
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        if (absolutePath2.startsWith(absolutePath)) {
            return absolutePath2.substring(absolutePath.length() + 1);
        }
        return absolutePath2;
    }

    private static File resolvePossibleAppStoragePath(Context context, String str) {
        if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return new File(str);
        }
        return new File(getBaseDir(context), str);
    }

    private static File resolvePossibleSdcardPath(String str) {
        if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return new File(str);
        }
        return new File(Environment.getExternalStorageDirectory(), str);
    }

    @Override // com.facebook.stetho.dumpapp.DumperPlugin
    public void dump(DumperContext dumperContext) throws DumpException {
        Iterator<String> it = dumperContext.getArgsAsList().iterator();
        String nextOptionalArg = ArgsHelper.nextOptionalArg(it, "");
        if ("ls".equals(nextOptionalArg)) {
            doLs(dumperContext.getStdout());
        } else if ("tree".equals(nextOptionalArg)) {
            doTree(dumperContext.getStdout());
        } else if ("download".equals(nextOptionalArg)) {
            doDownload(dumperContext.getStdout(), it);
        } else {
            doUsage(dumperContext.getStdout());
            if ("".equals(nextOptionalArg)) {
                return;
            }
            throw new DumpUsageException("Unknown command: " + nextOptionalArg);
        }
    }

    @Override // com.facebook.stetho.dumpapp.DumperPlugin
    public String getName() {
        return NAME;
    }
}
