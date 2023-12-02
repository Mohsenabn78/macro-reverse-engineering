package com.google.android.gms.nearby.connection;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.dex.DexFormat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.nearby.zzsl;
import com.google.android.gms.internal.nearby.zzst;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;
import net.bytebuddy.description.type.TypeDescription;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class Payload {
    public static final zzst zza = zzst.zzn(RemoteSettings.FORWARD_SLASH_STRING, "\\", "../");
    public static final zzst zzb = zzst.zzq("../", RemoteSettings.FORWARD_SLASH_STRING, "\\", TypeDescription.Generic.OfWildcardType.SYMBOL, "*", "\"", "<", ">", "|", ":", DexFormat.MAGIC_SUFFIX, "\n", "\r", "\t", "\f");
    public static final zzst zzc = zzst.zzo("..", ".", "\\", RemoteSettings.FORWARD_SLASH_STRING);
    public static final zzst zzd = zzst.zzl("\\");
    public static final zzst zze = zzst.zzm("../", "..\\");
    public static final zzst zzf = zzst.zzq(TypeDescription.Generic.OfWildcardType.SYMBOL, "*", "\"", "|", ":", DexFormat.MAGIC_SUFFIX, "\n", "\r", "\t", "\f", "../", "..", new String[0]);
    public static final zzst zzg = zzst.zzl("\\");
    public static final zzst zzh = zzst.zzm("\\", RemoteSettings.FORWARD_SLASH_STRING);

    /* renamed from: a  reason: collision with root package name */
    private final long f22202a;
    @Type

    /* renamed from: b  reason: collision with root package name */
    private final int f22203b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22204c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final File f22205d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Stream f22206e;

    /* renamed from: f  reason: collision with root package name */
    private long f22207f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22208g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private String f22209h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f22210i;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class File {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final java.io.File f22211a;

        /* renamed from: b  reason: collision with root package name */
        private final ParcelFileDescriptor f22212b;

        /* renamed from: c  reason: collision with root package name */
        private final long f22213c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final Uri f22214d;

        private File(@Nullable java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j4, @Nullable Uri uri) {
            this.f22211a = file;
            this.f22212b = parcelFileDescriptor;
            this.f22213c = j4;
            this.f22214d = uri;
        }

        @NonNull
        public static File zza(@NonNull java.io.File file, @NonNull ParcelFileDescriptor parcelFileDescriptor, long j4, @NonNull Uri uri) {
            return new File((java.io.File) Preconditions.checkNotNull(file, "Cannot create Payload.File from null java.io.File."), (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), j4, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"));
        }

        @NonNull
        public static File zzb(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), parcelFileDescriptor.getStatSize(), null);
        }

        @Nullable
        @Deprecated
        public java.io.File asJavaFile() {
            return this.f22211a;
        }

        @NonNull
        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.f22212b;
        }

        @Nullable
        public Uri asUri() {
            return this.f22214d;
        }

        @Deprecated
        public void close() {
            IOUtils.closeQuietly(this.f22212b);
        }

        public long getSize() {
            return this.f22213c;
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Stream {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final ParcelFileDescriptor f22215a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private InputStream f22216b;

        private Stream(@Nullable ParcelFileDescriptor parcelFileDescriptor, @Nullable InputStream inputStream) {
            this.f22215a = parcelFileDescriptor;
            this.f22216b = inputStream;
        }

        @NonNull
        public static Stream zza(@NonNull InputStream inputStream) {
            Preconditions.checkNotNull(inputStream, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream);
        }

        @NonNull
        public static Stream zzb(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        @NonNull
        public InputStream asInputStream() {
            if (this.f22216b == null) {
                this.f22216b = new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Preconditions.checkNotNull(this.f22215a));
            }
            return this.f22216b;
        }

        @Nullable
        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.f22215a;
        }

        @Deprecated
        public void close() {
            IOUtils.closeQuietly(this.f22215a);
            IOUtils.closeQuietly(this.f22216b);
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;
    }

    private Payload(long j4, int i4, @Nullable byte[] bArr, @Nullable File file, @Nullable Stream stream) {
        this.f22202a = j4;
        this.f22203b = i4;
        this.f22204c = bArr;
        this.f22205d = file;
        this.f22206e = stream;
    }

    @NonNull
    public static Payload fromBytes(@NonNull byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Cannot create a Payload from null bytes.");
        return zza(bArr, UUID.randomUUID().getLeastSignificantBits());
    }

    @NonNull
    public static Payload fromFile(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        return zzb(File.zzb(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    @NonNull
    public static Payload fromStream(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        return zzc(Stream.zzb(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    @NonNull
    public static Payload zza(@NonNull byte[] bArr, long j4) {
        return new Payload(j4, 1, bArr, null, null);
    }

    @NonNull
    public static Payload zzb(@NonNull File file, long j4) {
        return new Payload(j4, 2, null, file, null);
    }

    @NonNull
    public static Payload zzc(@NonNull Stream stream, long j4) {
        return new Payload(j4, 3, null, null, stream);
    }

    @Nullable
    public byte[] asBytes() {
        return this.f22204c;
    }

    @Nullable
    public File asFile() {
        return this.f22205d;
    }

    @Nullable
    public Stream asStream() {
        return this.f22206e;
    }

    public void close() {
        File file = this.f22205d;
        if (file != null) {
            file.close();
        }
        Stream stream = this.f22206e;
        if (stream != null) {
            stream.close();
        }
    }

    public long getId() {
        return this.f22202a;
    }

    public long getOffset() {
        return this.f22207f;
    }

    @Type
    public int getType() {
        return this.f22203b;
    }

    public void setFileName(@NonNull String str) {
        if (!zzsl.zzb(str)) {
            if (getType() == 2) {
                zzst zzstVar = zza;
                int size = zzstVar.size();
                int i4 = 0;
                while (i4 < size) {
                    String str2 = (String) zzstVar.get(i4);
                    i4++;
                    if (str.contains(str2)) {
                        throw new IllegalArgumentException("File name " + str + " contains illegal string " + str2 + ".");
                    }
                }
                this.f22209h = str;
                return;
            }
            throw new IllegalArgumentException("Payload type must be FILE.");
        }
        throw new IllegalArgumentException("Payload file name should not be null or empty.");
    }

    public void setOffset(long j4) {
        if (j4 >= 0) {
            if (getType() != 2 && getType() != 3) {
                throw new IllegalArgumentException("Payload offset only support FILE or STREAM type.");
            }
            File file = this.f22205d;
            if (file != null && j4 >= file.getSize()) {
                throw new IllegalArgumentException("Payload offset should be smaller than the file size.");
            }
            getType();
            this.f22207f = j4;
            return;
        }
        throw new IllegalArgumentException("Payload offset must be positive or zero.");
    }

    public void setParentFolder(@NonNull String str) {
        if (!zzsl.zzb(str)) {
            if (getType() == 2) {
                zzst zzstVar = zze;
                int size = zzstVar.size();
                int i4 = 0;
                while (i4 < size) {
                    boolean contains = str.contains((String) zzstVar.get(i4));
                    i4++;
                    if (contains) {
                        throw new IllegalArgumentException("Folder name contains illegal string.");
                    }
                }
                this.f22210i = str;
                return;
            }
            throw new IllegalArgumentException("Payload type must be FILE.");
        }
        throw new IllegalArgumentException("Payload parent folder should not be null or empty.");
    }

    public void setSensitive(boolean z3) {
        this.f22208g = z3;
    }

    @Nullable
    @ShowFirstParty
    public final String zzd() {
        return this.f22209h;
    }

    @Nullable
    @ShowFirstParty
    public final String zze() {
        return this.f22210i;
    }

    public final boolean zzf() {
        return this.f22208g;
    }

    @NonNull
    public static Payload fromFile(@NonNull java.io.File file) throws FileNotFoundException {
        return zzb(File.zza(file, ParcelFileDescriptor.open(file, 268435456), file.length(), Uri.fromFile(file)), UUID.randomUUID().getLeastSignificantBits());
    }

    @NonNull
    public static Payload fromStream(@NonNull InputStream inputStream) {
        return zzc(Stream.zza(inputStream), UUID.randomUUID().getLeastSignificantBits());
    }
}
