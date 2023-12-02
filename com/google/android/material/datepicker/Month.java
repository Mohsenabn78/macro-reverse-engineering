package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() { // from class: com.google.android.material.datepicker.Month.1
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public Month[] newArray(int i4) {
            return new Month[i4];
        }
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f23530a;

    /* renamed from: b  reason: collision with root package name */
    final int f23531b;

    /* renamed from: c  reason: collision with root package name */
    final int f23532c;

    /* renamed from: d  reason: collision with root package name */
    final int f23533d;

    /* renamed from: e  reason: collision with root package name */
    final int f23534e;

    /* renamed from: f  reason: collision with root package name */
    final long f23535f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f23536g;

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar f4 = UtcDates.f(calendar);
        this.f23530a = f4;
        this.f23531b = f4.get(2);
        this.f23532c = f4.get(1);
        this.f23533d = f4.getMaximum(7);
        this.f23534e = f4.getActualMaximum(5);
        this.f23535f = f4.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month b(int i4, int i5) {
        Calendar q4 = UtcDates.q();
        q4.set(1, i4);
        q4.set(2, i5);
        return new Month(q4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month c(long j4) {
        Calendar q4 = UtcDates.q();
        q4.setTimeInMillis(j4);
        return new Month(q4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month d() {
        return new Month(UtcDates.o());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull Month month) {
        return this.f23530a.compareTo(month.f23530a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        int firstDayOfWeek = this.f23530a.get(7) - this.f23530a.getFirstDayOfWeek();
        if (firstDayOfWeek < 0) {
            return firstDayOfWeek + this.f23533d;
        }
        return firstDayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f23531b == month.f23531b && this.f23532c == month.f23532c) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f(int i4) {
        Calendar f4 = UtcDates.f(this.f23530a);
        f4.set(5, i4);
        return f4.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(long j4) {
        Calendar f4 = UtcDates.f(this.f23530a);
        f4.setTimeInMillis(j4);
        return f4.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String h(Context context) {
        if (this.f23536g == null) {
            this.f23536g = DateStrings.i(context, this.f23530a.getTimeInMillis());
        }
        return this.f23536g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f23531b), Integer.valueOf(this.f23532c)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        return this.f23530a.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month j(int i4) {
        Calendar f4 = UtcDates.f(this.f23530a);
        f4.add(2, i4);
        return new Month(f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(@NonNull Month month) {
        if (this.f23530a instanceof GregorianCalendar) {
            return ((month.f23532c - this.f23532c) * 12) + (month.f23531b - this.f23531b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeInt(this.f23532c);
        parcel.writeInt(this.f23531b);
    }
}
