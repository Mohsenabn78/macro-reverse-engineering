package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class PickFiles extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<List<Uri>> {
    public static final String DEFAULT_MIME_TYPE = "*/*";

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36226a;

    /* renamed from: b  reason: collision with root package name */
    private final Config f36227b;

    /* renamed from: c  reason: collision with root package name */
    private final StartIntent f36228c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Function<Intent, List<Uri>> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public List<Uri> apply(Intent intent) throws Exception {
            if (intent == null) {
                return new ArrayList();
            }
            intent.addFlags(3);
            Uri data = intent.getData();
            if (data == null) {
                return PickFiles.this.d(intent);
            }
            PermissionUtil.grantReadPermissionToUri(PickFiles.this.f36226a, data);
            return Arrays.asList(data);
        }
    }

    public PickFiles(TargetUi targetUi, Config config, StartIntent startIntent) {
        this.f36226a = targetUi;
        this.f36227b = config;
        this.f36228c = startIntent;
    }

    private Intent c() {
        Intent intent = new Intent();
        if (this.f36227b.getMultipleMimeTypes() == null) {
            intent.setType(this.f36227b.getMimeType(getDefaultMimeType()));
        } else {
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", this.f36227b.getMultipleMimeTypes());
        }
        if (this.f36227b.isUseDocumentPicker()) {
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
        } else {
            intent.setAction("android.intent.action.GET_CONTENT");
        }
        if (this.f36227b.isPickOpenableOnly()) {
            intent.addCategory("android.intent.category.OPENABLE");
        }
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Uri> d(Intent intent) {
        ArrayList arrayList = new ArrayList();
        ClipData clipData = intent.getClipData();
        if (clipData != null) {
            for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                Uri uri = clipData.getItemAt(i4).getUri();
                PermissionUtil.grantReadPermissionToUri(this.f36226a, uri);
                arrayList.add(uri);
            }
        }
        return arrayList;
    }

    public String getDefaultMimeType() {
        return "*/*";
    }

    public Observable<List<Uri>> react() {
        return this.f36228c.c(c()).react().map(new a());
    }
}
