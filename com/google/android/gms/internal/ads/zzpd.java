package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import java.lang.reflect.Method;
import javax.mail.UIDFolder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzpd {
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private boolean zzE;
    private long zzF;
    private long zzG;
    private final zzpc zza;
    private final long[] zzb;
    @Nullable
    private AudioTrack zzc;
    private int zzd;
    private int zze;
    @Nullable
    private zzpb zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    @Nullable
    private Method zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    public zzpd(zzpc zzpcVar) {
        this.zza = zzpcVar;
        int i4 = zzfj.zza;
        try {
            this.zzn = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
    }

    private final long zzl(long j4) {
        return (j4 * this.zzg) / AnimationKt.MillisToNanos;
    }

    private final long zzm(long j4) {
        return (j4 * AnimationKt.MillisToNanos) / this.zzg;
    }

    private final long zzn() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = this.zzy;
        if (j4 != -9223372036854775807L) {
            return Math.min(this.zzB, this.zzA + zzl(zzfj.zzm((elapsedRealtime * 1000) - j4, this.zzj)));
        }
        if (elapsedRealtime - this.zzs >= 5) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                boolean z3 = this.zzh;
                long j5 = playbackHeadPosition & UIDFolder.MAXUID;
                long j6 = 0;
                if (z3) {
                    if (playState == 2) {
                        if (j5 == 0) {
                            this.zzv = this.zzt;
                        }
                        playState = 2;
                    }
                    j5 += this.zzv;
                }
                if (zzfj.zza <= 29) {
                    if (j5 == 0) {
                        if (this.zzt > 0 && playState == 3) {
                            if (this.zzz == -9223372036854775807L) {
                                this.zzz = elapsedRealtime;
                            }
                        }
                    } else {
                        j6 = j5;
                    }
                    this.zzz = -9223372036854775807L;
                    j5 = j6;
                }
                if (this.zzt > j5) {
                    this.zzu++;
                }
                this.zzt = j5;
            }
            this.zzs = elapsedRealtime;
        }
        return this.zzt + (this.zzu << 32);
    }

    private final void zzo() {
        this.zzl = 0L;
        this.zzx = 0;
        this.zzw = 0;
        this.zzm = 0L;
        this.zzD = 0L;
        this.zzG = 0L;
        this.zzk = false;
    }

    public final int zza(long j4) {
        return this.zze - ((int) (j4 - (zzn() * this.zzd)));
    }

    public final long zzb(boolean z3) {
        long zzm;
        zzow zzowVar;
        zzow zzowVar2;
        zzos zzosVar;
        Method method;
        long zzF;
        long zzG;
        long zzF2;
        long zzG2;
        zzpd zzpdVar = this;
        AudioTrack audioTrack = zzpdVar.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - zzpdVar.zzm >= 30000) {
                long zzm2 = zzpdVar.zzm(zzn());
                if (zzm2 != 0) {
                    zzpdVar.zzb[zzpdVar.zzw] = zzfj.zzn(zzm2, zzpdVar.zzj) - nanoTime;
                    zzpdVar.zzw = (zzpdVar.zzw + 1) % 10;
                    int i4 = zzpdVar.zzx;
                    if (i4 < 10) {
                        zzpdVar.zzx = i4 + 1;
                    }
                    zzpdVar.zzm = nanoTime;
                    zzpdVar.zzl = 0L;
                    int i5 = 0;
                    while (true) {
                        int i6 = zzpdVar.zzx;
                        if (i5 >= i6) {
                            break;
                        }
                        zzpdVar.zzl += zzpdVar.zzb[i5] / i6;
                        i5++;
                    }
                }
            }
            if (!zzpdVar.zzh) {
                zzpb zzpbVar = zzpdVar.zzf;
                zzpbVar.getClass();
                if (zzpbVar.zzg(nanoTime)) {
                    long zzb = zzpbVar.zzb();
                    long zza = zzpbVar.zza();
                    long zzm3 = zzpdVar.zzm(zzn());
                    if (Math.abs(zzb - nanoTime) > 5000000) {
                        zzpu zzpuVar = (zzpu) zzpdVar.zza;
                        zzF2 = zzpuVar.zza.zzF();
                        zzG2 = zzpuVar.zza.zzG();
                        zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + zza + ", " + zzb + ", " + nanoTime + ", " + zzm3 + ", " + zzF2 + ", " + zzG2);
                        zzpbVar.zzd();
                    } else if (Math.abs(zzpdVar.zzm(zza) - zzm3) > 5000000) {
                        zzpu zzpuVar2 = (zzpu) zzpdVar.zza;
                        zzF = zzpuVar2.zza.zzF();
                        zzG = zzpuVar2.zza.zzG();
                        zzer.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + zza + ", " + zzb + ", " + nanoTime + ", " + zzm3 + ", " + zzF + ", " + zzG);
                        zzpbVar.zzd();
                    } else {
                        zzpbVar.zzc();
                    }
                    zzpdVar = this;
                }
                if (zzpdVar.zzq && (method = zzpdVar.zzn) != null && nanoTime - zzpdVar.zzr >= 500000) {
                    try {
                        AudioTrack audioTrack2 = zzpdVar.zzc;
                        audioTrack2.getClass();
                        int i7 = zzfj.zza;
                        long intValue = ((Integer) method.invoke(audioTrack2, new Object[0])).intValue();
                        long j4 = zzpdVar.zzi;
                        Long.signum(intValue);
                        long j5 = (intValue * 1000) - j4;
                        zzpdVar.zzo = j5;
                        long max = Math.max(j5, 0L);
                        zzpdVar.zzo = max;
                        if (max > 5000000) {
                            zzer.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + max);
                            zzpdVar.zzo = 0L;
                        }
                    } catch (Exception unused) {
                        zzpdVar.zzn = null;
                    }
                    zzpdVar.zzr = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        zzpb zzpbVar2 = zzpdVar.zzf;
        zzpbVar2.getClass();
        boolean zzf = zzpbVar2.zzf();
        if (zzf) {
            zzm = zzpdVar.zzm(zzpbVar2.zza()) + zzfj.zzm(nanoTime2 - zzpbVar2.zzb(), zzpdVar.zzj);
        } else {
            if (zzpdVar.zzx == 0) {
                zzm = zzpdVar.zzm(zzn());
            } else {
                zzm = zzfj.zzm(zzpdVar.zzl + nanoTime2, zzpdVar.zzj);
            }
            if (!z3) {
                zzm = Math.max(0L, zzm - zzpdVar.zzo);
            }
        }
        if (zzpdVar.zzE != zzf) {
            zzpdVar.zzG = zzpdVar.zzD;
            zzpdVar.zzF = zzpdVar.zzC;
        }
        long j6 = nanoTime2 - zzpdVar.zzG;
        if (j6 < AnimationKt.MillisToNanos) {
            long j7 = (j6 * 1000) / AnimationKt.MillisToNanos;
            zzm = ((zzm * j7) + ((1000 - j7) * (zzpdVar.zzF + zzfj.zzm(j6, zzpdVar.zzj)))) / 1000;
        }
        if (!zzpdVar.zzk) {
            long j8 = zzpdVar.zzC;
            if (zzm > j8) {
                zzpdVar.zzk = true;
                int i8 = zzfj.zza;
                long currentTimeMillis = System.currentTimeMillis() - zzfj.zzq(zzfj.zzn(zzfj.zzq(zzm - j8), zzpdVar.zzj));
                zzpz zzpzVar = ((zzpu) zzpdVar.zza).zza;
                zzowVar = zzpzVar.zzp;
                if (zzowVar != null) {
                    zzowVar2 = zzpzVar.zzp;
                    zzosVar = ((zzqe) zzowVar2).zza.zzc;
                    zzosVar.zzr(currentTimeMillis);
                }
            }
        }
        zzpdVar.zzD = nanoTime2;
        zzpdVar.zzC = zzm;
        zzpdVar.zzE = zzf;
        return zzm;
    }

    public final void zzc(long j4) {
        this.zzA = zzn();
        this.zzy = SystemClock.elapsedRealtime() * 1000;
        this.zzB = j4;
    }

    public final void zzd() {
        zzo();
        this.zzc = null;
        this.zzf = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r6
            r2.zze = r7
            com.google.android.gms.internal.ads.zzpb r0 = new com.google.android.gms.internal.ads.zzpb
            r0.<init>(r3)
            r2.zzf = r0
            int r3 = r3.getSampleRate()
            r2.zzg = r3
            r3 = 0
            if (r4 == 0) goto L25
            int r4 = com.google.android.gms.internal.ads.zzfj.zza
            r0 = 23
            if (r4 >= r0) goto L25
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L26
            r4 = 6
            if (r5 != r4) goto L25
            r5 = 6
            goto L26
        L25:
            r0 = 0
        L26:
            r2.zzh = r0
            boolean r4 = com.google.android.gms.internal.ads.zzfj.zzD(r5)
            r2.zzq = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L3c
            int r7 = r7 / r6
            long r4 = (long) r7
            long r4 = r2.zzm(r4)
            goto L3d
        L3c:
            r4 = r0
        L3d:
            r2.zzi = r4
            r4 = 0
            r2.zzt = r4
            r2.zzu = r4
            r2.zzv = r4
            r2.zzp = r3
            r2.zzy = r0
            r2.zzz = r0
            r2.zzr = r4
            r2.zzo = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzj = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.zze(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zzf() {
        zzpb zzpbVar = this.zzf;
        zzpbVar.getClass();
        zzpbVar.zze();
    }

    public final boolean zzg(long j4) {
        if (j4 <= zzl(zzb(false))) {
            if (this.zzh) {
                AudioTrack audioTrack = this.zzc;
                audioTrack.getClass();
                if (audioTrack.getPlayState() == 2 && zzn() == 0) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public final boolean zzi(long j4) {
        if (this.zzz != -9223372036854775807L && j4 > 0 && SystemClock.elapsedRealtime() - this.zzz >= 200) {
            return true;
        }
        return false;
    }

    public final boolean zzj(long j4) {
        zzow zzowVar;
        long j5;
        zzow zzowVar2;
        zzos zzosVar;
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzh) {
            if (playState == 2) {
                this.zzp = false;
                return false;
            } else if (playState == 1) {
                if (zzn() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z3 = this.zzp;
        boolean zzg = zzg(j4);
        this.zzp = zzg;
        if (z3 && !zzg && playState != 1) {
            zzpc zzpcVar = this.zza;
            int i4 = this.zze;
            long zzq = zzfj.zzq(this.zzi);
            zzpu zzpuVar = (zzpu) zzpcVar;
            zzowVar = zzpuVar.zza.zzp;
            if (zzowVar != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                zzpz zzpzVar = zzpuVar.zza;
                j5 = zzpzVar.zzV;
                zzowVar2 = zzpzVar.zzp;
                zzosVar = ((zzqe) zzowVar2).zza.zzc;
                zzosVar.zzt(i4, zzq, elapsedRealtime - j5);
            }
        }
        return true;
    }

    public final boolean zzk() {
        zzo();
        if (this.zzy == -9223372036854775807L) {
            zzpb zzpbVar = this.zzf;
            zzpbVar.getClass();
            zzpbVar.zze();
            return true;
        }
        return false;
    }
}
