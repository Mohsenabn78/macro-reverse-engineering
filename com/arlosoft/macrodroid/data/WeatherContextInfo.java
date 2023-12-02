package com.arlosoft.macrodroid.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.data.Weather;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class WeatherContextInfo implements Parcelable {
    public static final Parcelable.Creator<WeatherContextInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final double f10742a;

    /* renamed from: b  reason: collision with root package name */
    private final double f10743b;

    /* renamed from: c  reason: collision with root package name */
    private final double f10744c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10745d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10746e;

    /* renamed from: f  reason: collision with root package name */
    private String f10747f;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<WeatherContextInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WeatherContextInfo createFromParcel(Parcel parcel) {
            return new WeatherContextInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WeatherContextInfo[] newArray(int i4) {
            return new WeatherContextInfo[i4];
        }
    }

    /* synthetic */ WeatherContextInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getConditions() {
        return this.f10747f;
    }

    public int getHumidity() {
        return this.f10745d;
    }

    public double getTempC() {
        return this.f10742a;
    }

    public double getTempF() {
        return this.f10743b;
    }

    public int getWindDirectionDegrees() {
        return this.f10746e;
    }

    public double getWindSpeed() {
        return this.f10744c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeDouble(this.f10742a);
        parcel.writeDouble(this.f10743b);
        parcel.writeDouble(this.f10744c);
        parcel.writeInt(this.f10745d);
        parcel.writeString(this.f10747f);
        parcel.writeInt(this.f10746e);
    }

    public WeatherContextInfo(double d4, double d5, double d6, int i4, int i5, List<Weather.CurrentCondition> list) {
        Iterator<Weather.CurrentCondition> it;
        this.f10742a = d4;
        this.f10743b = d5;
        this.f10744c = d6;
        this.f10745d = i4;
        this.f10746e = i5;
        this.f10747f = "";
        while (list.iterator().hasNext()) {
            this.f10747f += it.next().getDescr() + ", ";
        }
        if (this.f10747f.length() > 2) {
            String str = this.f10747f;
            this.f10747f = str.substring(0, str.length() - 2);
        }
    }

    private WeatherContextInfo(Parcel parcel) {
        this.f10742a = parcel.readDouble();
        this.f10743b = parcel.readDouble();
        this.f10744c = parcel.readDouble();
        this.f10745d = parcel.readInt();
        this.f10747f = parcel.readString();
        this.f10746e = parcel.readInt();
    }
}
