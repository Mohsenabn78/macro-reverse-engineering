package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcby extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcbw {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzcbx zzb;
    private final float[] zzc;
    private final float[] zzd;
    private final float[] zze;
    private final float[] zzf;
    private final float[] zzg;
    private final float[] zzh;
    private final float[] zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzcby(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zza;
        int length = fArr.length;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        this.zzc = new float[9];
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzg = new float[9];
        this.zzh = new float[9];
        this.zzi = new float[9];
        this.zzj = Float.NaN;
        zzcbx zzcbxVar = new zzcbx(context);
        this.zzb = zzcbxVar;
        zzcbxVar.zza(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", str + ": glError " + glGetError);
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        float f4 = fArr2[1];
        float f5 = fArr3[3];
        float f6 = fArr2[2];
        float f7 = fArr3[6];
        fArr[0] = (fArr2[0] * fArr3[0]) + (f4 * f5) + (f6 * f7);
        float f8 = fArr2[0];
        float f9 = fArr3[4];
        float f10 = fArr3[7];
        fArr[1] = (fArr3[1] * f8) + (f4 * f9) + (f6 * f10);
        float f11 = f8 * fArr3[2];
        float f12 = fArr2[1];
        float f13 = fArr3[5];
        float f14 = fArr3[8];
        fArr[2] = f11 + (f12 * f13) + (f6 * f14);
        float f15 = fArr2[3];
        float f16 = fArr3[0];
        float f17 = fArr2[4];
        float f18 = fArr2[5];
        fArr[3] = (f15 * f16) + (f5 * f17) + (f18 * f7);
        float f19 = fArr2[3];
        float f20 = fArr3[1];
        fArr[4] = (f19 * f20) + (f17 * f9) + (f18 * f10);
        float f21 = fArr3[2];
        fArr[5] = (f19 * f21) + (fArr2[4] * f13) + (f18 * f14);
        float f22 = fArr2[6] * f16;
        float f23 = fArr2[7];
        float f24 = fArr2[8];
        fArr[6] = f22 + (fArr3[3] * f23) + (f7 * f24);
        float f25 = fArr2[6];
        fArr[7] = (f20 * f25) + (f23 * fArr3[4]) + (f10 * f24);
        fArr[8] = (f25 * f21) + (fArr2[7] * fArr3[5]) + (f24 * f14);
    }

    private static final void zzj(float[] fArr, float f4) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d4 = f4;
        fArr[4] = (float) Math.cos(d4);
        fArr[5] = (float) (-Math.sin(d4));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d4);
        fArr[8] = (float) Math.cos(d4);
    }

    private static final void zzk(float[] fArr, float f4) {
        double d4 = f4;
        fArr[0] = (float) Math.cos(d4);
        fArr[1] = (float) (-Math.sin(d4));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d4);
        fArr[4] = (float) Math.cos(d4);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i4, String str) {
        int glCreateShader = GLES20.glCreateShader(i4);
        zzh("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i4 + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bf A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.SurfaceTexture, android.graphics.SurfaceTexture$OnFrameAvailableListener] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcby.run():void");
    }

    @Override // com.google.android.gms.internal.ads.zzcbw
    public final void zza() {
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    @Nullable
    public final SurfaceTexture zzb() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzc(int i4, int i5) {
        synchronized (this.zzv) {
            this.zzn = i4;
            this.zzm = i5;
            this.zzA = true;
            this.zzv.notifyAll();
        }
    }

    public final void zzd(SurfaceTexture surfaceTexture, int i4, int i5) {
        this.zzn = i4;
        this.zzm = i5;
        this.zzp = surfaceTexture;
    }

    public final void zze() {
        synchronized (this.zzv) {
            this.zzB = true;
            this.zzp = null;
            this.zzv.notifyAll();
        }
    }

    public final void zzf(float f4, float f5) {
        float f6;
        int i4 = this.zzn;
        int i5 = this.zzm;
        float f7 = f4 * 1.7453293f;
        float f8 = f5 * 1.7453293f;
        if (i4 > i5) {
            f6 = i4;
        } else {
            f6 = i5;
        }
        this.zzk -= f7 / f6;
        float f9 = this.zzl - (f8 / f6);
        this.zzl = f9;
        if (f9 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f9 = -1.5707964f;
        }
        if (f9 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    @VisibleForTesting
    final boolean zzg() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzz;
        boolean z3 = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            z3 = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            z3 |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay != null) {
            boolean eglTerminate = this.zzw.eglTerminate(eGLDisplay) | z3;
            this.zzx = null;
            return eglTerminate;
        }
        return z3;
    }
}
