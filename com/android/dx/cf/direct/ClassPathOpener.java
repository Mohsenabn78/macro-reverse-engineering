package com.android.dx.cf.direct;

import com.android.dex.util.FileUtils;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.text.Typography;
import net.bytebuddy.description.type.PackageDescription;

/* loaded from: classes2.dex */
public class ClassPathOpener {
    public static final FileNameFilter acceptAll = new FileNameFilter() { // from class: com.android.dx.cf.direct.ClassPathOpener.1
        @Override // com.android.dx.cf.direct.ClassPathOpener.FileNameFilter
        public boolean accept(String str) {
            return true;
        }
    };
    private final Consumer consumer;
    private FileNameFilter filter;
    private final String pathname;
    private final boolean sort;

    /* loaded from: classes2.dex */
    public interface Consumer {
        void onException(Exception exc);

        void onProcessArchiveStart(File file);

        boolean processFileBytes(String str, long j4, byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public interface FileNameFilter {
        boolean accept(String str);
    }

    public ClassPathOpener(String str, boolean z3, Consumer consumer) {
        this(str, z3, acceptAll, consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareClassNames(String str, String str2) {
        return str.replace(Typography.dollar, '0').replace(PackageDescription.PACKAGE_CLASS_NAME, "").compareTo(str2.replace(Typography.dollar, '0').replace(PackageDescription.PACKAGE_CLASS_NAME, ""));
    }

    private boolean processArchive(File file) throws IOException {
        byte[] bArr;
        ZipFile zipFile = new ZipFile(file);
        ArrayList list = Collections.list(zipFile.entries());
        if (this.sort) {
            Collections.sort(list, new Comparator<ZipEntry>() { // from class: com.android.dx.cf.direct.ClassPathOpener.3
                @Override // java.util.Comparator
                public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                    return ClassPathOpener.compareClassNames(zipEntry.getName(), zipEntry2.getName());
                }
            });
        }
        this.consumer.onProcessArchiveStart(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(SamsungIrisUnlockModule.IRIS_ONE_EYE);
        byte[] bArr2 = new byte[20000];
        Iterator it = list.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            ZipEntry zipEntry = (ZipEntry) it.next();
            boolean isDirectory = zipEntry.isDirectory();
            String name = zipEntry.getName();
            if (this.filter.accept(name)) {
                if (!isDirectory) {
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    byteArrayOutputStream.reset();
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    inputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                } else {
                    bArr = new byte[0];
                }
                z3 |= this.consumer.processFileBytes(name, zipEntry.getTime(), bArr);
            }
        }
        zipFile.close();
        return z3;
    }

    private boolean processDirectory(File file, boolean z3) {
        if (z3) {
            file = new File(file, ".");
        }
        File[] listFiles = file.listFiles();
        if (this.sort) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.android.dx.cf.direct.ClassPathOpener.2
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return ClassPathOpener.compareClassNames(file2.getName(), file3.getName());
                }
            });
        }
        boolean z4 = false;
        for (File file2 : listFiles) {
            z4 |= processOne(file2, false);
        }
        return z4;
    }

    private boolean processOne(File file, boolean z3) {
        try {
            if (file.isDirectory()) {
                return processDirectory(file, z3);
            }
            String path = file.getPath();
            if (!path.endsWith(".zip") && !path.endsWith(".jar") && !path.endsWith(".apk")) {
                if (!this.filter.accept(path)) {
                    return false;
                }
                return this.consumer.processFileBytes(path, file.lastModified(), FileUtils.readFile(file));
            }
            return processArchive(file);
        } catch (Exception e4) {
            this.consumer.onException(e4);
            return false;
        }
    }

    public boolean process() {
        return processOne(new File(this.pathname), true);
    }

    public ClassPathOpener(String str, boolean z3, FileNameFilter fileNameFilter, Consumer consumer) {
        this.pathname = str;
        this.sort = z3;
        this.consumer = consumer;
        this.filter = fileNameFilter;
    }
}
