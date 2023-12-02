package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class SoterSessionResult implements Parcelable {
    public static final Parcelable.Creator<SoterSessionResult> CREATOR = new Parcelable.Creator<SoterSessionResult>() { // from class: com.tencent.soter.soterserver.SoterSessionResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoterSessionResult createFromParcel(Parcel parcel) {
            return new SoterSessionResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoterSessionResult[] newArray(int i4) {
            return new SoterSessionResult[i4];
        }
    };
    public int resultCode;
    public long session;

    public SoterSessionResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.session);
        parcel.writeInt(this.resultCode);
    }

    protected SoterSessionResult(Parcel parcel) {
        this.session = parcel.readLong();
        this.resultCode = parcel.readInt();
    }
}
