package com.facebook.stetho.inspector.database;

import android.net.Uri;

/* loaded from: classes3.dex */
public class ContentProviderSchema {
    private final String[] mProjection;
    private final String mTableName;
    private final Uri mUri;

    /* loaded from: classes3.dex */
    public static class Builder {
        private Table mTable;

        public ContentProviderSchema build() {
            return new ContentProviderSchema(this);
        }

        public Builder table(Table table) {
            this.mTable = table;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Table {
        private String[] mProjection;
        private String mTableName;
        private Uri mUri;

        /* loaded from: classes3.dex */
        public static class Builder {
            private String[] mProjection;
            private String mTableName;
            private Uri mUri;

            public Table build() {
                return new Table(this);
            }

            public Builder name(String str) {
                this.mTableName = str;
                return this;
            }

            public Builder projection(String[] strArr) {
                this.mProjection = strArr;
                return this;
            }

            public Builder uri(Uri uri) {
                this.mUri = uri;
                return this;
            }
        }

        private Table(Builder builder) {
            this.mUri = builder.mUri;
            this.mProjection = builder.mProjection;
            String str = builder.mTableName;
            this.mTableName = str;
            if (str == null) {
                this.mTableName = this.mUri.getLastPathSegment();
            }
        }
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getTableName() {
        return this.mTableName;
    }

    public Uri getUri() {
        return this.mUri;
    }

    private ContentProviderSchema(Builder builder) {
        this.mTableName = builder.mTable.mTableName;
        this.mUri = builder.mTable.mUri;
        this.mProjection = builder.mTable.mProjection;
    }
}
