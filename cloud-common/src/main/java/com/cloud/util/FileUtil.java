package com.cloud.util;

import com.cloud.enums.CharseNameEnum;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.util
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/24 10:20
 * @UpdateDate: 2018/4/24 10:20
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class FileUtil {

    /**
     * 获取文件内容
     * @param path
     * @return
     */
    public static String getFileContent(String path){
        ClassPathResource classPathResource=new ClassPathResource(path);
        InputStream inputStream=null;
        BufferedReader bufferedReader=null;
        String b ;
        StringBuffer stringBuffer=new StringBuffer();
        try {
            inputStream= classPathResource.getInputStream();
            bufferedReader=  new BufferedReader(new InputStreamReader(inputStream,CharseNameEnum.UTF_8.getCharName()));
            while ((b=bufferedReader.readLine())!=null){
                stringBuffer.append(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString().trim();
    }
}
