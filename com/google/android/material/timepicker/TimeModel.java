package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() { // from class: com.google.android.material.timepicker.TimeModel.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TimeModel[] newArray(int i4) {
            return new TimeModel[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MaxInputValidator f24785a;

    /* renamed from: b  reason: collision with root package name */
    private final MaxInputValidator f24786b;

    /* renamed from: c  reason: collision with root package name */
    final int f24787c;

    /* renamed from: d  reason: collision with root package name */
    int f24788d;

    /* renamed from: e  reason: collision with root package name */
    int f24789e;

    /* renamed from: f  reason: collision with root package name */
    int f24790f;

    /* renamed from: g  reason: collision with root package name */
    int f24791g;

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, "%02d");
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int f(int i4) {
        if (i4 >= 12) {
            return 1;
        }
        return 0;
    }

    public int c() {
        if (this.f24787c == 1) {
            return this.f24788d % 24;
        }
        int i4 = this.f24788d;
        if (i4 % 12 == 0) {
            return 12;
        }
        if (this.f24791g == 1) {
            return i4 - 12;
        }
        return i4;
    }

    public MaxInputValidator d() {
        return this.f24786b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MaxInputValidator e() {
        return this.f24785a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f24788d == timeModel.f24788d && this.f24789e == timeModel.f24789e && this.f24787c == timeModel.f24787c && this.f24790f == timeModel.f24790f) {
            return true;
        }
        return false;
    }

    public void g(int i4) {
        if (this.f24787c == 1) {
            this.f24788d = i4;
            return;
        }
        int i5 = 12;
        int i6 = i4 % 12;
        if (this.f24791g != 1) {
            i5 = 0;
        }
        this.f24788d = i6 + i5;
    }

    public void h(int i4) {
        this.f24791g = f(i4);
        this.f24788d = i4;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f24787c), Integer.valueOf(this.f24788d), Integer.valueOf(this.f24789e), Integer.valueOf(this.f24790f)});
    }

    public void i(@IntRange(from = 0, to = 60) int i4) {
        this.f24789e = i4 % 60;
    }

    public void j(int i4) {
        if (i4 != this.f24791g) {
            this.f24791g = i4;
            int i5 = this.f24788d;
            if (i5 < 12 && i4 == 1) {
                this.f24788d = i5 + 12;
            } else if (i5 >= 12 && i4 == 0) {
                this.f24788d = i5 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f24788d);
        parcel.writeInt(this.f24789e);
        parcel.writeInt(this.f24790f);
        parcel.writeInt(this.f24787c);
    }

    public TimeModel(int i4) {
        this(0, 0, 10, i4);
    }

    public TimeModel(int i4, int i5, int i6, int i7) {
        this.f24788d = i4;
        this.f24789e = i5;
        this.f24790f = i6;
        this.f24787c = i7;
        this.f24791g = f(i4);
        this.f24785a = new MaxInputValidator(59);
        this.f24786b = new MaxInputValidator(i7 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
