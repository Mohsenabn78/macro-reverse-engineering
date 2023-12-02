package com.google.android.gms.location.places;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.location.places.internal.zzak;
import com.google.android.gms.location.places.internal.zzam;
import java.util.Comparator;

@Deprecated
/* loaded from: classes4.dex */
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<zzak> f21031e = new zzj();

    /* renamed from: a  reason: collision with root package name */
    private final String f21032a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21033b;

    /* renamed from: c  reason: collision with root package name */
    private final Status f21034c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f21035d;

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i4) {
        this(dataHolder, false, i4);
    }

    public static int zzb(Bundle bundle) {
        return bundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlaceLikelihood get(int i4) {
        return new zzam(this.mDataHolder, i4);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.f21032a;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f21034c;
    }

    @ShowFirstParty
    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, getStatus()).add("attributions", this.f21032a).toString();
    }

    private PlaceLikelihoodBuffer(DataHolder dataHolder, boolean z3, int i4) {
        super(dataHolder);
        this.f21034c = PlacesStatusCodes.zzb(dataHolder.getStatusCode());
        switch (i4) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                this.f21033b = i4;
                this.f21035d = false;
                if (dataHolder.getMetadata() != null) {
                    this.f21032a = dataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
                    return;
                } else {
                    this.f21032a = null;
                    return;
                }
            default:
                StringBuilder sb = new StringBuilder(27);
                sb.append("invalid source: ");
                sb.append(i4);
                throw new IllegalArgumentException(sb.toString());
        }
    }
}
