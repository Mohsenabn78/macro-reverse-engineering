package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import rx_activity_result2.OnPreResult;

/* loaded from: classes6.dex */
public class PickFile extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<Uri> {
    public static final String DEFAULT_MIME_TYPE = "*/*";

    /* renamed from: a  reason: collision with root package name */
    private final Config f36221a;

    /* renamed from: b  reason: collision with root package name */
    private final StartIntent f36222b;

    /* renamed from: c  reason: collision with root package name */
    private final TargetUi f36223c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Function<Intent, Uri> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Uri apply(Intent intent) throws Exception {
            return intent.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements OnPreResult {
        b() {
        }

        @Override // rx_activity_result2.OnPreResult
        public Observable<Uri> response(int i4, int i5, @Nullable Intent intent) {
            if (i5 == -1 && intent != null && intent.getData() != null) {
                PermissionUtil.grantReadPermissionToUri(PickFile.this.f36223c, intent.getData());
                return Observable.just(intent.getData());
            }
            return Observable.empty();
        }
    }

    public PickFile(TargetUi targetUi, Config config, StartIntent startIntent) {
        this.f36223c = targetUi;
        this.f36221a = config;
        this.f36222b = startIntent;
    }

    private Intent b() {
        Intent intent = new Intent();
        if (this.f36221a.getMultipleMimeTypes() == null) {
            intent.setType(this.f36221a.getMimeType(getDefaultMimeType()));
        } else {
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", this.f36221a.getMultipleMimeTypes());
        }
        if (this.f36221a.isUseDocumentPicker()) {
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
        } else {
            intent.setAction("android.intent.action.GET_CONTENT");
        }
        if (this.f36221a.isPickOpenableOnly()) {
            intent.addCategory("android.intent.category.OPENABLE");
        }
        return intent;
    }

    private OnPreResult c() {
        return new b();
    }

    public String getDefaultMimeType() {
        return "*/*";
    }

    public Observable<Uri> react() {
        return this.f36222b.d(b(), c()).react().map(new a());
    }
}
