package com.firebase.ui.auth.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.text.Collator;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class CountryInfo implements Comparable<CountryInfo>, Parcelable {
    public static final Parcelable.Creator<CountryInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Collator f17968a;

    /* renamed from: b  reason: collision with root package name */
    private final Locale f17969b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17970c;

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<CountryInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CountryInfo createFromParcel(Parcel parcel) {
            return new CountryInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CountryInfo[] newArray(int i4) {
            return new CountryInfo[i4];
        }
    }

    public CountryInfo(Locale locale, int i4) {
        Collator collator = Collator.getInstance(Locale.getDefault());
        this.f17968a = collator;
        collator.setStrength(0);
        this.f17969b = locale;
        this.f17970c = i4;
    }

    public static String localeToEmoji(Locale locale) {
        String country = locale.getCountry();
        return new String(Character.toChars((Character.codePointAt(country, 0) - 65) + 127462)) + new String(Character.toChars((Character.codePointAt(country, 1) - 65) + 127462));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CountryInfo.class != obj.getClass()) {
            return false;
        }
        CountryInfo countryInfo = (CountryInfo) obj;
        if (this.f17970c == countryInfo.f17970c) {
            Locale locale = this.f17969b;
            if (locale != null) {
                if (locale.equals(countryInfo.f17969b)) {
                    return true;
                }
            } else if (countryInfo.f17969b == null) {
                return true;
            }
        }
        return false;
    }

    public int getCountryCode() {
        return this.f17970c;
    }

    public Locale getLocale() {
        return this.f17969b;
    }

    public int hashCode() {
        int i4;
        Locale locale = this.f17969b;
        if (locale != null) {
            i4 = locale.hashCode();
        } else {
            i4 = 0;
        }
        return (i4 * 31) + this.f17970c;
    }

    public String toString() {
        return localeToEmoji(this.f17969b) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f17969b.getDisplayCountry() + " +" + this.f17970c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeSerializable(this.f17969b);
        parcel.writeInt(this.f17970c);
    }

    @Override // java.lang.Comparable
    public int compareTo(CountryInfo countryInfo) {
        return this.f17968a.compare(this.f17969b.getDisplayCountry(), countryInfo.f17969b.getDisplayCountry());
    }

    protected CountryInfo(Parcel parcel) {
        Collator collator = Collator.getInstance(Locale.getDefault());
        this.f17968a = collator;
        collator.setStrength(0);
        this.f17969b = (Locale) parcel.readSerializable();
        this.f17970c = parcel.readInt();
    }
}
