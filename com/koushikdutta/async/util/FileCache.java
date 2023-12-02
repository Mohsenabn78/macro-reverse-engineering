package com.koushikdutta.async.util;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* loaded from: classes6.dex */
public class FileCache {

    /* renamed from: i  reason: collision with root package name */
    private static String f35669i = "MD5";

    /* renamed from: j  reason: collision with root package name */
    static MessageDigest f35670j;

    /* renamed from: a  reason: collision with root package name */
    boolean f35671a;

    /* renamed from: e  reason: collision with root package name */
    File f35675e;

    /* renamed from: f  reason: collision with root package name */
    long f35676f;

    /* renamed from: h  reason: collision with root package name */
    boolean f35678h;

    /* renamed from: b  reason: collision with root package name */
    Random f35672b = new Random();

    /* renamed from: c  reason: collision with root package name */
    long f35673c = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;

    /* renamed from: g  reason: collision with root package name */
    Comparator<File> f35677g = new a();

    /* renamed from: d  reason: collision with root package name */
    d f35674d = new d();

    /* loaded from: classes6.dex */
    public static class Snapshot {

        /* renamed from: a  reason: collision with root package name */
        FileInputStream[] f35679a;

        /* renamed from: b  reason: collision with root package name */
        long[] f35680b;

        public void close() {
            StreamUtility.closeQuietly(this.f35679a);
        }

        public long getLength(int i4) {
            return this.f35680b[i4];
        }
    }

    /* loaded from: classes6.dex */
    class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified < lastModified2) {
                return -1;
            }
            if (lastModified2 > lastModified) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends Thread {
        b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileCache.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        final long f35683a;

        public c(File file) {
            this.f35683a = file.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d extends LruCache<String, c> {
        public d() {
            super(FileCache.this.f35676f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.util.LruCache
        /* renamed from: f */
        public void b(boolean z3, String str, c cVar, c cVar2) {
            super.b(z3, str, cVar, cVar2);
            if (cVar2 != null || FileCache.this.f35678h) {
                return;
            }
            new File(FileCache.this.f35675e, str).delete();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.util.LruCache
        /* renamed from: g */
        public long d(String str, c cVar) {
            return Math.max(FileCache.this.f35673c, cVar.f35683a);
        }
    }

    static {
        try {
            f35670j = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException e4) {
            MessageDigest b4 = b();
            f35670j = b4;
            if (b4 == null) {
                throw new RuntimeException(e4);
            }
        }
        try {
            f35670j = (MessageDigest) f35670j.clone();
        } catch (CloneNotSupportedException unused) {
        }
    }

    public FileCache(File file, long j4, boolean z3) {
        this.f35675e = file;
        this.f35676f = j4;
        this.f35671a = z3;
        file.mkdirs();
        a();
    }

    private void a() {
        if (this.f35671a) {
            new b().start();
        } else {
            e();
        }
    }

    private static MessageDigest b() {
        MessageDigest messageDigest;
        if (KeyPropertiesCompact.DIGEST_MD5.equals(f35669i)) {
            for (Provider provider : Security.getProviders()) {
                for (Provider.Service service : provider.getServices()) {
                    String algorithm = service.getAlgorithm();
                    f35669i = algorithm;
                    try {
                        messageDigest = MessageDigest.getInstance(algorithm);
                    } catch (NoSuchAlgorithmException unused) {
                    }
                    if (messageDigest != null) {
                        return messageDigest;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static void removeFiles(File... fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            file.delete();
        }
    }

    public static synchronized String toKeyString(Object... objArr) {
        String bigInteger;
        synchronized (FileCache.class) {
            f35670j.reset();
            for (Object obj : objArr) {
                f35670j.update(obj.toString().getBytes());
            }
            bigInteger = new BigInteger(1, f35670j.digest()).toString(16);
        }
        return bigInteger;
    }

    File c(String str, int i4) {
        return new File(this.f35675e, d(str, i4));
    }

    public void clear() {
        removeFiles(this.f35675e.listFiles());
        this.f35674d.evictAll();
    }

    public void commitTempFiles(String str, File... fileArr) {
        f(str);
        for (int i4 = 0; i4 < fileArr.length; i4++) {
            File file = fileArr[i4];
            File c4 = c(str, i4);
            if (!file.renameTo(c4)) {
                removeFiles(fileArr);
                remove(str);
                return;
            }
            remove(file.getName());
            this.f35674d.put(d(str, i4), new c(c4));
        }
    }

    String d(String str, int i4) {
        return str + "." + i4;
    }

    void e() {
        this.f35678h = true;
        try {
            File[] listFiles = this.f35675e.listFiles();
            if (listFiles == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, listFiles);
            Collections.sort(arrayList, this.f35677g);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                String name = file.getName();
                this.f35674d.put(name, new c(file));
                this.f35674d.get(name);
            }
        } finally {
            this.f35678h = false;
        }
    }

    public boolean exists(String str, int i4) {
        return c(str, i4).exists();
    }

    void f(String str) {
        int i4 = 0;
        while (true) {
            File c4 = c(str, i4);
            if (c4.exists()) {
                c4.delete();
                i4++;
            } else {
                return;
            }
        }
    }

    public FileInputStream get(String str) throws IOException {
        return new FileInputStream(touch(c(str, 0)));
    }

    public File getFile(String str) {
        return touch(c(str, 0));
    }

    public File getTempFile() {
        File file;
        do {
            file = new File(this.f35675e, new BigInteger(128, this.f35672b).toString(16));
        } while (file.exists());
        return file;
    }

    public File[] getTempFiles(int i4) {
        File[] fileArr = new File[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            fileArr[i5] = getTempFile();
        }
        return fileArr;
    }

    public Set<String> keySet() {
        HashSet hashSet = new HashSet();
        File[] listFiles = this.f35675e.listFiles();
        if (listFiles == null) {
            return hashSet;
        }
        for (File file : listFiles) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf != -1) {
                hashSet.add(name.substring(0, lastIndexOf));
            }
        }
        return hashSet;
    }

    public void remove(String str) {
        for (int i4 = 0; this.f35674d.remove(d(str, i4)) != null; i4++) {
        }
        f(str);
    }

    public void setBlockSize(long j4) {
        this.f35673c = j4;
    }

    public void setMaxSize(long j4) {
        this.f35674d.setMaxSize(j4);
        a();
    }

    public long size() {
        return this.f35674d.size();
    }

    public File touch(File file) {
        this.f35674d.get(file.getName());
        file.setLastModified(System.currentTimeMillis());
        return file;
    }

    public boolean exists(String str) {
        return c(str, 0).exists();
    }

    public FileInputStream[] get(String str, int i4) throws IOException {
        FileInputStream[] fileInputStreamArr = new FileInputStream[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            try {
                fileInputStreamArr[i5] = new FileInputStream(touch(c(str, i5)));
            } catch (IOException e4) {
                for (int i6 = 0; i6 < i4; i6++) {
                    StreamUtility.closeQuietly(fileInputStreamArr[i6]);
                }
                remove(str);
                throw e4;
            }
        }
        return fileInputStreamArr;
    }
}
