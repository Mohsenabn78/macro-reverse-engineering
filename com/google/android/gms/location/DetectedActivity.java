package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "DetectedActivityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class DetectedActivity extends AbstractSafeParcelable {
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    int f20904a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    int f20905b;
    @NonNull
    public static final Comparator zza = new zzk();
    @NonNull
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzl();

    @SafeParcelable.Constructor
    public DetectedActivity(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5) {
        this.f20904a = i4;
        this.f20905b = i5;
    }

    @ShowFirstParty
    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f20904a == detectedActivity.f20904a && this.f20905b == detectedActivity.f20905b) {
                return true;
            }
        }
        return false;
    }

    public int getConfidence() {
        return this.f20905b;
    }

    public int getType() {
        int i4 = this.f20904a;
        if (i4 <= 22 && i4 >= 0) {
            return i4;
        }
        return 4;
    }

    @ShowFirstParty
    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20904a), Integer.valueOf(this.f20905b));
    }

    @NonNull
    public String toString() {
        String str;
        int type = getType();
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            if (type != 5) {
                                if (type != 7) {
                                    if (type != 8) {
                                        if (type != 16) {
                                            if (type != 17) {
                                                str = Integer.toString(type);
                                            } else {
                                                str = "IN_RAIL_VEHICLE";
                                            }
                                        } else {
                                            str = "IN_ROAD_VEHICLE";
                                        }
                                    } else {
                                        str = DebugCoroutineInfoImplKt.RUNNING;
                                    }
                                } else {
                                    str = "WALKING";
                                }
                            } else {
                                str = "TILTING";
                            }
                        } else {
                            str = "UNKNOWN";
                        }
                    } else {
                        str = "STILL";
                    }
                } else {
                    str = "ON_FOOT";
                }
            } else {
                str = "ON_BICYCLE";
            }
        } else {
            str = "IN_VEHICLE";
        }
        int i4 = this.f20905b;
        return "DetectedActivity [type=" + str + ", confidence=" + i4 + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20904a);
        SafeParcelWriter.writeInt(parcel, 2, this.f20905b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
