package com.google.firebase.auth.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaed;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzo implements ActionCodeResult {

    /* renamed from: a  reason: collision with root package name */
    private final int f29076a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29077b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29078c;

    /* renamed from: d  reason: collision with root package name */
    private final ActionCodeInfo f29079d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public zzo(zzaed zzaedVar) {
        String zzc;
        char c4;
        if (zzaedVar.zzh()) {
            zzc = zzaedVar.zzd();
        } else {
            zzc = zzaedVar.zzc();
        }
        this.f29077b = zzc;
        this.f29078c = zzaedVar.zzc();
        ActionCodeInfo actionCodeInfo = null;
        if (!zzaedVar.zzi()) {
            this.f29076a = 3;
            this.f29079d = null;
            return;
        }
        String zze = zzaedVar.zze();
        int i4 = 0;
        switch (zze.hashCode()) {
            case -1874510116:
                if (zze.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -1452371317:
                if (zze.equals("PASSWORD_RESET")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -1341836234:
                if (zze.equals("VERIFY_EMAIL")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -1099157829:
                if (zze.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 870738373:
                if (zze.equals("EMAIL_SIGNIN")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 970484929:
                if (zze.equals("RECOVER_EMAIL")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 != 2) {
                    if (c4 != 3) {
                        if (c4 != 4) {
                            if (c4 != 5) {
                                i4 = 3;
                            } else {
                                i4 = 6;
                            }
                        } else {
                            i4 = 2;
                        }
                    } else {
                        i4 = 5;
                    }
                } else {
                    i4 = 4;
                }
            } else {
                i4 = 1;
            }
        }
        this.f29076a = i4;
        if (i4 != 4 && i4 != 3) {
            if (zzaedVar.zzg()) {
                actionCodeInfo = new zzn(zzaedVar.zzc(), zzbc.zza(zzaedVar.zzb()));
            } else if (zzaedVar.zzh()) {
                actionCodeInfo = new zzl(zzaedVar.zzd(), zzaedVar.zzc());
            } else if (zzaedVar.zzf()) {
                actionCodeInfo = new zzm(zzaedVar.zzc());
            }
            this.f29079d = actionCodeInfo;
            return;
        }
        this.f29079d = null;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    @Nullable
    public final String getData(int i4) {
        if (this.f29076a == 4) {
            return null;
        }
        if (i4 != 0) {
            if (i4 != 1) {
                return null;
            }
            return this.f29078c;
        }
        return this.f29077b;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    @Nullable
    public final ActionCodeInfo getInfo() {
        return this.f29079d;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.f29076a;
    }
}
