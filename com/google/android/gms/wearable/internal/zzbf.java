package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "ChannelEventParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzbf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbf> CREATOR = new zzbg();
    @SafeParcelable.Field(id = 2)

    /* renamed from: a  reason: collision with root package name */
    final zzbq f22687a;
    @SafeParcelable.Field(id = 3)

    /* renamed from: b  reason: collision with root package name */
    final int f22688b;
    @SafeParcelable.Field(id = 4)

    /* renamed from: c  reason: collision with root package name */
    final int f22689c;
    @SafeParcelable.Field(id = 5)

    /* renamed from: d  reason: collision with root package name */
    final int f22690d;

    @SafeParcelable.Constructor
    public zzbf(@SafeParcelable.Param(id = 2) zzbq zzbqVar, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) int i5, @SafeParcelable.Param(id = 5) int i6) {
        this.f22687a = zzbqVar;
        this.f22688b = i4;
        this.f22689c = i5;
        this.f22690d = i6;
    }

    public final String toString() {
        String str;
        String str2;
        String valueOf = String.valueOf(this.f22687a);
        int i4 = this.f22688b;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        str = Integer.toString(i4);
                    } else {
                        str = "OUTPUT_CLOSED";
                    }
                } else {
                    str = "INPUT_CLOSED";
                }
            } else {
                str = "CHANNEL_CLOSED";
            }
        } else {
            str = "CHANNEL_OPENED";
        }
        int i5 = this.f22689c;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        str2 = Integer.toString(i5);
                    } else {
                        str2 = "CLOSE_REASON_LOCAL_CLOSE";
                    }
                } else {
                    str2 = "CLOSE_REASON_REMOTE_CLOSE";
                }
            } else {
                str2 = "CLOSE_REASON_DISCONNECTED";
            }
        } else {
            str2 = "CLOSE_REASON_NORMAL";
        }
        int i6 = this.f22690d;
        return "ChannelEventParcelable[, channel=" + valueOf + ", type=" + str + ", closeReason=" + str2 + ", appErrorCode=" + i6 + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22687a, i4, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f22688b);
        SafeParcelWriter.writeInt(parcel, 4, this.f22689c);
        SafeParcelWriter.writeInt(parcel, 5, this.f22690d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zza(ChannelApi.ChannelListener channelListener) {
        int i4 = this.f22688b;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        Log.w("ChannelEventParcelable", "Unknown type: " + i4);
                        return;
                    }
                    channelListener.onOutputClosed(this.f22687a, this.f22689c, this.f22690d);
                    return;
                }
                channelListener.onInputClosed(this.f22687a, this.f22689c, this.f22690d);
                return;
            }
            channelListener.onChannelClosed(this.f22687a, this.f22689c, this.f22690d);
            return;
        }
        channelListener.onChannelOpened(this.f22687a);
    }
}
