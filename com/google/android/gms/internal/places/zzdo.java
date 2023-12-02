package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
final class zzdo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(zzw zzwVar) {
        zzdn zzdnVar = new zzdn(zzwVar);
        StringBuilder sb = new StringBuilder(zzdnVar.size());
        for (int i4 = 0; i4 < zzdnVar.size(); i4++) {
            byte zzi = zzdnVar.zzi(i4);
            if (zzi != 34) {
                if (zzi != 39) {
                    if (zzi != 92) {
                        switch (zzi) {
                            case 7:
                                sb.append("\\a");
                                continue;
                            case 8:
                                sb.append("\\b");
                                continue;
                            case 9:
                                sb.append("\\t");
                                continue;
                            case 10:
                                sb.append("\\n");
                                continue;
                            case 11:
                                sb.append("\\v");
                                continue;
                            case 12:
                                sb.append("\\f");
                                continue;
                            case 13:
                                sb.append("\\r");
                                continue;
                            default:
                                if (zzi >= 32 && zzi <= 126) {
                                    sb.append((char) zzi);
                                    continue;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((zzi >>> 6) & 3) + 48));
                                    sb.append((char) (((zzi >>> 3) & 7) + 48));
                                    sb.append((char) ((zzi & 7) + 48));
                                    break;
                                }
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }
}
