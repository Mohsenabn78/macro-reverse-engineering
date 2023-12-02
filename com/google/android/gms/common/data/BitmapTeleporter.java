package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@ShowFirstParty
@KeepForSdk
@SafeParcelable.Class(creator = "BitmapTeleporterCreator")
/* loaded from: classes4.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20359a;
    @Nullable
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    ParcelFileDescriptor f20360b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f20361c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f20362d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20363e;

    /* renamed from: f  reason: collision with root package name */
    private File f20364f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public BitmapTeleporter(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 3) int i5) {
        this.f20359a = i4;
        this.f20360b = parcelFileDescriptor;
        this.f20361c = i5;
        this.f20362d = null;
        this.f20363e = false;
    }

    private static final void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e4) {
            Log.w("BitmapTeleporter", "Could not close stream", e4);
        }
    }

    @Nullable
    @KeepForSdk
    public Bitmap get() {
        if (!this.f20363e) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Preconditions.checkNotNull(this.f20360b)));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                    dataInputStream.read(bArr);
                    b(dataInputStream);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                    createBitmap.copyPixelsFromBuffer(wrap);
                    this.f20362d = createBitmap;
                    this.f20363e = true;
                } catch (IOException e4) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e4);
                }
            } catch (Throwable th) {
                b(dataInputStream);
                throw th;
            }
        }
        return this.f20362d;
    }

    @KeepForSdk
    public void release() {
        if (!this.f20363e) {
            try {
                ((ParcelFileDescriptor) Preconditions.checkNotNull(this.f20360b)).close();
            } catch (IOException e4) {
                Log.w("BitmapTeleporter", "Could not close PFD", e4);
            }
        }
    }

    @KeepForSdk
    public void setTempDir(@NonNull File file) {
        if (file != null) {
            this.f20364f = file;
            return;
        }
        throw new NullPointerException("Cannot set null temp directory");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        if (this.f20360b == null) {
            Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(this.f20362d);
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            File file = this.f20364f;
            if (file != null) {
                try {
                    File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        this.f20360b = ParcelFileDescriptor.open(createTempFile, 268435456);
                        createTempFile.delete();
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                        try {
                            try {
                                dataOutputStream.writeInt(array.length);
                                dataOutputStream.writeInt(bitmap.getWidth());
                                dataOutputStream.writeInt(bitmap.getHeight());
                                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                                dataOutputStream.write(array);
                            } catch (IOException e4) {
                                throw new IllegalStateException("Could not write into unlinked file", e4);
                            }
                        } finally {
                            b(dataOutputStream);
                        }
                    } catch (FileNotFoundException unused) {
                        throw new IllegalStateException("Temporary file is somehow already deleted");
                    }
                } catch (IOException e5) {
                    throw new IllegalStateException("Could not create temporary file", e5);
                }
            } else {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20359a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f20360b, i4 | 1, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f20361c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        this.f20360b = null;
    }

    @KeepForSdk
    public BitmapTeleporter(@NonNull Bitmap bitmap) {
        this.f20359a = 1;
        this.f20360b = null;
        this.f20361c = 0;
        this.f20362d = bitmap;
        this.f20363e = true;
    }
}
