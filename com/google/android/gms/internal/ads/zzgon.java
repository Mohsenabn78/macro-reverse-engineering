package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgon implements zzgrh {
    private final zzgom zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgon(zzgom zzgomVar) {
        byte[] bArr = zzgpw.zzd;
        this.zza = zzgomVar;
        zzgomVar.zzc = this;
    }

    private final void zzP(Object obj, zzgrp zzgrpVar, zzgoy zzgoyVar) throws IOException {
        int i4 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzgrpVar.zzh(obj, this, zzgoyVar);
            if (this.zzb == this.zzc) {
                return;
            }
            throw zzgpy.zzg();
        } finally {
            this.zzc = i4;
        }
    }

    private final void zzQ(Object obj, zzgrp zzgrpVar, zzgoy zzgoyVar) throws IOException {
        zzgom zzgomVar;
        int zzn = this.zza.zzn();
        zzgom zzgomVar2 = this.zza;
        if (zzgomVar2.zza < zzgomVar2.zzb) {
            int zze = zzgomVar2.zze(zzn);
            this.zza.zza++;
            zzgrpVar.zzh(obj, this, zzgoyVar);
            this.zza.zzz(0);
            zzgomVar.zza--;
            this.zza.zzA(zze);
            return;
        }
        throw new zzgpy("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i4) throws IOException {
        if (this.zza.zzd() == i4) {
            return;
        }
        throw zzgpy.zzj();
    }

    private final void zzS(int i4) throws IOException {
        if ((this.zzb & 7) == i4) {
            return;
        }
        throw zzgpy.zza();
    }

    private static final void zzT(int i4) throws IOException {
        if ((i4 & 3) == 0) {
            return;
        }
        throw zzgpy.zzg();
    }

    private static final void zzU(int i4) throws IOException {
        if ((i4 & 7) == 0) {
            return;
        }
        throw zzgpy.zzg();
    }

    public static zzgon zzq(zzgom zzgomVar) {
        zzgon zzgonVar = zzgomVar.zzc;
        if (zzgonVar != null) {
            return zzgonVar;
        }
        return new zzgon(zzgomVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzA(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzgqlVar.zzg(this.zza.zzo());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgqlVar.zzg(this.zza.zzo());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzB(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpf) {
            zzgpf zzgpfVar = (zzgpf) list;
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 == 5) {
                    do {
                        zzgpfVar.zze(this.zza.zzc());
                        if (this.zza.zzC()) {
                            return;
                        }
                        zzm2 = this.zza.zzm();
                    } while (zzm2 == this.zzb);
                    this.zzd = zzm2;
                    return;
                }
                throw zzgpy.zza();
            }
            int zzn = this.zza.zzn();
            zzT(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                zzgpfVar.zze(this.zza.zzc());
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
            throw zzgpy.zza();
        }
        int zzn2 = this.zza.zzn();
        zzT(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            list.add(Float.valueOf(this.zza.zzc()));
        } while (this.zza.zzd() < zzd2);
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    @Deprecated
    public final void zzC(List list, zzgrp zzgrpVar, zzgoy zzgoyVar) throws IOException {
        int zzm;
        int i4 = this.zzb;
        if ((i4 & 7) == 3) {
            do {
                Object zze = zzgrpVar.zze();
                zzP(zze, zzgrpVar, zzgoyVar);
                zzgrpVar.zzf(zze);
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
        throw zzgpy.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzD(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgpnVar.zzh(this.zza.zzh());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgpnVar.zzh(this.zza.zzh());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzE(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgqlVar.zzg(this.zza.zzp());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgqlVar.zzg(this.zza.zzp());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzF(List list, zzgrp zzgrpVar, zzgoy zzgoyVar) throws IOException {
        int zzm;
        int i4 = this.zzb;
        if ((i4 & 7) == 2) {
            do {
                Object zze = zzgrpVar.zze();
                zzQ(zze, zzgrpVar, zzgoyVar);
                zzgrpVar.zzf(zze);
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
        throw zzgpy.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzG(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 == 5) {
                    do {
                        zzgpnVar.zzh(this.zza.zzk());
                        if (this.zza.zzC()) {
                            return;
                        }
                        zzm2 = this.zza.zzm();
                    } while (zzm2 == this.zzb);
                    this.zzd = zzm2;
                    return;
                }
                throw zzgpy.zza();
            }
            int zzn = this.zza.zzn();
            zzT(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                zzgpnVar.zzh(this.zza.zzk());
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
            throw zzgpy.zza();
        }
        int zzn2 = this.zza.zzn();
        zzT(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            list.add(Integer.valueOf(this.zza.zzk()));
        } while (this.zza.zzd() < zzd2);
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzH(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzgqlVar.zzg(this.zza.zzt());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgqlVar.zzg(this.zza.zzt());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzI(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgpnVar.zzh(this.zza.zzl());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgpnVar.zzh(this.zza.zzl());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzJ(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgqlVar.zzg(this.zza.zzu());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgqlVar.zzg(this.zza.zzu());
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
            throw zzgpy.zza();
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
            if ((list instanceof zzgqe) && !z3) {
                zzgqe zzgqeVar = (zzgqe) list;
                do {
                    zzgqeVar.zzi(zzp());
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
        throw zzgpy.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzL(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgpnVar.zzh(this.zza.zzn());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgpnVar.zzh(this.zza.zzn());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzM(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgql) {
            zzgql zzgqlVar = (zzgql) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgqlVar.zzg(this.zza.zzv());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgqlVar.zzg(this.zza.zzv());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final boolean zzO() throws IOException {
        int i4;
        if (!this.zza.zzC() && (i4 = this.zzb) != this.zzc) {
            return this.zza.zzE(i4);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final zzgoe zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzt(Object obj, zzgrp zzgrpVar, zzgoy zzgoyVar) throws IOException {
        zzS(3);
        zzP(obj, zzgrpVar, zzgoyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzu(Object obj, zzgrp zzgrpVar, zzgoy zzgoyVar) throws IOException {
        zzS(2);
        zzQ(obj, zzgrpVar, zzgoyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzv(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgns) {
            zzgns zzgnsVar = (zzgns) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgnsVar.zze(this.zza.zzD());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgnsVar.zze(this.zza.zzD());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
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
        throw zzgpy.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzx(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgov) {
            zzgov zzgovVar = (zzgov) list;
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = this.zza.zzd() + zzn;
                    do {
                        zzgovVar.zze(this.zza.zzb());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgovVar.zze(this.zza.zzb());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzy(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    int zzd = this.zza.zzd() + this.zza.zzn();
                    do {
                        zzgpnVar.zzh(this.zza.zzf());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw zzgpy.zza();
            }
            do {
                zzgpnVar.zzh(this.zza.zzf());
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
            throw zzgpy.zza();
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

    @Override // com.google.android.gms.internal.ads.zzgrh
    public final void zzz(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgpn) {
            zzgpn zzgpnVar = (zzgpn) list;
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 == 5) {
                    do {
                        zzgpnVar.zzh(this.zza.zzg());
                        if (this.zza.zzC()) {
                            return;
                        }
                        zzm2 = this.zza.zzm();
                    } while (zzm2 == this.zzb);
                    this.zzd = zzm2;
                    return;
                }
                throw zzgpy.zza();
            }
            int zzn = this.zza.zzn();
            zzT(zzn);
            int zzd = this.zza.zzd() + zzn;
            do {
                zzgpnVar.zzh(this.zza.zzg());
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
            throw zzgpy.zza();
        }
        int zzn2 = this.zza.zzn();
        zzT(zzn2);
        int zzd2 = this.zza.zzd() + zzn2;
        do {
            list.add(Integer.valueOf(this.zza.zzg()));
        } while (this.zza.zzd() < zzd2);
    }
}
