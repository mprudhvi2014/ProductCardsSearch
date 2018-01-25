package com.productcards.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;


public class ProductCardListResults implements Parcelable {

    @Nullable
    private String title;

    public static final Creator<ProductCardListResults> CREATOR = new Creator<ProductCardListResults>() {
        @Override
        public ProductCardListResults createFromParcel(Parcel in) {
            return new ProductCardListResults(in);
        }

        @Override
        public ProductCardListResults[] newArray(int size) {
            return new ProductCardListResults[size];
        }
    };

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(@Nullable String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Nullable
    public Content[] getContent() {
        return content;
    }

    public void setContent(@Nullable Content[] content) {
        this.content = content;
    }

    @Nullable
    public String getPromoMessage() {
        return promoMessage;
    }

    public void setPromoMessage(@Nullable String promoMessage) {
        this.promoMessage = promoMessage;
    }

    @Nullable
    public String getTopDescription() {
        return topDescription;
    }

    public void setTopDescription(@Nullable String topDescription) {
        this.topDescription = topDescription;
    }

    @Nullable
    public String getBottomDescription() {
        return bottomDescription;
    }

    public void setBottomDescription(@Nullable String bottomDescription) {
        this.bottomDescription = bottomDescription;
    }

    @Nullable
    private String backgroundImage;
    @Nullable
    private Content content[];
    @Nullable
    private String promoMessage;
    @Nullable
    private String topDescription;
    @Nullable
    private String bottomDescription;


    protected ProductCardListResults(Parcel in) {
        title = in.readString();
        backgroundImage = in.readString();
        promoMessage = in.readString();
        topDescription = in.readString();
        bottomDescription = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(backgroundImage);
        dest.writeString(promoMessage);
        dest.writeString(topDescription);
        dest.writeString(bottomDescription);
    }

    @Override
    public int describeContents() {
        return 0;
    }



}
