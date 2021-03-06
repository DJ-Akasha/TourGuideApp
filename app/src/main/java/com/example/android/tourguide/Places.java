package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by elisasimone on 24/04/2018.
 */

public class Places implements Parcelable {

    private String mNameOfPlace;

    private int mDaysOpen;

    private int mInfoBlurb;

    private int mImageResourceId;

    private int mPhysicalAddress;

    public Places(String nameOfPlace, int daysOpen, int infoBlurb, int imageResourceId, int physicalAddress){
        mNameOfPlace = nameOfPlace;
        mDaysOpen = daysOpen;
        mInfoBlurb = infoBlurb;
        mImageResourceId = imageResourceId;
        mPhysicalAddress = physicalAddress;
    }

    // Parcel allows you to move data around the app into different fragments and activities.
    protected Places(Parcel in) {
        this.mNameOfPlace = in.readString();
        this.mDaysOpen = in.readInt();
        this.mInfoBlurb = in.readInt();
        this.mImageResourceId = in.readInt();
        this.mPhysicalAddress = in.readInt();
    }

    // Parceable code found in several tutorials:
    // Author Simon Codrington, August 12, 2016 -
    // https://www.sitepoint.com/transfer-data-between-activities-with-android-parcelable/
    // Author Caren Chang, May 8, 2017 -
    // https://medium.com/@calren24/android-parcelables-made-easy-acb742bcf96b
    // Author Coding in Flow,
    // https://youtu.be/WBbsvqSu0is
    public static final Creator<Places> CREATOR = new Creator<Places>() {
        @Override
        public Places createFromParcel(Parcel source) {
            return new Places(source);
        }

        @Override
        public Places[] newArray(int size) {
            return new Places[size];
        }
    };

    public String getmNameOfPlace() {
        return mNameOfPlace;
    }

    public int getmDaysOpen(){
        return mDaysOpen;
    }

    public int getmInfoBlurb(){
        return mInfoBlurb;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public int getmPhysicalAddress() {
        return mPhysicalAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mNameOfPlace);
        dest.writeInt(this.mDaysOpen);
        dest.writeInt(this.mInfoBlurb);
        dest.writeInt(this.mImageResourceId);
        dest.writeInt(this.mPhysicalAddress);
    }

}
