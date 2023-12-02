package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class SoterExportResult implements Parcelable {
    public static final Parcelable.Creator<SoterExportResult> CREATOR = new Parcelable.Creator<SoterExportResult>() { // from class: com.tencent.soter.soterserver.SoterExportResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoterExportResult createFromParcel(Parcel parcel) {
            return new SoterExportResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SoterExportResult[] newArray(int i4) {
            return new SoterExportResult[i4];
        }
    };
    public byte[] exportData;
    public int exportDataLength;
    public int resultCode;

    public SoterExportResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.resultCode);
        parcel.writeByteArray(this.exportData);
        parcel.writeInt(this.exportDataLength);
    }

    public SoterExportResult(Parcel parcel) {
        this.resultCode = parcel.readInt();
        this.exportData = parcel.createByteArray();
        this.exportDataLength = parcel.readInt();
    }
}
