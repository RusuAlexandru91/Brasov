package com.example.andoid.brasov;


public class contentSquare {

    /** Declare all the variables inside the card view **/
    private final int mName;
    private final int mAdress;
    private final int mImageMain;
    private int mImageStars;

    /** Variales for finding out if it has immage or not **/
    private int getImageStars = NO_IMMAGE_PROVIDED;
    private static  int NO_IMMAGE_PROVIDED = -1;

    /*** Create the Constructor **/
    public contentSquare(int name, int adress, int imageMain, int imageStars) {
        mName = name;
        mAdress = adress;
        mImageMain = imageMain;
        mImageStars = imageStars;
    }

    /** Create a secound constructor for places to display only one immage **/
    public contentSquare(int name, int adress, int imageMain){
        mName = name;
        mAdress = adress;
        mImageMain = imageMain;
    }
    /** If has immage or not . Strictly for places */
    public boolean hasImage(){
        return mImageStars != NO_IMMAGE_PROVIDED;

    }
    /** Methods **/
    public int getname(){
        return mName;
    }
    public int getadress(){
        return mAdress;
    }
    public int getImageMain(){
        return mImageMain;
    }
    public int getimageStars(){
        return mImageStars;
    }
}






