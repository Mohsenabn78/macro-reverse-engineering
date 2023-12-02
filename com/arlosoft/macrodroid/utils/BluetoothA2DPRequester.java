package com.arlosoft.macrodroid.utils;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import android.content.Context;

/* loaded from: classes3.dex */
public class BluetoothA2DPRequester implements BluetoothProfile.ServiceListener {

    /* renamed from: a  reason: collision with root package name */
    private final Callback f16008a;

    /* loaded from: classes3.dex */
    public interface Callback {
        void onA2DPProxyReceived(BluetoothA2dp bluetoothA2dp);
    }

    public BluetoothA2DPRequester(Callback callback) {
        this.f16008a = callback;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int i4, BluetoothProfile bluetoothProfile) {
        Callback callback = this.f16008a;
        if (callback != null) {
            callback.onA2DPProxyReceived((BluetoothA2dp) bluetoothProfile);
        }
    }

    public void request(Context context, BluetoothAdapter bluetoothAdapter) {
        bluetoothAdapter.getProfileProxy(context, this, 2);
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int i4) {
    }
}
