package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzs {

    /* renamed from: a  reason: collision with root package name */
    private String f22253a;

    /* renamed from: b  reason: collision with root package name */
    private String f22254b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private BluetoothDevice f22255c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f22256d;

    public final zzs zza(@Nullable BluetoothDevice bluetoothDevice) {
        this.f22255c = bluetoothDevice;
        this.f22254b = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
        this.f22256d = "__UNRECOGNIZED_BLUETOOTH_DEVICE__".getBytes();
        return this;
    }

    public final zzs zzb(byte[] bArr) {
        this.f22256d = bArr;
        return this;
    }

    public final zzs zzc(String str) {
        this.f22254b = str;
        return this;
    }

    public final zzs zzd(String str) {
        this.f22253a = str;
        return this;
    }

    public final DiscoveredEndpointInfo zze() {
        return new DiscoveredEndpointInfo(this.f22253a, this.f22254b, this.f22255c, this.f22256d, null);
    }
}
