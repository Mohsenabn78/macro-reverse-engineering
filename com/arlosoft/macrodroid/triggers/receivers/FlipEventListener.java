package com.arlosoft.macrodroid.triggers.receivers;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public class FlipEventListener implements SensorEventListener {

    /* renamed from: d  reason: collision with root package name */
    private static a f15315d = a.UNKNOWN;

    /* renamed from: a  reason: collision with root package name */
    private long f15316a;

    /* renamed from: b  reason: collision with root package name */
    private long f15317b;

    /* renamed from: c  reason: collision with root package name */
    private OnFlipListener f15318c;

    /* loaded from: classes3.dex */
    public interface OnFlipListener {
        void onFaceDown();

        void onFlip(boolean z3);
    }

    /* loaded from: classes3.dex */
    enum a {
        FACE_DOWN,
        FACE_UP,
        UNKNOWN
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        OnFlipListener onFlipListener;
        OnFlipListener onFlipListener2;
        double d4 = sensorEvent.values[2];
        if (-9.0d > d4 && d4 > -10.0d) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (8.8d < d4 && d4 < 10.2d) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (-8.0d > d4 && d4 > -11.0d) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (8.0d < d4 && d4 > 11.0d) {
            z6 = true;
        } else {
            z6 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (z3) {
            this.f15317b = currentTimeMillis;
            a aVar = f15315d;
            a aVar2 = a.FACE_DOWN;
            if (aVar != aVar2 && (onFlipListener2 = this.f15318c) != null) {
                if (currentTimeMillis - this.f15316a < 2500) {
                    onFlipListener2.onFlip(true);
                }
                this.f15318c.onFaceDown();
            }
            f15315d = aVar2;
        } else if (z5) {
            this.f15317b = currentTimeMillis;
        } else if (z4) {
            this.f15316a = currentTimeMillis;
            a aVar3 = f15315d;
            a aVar4 = a.FACE_UP;
            if (aVar3 != aVar4 && (onFlipListener = this.f15318c) != null && currentTimeMillis - this.f15317b < 2500) {
                onFlipListener.onFlip(false);
                this.f15317b = 0L;
            }
            f15315d = aVar4;
        } else if (z6) {
            this.f15316a = currentTimeMillis;
        } else if (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            f15315d = a.UNKNOWN;
        }
    }

    public void setOnFlipListener(OnFlipListener onFlipListener) {
        this.f15318c = onFlipListener;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }
}
