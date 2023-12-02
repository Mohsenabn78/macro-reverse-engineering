package com.facebook.stetho.inspector.network;

import com.arlosoft.macrodroid.utils.FileUtils;
import com.facebook.stetho.inspector.protocol.module.Page;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;

/* loaded from: classes3.dex */
public class ResourceTypeHelper {
    private final MimeMatcher<Page.ResourceType> mMimeMatcher;

    public ResourceTypeHelper() {
        MimeMatcher<Page.ResourceType> mimeMatcher = new MimeMatcher<>();
        this.mMimeMatcher = mimeMatcher;
        mimeMatcher.addRule("text/css", Page.ResourceType.STYLESHEET);
        mimeMatcher.addRule(ImageUtils.MIME_TYPE_IMAGE_WILDCARD, Page.ResourceType.IMAGE);
        mimeMatcher.addRule("application/x-javascript", Page.ResourceType.SCRIPT);
        Page.ResourceType resourceType = Page.ResourceType.XHR;
        mimeMatcher.addRule("text/javascript", resourceType);
        mimeMatcher.addRule("application/json", resourceType);
        mimeMatcher.addRule(FileUtils.MIME_TYPE_TEXT, Page.ResourceType.DOCUMENT);
        mimeMatcher.addRule("*", Page.ResourceType.OTHER);
    }

    public Page.ResourceType determineResourceType(String str) {
        return this.mMimeMatcher.match(stripContentExtras(str));
    }

    public String stripContentExtras(String str) {
        int indexOf = str.indexOf(59);
        if (indexOf >= 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }
}
