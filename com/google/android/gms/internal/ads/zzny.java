package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(31)
/* loaded from: classes4.dex */
public final class zzny implements zzlv, zznz {
    private final Context zza;
    private final zzoa zzb;
    private final PlaybackSession zzc;
    @Nullable
    private String zzi;
    @Nullable
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    @Nullable
    private zzcf zzn;
    @Nullable
    private zznx zzo;
    @Nullable
    private zznx zzp;
    @Nullable
    private zznx zzq;
    @Nullable
    private zzam zzr;
    @Nullable
    private zzam zzs;
    @Nullable
    private zzam zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;
    private final zzcv zze = new zzcv();
    private final zzct zzf = new zzct();
    private final HashMap zzh = new HashMap();
    private final HashMap zzg = new HashMap();
    private final long zzd = SystemClock.elapsedRealtime();
    private int zzl = 0;
    private int zzm = 0;

    private zzny(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zznw zznwVar = new zznw(zznw.zza);
        this.zzb = zznwVar;
        zznwVar.zzg(this);
    }

    @Nullable
    public static zzny zzb(Context context) {
        PlaybackSession createPlaybackSession;
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager != null) {
            createPlaybackSession = mediaMetricsManager.createPlaybackSession();
            return new zzny(context, createPlaybackSession);
        }
        return null;
    }

    @SuppressLint({"SwitchIntDef"})
    private static int zzr(int i4) {
        switch (zzfj.zzh(i4)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long longValue;
        long longValue2;
        int i4;
        PlaybackMetrics build;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l4 = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l4 == null) {
                longValue = 0;
            } else {
                longValue = l4.longValue();
            }
            builder2.setNetworkTransferDurationMillis(longValue);
            Long l5 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l5 == null) {
                longValue2 = 0;
            } else {
                longValue2 = l5.longValue();
            }
            builder3.setNetworkBytesRead(longValue2);
            PlaybackMetrics.Builder builder4 = this.zzj;
            if (l5 != null && l5.longValue() > 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            builder4.setStreamSource(i4);
            PlaybackSession playbackSession = this.zzc;
            build = this.zzj.build();
            playbackSession.reportPlaybackMetrics(build);
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j4, @Nullable zzam zzamVar, int i4) {
        int i5;
        if (zzfj.zzC(this.zzs, zzamVar)) {
            return;
        }
        if (this.zzs == null) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        this.zzs = zzamVar;
        zzx(0, j4, zzamVar, i5);
    }

    private final void zzu(long j4, @Nullable zzam zzamVar, int i4) {
        int i5;
        if (zzfj.zzC(this.zzt, zzamVar)) {
            return;
        }
        if (this.zzt == null) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        this.zzt = zzamVar;
        zzx(2, j4, zzamVar, i5);
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzcw zzcwVar, @Nullable zzto zztoVar) {
        int zza;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zztoVar == null || (zza = zzcwVar.zza(zztoVar.zza)) == -1) {
            return;
        }
        int i4 = 0;
        zzcwVar.zzd(zza, this.zzf, false);
        zzcwVar.zze(this.zzf.zzd, this.zze, 0L);
        zzbi zzbiVar = this.zze.zzd.zzd;
        int i5 = 2;
        if (zzbiVar != null) {
            int zzl = zzfj.zzl(zzbiVar.zzb);
            if (zzl != 0) {
                if (zzl != 1) {
                    if (zzl != 2) {
                        i4 = 1;
                    } else {
                        i4 = 4;
                    }
                } else {
                    i4 = 5;
                }
            } else {
                i4 = 3;
            }
        }
        builder.setStreamType(i4);
        zzcv zzcvVar = this.zze;
        if (zzcvVar.zzn != -9223372036854775807L && !zzcvVar.zzl && !zzcvVar.zzi && !zzcvVar.zzb()) {
            builder.setMediaDurationMillis(zzfj.zzq(this.zze.zzn));
        }
        if (true != this.zze.zzb()) {
            i5 = 1;
        }
        builder.setPlaybackType(i5);
        this.zzz = true;
    }

    private final void zzw(long j4, @Nullable zzam zzamVar, int i4) {
        int i5;
        if (zzfj.zzC(this.zzr, zzamVar)) {
            return;
        }
        if (this.zzr == null) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        this.zzr = zzamVar;
        zzx(1, j4, zzamVar, i5);
    }

    private final void zzx(int i4, long j4, @Nullable zzam zzamVar, int i5) {
        TrackChangeEvent.Builder timeSinceCreatedMillis;
        TrackChangeEvent build;
        int i6;
        String str;
        timeSinceCreatedMillis = new TrackChangeEvent.Builder(i4).setTimeSinceCreatedMillis(j4 - this.zzd);
        if (zzamVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i5 != 1) {
                i6 = 1;
            } else {
                i6 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i6);
            String str2 = zzamVar.zzl;
            if (str2 != null) {
                timeSinceCreatedMillis.setContainerMimeType(str2);
            }
            String str3 = zzamVar.zzm;
            if (str3 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str3);
            }
            String str4 = zzamVar.zzj;
            if (str4 != null) {
                timeSinceCreatedMillis.setCodecName(str4);
            }
            int i7 = zzamVar.zzi;
            if (i7 != -1) {
                timeSinceCreatedMillis.setBitrate(i7);
            }
            int i8 = zzamVar.zzr;
            if (i8 != -1) {
                timeSinceCreatedMillis.setWidth(i8);
            }
            int i9 = zzamVar.zzs;
            if (i9 != -1) {
                timeSinceCreatedMillis.setHeight(i9);
            }
            int i10 = zzamVar.zzz;
            if (i10 != -1) {
                timeSinceCreatedMillis.setChannelCount(i10);
            }
            int i11 = zzamVar.zzA;
            if (i11 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i11);
            }
            String str5 = zzamVar.zzd;
            if (str5 != null) {
                int i12 = zzfj.zza;
                String[] split = str5.split("-", -1);
                String str6 = split[0];
                if (split.length >= 2) {
                    str = split[1];
                } else {
                    str = null;
                }
                Pair create = Pair.create(str6, str);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f4 = zzamVar.zzt;
            if (f4 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f4);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        PlaybackSession playbackSession = this.zzc;
        build = timeSinceCreatedMillis.build();
        playbackSession.reportTrackChangeEvent(build);
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(@Nullable zznx zznxVar) {
        if (zznxVar != null && zznxVar.zzc.equals(this.zzb.zzd())) {
            return true;
        }
        return false;
    }

    public final LogSessionId zza() {
        LogSessionId sessionId;
        sessionId = this.zzc.getSessionId();
        return sessionId;
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final void zzc(zzlt zzltVar, String str) {
        PlaybackMetrics.Builder playerName;
        PlaybackMetrics.Builder playerVersion;
        zzto zztoVar = zzltVar.zzd;
        if (zztoVar != null && zztoVar.zzb()) {
            return;
        }
        zzs();
        this.zzi = str;
        playerName = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3");
        playerVersion = playerName.setPlayerVersion("1.1.0-beta01");
        this.zzj = playerVersion;
        zzv(zzltVar.zzb, zzltVar.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final void zzd(zzlt zzltVar, String str, boolean z3) {
        zzto zztoVar = zzltVar.zzd;
        if ((zztoVar == null || !zztoVar.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzf(zzlt zzltVar, int i4, long j4, long j5) {
        long longValue;
        zzto zztoVar = zzltVar.zzd;
        if (zztoVar != null) {
            String zze = this.zzb.zze(zzltVar.zzb, zztoVar);
            Long l4 = (Long) this.zzh.get(zze);
            Long l5 = (Long) this.zzg.get(zze);
            HashMap hashMap = this.zzh;
            long j6 = 0;
            if (l4 == null) {
                longValue = 0;
            } else {
                longValue = l4.longValue();
            }
            hashMap.put(zze, Long.valueOf(longValue + j4));
            HashMap hashMap2 = this.zzg;
            if (l5 != null) {
                j6 = l5.longValue();
            }
            hashMap2.put(zze, Long.valueOf(j6 + i4));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzg(zzlt zzltVar, zztk zztkVar) {
        zzto zztoVar = zzltVar.zzd;
        if (zztoVar == null) {
            return;
        }
        zzam zzamVar = zztkVar.zzb;
        zzamVar.getClass();
        zznx zznxVar = new zznx(zzamVar, 0, this.zzb.zze(zzltVar.zzb, zztoVar));
        int i4 = zztkVar.zza;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return;
                    }
                    this.zzq = zznxVar;
                    return;
                }
            } else {
                this.zzp = zznxVar;
                return;
            }
        }
        this.zzo = zznxVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x01e6, code lost:
        if (r8 != 1) goto L149;
     */
    @Override // com.google.android.gms.internal.ads.zzlv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(com.google.android.gms.internal.ads.zzcp r19, com.google.android.gms.internal.ads.zzlu r20) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzny.zzi(com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzlu):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzl(zzlt zzltVar, zzcf zzcfVar) {
        this.zzn = zzcfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzm(zzlt zzltVar, zzco zzcoVar, zzco zzcoVar2, int i4) {
        if (i4 == 1) {
            this.zzu = true;
            i4 = 1;
        }
        this.zzk = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzo(zzlt zzltVar, zzhz zzhzVar) {
        this.zzw += zzhzVar.zzg;
        this.zzx += zzhzVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzq(zzlt zzltVar, zzdn zzdnVar) {
        zznx zznxVar = this.zzo;
        if (zznxVar != null) {
            zzam zzamVar = zznxVar.zza;
            if (zzamVar.zzs == -1) {
                zzak zzb = zzamVar.zzb();
                zzb.zzX(zzdnVar.zzc);
                zzb.zzF(zzdnVar.zzd);
                this.zzo = new zznx(zzb.zzY(), 0, zznxVar.zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzk(zzlt zzltVar, int i4) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zze(zzlt zzltVar, zzam zzamVar, zzia zziaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzh(zzlt zzltVar, int i4, long j4) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzn(zzlt zzltVar, Object obj, long j4) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzp(zzlt zzltVar, zzam zzamVar, zzia zziaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzj(zzlt zzltVar, zztf zztfVar, zztk zztkVar, IOException iOException, boolean z3) {
    }
}
