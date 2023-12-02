package com.bumptech.glide.disklrucache;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final File f16646a;

    /* renamed from: b  reason: collision with root package name */
    private final File f16647b;

    /* renamed from: c  reason: collision with root package name */
    private final File f16648c;

    /* renamed from: d  reason: collision with root package name */
    private final File f16649d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16650e;

    /* renamed from: f  reason: collision with root package name */
    private long f16651f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16652g;

    /* renamed from: i  reason: collision with root package name */
    private Writer f16654i;

    /* renamed from: k  reason: collision with root package name */
    private int f16656k;

    /* renamed from: h  reason: collision with root package name */
    private long f16653h = 0;

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashMap<String, c> f16655j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    private long f16657l = 0;

    /* renamed from: m  reason: collision with root package name */
    final ThreadPoolExecutor f16658m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n  reason: collision with root package name */
    private final Callable<Void> f16659n = new a();

    /* loaded from: classes3.dex */
    public final class Editor {

        /* renamed from: a  reason: collision with root package name */
        private final c f16660a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f16661b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16662c;

        /* synthetic */ Editor(DiskLruCache diskLruCache, c cVar, a aVar) {
            this(cVar);
        }

        private InputStream c(int i4) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f16660a.f16675f == this) {
                    if (!this.f16660a.f16674e) {
                        return null;
                    }
                    try {
                        return new FileInputStream(this.f16660a.j(i4));
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public void abort() throws IOException {
            DiskLruCache.this.m(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.f16662c) {
                try {
                    abort();
                } catch (IOException unused) {
                }
            }
        }

        public void commit() throws IOException {
            DiskLruCache.this.m(this, true);
            this.f16662c = true;
        }

        public File getFile(int i4) throws IOException {
            File k4;
            synchronized (DiskLruCache.this) {
                if (this.f16660a.f16675f == this) {
                    if (!this.f16660a.f16674e) {
                        this.f16661b[i4] = true;
                    }
                    k4 = this.f16660a.k(i4);
                    if (!DiskLruCache.this.f16646a.exists()) {
                        DiskLruCache.this.f16646a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k4;
        }

        public String getString(int i4) throws IOException {
            InputStream c4 = c(i4);
            if (c4 != null) {
                return DiskLruCache.p(c4);
            }
            return null;
        }

        public void set(int i4, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(getFile(i4)), com.bumptech.glide.disklrucache.b.f16685b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                com.bumptech.glide.disklrucache.b.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                com.bumptech.glide.disklrucache.b.a(outputStreamWriter2);
                throw th;
            }
        }

        private Editor(c cVar) {
            this.f16660a = cVar;
            this.f16661b = cVar.f16674e ? null : new boolean[DiskLruCache.this.f16652g];
        }
    }

    /* loaded from: classes3.dex */
    public final class Value {

        /* renamed from: a  reason: collision with root package name */
        private final String f16664a;

        /* renamed from: b  reason: collision with root package name */
        private final long f16665b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f16666c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f16667d;

        /* synthetic */ Value(DiskLruCache diskLruCache, String str, long j4, File[] fileArr, long[] jArr, a aVar) {
            this(str, j4, fileArr, jArr);
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.o(this.f16664a, this.f16665b);
        }

        public File getFile(int i4) {
            return this.f16667d[i4];
        }

        public long getLength(int i4) {
            return this.f16666c[i4];
        }

        public String getString(int i4) throws IOException {
            return DiskLruCache.p(new FileInputStream(this.f16667d[i4]));
        }

        private Value(String str, long j4, File[] fileArr, long[] jArr) {
            this.f16664a = str;
            this.f16665b = j4;
            this.f16667d = fileArr;
            this.f16666c = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f16654i != null) {
                    DiskLruCache.this.w();
                    if (DiskLruCache.this.q()) {
                        DiskLruCache.this.u();
                        DiskLruCache.this.f16656k = 0;
                    }
                    return null;
                }
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class b implements ThreadFactory {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f16670a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f16671b;

        /* renamed from: c  reason: collision with root package name */
        File[] f16672c;

        /* renamed from: d  reason: collision with root package name */
        File[] f16673d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f16674e;

        /* renamed from: f  reason: collision with root package name */
        private Editor f16675f;

        /* renamed from: g  reason: collision with root package name */
        private long f16676g;

        /* synthetic */ c(DiskLruCache diskLruCache, String str, a aVar) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f16652g) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        this.f16671b[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i4) {
            return this.f16672c[i4];
        }

        public File k(int i4) {
            return this.f16673d[i4];
        }

        public String l() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j4 : this.f16671b) {
                sb.append(' ');
                sb.append(j4);
            }
            return sb.toString();
        }

        private c(String str) {
            this.f16670a = str;
            this.f16671b = new long[DiskLruCache.this.f16652g];
            this.f16672c = new File[DiskLruCache.this.f16652g];
            this.f16673d = new File[DiskLruCache.this.f16652g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i4 = 0; i4 < DiskLruCache.this.f16652g; i4++) {
                sb.append(i4);
                this.f16672c[i4] = new File(DiskLruCache.this.f16646a, sb.toString());
                sb.append(".tmp");
                this.f16673d[i4] = new File(DiskLruCache.this.f16646a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    private DiskLruCache(File file, int i4, int i5, long j4) {
        this.f16646a = file;
        this.f16650e = i4;
        this.f16647b = new File(file, "journal");
        this.f16648c = new File(file, "journal.tmp");
        this.f16649d = new File(file, "journal.bkp");
        this.f16652g = i5;
        this.f16651f = j4;
    }

    private void l() {
        if (this.f16654i != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(Editor editor, boolean z3) throws IOException {
        c cVar = editor.f16660a;
        if (cVar.f16675f == editor) {
            if (z3 && !cVar.f16674e) {
                for (int i4 = 0; i4 < this.f16652g; i4++) {
                    if (editor.f16661b[i4]) {
                        if (!cVar.k(i4).exists()) {
                            editor.abort();
                            return;
                        }
                    } else {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i4);
                    }
                }
            }
            for (int i5 = 0; i5 < this.f16652g; i5++) {
                File k4 = cVar.k(i5);
                if (z3) {
                    if (k4.exists()) {
                        File j4 = cVar.j(i5);
                        k4.renameTo(j4);
                        long j5 = cVar.f16671b[i5];
                        long length = j4.length();
                        cVar.f16671b[i5] = length;
                        this.f16653h = (this.f16653h - j5) + length;
                    }
                } else {
                    n(k4);
                }
            }
            this.f16656k++;
            cVar.f16675f = null;
            if (cVar.f16674e | z3) {
                cVar.f16674e = true;
                this.f16654i.append((CharSequence) "CLEAN");
                this.f16654i.append(' ');
                this.f16654i.append((CharSequence) cVar.f16670a);
                this.f16654i.append((CharSequence) cVar.l());
                this.f16654i.append('\n');
                if (z3) {
                    long j6 = this.f16657l;
                    this.f16657l = 1 + j6;
                    cVar.f16676g = j6;
                }
            } else {
                this.f16655j.remove(cVar.f16670a);
                this.f16654i.append((CharSequence) "REMOVE");
                this.f16654i.append(' ');
                this.f16654i.append((CharSequence) cVar.f16670a);
                this.f16654i.append('\n');
            }
            this.f16654i.flush();
            if (this.f16653h > this.f16651f || q()) {
                this.f16658m.submit(this.f16659n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void n(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Editor o(String str, long j4) throws IOException {
        l();
        c cVar = this.f16655j.get(str);
        if (j4 != -1 && (cVar == null || cVar.f16676g != j4)) {
            return null;
        }
        if (cVar == null) {
            cVar = new c(this, str, null);
            this.f16655j.put(str, cVar);
        } else if (cVar.f16675f != null) {
            return null;
        }
        Editor editor = new Editor(this, cVar, null);
        cVar.f16675f = editor;
        this.f16654i.append((CharSequence) "DIRTY");
        this.f16654i.append(' ');
        this.f16654i.append((CharSequence) str);
        this.f16654i.append('\n');
        this.f16654i.flush();
        return editor;
    }

    public static DiskLruCache open(File file, int i4, int i5, long j4) throws IOException {
        if (j4 > 0) {
            if (i5 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        v(file2, file3, false);
                    }
                }
                DiskLruCache diskLruCache = new DiskLruCache(file, i4, i5, j4);
                if (diskLruCache.f16647b.exists()) {
                    try {
                        diskLruCache.s();
                        diskLruCache.r();
                        return diskLruCache;
                    } catch (IOException e4) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e4.getMessage() + ", removing");
                        diskLruCache.delete();
                    }
                }
                file.mkdirs();
                DiskLruCache diskLruCache2 = new DiskLruCache(file, i4, i5, j4);
                diskLruCache2.u();
                return diskLruCache2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String p(InputStream inputStream) throws IOException {
        return com.bumptech.glide.disklrucache.b.c(new InputStreamReader(inputStream, com.bumptech.glide.disklrucache.b.f16685b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        int i4 = this.f16656k;
        if (i4 >= 2000 && i4 >= this.f16655j.size()) {
            return true;
        }
        return false;
    }

    private void r() throws IOException {
        n(this.f16648c);
        Iterator<c> it = this.f16655j.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i4 = 0;
            if (next.f16675f != null) {
                next.f16675f = null;
                while (i4 < this.f16652g) {
                    n(next.j(i4));
                    n(next.k(i4));
                    i4++;
                }
                it.remove();
            } else {
                while (i4 < this.f16652g) {
                    this.f16653h += next.f16671b[i4];
                    i4++;
                }
            }
        }
    }

    private void s() throws IOException {
        com.bumptech.glide.disklrucache.a aVar = new com.bumptech.glide.disklrucache.a(new FileInputStream(this.f16647b), com.bumptech.glide.disklrucache.b.f16684a);
        try {
            String e4 = aVar.e();
            String e5 = aVar.e();
            String e6 = aVar.e();
            String e7 = aVar.e();
            String e8 = aVar.e();
            if ("libcore.io.DiskLruCache".equals(e4) && "1".equals(e5) && Integer.toString(this.f16650e).equals(e6) && Integer.toString(this.f16652g).equals(e7) && "".equals(e8)) {
                int i4 = 0;
                while (true) {
                    try {
                        t(aVar.e());
                        i4++;
                    } catch (EOFException unused) {
                        this.f16656k = i4 - this.f16655j.size();
                        if (aVar.d()) {
                            u();
                        } else {
                            this.f16654i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16647b, true), com.bumptech.glide.disklrucache.b.f16684a));
                        }
                        com.bumptech.glide.disklrucache.b.a(aVar);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + e4 + ", " + e5 + ", " + e7 + ", " + e8 + "]");
            }
        } catch (Throwable th) {
            com.bumptech.glide.disklrucache.b.a(aVar);
            throw th;
        }
    }

    private void t(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i4 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i4);
            if (indexOf2 == -1) {
                substring = str.substring(i4);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f16655j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i4, indexOf2);
            }
            c cVar = this.f16655j.get(substring);
            if (cVar == null) {
                cVar = new c(this, substring, null);
                this.f16655j.put(substring, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                cVar.f16674e = true;
                cVar.f16675f = null;
                cVar.n(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f16675f = new Editor(this, cVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u() throws IOException {
        Writer writer = this.f16654i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16648c), com.bumptech.glide.disklrucache.b.f16684a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f16650e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f16652g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (c cVar : this.f16655j.values()) {
            if (cVar.f16675f != null) {
                bufferedWriter.write("DIRTY " + cVar.f16670a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + cVar.f16670a + cVar.l() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f16647b.exists()) {
            v(this.f16647b, this.f16649d, true);
        }
        v(this.f16648c, this.f16647b, false);
        this.f16649d.delete();
        this.f16654i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16647b, true), com.bumptech.glide.disklrucache.b.f16684a));
    }

    private static void v(File file, File file2, boolean z3) throws IOException {
        if (z3) {
            n(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() throws IOException {
        while (this.f16653h > this.f16651f) {
            remove(this.f16655j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f16654i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f16655j.values()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f16675f != null) {
                cVar.f16675f.abort();
            }
        }
        w();
        this.f16654i.close();
        this.f16654i = null;
    }

    public void delete() throws IOException {
        close();
        com.bumptech.glide.disklrucache.b.b(this.f16646a);
    }

    public Editor edit(String str) throws IOException {
        return o(str, -1L);
    }

    public synchronized void flush() throws IOException {
        l();
        w();
        this.f16654i.flush();
    }

    public synchronized Value get(String str) throws IOException {
        l();
        c cVar = this.f16655j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f16674e) {
            return null;
        }
        for (File file : cVar.f16672c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f16656k++;
        this.f16654i.append((CharSequence) "READ");
        this.f16654i.append(' ');
        this.f16654i.append((CharSequence) str);
        this.f16654i.append('\n');
        if (q()) {
            this.f16658m.submit(this.f16659n);
        }
        return new Value(this, str, cVar.f16676g, cVar.f16672c, cVar.f16671b, null);
    }

    public File getDirectory() {
        return this.f16646a;
    }

    public synchronized long getMaxSize() {
        return this.f16651f;
    }

    public synchronized boolean isClosed() {
        boolean z3;
        if (this.f16654i == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }

    public synchronized boolean remove(String str) throws IOException {
        l();
        c cVar = this.f16655j.get(str);
        if (cVar != null && cVar.f16675f == null) {
            for (int i4 = 0; i4 < this.f16652g; i4++) {
                File j4 = cVar.j(i4);
                if (j4.exists() && !j4.delete()) {
                    throw new IOException("failed to delete " + j4);
                }
                this.f16653h -= cVar.f16671b[i4];
                cVar.f16671b[i4] = 0;
            }
            this.f16656k++;
            this.f16654i.append((CharSequence) "REMOVE");
            this.f16654i.append(' ');
            this.f16654i.append((CharSequence) str);
            this.f16654i.append('\n');
            this.f16655j.remove(str);
            if (q()) {
                this.f16658m.submit(this.f16659n);
            }
            return true;
        }
        return false;
    }

    public synchronized void setMaxSize(long j4) {
        this.f16651f = j4;
        this.f16658m.submit(this.f16659n);
    }

    public synchronized long size() {
        return this.f16653h;
    }
}
