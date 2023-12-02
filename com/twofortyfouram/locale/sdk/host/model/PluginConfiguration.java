package com.twofortyfouram.locale.sdk.host.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
/* loaded from: classes6.dex */
public final class PluginConfiguration implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<PluginConfiguration> CREATOR = new Parcelable.Creator<PluginConfiguration>() { // from class: com.twofortyfouram.locale.sdk.host.model.PluginConfiguration.1
        private boolean convertIntToBoolean(int i4) {
            if (i4 != 0) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginConfiguration createFromParcel(Parcel parcel) {
            Assertions.assertNotNull(parcel, "in");
            boolean convertIntToBoolean = convertIntToBoolean(parcel.readInt());
            boolean convertIntToBoolean2 = convertIntToBoolean(parcel.readInt());
            boolean convertIntToBoolean3 = convertIntToBoolean(parcel.readInt());
            boolean convertIntToBoolean4 = convertIntToBoolean(parcel.readInt());
            boolean convertIntToBoolean5 = convertIntToBoolean(parcel.readInt());
            boolean convertIntToBoolean6 = convertIntToBoolean(parcel.readInt());
            LinkedList linkedList = new LinkedList();
            parcel.readStringList(linkedList);
            return new PluginConfiguration(convertIntToBoolean, convertIntToBoolean2, convertIntToBoolean3, convertIntToBoolean4, convertIntToBoolean5, convertIntToBoolean6, linkedList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginConfiguration[] newArray(int i4) {
            return new PluginConfiguration[i4];
        }
    };
    @NonNull
    private final Set<String> mAlternatives;
    private final boolean mIsBackwardsCompatibilityEnabled;
    private final boolean mIsBlacklisted;
    private final boolean mIsBuggy;
    private final boolean mIsDisruptsConnectivity;
    private final boolean mIsDrainsBattery;
    private final boolean mIsRequiresConnectivity;

    public PluginConfiguration(boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @NonNull Collection<String> collection) {
        Assertions.assertNotNull(collection, "alternatives");
        this.mIsBackwardsCompatibilityEnabled = z3;
        this.mIsRequiresConnectivity = z4;
        this.mIsDisruptsConnectivity = z5;
        this.mIsBuggy = z6;
        this.mIsDrainsBattery = z7;
        this.mIsBlacklisted = z8;
        if (collection.isEmpty()) {
            this.mAlternatives = Collections.emptySet();
        } else {
            this.mAlternatives = Collections.unmodifiableSet(new LinkedHashSet(collection));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PluginConfiguration.class != obj.getClass()) {
            return false;
        }
        PluginConfiguration pluginConfiguration = (PluginConfiguration) obj;
        if (this.mIsBackwardsCompatibilityEnabled != pluginConfiguration.mIsBackwardsCompatibilityEnabled || this.mIsBlacklisted != pluginConfiguration.mIsBlacklisted || this.mIsBuggy != pluginConfiguration.mIsBuggy || this.mIsDisruptsConnectivity != pluginConfiguration.mIsDisruptsConnectivity || this.mIsDrainsBattery != pluginConfiguration.mIsDrainsBattery || this.mIsRequiresConnectivity != pluginConfiguration.mIsRequiresConnectivity) {
            return false;
        }
        return this.mAlternatives.equals(pluginConfiguration.mAlternatives);
    }

    @NonNull
    public Collection<String> getAlternatives() {
        return this.mAlternatives;
    }

    public int hashCode() {
        return ((((((((((((this.mIsBackwardsCompatibilityEnabled ? 1 : 0) * 31) + (this.mIsRequiresConnectivity ? 1 : 0)) * 31) + (this.mIsDisruptsConnectivity ? 1 : 0)) * 31) + (this.mIsDrainsBattery ? 1 : 0)) * 31) + (this.mIsBuggy ? 1 : 0)) * 31) + (this.mIsBlacklisted ? 1 : 0)) * 31) + this.mAlternatives.hashCode();
    }

    public boolean isBackwardsCompatibilityEnabled() {
        return true;
    }

    public boolean isBlacklisted() {
        return this.mIsBlacklisted;
    }

    public boolean isBuggy() {
        return this.mIsBuggy;
    }

    public boolean isDisruptsConnectivity() {
        return this.mIsDisruptsConnectivity;
    }

    public boolean isDrainsBattery() {
        return this.mIsDrainsBattery;
    }

    public boolean isRequiresConnectivity() {
        return this.mIsRequiresConnectivity;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(convertBooleanToInt(this.mIsBackwardsCompatibilityEnabled));
        parcel.writeInt(convertBooleanToInt(this.mIsRequiresConnectivity));
        parcel.writeInt(convertBooleanToInt(this.mIsDisruptsConnectivity));
        parcel.writeInt(convertBooleanToInt(this.mIsBuggy));
        parcel.writeInt(convertBooleanToInt(this.mIsDrainsBattery));
        parcel.writeInt(convertBooleanToInt(this.mIsBlacklisted));
        parcel.writeStringList(new LinkedList(this.mAlternatives));
    }

    private static int convertBooleanToInt(boolean z3) {
        return z3 ? 1 : 0;
    }
}
