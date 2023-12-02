package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.MiuiFaceManagerImpl;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() { // from class: com.google.android.material.datepicker.CalendarConstraints.1
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public CalendarConstraints[] newArray(int i4) {
            return new CalendarConstraints[i4];
        }
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Month f23408a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Month f23409b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final DateValidator f23410c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Month f23411d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23412e;

    /* renamed from: f  reason: collision with root package name */
    private final int f23413f;

    /* loaded from: classes5.dex */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month e(Month month) {
        if (month.compareTo(this.f23408a) < 0) {
            return this.f23408a;
        }
        if (month.compareTo(this.f23409b) > 0) {
            return this.f23409b;
        }
        return month;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.f23408a.equals(calendarConstraints.f23408a) && this.f23409b.equals(calendarConstraints.f23409b) && ObjectsCompat.equals(this.f23411d, calendarConstraints.f23411d) && this.f23410c.equals(calendarConstraints.f23410c)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month f() {
        return this.f23409b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f23413f;
    }

    public DateValidator getDateValidator() {
        return this.f23410c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Month h() {
        return this.f23411d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f23408a, this.f23409b, this.f23411d, this.f23410c});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month i() {
        return this.f23408a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f23412e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(long j4) {
        if (this.f23408a.f(1) <= j4) {
            Month month = this.f23409b;
            if (j4 <= month.f(month.f23534e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@Nullable Month month) {
        this.f23411d = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f23408a, 0);
        parcel.writeParcelable(this.f23409b, 0);
        parcel.writeParcelable(this.f23411d, 0);
        parcel.writeParcelable(this.f23410c, 0);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.f23408a = month;
        this.f23409b = month2;
        this.f23411d = month3;
        this.f23410c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f23413f = month.k(month2) + 1;
        this.f23412e = (month2.f23532c - month.f23532c) + 1;
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: e  reason: collision with root package name */
        static final long f23414e = UtcDates.a(Month.b(1900, 0).f23535f);

        /* renamed from: f  reason: collision with root package name */
        static final long f23415f = UtcDates.a(Month.b(MiuiFaceManagerImpl.ERROR_BINDER_CALL, 11).f23535f);

        /* renamed from: a  reason: collision with root package name */
        private long f23416a;

        /* renamed from: b  reason: collision with root package name */
        private long f23417b;

        /* renamed from: c  reason: collision with root package name */
        private Long f23418c;

        /* renamed from: d  reason: collision with root package name */
        private DateValidator f23419d;

        public Builder() {
            this.f23416a = f23414e;
            this.f23417b = f23415f;
            this.f23419d = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints build() {
            Month c4;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f23419d);
            Month c5 = Month.c(this.f23416a);
            Month c6 = Month.c(this.f23417b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l4 = this.f23418c;
            if (l4 == null) {
                c4 = null;
            } else {
                c4 = Month.c(l4.longValue());
            }
            return new CalendarConstraints(c5, c6, dateValidator, c4);
        }

        @NonNull
        public Builder setEnd(long j4) {
            this.f23417b = j4;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long j4) {
            this.f23418c = Long.valueOf(j4);
            return this;
        }

        @NonNull
        public Builder setStart(long j4) {
            this.f23416a = j4;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator dateValidator) {
            this.f23419d = dateValidator;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.f23416a = f23414e;
            this.f23417b = f23415f;
            this.f23419d = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.f23416a = calendarConstraints.f23408a.f23535f;
            this.f23417b = calendarConstraints.f23409b.f23535f;
            this.f23418c = Long.valueOf(calendarConstraints.f23411d.f23535f);
            this.f23419d = calendarConstraints.f23410c;
        }
    }
}
