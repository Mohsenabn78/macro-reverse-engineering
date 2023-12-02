package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
@KeepName
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
/* loaded from: classes4.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();

    /* renamed from: k  reason: collision with root package name */
    private static final Builder f20371k = new zab(new String[0], null);
    @SafeParcelable.VersionField(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    final int f20372a;
    @SafeParcelable.Field(getter = "getColumns", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final String[] f20373b;

    /* renamed from: c  reason: collision with root package name */
    Bundle f20374c;
    @SafeParcelable.Field(getter = "getWindows", id = 2)

    /* renamed from: d  reason: collision with root package name */
    private final CursorWindow[] f20375d;
    @SafeParcelable.Field(getter = "getStatusCode", id = 3)

    /* renamed from: e  reason: collision with root package name */
    private final int f20376e;
    @Nullable
    @SafeParcelable.Field(getter = "getMetadata", id = 4)

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f20377f;

    /* renamed from: g  reason: collision with root package name */
    int[] f20378g;

    /* renamed from: h  reason: collision with root package name */
    int f20379h;

    /* renamed from: i  reason: collision with root package name */
    boolean f20380i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20381j;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String[] f20382a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f20383b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final HashMap f20384c = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Builder(String[] strArr, String str, zac zacVar) {
            this.f20382a = (String[]) Preconditions.checkNotNull(strArr);
        }

        @NonNull
        @KeepForSdk
        public DataHolder build(int i4) {
            return new DataHolder(this, i4);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder withRow(@NonNull ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zaa(hashMap);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder zaa(@NonNull HashMap hashMap) {
            Asserts.checkNotNull(hashMap);
            this.f20383b.add(hashMap);
            return this;
        }

        @NonNull
        @KeepForSdk
        public DataHolder build(int i4, @NonNull Bundle bundle) {
            return new DataHolder(this, i4, bundle);
        }
    }

    private final void b(String str, int i4) {
        Bundle bundle = this.f20374c;
        if (bundle != null && bundle.containsKey(str)) {
            if (!isClosed()) {
                if (i4 >= 0 && i4 < this.f20379h) {
                    return;
                }
                throw new CursorIndexOutOfBoundsException(i4, this.f20379h);
            }
            throw new IllegalArgumentException("Buffer is closed.");
        }
        throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
    }

    @NonNull
    @KeepForSdk
    public static Builder builder(@NonNull String[] strArr) {
        return new Builder(strArr, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x012c, code lost:
        if (r5 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012e, code lost:
        r5 = new java.lang.StringBuilder();
        r5.append("Couldn't populate window data for row ");
        r5.append(r4);
        r5.append(" - allocating new window.");
        r2.freeLastRow();
        r2 = new android.database.CursorWindow(false);
        r2.setStartPosition(r4);
        r2.setNumColumns(r12.f20382a.length);
        r3.add(r2);
        r4 = r4 - 1;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0159, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0163, code lost:
        throw new com.google.android.gms.common.data.zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.database.CursorWindow[] c(com.google.android.gms.common.data.DataHolder.Builder r12, int r13) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.c(com.google.android.gms.common.data.DataHolder$Builder, int):android.database.CursorWindow[]");
    }

    @NonNull
    @KeepForSdk
    public static DataHolder empty(int i4) {
        return new DataHolder(f20371k, i4, (Bundle) null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public void close() {
        synchronized (this) {
            if (!this.f20380i) {
                this.f20380i = true;
                int i4 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f20375d;
                    if (i4 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i4].close();
                    i4++;
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f20381j && this.f20375d.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + obj + ")");
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public boolean getBoolean(@NonNull String str, int i4, int i5) {
        b(str, i4);
        if (Long.valueOf(this.f20375d[i5].getLong(i4, this.f20374c.getInt(str))).longValue() == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public byte[] getByteArray(@NonNull String str, int i4, int i5) {
        b(str, i4);
        return this.f20375d[i5].getBlob(i4, this.f20374c.getInt(str));
    }

    @KeepForSdk
    public int getCount() {
        return this.f20379h;
    }

    @KeepForSdk
    public int getInteger(@NonNull String str, int i4, int i5) {
        b(str, i4);
        return this.f20375d[i5].getInt(i4, this.f20374c.getInt(str));
    }

    @KeepForSdk
    public long getLong(@NonNull String str, int i4, int i5) {
        b(str, i4);
        return this.f20375d[i5].getLong(i4, this.f20374c.getInt(str));
    }

    @Nullable
    @KeepForSdk
    public Bundle getMetadata() {
        return this.f20377f;
    }

    @KeepForSdk
    public int getStatusCode() {
        return this.f20376e;
    }

    @NonNull
    @KeepForSdk
    public String getString(@NonNull String str, int i4, int i5) {
        b(str, i4);
        return this.f20375d[i5].getString(i4, this.f20374c.getInt(str));
    }

    @KeepForSdk
    public int getWindowIndex(int i4) {
        boolean z3;
        int length;
        int i5 = 0;
        if (i4 >= 0 && i4 < this.f20379h) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        while (true) {
            int[] iArr = this.f20378g;
            length = iArr.length;
            if (i5 >= length) {
                break;
            } else if (i4 < iArr[i5]) {
                i5--;
                break;
            } else {
                i5++;
            }
        }
        if (i5 == length) {
            return i5 - 1;
        }
        return i5;
    }

    @KeepForSdk
    public boolean hasColumn(@NonNull String str) {
        return this.f20374c.containsKey(str);
    }

    @KeepForSdk
    public boolean hasNull(@NonNull String str, int i4, int i5) {
        b(str, i4);
        return this.f20375d[i5].isNull(i4, this.f20374c.getInt(str));
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z3;
        synchronized (this) {
            z3 = this.f20380i;
        }
        return z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.f20373b, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f20375d, i4, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f20372a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i4 & 1) != 0) {
            close();
        }
    }

    public final double zaa(@NonNull String str, int i4, int i5) {
        b(str, i4);
        return this.f20375d[i5].getDouble(i4, this.f20374c.getInt(str));
    }

    public final float zab(@NonNull String str, int i4, int i5) {
        b(str, i4);
        return this.f20375d[i5].getFloat(i4, this.f20374c.getInt(str));
    }

    public final void zac(@NonNull String str, int i4, int i5, @NonNull CharArrayBuffer charArrayBuffer) {
        b(str, i4);
        this.f20375d[i5].copyStringToBuffer(i4, this.f20374c.getInt(str), charArrayBuffer);
    }

    public final void zad() {
        this.f20374c = new Bundle();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr = this.f20373b;
            if (i5 >= strArr.length) {
                break;
            }
            this.f20374c.putInt(strArr[i5], i5);
            i5++;
        }
        this.f20378g = new int[this.f20375d.length];
        int i6 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f20375d;
            if (i4 < cursorWindowArr.length) {
                this.f20378g[i4] = i6;
                i6 += this.f20375d[i4].getNumRows() - (i6 - cursorWindowArr[i4].getStartPosition());
                i4++;
            } else {
                this.f20379h = i6;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DataHolder(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i5, @Nullable @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.f20380i = false;
        this.f20381j = true;
        this.f20372a = i4;
        this.f20373b = strArr;
        this.f20375d = cursorWindowArr;
        this.f20376e = i5;
        this.f20377f = bundle;
    }

    @KeepForSdk
    public DataHolder(@NonNull String[] strArr, @NonNull CursorWindow[] cursorWindowArr, int i4, @Nullable Bundle bundle) {
        this.f20380i = false;
        this.f20381j = true;
        this.f20372a = 1;
        this.f20373b = (String[]) Preconditions.checkNotNull(strArr);
        this.f20375d = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.f20376e = i4;
        this.f20377f = bundle;
        zad();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DataHolder(@androidx.annotation.NonNull android.database.Cursor r8, int r9, @androidx.annotation.Nullable android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L76
            android.database.CursorWindow r3 = r0.getWindow()     // Catch: java.lang.Throwable -> L76
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L2e
            int r6 = r3.getStartPosition()     // Catch: java.lang.Throwable -> L76
            if (r6 != 0) goto L2e
            r3.acquireReference()     // Catch: java.lang.Throwable -> L76
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L76
            r1.add(r3)     // Catch: java.lang.Throwable -> L76
            int r3 = r3.getNumRows()     // Catch: java.lang.Throwable -> L76
            goto L2f
        L2e:
            r3 = 0
        L2f:
            if (r3 >= r2) goto L63
            boolean r6 = r0.moveToPosition(r3)     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L63
            android.database.CursorWindow r6 = r0.getWindow()     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L44
            r6.acquireReference()     // Catch: java.lang.Throwable -> L76
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L76
            goto L4f
        L44:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch: java.lang.Throwable -> L76
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L76
            r6.setStartPosition(r3)     // Catch: java.lang.Throwable -> L76
            r0.fillWindow(r3, r6)     // Catch: java.lang.Throwable -> L76
        L4f:
            int r3 = r6.getNumRows()     // Catch: java.lang.Throwable -> L76
            if (r3 != 0) goto L56
            goto L63
        L56:
            r1.add(r6)     // Catch: java.lang.Throwable -> L76
            int r3 = r6.getStartPosition()     // Catch: java.lang.Throwable -> L76
            int r6 = r6.getNumRows()     // Catch: java.lang.Throwable -> L76
            int r3 = r3 + r6
            goto L2f
        L63:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>(r8, r0, r9, r10)
            return
        L76:
            r8 = move-exception
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i4, @Nullable Bundle bundle) {
        this(builder.f20382a, c(builder, -1), i4, (Bundle) null);
    }
}
