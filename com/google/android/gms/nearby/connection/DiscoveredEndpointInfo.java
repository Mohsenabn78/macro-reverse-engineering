package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class DiscoveredEndpointInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f22178a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22179b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final BluetoothDevice f22180c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f22181d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ DiscoveredEndpointInfo(String str, String str2, BluetoothDevice bluetoothDevice, byte[] bArr, zzt zztVar) {
        this.f22178a = str;
        this.f22179b = str2;
        this.f22180c = bluetoothDevice;
        this.f22181d = bArr;
    }

    @NonNull
    public byte[] getEndpointInfo() {
        return this.f22181d;
    }

    @NonNull
    public String getEndpointName() {
        return this.f22179b;
    }

    @NonNull
    public String getServiceId() {
        return this.f22178a;
    }

    @Deprecated
    public DiscoveredEndpointInfo(@NonNull String str, @NonNull String str2) {
        this.f22178a = str;
        this.f22179b = str2;
        this.f22181d = str2.getBytes();
        this.f22180c = null;
    }
}
