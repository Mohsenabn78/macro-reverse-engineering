package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdtw implements SensorEventListener {
    private final Context zza;
    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzdtv zzf;
    private boolean zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtw(Context context) {
        this.zza = context;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziy)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f5 = f4 / 9.80665f;
            float f6 = fArr[1] / 9.80665f;
            float f7 = fArr[2] / 9.80665f;
            if (((float) Math.sqrt((f5 * f5) + (f6 * f6) + (f7 * f7))) < ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziz)).floatValue()) {
                return;
            }
            long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            if (this.zzd + ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziA)).intValue() > currentTimeMillis) {
                return;
            }
            if (this.zzd + ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziB)).intValue() < currentTimeMillis) {
                this.zze = 0;
            }
            com.google.android.gms.ads.internal.util.zze.zza("Shake detected.");
            this.zzd = currentTimeMillis;
            int i4 = this.zze + 1;
            this.zze = i4;
            zzdtv zzdtvVar = this.zzf;
            if (zzdtvVar != null) {
                if (i4 == ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziC)).intValue()) {
                    zzdsx zzdsxVar = (zzdsx) zzdtvVar;
                    zzdsxVar.zzh(new zzdsu(zzdsxVar), zzdsw.GESTURE);
                }
            }
        }
    }

    public final void zza() {
        synchronized (this) {
            if (this.zzg) {
                SensorManager sensorManager = this.zzb;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzc);
                    com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for shake gestures.");
                }
                this.zzg = false;
            }
        }
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziy)).booleanValue()) {
                return;
            }
            if (this.zzb == null) {
                SensorManager sensorManager2 = (SensorManager) this.zza.getSystemService("sensor");
                this.zzb = sensorManager2;
                if (sensorManager2 == null) {
                    zzbzr.zzj("Shake detection failed to initialize. Failed to obtain accelerometer.");
                    return;
                }
                this.zzc = sensorManager2.getDefaultSensor(1);
            }
            if (!this.zzg && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                sensorManager.registerListener(this, sensor, 2);
                this.zzd = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziA)).intValue();
                this.zzg = true;
                com.google.android.gms.ads.internal.util.zze.zza("Listening for shake gestures.");
            }
        }
    }

    public final void zzc(zzdtv zzdtvVar) {
        this.zzf = zzdtvVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i4) {
    }
}
