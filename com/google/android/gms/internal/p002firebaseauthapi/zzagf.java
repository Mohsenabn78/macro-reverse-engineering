package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagf  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzagf implements zzait {
    private final zzage zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzagf(zzage zzageVar) {
        byte[] bArr = zzahj.zzd;
        this.zza = zzageVar;
        zzageVar.zzc = this;
    }

    private final void zzP(Object obj, zzaiu zzaiuVar, zzagq zzagqVar) throws IOException {
        int i4 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzaiuVar.zzh(obj, this, zzagqVar);
            if (this.zzb == this.zzc) {
                return;
            }
            throw zzahl.zzg();
        } finally {
            this.zzc = i4;
        }
    }

    private final void zzQ(Object obj, zzaiu zzaiuVar, zzagq zzagqVar) throws IOException {
        zzage zzageVar;
        int zzn = this.zza.zzn();
        zzage zzageVar2 = this.zza;
        if (zzageVar2.zza < zzageVar2.zzb) {
            int zze = zzageVar2.zze(zzn);
            this.zza.zza++;
            zzaiuVar.zzh(obj, this, zzagqVar);
            this.zza.zzz(0);
            zzageVar.zza--;
            this.zza.zzA(zze);
            return;
        }
        throw new zzahl("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i4) throws IOException {
        if (this.zza.zzd() == i4) {
            return;
        }
        throw zzahl.zzj();
    }

    private final void zzS(int i4) throws IOException {
        if ((this.zzb & 7) == i4) {
            return;
        }
        throw zzahl.zza();
    }

    private static final void zzT(int i4) throws IOException {
        if ((i4 & 3) == 0) {
            return;
        }
        throw zzahl.zzg();
    }

    private static final void zzU(int i4) throws IOException {
        if ((i4 & 7) == 0) {
            return;
        }
        throw zzahl.zzg();
    }

    public static zzagf zzq(zzage zzageVar) {
        zzagf zzagfVar = zzageVar.zzc;
        if (zzagfVar != null) {
            return zzagfVar;
        }
        return new zzagf(zzageVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzA(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzahxVar.zzf(this.zza.zzo());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzahxVar.zzf(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 1) {
            if (i5 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzo()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzB(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagx) {
            zzagx zzagxVar = (zzagx) list;
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 == 5) {
                    do {
                        zzagxVar.zze(this.zza.zzc());
                        if (this.zza.zzC()) {
                            return;
                        }
                        zzm2 = this.zza.zzm();
                    } while (zzm2 == this.zzb);
                    this.zzd = zzm2;
                    return;
                }
                throw zzahl.zza();
            }
            int zzn = this.zza.zzn();
            zzT(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                zzagxVar.zze(this.zza.zzc());
            } while (this.zza.zzd() < zzd);
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 2) {
            if (i5 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm = this.zza.zzm();
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            throw zzahl.zza();
        }
        int zzn2 = this.zza.zzn();
        zzT(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            list.add(Float.valueOf(this.zza.zzc()));
        } while (this.zza.zzd() < zzd2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    @Deprecated
    public final void zzC(List list, zzaiu zzaiuVar, zzagq zzagqVar) throws IOException {
        int zzm;
        int i4 = this.zzb;
        if ((i4 & 7) == 3) {
            do {
                Object zze = zzaiuVar.zze();
                zzP(zze, zzaiuVar, zzagqVar);
                zzaiuVar.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i4);
            this.zzd = zzm;
            return;
        }
        throw zzahl.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzD(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzaheVar.zzf(this.zza.zzh());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzaheVar.zzf(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzh()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzE(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzahxVar.zzf(this.zza.zzp());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzahxVar.zzf(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzp()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzF(List list, zzaiu zzaiuVar, zzagq zzagqVar) throws IOException {
        int zzm;
        int i4 = this.zzb;
        if ((i4 & 7) == 2) {
            do {
                Object zze = zzaiuVar.zze();
                zzQ(zze, zzaiuVar, zzagqVar);
                zzaiuVar.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i4);
            this.zzd = zzm;
            return;
        }
        throw zzahl.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzG(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 == 5) {
                    do {
                        zzaheVar.zzf(this.zza.zzk());
                        if (this.zza.zzC()) {
                            return;
                        }
                        zzm2 = this.zza.zzm();
                    } while (zzm2 == this.zzb);
                    this.zzd = zzm2;
                    return;
                }
                throw zzahl.zza();
            }
            int zzn = this.zza.zzn();
            zzT(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                zzaheVar.zzf(this.zza.zzk());
            } while (this.zza.zzd() < zzd);
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 2) {
            if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm = this.zza.zzm();
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            throw zzahl.zza();
        }
        int zzn2 = this.zza.zzn();
        zzT(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            list.add(Integer.valueOf(this.zza.zzk()));
        } while (this.zza.zzd() < zzd2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzH(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzahxVar.zzf(this.zza.zzt());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzahxVar.zzf(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 1) {
            if (i5 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzt()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzI(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzaheVar.zzf(this.zza.zzl());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzaheVar.zzf(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzl()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzJ(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzahxVar.zzf(this.zza.zzu());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzahxVar.zzf(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzu()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    public final void zzK(List list, boolean z3) throws IOException {
        String zzr;
        int zzm;
        int zzm2;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzahq) && !z3) {
                zzahq zzahqVar = (zzahq) list;
                do {
                    zzahqVar.zzi(zzp());
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm2 = this.zza.zzm();
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
                return;
            }
            do {
                if (z3) {
                    zzr = zzs();
                } else {
                    zzr = zzr();
                }
                list.add(zzr);
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw zzahl.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzL(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzaheVar.zzf(this.zza.zzn());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzaheVar.zzf(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzn()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzM(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahx) {
            zzahx zzahxVar = (zzahx) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzahxVar.zzf(this.zza.zzv());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzahxVar.zzf(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzv()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final boolean zzO() throws IOException {
        int i4;
        if (!this.zza.zzC() && (i4 = this.zzb) != this.zzc) {
            return this.zza.zzE(i4);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zzc() throws IOException {
        int i4 = this.zzd;
        if (i4 != 0) {
            this.zzb = i4;
            this.zzd = 0;
        } else {
            i4 = this.zza.zzm();
            this.zzb = i4;
        }
        if (i4 != 0 && i4 != this.zzc) {
            return i4 >>> 3;
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final zzafy zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzt(Object obj, zzaiu zzaiuVar, zzagq zzagqVar) throws IOException {
        zzS(3);
        zzP(obj, zzaiuVar, zzagqVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzu(Object obj, zzaiu zzaiuVar, zzagq zzagqVar) throws IOException {
        zzS(2);
        zzQ(obj, zzaiuVar, zzagqVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzv(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzafn) {
            zzafn zzafnVar = (zzafn) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzafnVar.zze(this.zza.zzD());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzafnVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Boolean.valueOf(this.zza.zzD()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw zzahl.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzx(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagn) {
            zzagn zzagnVar = (zzagn) list;
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzagnVar.zze(this.zza.zzb());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzagnVar.zze(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 1) {
            if (i5 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Double.valueOf(this.zza.zzb()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzy(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzaheVar.zzf(this.zza.zzf());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzahl.zza();
            }
            do {
                zzaheVar.zzf(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                }
                zzm2 = this.zza.zzm();
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            throw zzahl.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzf()));
            if (this.zza.zzC()) {
                return;
            }
            zzm = this.zza.zzm();
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzait
    public final void zzz(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahe) {
            zzahe zzaheVar = (zzahe) list;
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 == 5) {
                    do {
                        zzaheVar.zzf(this.zza.zzg());
                        if (this.zza.zzC()) {
                            return;
                        }
                        zzm2 = this.zza.zzm();
                    } while (zzm2 == this.zzb);
                    this.zzd = zzm2;
                    return;
                }
                throw zzahl.zza();
            }
            int zzn = this.zza.zzn();
            zzT(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                zzaheVar.zzf(this.zza.zzg());
            } while (this.zza.zzd() < zzd);
            return;
        }
        int i5 = this.zzb & 7;
        if (i5 != 2) {
            if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm = this.zza.zzm();
                } while (zzm == this.zzb);
                this.zzd = zzm;
                return;
            }
            throw zzahl.zza();
        }
        int zzn2 = this.zza.zzn();
        zzT(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            list.add(Integer.valueOf(this.zza.zzg()));
        } while (this.zza.zzd() < zzd2);
    }
}
