package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.PowerManager;
import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes3.dex */
public class ShakeEventListener implements SensorEventListener {

    /* renamed from: j  reason: collision with root package name */
    private static int f15340j = 18;

    /* renamed from: k  reason: collision with root package name */
    private static int f15341k = 5;

    /* renamed from: b  reason: collision with root package name */
    private long f15343b;

    /* renamed from: h  reason: collision with root package name */
    private OnShakeListener f15349h;

    /* renamed from: i  reason: collision with root package name */
    private final PowerManager.WakeLock f15350i;

    /* renamed from: a  reason: collision with root package name */
    private long f15342a = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f15344c = 0;

    /* renamed from: d  reason: collision with root package name */
    private float f15345d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f15346e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f15347f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private long f15348g = 0;

    /* loaded from: classes3.dex */
    public interface OnShakeListener {
        void onShake();
    }

    public ShakeEventListener(Context context) {
        this.f15350i = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "MacroDroid:ShakeEventListener");
    }

    private void a() {
        this.f15342a = 0L;
        this.f15344c = 0;
        this.f15343b = 0L;
        this.f15345d = 0.0f;
        this.f15346e = 0.0f;
        this.f15347f = 0.0f;
    }

    public static void setShakeSensitivity(String str) {
        if (str.startsWith("5")) {
            f15340j = 4;
            f15341k = 4;
        } else if (str.startsWith("4")) {
            f15340j = 9;
            f15341k = 4;
        } else if (str.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
            f15340j = 15;
            f15341k = 4;
        } else if (str.startsWith(ExifInterface.GPS_MEASUREMENT_2D)) {
            f15340j = 21;
            f15341k = 5;
        } else if (str.startsWith("1")) {
            f15340j = 32;
            f15341k = 6;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f15348g + 1200) {
            return;
        }
        float[] fArr = sensorEvent.values;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[2];
        if (Math.abs(((((f4 + f5) + f6) - this.f15345d) - this.f15346e) - this.f15347f) > f15340j) {
            if (this.f15342a == 0) {
                this.f15342a = currentTimeMillis;
                this.f15343b = currentTimeMillis;
            }
            if (currentTimeMillis - this.f15343b < 300) {
                this.f15343b = currentTimeMillis;
                int i4 = this.f15344c + 1;
                this.f15344c = i4;
                this.f15345d = f4;
                this.f15346e = f5;
                this.f15347f = f6;
                if (i4 >= f15341k && currentTimeMillis - this.f15342a < 1000) {
                    this.f15350i.acquire(10000L);
                    this.f15349h.onShake();
                    try {
                        this.f15350i.release();
                    } catch (Exception unused) {
                    }
                    a();
                    this.f15348g = System.currentTimeMillis();
                    return;
                }
                return;
            }
            a();
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.f15349h = onShakeListener;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }
}
