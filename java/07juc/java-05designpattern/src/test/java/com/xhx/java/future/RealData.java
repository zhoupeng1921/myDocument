package com.xhx.java.future;

public class RealData implements Data {
    protected final String result;

    /**
     * RealData的构造可能很慢，用户不知道要等多久
     * @param data
     */
    public RealData(String data){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<10;i++){
            sb.append(data);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }
    public String getResult(){
        return result;
    }
}
