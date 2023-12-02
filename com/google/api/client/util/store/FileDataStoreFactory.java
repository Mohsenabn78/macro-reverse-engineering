package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Throwables;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class FileDataStoreFactory extends AbstractDataStoreFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f26173e = Logger.getLogger(FileDataStoreFactory.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private final File f26174d;

    /* loaded from: classes5.dex */
    static class FileDataStore<V extends Serializable> extends AbstractMemoryDataStore<V> {

        /* renamed from: e  reason: collision with root package name */
        private final File f26175e;

        FileDataStore(FileDataStoreFactory fileDataStoreFactory, File file, String str) throws IOException {
            super(fileDataStoreFactory, str);
            File file2 = new File(file, str);
            this.f26175e = file2;
            if (!IOUtils.isSymbolicLink(file2)) {
                if (file2.createNewFile()) {
                    this.f26172d = Maps.newHashMap();
                    a();
                    return;
                }
                this.f26172d = (HashMap) IOUtils.deserialize(new FileInputStream(file2));
                return;
            }
            String valueOf = String.valueOf(file2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 31);
            sb.append("unable to use a symbolic link: ");
            sb.append(valueOf);
            throw new IOException(sb.toString());
        }

        @Override // com.google.api.client.util.store.AbstractMemoryDataStore
        void a() throws IOException {
            IOUtils.serialize(this.f26172d, new FileOutputStream(this.f26175e));
        }

        @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
        /* renamed from: b */
        public FileDataStoreFactory getDataStoreFactory() {
            return (FileDataStoreFactory) super.getDataStoreFactory();
        }
    }

    public FileDataStoreFactory(File file) throws IOException {
        File canonicalFile = file.getCanonicalFile();
        this.f26174d = canonicalFile;
        if (!IOUtils.isSymbolicLink(canonicalFile)) {
            if (!canonicalFile.exists() && !canonicalFile.mkdirs()) {
                String valueOf = String.valueOf(canonicalFile);
                StringBuilder sb = new StringBuilder(valueOf.length() + 28);
                sb.append("unable to create directory: ");
                sb.append(valueOf);
                throw new IOException(sb.toString());
            }
            b(canonicalFile);
            return;
        }
        String valueOf2 = String.valueOf(canonicalFile);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 31);
        sb2.append("unable to use a symbolic link: ");
        sb2.append(valueOf2);
        throw new IOException(sb2.toString());
    }

    static void b(File file) throws IOException {
        try {
            Class cls = Boolean.TYPE;
            Method method = File.class.getMethod("setReadable", cls, cls);
            Method method2 = File.class.getMethod("setWritable", cls, cls);
            Method method3 = File.class.getMethod("setExecutable", cls, cls);
            Boolean bool = Boolean.FALSE;
            if (!((Boolean) method.invoke(file, bool, bool)).booleanValue() || !((Boolean) method2.invoke(file, bool, bool)).booleanValue() || !((Boolean) method3.invoke(file, bool, bool)).booleanValue()) {
                Logger logger = f26173e;
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(valueOf.length() + 44);
                sb.append("unable to change permissions for everybody: ");
                sb.append(valueOf);
                logger.warning(sb.toString());
            }
            Boolean bool2 = Boolean.TRUE;
            if (!((Boolean) method.invoke(file, bool2, bool2)).booleanValue() || !((Boolean) method2.invoke(file, bool2, bool2)).booleanValue() || !((Boolean) method3.invoke(file, bool2, bool2)).booleanValue()) {
                Logger logger2 = f26173e;
                String valueOf2 = String.valueOf(file);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 40);
                sb2.append("unable to change permissions for owner: ");
                sb2.append(valueOf2);
                logger2.warning(sb2.toString());
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException unused) {
        } catch (NoSuchMethodException unused2) {
            Logger logger3 = f26173e;
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 93);
            sb3.append("Unable to set permissions for ");
            sb3.append(valueOf3);
            sb3.append(", likely because you are running a version of Java prior to 1.6");
            logger3.warning(sb3.toString());
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            Throwables.propagateIfPossible(cause, IOException.class);
            throw new RuntimeException(cause);
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> a(String str) throws IOException {
        return new FileDataStore(this, this.f26174d, str);
    }

    public final File getDataDirectory() {
        return this.f26174d;
    }
}
