package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

/* loaded from: classes5.dex */
public class LogFileManager {

    /* renamed from: c  reason: collision with root package name */
    private static final NoopLogStore f29557c = new NoopLogStore();

    /* renamed from: a  reason: collision with root package name */
    private final FileStore f29558a;

    /* renamed from: b  reason: collision with root package name */
    private FileLogStore f29559b;

    public LogFileManager(FileStore fileStore) {
        this.f29558a = fileStore;
        this.f29559b = f29557c;
    }

    private File a(String str) {
        return this.f29558a.getSessionFile(str, "userlog");
    }

    void b(File file, int i4) {
        this.f29559b = new QueueFileLogStore(file, i4);
    }

    public void clearLog() {
        this.f29559b.b();
    }

    public byte[] getBytesForLog() {
        return this.f29559b.a();
    }

    @Nullable
    public String getLogString() {
        return this.f29559b.e();
    }

    public final void setCurrentSession(String str) {
        this.f29559b.d();
        this.f29559b = f29557c;
        if (str == null) {
            return;
        }
        b(a(str), 65536);
    }

    public void writeToLog(long j4, String str) {
        this.f29559b.c(j4, str);
    }

    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        setCurrentSession(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public byte[] a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public String e() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void b() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void d() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void c(long j4, String str) {
        }
    }
}
