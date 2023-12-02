package com.miguelbcr.ui.rx_paparazzo2.entities;

import android.content.Context;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.ScreenSize;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.Size;
import com.yalantis.ucrop.UCrop;

/* loaded from: classes6.dex */
public class Config {

    /* renamed from: a  reason: collision with root package name */
    private UCrop.Options f36167a;

    /* renamed from: c  reason: collision with root package name */
    private Size f36169c = new ScreenSize();

    /* renamed from: d  reason: collision with root package name */
    private boolean f36170d = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f36172f = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f36176j = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36175i = false;

    /* renamed from: g  reason: collision with root package name */
    private String f36173g = null;

    /* renamed from: h  reason: collision with root package name */
    private String[] f36174h = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f36177k = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f36171e = false;

    /* renamed from: l  reason: collision with root package name */
    private String f36178l = null;

    /* renamed from: m  reason: collision with root package name */
    private String f36179m = null;

    /* renamed from: b  reason: collision with root package name */
    private long f36168b = Long.MAX_VALUE;

    public String getFileProviderAuthority(Context context) {
        String str = this.f36178l;
        if (str != null && str.trim().length() != 0) {
            return this.f36178l;
        }
        return context.getPackageName() + ".file_provider";
    }

    public String getFileProviderDirectory() {
        String str = this.f36179m;
        if (str != null && str.trim().length() != 0) {
            return this.f36179m;
        }
        return "RxPaparazzo";
    }

    public long getMaximumFileSize() {
        return this.f36168b;
    }

    public String getMimeType(String str) {
        String str2 = this.f36173g;
        if (str2 == null) {
            return str;
        }
        return str2;
    }

    public String[] getMultipleMimeTypes() {
        String[] strArr = this.f36174h;
        if (strArr == null) {
            return null;
        }
        return strArr;
    }

    public UCrop.Options getOptions() {
        return this.f36167a;
    }

    public Size getSize() {
        return this.f36169c;
    }

    public boolean isDoCrop() {
        return this.f36170d;
    }

    public boolean isFailCropIfNotImage() {
        return this.f36171e;
    }

    public boolean isPickOpenableOnly() {
        return this.f36175i;
    }

    public boolean isSendToMediaScanner() {
        return this.f36177k;
    }

    public boolean isUseDocumentPicker() {
        return this.f36176j;
    }

    public boolean isUseInternalStorage() {
        return this.f36172f;
    }

    public void setCrop(UCrop.Options options) {
        this.f36167a = options;
        this.f36170d = true;
    }

    public void setFailCropIfNotImage(boolean z3) {
        this.f36171e = z3;
    }

    public void setFileProviderAuthority(String str) {
        this.f36178l = str;
    }

    public void setFileProviderPath(String str) {
        this.f36179m = str;
    }

    public void setMaximumFileSize(long j4) {
        this.f36168b = j4;
    }

    public void setPickMimeType(String str) {
        this.f36173g = str;
    }

    public void setPickMultipleMimeTypes(String... strArr) {
        this.f36174h = strArr;
    }

    public void setPickOpenableOnly(boolean z3) {
        this.f36175i = z3;
    }

    public void setSendToMediaScanner(boolean z3) {
        this.f36177k = z3;
    }

    public void setSize(Size size) {
        this.f36169c = size;
    }

    public void setUseDocumentPicker(boolean z3) {
        this.f36176j = z3;
    }

    public void setUseInternalStorage(boolean z3) {
        this.f36172f = z3;
    }

    public void setCrop() {
        this.f36167a = new UCrop.Options();
        this.f36170d = true;
    }
}
