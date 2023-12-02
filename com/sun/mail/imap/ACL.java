package com.sun.mail.imap;

/* loaded from: classes6.dex */
public class ACL implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f37631a;

    /* renamed from: b  reason: collision with root package name */
    private Rights f37632b;

    public ACL(String str) {
        this.f37631a = str;
        this.f37632b = new Rights();
    }

    public Object clone() throws CloneNotSupportedException {
        ACL acl = (ACL) super.clone();
        acl.f37632b = (Rights) this.f37632b.clone();
        return acl;
    }

    public String getName() {
        return this.f37631a;
    }

    public Rights getRights() {
        return this.f37632b;
    }

    public void setRights(Rights rights) {
        this.f37632b = rights;
    }

    public ACL(String str, Rights rights) {
        this.f37631a = str;
        this.f37632b = rights;
    }
}
