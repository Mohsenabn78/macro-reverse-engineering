package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object f18992a = new Object();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private zzdq f18993b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private VideoLifecycleCallbacks f18994c;

    @KeepForSdk
    public int getPlaybackState() {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar == null) {
                return 0;
            }
            try {
                return zzdqVar.zzh();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call getPlaybackState on video controller.", e4);
                return 0;
            }
        }
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.f18992a) {
            videoLifecycleCallbacks = this.f18994c;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z3;
        synchronized (this.f18992a) {
            if (this.f18993b != null) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar == null) {
                return false;
            }
            try {
                return zzdqVar.zzo();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call isClickToExpandEnabled.", e4);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar == null) {
                return false;
            }
            try {
                return zzdqVar.zzp();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call isUsingCustomPlayerControls.", e4);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar == null) {
                return true;
            }
            try {
                return zzdqVar.zzq();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call isMuted on video controller.", e4);
                return true;
            }
        }
    }

    public void mute(boolean z3) {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar != null) {
                try {
                    zzdqVar.zzj(z3);
                } catch (RemoteException e4) {
                    zzbzr.zzh("Unable to call mute on video controller.", e4);
                }
            }
        }
    }

    public void pause() {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar != null) {
                try {
                    zzdqVar.zzk();
                } catch (RemoteException e4) {
                    zzbzr.zzh("Unable to call pause on video controller.", e4);
                }
            }
        }
    }

    public void play() {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar != null) {
                try {
                    zzdqVar.zzl();
                } catch (RemoteException e4) {
                    zzbzr.zzh("Unable to call play on video controller.", e4);
                }
            }
        }
    }

    public void setVideoLifecycleCallbacks(@Nullable VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfk zzfkVar;
        synchronized (this.f18992a) {
            this.f18994c = videoLifecycleCallbacks;
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar != null) {
                if (videoLifecycleCallbacks == null) {
                    zzfkVar = null;
                } else {
                    try {
                        zzfkVar = new zzfk(videoLifecycleCallbacks);
                    } catch (RemoteException e4) {
                        zzbzr.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e4);
                    }
                }
                zzdqVar.zzm(zzfkVar);
            }
        }
    }

    public void stop() {
        synchronized (this.f18992a) {
            zzdq zzdqVar = this.f18993b;
            if (zzdqVar != null) {
                try {
                    zzdqVar.zzn();
                } catch (RemoteException e4) {
                    zzbzr.zzh("Unable to call stop on video controller.", e4);
                }
            }
        }
    }

    @Nullable
    public final zzdq zza() {
        zzdq zzdqVar;
        synchronized (this.f18992a) {
            zzdqVar = this.f18993b;
        }
        return zzdqVar;
    }

    public final void zzb(@Nullable zzdq zzdqVar) {
        synchronized (this.f18992a) {
            this.f18993b = zzdqVar;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.f18994c;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }

        public void onVideoMute(boolean z3) {
        }
    }
}
