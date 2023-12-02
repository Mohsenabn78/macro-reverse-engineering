package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class AdActivity extends Activity {
    @NonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private zzbrt f18949a;

    private final void a() {
        zzbrt zzbrtVar = this.f18949a;
        if (zzbrtVar != null) {
            try {
                zzbrtVar.zzx();
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i4, int i5, @NonNull Intent intent) {
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzh(i4, i5, intent);
            }
        } catch (Exception e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                if (!zzbrtVar.zzG()) {
                    return;
                }
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        super.onBackPressed();
        try {
            zzbrt zzbrtVar2 = this.f18949a;
            if (zzbrtVar2 != null) {
                zzbrtVar2.zzi();
            }
        } catch (RemoteException e5) {
            zzbzr.zzl("#007 Could not call remote method.", e5);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zzbrt zzo = zzay.zza().zzo(this);
        this.f18949a = zzo;
        if (zzo != null) {
            try {
                zzo.zzl(bundle);
                return;
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
                finish();
                return;
            }
        }
        zzbzr.zzl("#007 Could not call remote method.", null);
        finish();
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzm();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzo();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzp(i4, strArr, iArr);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzq();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzr();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(@NonNull Bundle bundle) {
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzs(bundle);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzt();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzu();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbrt zzbrtVar = this.f18949a;
            if (zzbrtVar != null) {
                zzbrtVar.zzv();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i4) {
        super.setContentView(i4);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view) {
        super.setContentView(view);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view, @NonNull ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }
}
