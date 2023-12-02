package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaig implements zzaju {
    private final List zza;

    public zzaig(int i4, List list) {
        this.zza = list;
    }

    private final zzajk zzb(zzajt zzajtVar) {
        return new zzajk(zzd(zzajtVar));
    }

    private final zzajy zzc(zzajt zzajtVar) {
        return new zzajy(zzd(zzajtVar));
    }

    private final List zzd(zzajt zzajtVar) {
        boolean z3;
        String str;
        int i4;
        List list;
        zzfa zzfaVar = new zzfa(zzajtVar.zzd);
        List list2 = this.zza;
        while (zzfaVar.zza() > 0) {
            int zzk = zzfaVar.zzk();
            int zzc = zzfaVar.zzc() + zzfaVar.zzk();
            if (zzk == 134) {
                list2 = new ArrayList();
                int zzk2 = zzfaVar.zzk() & 31;
                for (int i5 = 0; i5 < zzk2; i5++) {
                    String zzx = zzfaVar.zzx(3, zzfot.zzc);
                    int zzk3 = zzfaVar.zzk();
                    if ((zzk3 & 128) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        i4 = zzk3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i4 = 1;
                    }
                    byte zzk4 = (byte) zzfaVar.zzk();
                    zzfaVar.zzG(1);
                    if (z3) {
                        int i6 = zzk4 & SignedBytes.MAX_POWER_OF_TWO;
                        int i7 = zzea.zza;
                        list = Collections.singletonList(i6 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzak zzakVar = new zzak();
                    zzakVar.zzS(str);
                    zzakVar.zzK(zzx);
                    zzakVar.zzu(i4);
                    zzakVar.zzI(list);
                    list2.add(zzakVar.zzY());
                }
            }
            zzfaVar.zzF(zzc);
        }
        return list2;
    }

    @Override // com.google.android.gms.internal.ads.zzaju
    @Nullable
    public final zzajw zza(int i4, zzajt zzajtVar) {
        if (i4 != 2) {
            if (i4 != 3 && i4 != 4) {
                if (i4 != 21) {
                    if (i4 != 27) {
                        if (i4 != 36) {
                            if (i4 != 89) {
                                if (i4 != 138) {
                                    if (i4 != 172) {
                                        if (i4 != 257) {
                                            if (i4 != 128) {
                                                if (i4 != 129) {
                                                    if (i4 != 134) {
                                                        if (i4 != 135) {
                                                            switch (i4) {
                                                                case 15:
                                                                    return new zzaja(new zzaif(false, zzajtVar.zzb));
                                                                case 16:
                                                                    return new zzaja(new zzaio(zzc(zzajtVar)));
                                                                case 17:
                                                                    return new zzaja(new zzaiw(zzajtVar.zzb));
                                                                default:
                                                                    return null;
                                                            }
                                                        }
                                                    } else {
                                                        return new zzajj(new zzaiz("application/x-scte35"));
                                                    }
                                                }
                                                return new zzaja(new zzahz(zzajtVar.zzb));
                                            }
                                        } else {
                                            return new zzajj(new zzaiz("application/vnd.dvb.ait"));
                                        }
                                    } else {
                                        return new zzaja(new zzaic(zzajtVar.zzb));
                                    }
                                } else {
                                    return new zzaja(new zzaih(zzajtVar.zzb));
                                }
                            } else {
                                return new zzaja(new zzaii(zzajtVar.zzc));
                            }
                        } else {
                            return new zzaja(new zzaiu(zzb(zzajtVar)));
                        }
                    } else {
                        return new zzaja(new zzais(zzb(zzajtVar), false, false));
                    }
                } else {
                    return new zzaja(new zzaiv());
                }
            } else {
                return new zzaja(new zzaix(zzajtVar.zzb));
            }
        }
        return new zzaja(new zzail(zzc(zzajtVar)));
    }

    public zzaig() {
        this(0);
    }

    public zzaig(int i4) {
        this.zza = zzfsc.zzl();
    }
}
