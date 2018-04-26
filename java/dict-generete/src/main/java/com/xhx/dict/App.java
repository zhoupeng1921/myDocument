package com.xhx.dict;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        char[] chars=new char[]{'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g'
                ,'h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y'
                ,'z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'
                ,'S','T','U','V','W','X','Y','Z','.'};
        int len = chars.length;
        File file = new File("d:/dict.txt");
        List<String> lists = new ArrayList<>();
        for(int i1 = 0; i1<len;i1++){
            for(int i2 = 0; i2<len;i2++){
                for(int i3 = 0; i3<len;i3++){
                    for(int i4 = 0; i4<len;i4++){
                        for(int i5 = 0; i5<len;i5++){
                            for(int i6 = 0; i6<len;i6++){
                                for(int i7 = 0; i7<len;i7++){
                                    for(int i8 = 0; i8<len;i8++){
                                        StringBuffer sb = new StringBuffer();
                                        sb.append(chars[i1]);
                                        sb.append(chars[i2]);
                                        sb.append(chars[i3]);
                                        sb.append(chars[i4]);
                                        sb.append(chars[i5]);
                                        sb.append(chars[i6]);
                                        sb.append(chars[i7]);
                                        sb.append(chars[i8]);
                                        sb.append(chars[i8]);
                                        sb.append("\r\n");
                                        lists.add(sb.toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}
