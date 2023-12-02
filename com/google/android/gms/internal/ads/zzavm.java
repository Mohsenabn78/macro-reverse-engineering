package com.google.android.gms.internal.ads;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzavm {
    private final zzavb zza;
    private final int zzb;
    private String zzc;
    private final int zzd;

    public zzavm(int i4, int i5, int i6) {
        this.zzb = i4;
        i5 = (i5 > 64 || i5 < 0) ? 64 : 64;
        if (i6 <= 0) {
            this.zzd = 1;
        } else {
            this.zzd = i6;
        }
        this.zza = new zzavk(i5);
    }

    public final String zza(ArrayList arrayList, ArrayList arrayList2) {
        String str;
        Collections.sort(arrayList2, new zzavl(this));
        HashSet hashSet = new HashSet();
        loop0: for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            String[] split = Normalizer.normalize((CharSequence) arrayList.get(((zzava) arrayList2.get(i4)).zze()), Normalizer.Form.NFKC).toLowerCase(Locale.US).split("\n");
            if (split.length != 0) {
                for (String str2 : split) {
                    if (str2.contains("'")) {
                        StringBuilder sb = new StringBuilder(str2);
                        int i5 = 1;
                        boolean z3 = false;
                        while (true) {
                            int i6 = i5 + 2;
                            if (i6 > sb.length()) {
                                break;
                            }
                            if (sb.charAt(i5) == '\'') {
                                if (sb.charAt(i5 - 1) != ' ') {
                                    int i7 = i5 + 1;
                                    if ((sb.charAt(i7) == 's' || sb.charAt(i7) == 'S') && (i6 == sb.length() || sb.charAt(i6) == ' ')) {
                                        sb.insert(i5, ' ');
                                        i5 = i6;
                                        z3 = true;
                                    }
                                }
                                sb.setCharAt(i5, ' ');
                                z3 = true;
                            }
                            i5++;
                        }
                        if (z3) {
                            str = sb.toString();
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            this.zzc = str;
                            str2 = str;
                        }
                    }
                    String[] zzb = zzavf.zzb(str2, true);
                    if (zzb.length >= this.zzd) {
                        for (int i8 = 0; i8 < zzb.length; i8++) {
                            String str3 = "";
                            for (int i9 = 0; i9 < this.zzd; i9++) {
                                int i10 = i8 + i9;
                                if (i10 >= zzb.length) {
                                    break;
                                }
                                if (i9 > 0) {
                                    str3 = str3.concat(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                                }
                                str3 = str3.concat(String.valueOf(zzb[i10]));
                            }
                            hashSet.add(str3);
                            if (hashSet.size() >= this.zzb) {
                                break loop0;
                            }
                        }
                        if (hashSet.size() >= this.zzb) {
                            break loop0;
                        }
                    }
                }
                continue;
            }
        }
        zzavd zzavdVar = new zzavd();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                zzavdVar.zzb.write(this.zza.zzb((String) it.next()));
            } catch (IOException e4) {
                zzbzr.zzh("Error while writing hash to byteStream", e4);
            }
        }
        return zzavdVar.toString();
    }
}
