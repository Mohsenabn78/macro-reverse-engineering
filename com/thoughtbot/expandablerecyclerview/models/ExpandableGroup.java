package com.thoughtbot.expandablerecyclerview.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class ExpandableGroup<T extends Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ExpandableGroup> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f38086a;

    /* renamed from: b  reason: collision with root package name */
    private List<T> f38087b;

    /* loaded from: classes6.dex */
    static class a implements Parcelable.Creator<ExpandableGroup> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExpandableGroup createFromParcel(Parcel parcel) {
            return new ExpandableGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExpandableGroup[] newArray(int i4) {
            return new ExpandableGroup[i4];
        }
    }

    public ExpandableGroup(String str, List<T> list) {
        this.f38086a = str;
        this.f38087b = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getItemCount() {
        List<T> list = this.f38087b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> getItems() {
        return this.f38087b;
    }

    public String getTitle() {
        return this.f38086a;
    }

    public String toString() {
        return "ExpandableGroup{title='" + this.f38086a + "', items=" + this.f38087b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f38086a);
        if (this.f38087b == null) {
            parcel.writeByte((byte) 0);
            parcel.writeInt(0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.f38087b.size());
        parcel.writeSerializable(this.f38087b.get(0).getClass());
        parcel.writeList(this.f38087b);
    }

    protected ExpandableGroup(Parcel parcel) {
        this.f38086a = parcel.readString();
        byte readByte = parcel.readByte();
        int readInt = parcel.readInt();
        if (readByte == 1) {
            this.f38087b = new ArrayList(readInt);
            parcel.readList(this.f38087b, ((Class) parcel.readSerializable()).getClassLoader());
            return;
        }
        this.f38087b = null;
    }
}
