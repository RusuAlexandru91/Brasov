package com.example.andoid.brasov;


public class contentRound {

    /** Declare all the variables inside the card view **/

    private final int mName;
    private final int mProffesion;
    private final int mReadMore;
    private final int mImage;

    /** Create the Constructor **/
    public contentRound(int name, int proffesion, int readMore, int image){
        mName = name;
        mProffesion = proffesion;
        mReadMore = readMore;
        mImage = image;
    }

    /** Methods **/

    public int getname(){
        return mName;
    }
    public int getproffesion(){
        return mProffesion;
    }
    public int getreadMore(){
        return mReadMore;
    }
    public int getimage(){
        return mImage;
    }
}



