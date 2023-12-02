package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Date;
import kotlin.time.DurationKt;

/* loaded from: classes5.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    @NonNull
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Timestamp createFromParcel(Parcel parcel) {
            return new Timestamp(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Timestamp[] newArray(int i4) {
            return new Timestamp[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final long f28725a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28726b;

    public Timestamp(long j4, int i4) {
        a(j4, i4);
        this.f28725a = j4;
        this.f28726b = i4;
    }

    private static void a(long j4, int i4) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Timestamp nanoseconds out of range: %s", Integer.valueOf(i4));
        if (i4 < 1.0E9d) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Timestamp nanoseconds out of range: %s", Integer.valueOf(i4));
        if (j4 >= -62135596800L) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Timestamp seconds out of range: %s", Long.valueOf(j4));
        if (j4 < 253402300800L) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkArgument(z6, "Timestamp seconds out of range: %s", Long.valueOf(j4));
    }

    @NonNull
    public static Timestamp now() {
        return new Timestamp(new Date());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0) {
            return true;
        }
        return false;
    }

    public int getNanoseconds() {
        return this.f28726b;
    }

    public long getSeconds() {
        return this.f28725a;
    }

    public int hashCode() {
        long j4 = this.f28725a;
        return (((((int) j4) * 37 * 37) + ((int) (j4 >> 32))) * 37) + this.f28726b;
    }

    @NonNull
    public Date toDate() {
        return new Date((this.f28725a * 1000) + (this.f28726b / DurationKt.NANOS_IN_MILLIS));
    }

    public String toString() {
        return "Timestamp(seconds=" + this.f28725a + ", nanoseconds=" + this.f28726b + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeLong(this.f28725a);
        parcel.writeInt(this.f28726b);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Timestamp timestamp) {
        long j4 = this.f28725a;
        long j5 = timestamp.f28725a;
        if (j4 == j5) {
            return Integer.signum(this.f28726b - timestamp.f28726b);
        }
        return Long.signum(j4 - j5);
    }

    protected Timestamp(@NonNull Parcel parcel) {
        this.f28725a = parcel.readLong();
        this.f28726b = parcel.readInt();
    }

    public Timestamp(@NonNull Date date) {
        long time = date.getTime();
        long j4 = time / 1000;
        int i4 = ((int) (time % 1000)) * DurationKt.NANOS_IN_MILLIS;
        if (i4 < 0) {
            j4--;
            i4 += 1000000000;
        }
        a(j4, i4);
        this.f28725a = j4;
        this.f28726b = i4;
    }
}
