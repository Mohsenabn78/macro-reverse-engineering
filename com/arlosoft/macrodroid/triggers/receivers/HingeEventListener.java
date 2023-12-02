package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.arlosoft.macrodroid.settings.Settings;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class HingeEventListener implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private float f15324a;

    /* renamed from: b  reason: collision with root package name */
    private OnHingeChangeListener f15325b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f15326c;

    /* loaded from: classes3.dex */
    public enum HingeState {
        OPEN,
        CLOSED,
        OPEN_TO_90,
        CLOSED_TO_90
    }

    /* loaded from: classes3.dex */
    public interface OnHingeChangeListener {
        void onHingeChange(HingeState hingeState);
    }

    public HingeEventListener(Context context, OnHingeChangeListener onHingeChangeListener) {
        this.f15324a = -1.0f;
        this.f15324a = Settings.getLastHingeAngle(context);
        this.f15326c = new WeakReference<>(context);
        this.f15325b = onHingeChangeListener;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f4 = sensorEvent.values[0];
        float f5 = this.f15324a;
        if (f5 == f4) {
            return;
        }
        if (f5 >= 0.0f) {
            if (f4 < 2.0f) {
                this.f15325b.onHingeChange(HingeState.CLOSED);
            } else if (f4 > 178.0f) {
                this.f15325b.onHingeChange(HingeState.OPEN);
            } else if (f4 > 85.0f && f4 < 95.0f) {
                if (f5 < 2.0f) {
                    this.f15325b.onHingeChange(HingeState.CLOSED_TO_90);
                } else if (f5 > 178.0f) {
                    this.f15325b.onHingeChange(HingeState.OPEN_TO_90);
                }
            }
        }
        this.f15324a = (int) f4;
        Context context = this.f15326c.get();
        if (context != null) {
            Settings.setLastHingeAngle(context, this.f15324a);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }
}
