package com.twofortyfouram.locale.sdk.host.model;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.internal.BundleSerializer;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.bundle.BundlePrinter;
import java.util.Arrays;
import java.util.Locale;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class PluginInstanceData implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<PluginInstanceData> CREATOR = new Parcelable.Creator<PluginInstanceData>() { // from class: com.twofortyfouram.locale.sdk.host.model.PluginInstanceData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginInstanceData createFromParcel(Parcel parcel) {
            Assertions.assertNotNull(parcel, "in");
            PluginType valueOf = PluginType.valueOf(parcel.readString());
            String readString = parcel.readString();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new PluginInstanceData(valueOf, readString, bArr, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginInstanceData[] newArray(int i4) {
            return new PluginInstanceData[i4];
        }
    };
    public static final int MAXIMUM_BUNDLE_SIZE_BYTES = 25000;
    @NonNull
    private String mBlurb;
    @NonNull
    private final String mRegistryName;
    @NonNull
    private final byte[] mSerializedBundle;
    @NonNull
    private final PluginType mType;

    public PluginInstanceData(@NonNull PluginType pluginType, @NonNull String str, @NonNull byte[] bArr, String str2) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotNull(str, "registryName");
        Assertions.assertNotNull(bArr, "serializedBundle");
        this.mType = pluginType;
        this.mRegistryName = str;
        this.mSerializedBundle = copyArray(bArr);
        this.mBlurb = str2 == null ? "" : str2;
    }

    @NonNull
    @SuppressLint({"NewApi"})
    private static byte[] copyArray(@NonNull byte[] bArr) {
        Assertions.assertNotNull(bArr, "toCopy");
        if (AndroidSdkVersion.isAtLeastSdk(9)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PluginInstanceData.class != obj.getClass()) {
            return false;
        }
        PluginInstanceData pluginInstanceData = (PluginInstanceData) obj;
        if (this.mBlurb.equals(pluginInstanceData.mBlurb) && this.mRegistryName.equals(pluginInstanceData.mRegistryName) && Arrays.equals(this.mSerializedBundle, pluginInstanceData.mSerializedBundle) && this.mType == pluginInstanceData.mType) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getBlurb() {
        return this.mBlurb;
    }

    @NonNull
    public String getRegistryName() {
        return this.mRegistryName;
    }

    @NonNull
    public byte[] getSerializedBundle() {
        return copyArray(this.mSerializedBundle);
    }

    @NonNull
    public PluginType getType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((this.mType.hashCode() * 31) + this.mRegistryName.hashCode()) * 31) + Arrays.hashCode(this.mSerializedBundle)) * 31) + this.mBlurb.hashCode();
    }

    public void setBlurb(String str) {
        this.mBlurb = str;
    }

    @NonNull
    public String toString() {
        Bundle bundle;
        try {
            bundle = BundleSerializer.deserializeFromByteArray(this.mSerializedBundle);
        } catch (ClassNotFoundException unused) {
            bundle = null;
        }
        return String.format(Locale.US, "PluginInstanceData{mType='%s', mRegistryName='%s', mBlurb='%s', mSerializedBundle='%s'", this.mType, this.mRegistryName, this.mBlurb, BundlePrinter.toString(bundle));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Assertions.assertNotNull(parcel, "dest");
        parcel.writeString(this.mType.name());
        parcel.writeString(this.mRegistryName);
        parcel.writeInt(this.mSerializedBundle.length);
        parcel.writeByteArray(this.mSerializedBundle);
        parcel.writeString(this.mBlurb);
    }
}
