package com.arlosoft.macrodroid.bugreporting.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BugReport implements Parcelable {
    public static final Parcelable.Creator<BugReport> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private List<Macro> f9589a;

    /* renamed from: b  reason: collision with root package name */
    private String f9590b;

    /* renamed from: c  reason: collision with root package name */
    private String f9591c;

    /* renamed from: d  reason: collision with root package name */
    private String f9592d;

    /* renamed from: e  reason: collision with root package name */
    private String f9593e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Uri> f9594f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9595g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9596h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9597i;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<BugReport> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BugReport createFromParcel(Parcel parcel) {
            return new BugReport(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BugReport[] newArray(int i4) {
            return new BugReport[i4];
        }
    }

    /* synthetic */ BugReport(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppVersion() {
        return this.f9593e;
    }

    public String getDescription() {
        return this.f9590b;
    }

    public String getEmail() {
        return this.f9591c;
    }

    public String getGoogleAccountEmail() {
        return this.f9592d;
    }

    public List<Macro> getMacroList() {
        return this.f9589a;
    }

    public ArrayList<Uri> getScreenshotUris() {
        return this.f9594f;
    }

    public boolean isPirate() {
        return this.f9595g;
    }

    public boolean isPro() {
        return this.f9597i;
    }

    public boolean isRoot() {
        return this.f9596h;
    }

    public void setDescription(String str) {
        this.f9590b = str;
    }

    public void setEmail(String str) {
        this.f9591c = str;
    }

    public void setGoogleAccountEmail(String str) {
        this.f9592d = str;
    }

    public void setMacroList(List<Macro> list) {
        this.f9589a = list;
    }

    public void setScreenshotUris(ArrayList<Uri> arrayList) {
        this.f9594f = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f9590b);
        parcel.writeString(this.f9591c);
        parcel.writeString(this.f9592d);
        parcel.writeList(this.f9589a);
        parcel.writeString(this.f9593e);
        parcel.writeInt(this.f9595g ? 1 : 0);
        parcel.writeInt(this.f9596h ? 1 : 0);
        parcel.writeInt(this.f9597i ? 1 : 0);
    }

    public BugReport(String str, boolean z3, boolean z4, boolean z5) {
        this.f9593e = str;
        this.f9595g = z3;
        this.f9596h = z4;
        this.f9597i = z5;
    }

    private BugReport(Parcel parcel) {
        this.f9590b = parcel.readString();
        this.f9591c = parcel.readString();
        this.f9592d = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.f9589a = arrayList;
        parcel.readList(arrayList, Macro.class.getClassLoader());
        this.f9593e = parcel.readString();
        this.f9595g = parcel.readInt() != 0;
        this.f9596h = parcel.readInt() != 0;
        this.f9597i = parcel.readInt() != 0;
    }
}
