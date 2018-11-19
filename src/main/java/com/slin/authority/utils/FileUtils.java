package com.slin.authority.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yangsonglin
 * @create 2018-07-16 16:55
 **/
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
    /**
     * 读取过程暂停，给当前做一个标记，下一次从标记位置开始读取
     * @param fileName
     */
    public static String readFile(String fileName) {
        // TODO Auto-generated method stub
        //创建BufferedReader
//        try {
//            BufferedReader bfr=Files.newBufferedReader(fileName);
//            System.out.println(bfr.readLine());
//            bfr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //读取过程中暂停
        //给当前做一个标记
        //下一次从标记位置开始读取
        String str ="";

        try {
            BufferedInputStream bis= new BufferedInputStream(new FileInputStream(fileName));
            byte[] b = new byte[bis.available()];
            bis.read(b);

			/*char[] c = new char[b.length];
			for (int i = 0; i < c.length; i++) {
				c[i]=(char) b[i];
			}
			System.out.println(Arrays.toString(c));//乱码
			 */

//            System.out.println(Arrays.toString(b));//得到的是字节
            //String(byte[])把字节数组转成字符串
            str = new String(b);
            str = str .replaceAll("\\s*", "");

            bis.close();//关闭流(关闭bis就可以了)
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public static void writeFile(String path,String filename,String str){
        Path fpath=Paths.get(path);
        Path file = Paths.get(filename);
        Path inputFile = fpath.resolve(file);
        //创建文件
        if(!Files.exists(fpath)) {
            try {
                Files.createDirectories(fpath);
                Files.createFile(inputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //创建BufferedWriter
        try {
            BufferedWriter bfw=Files.newBufferedWriter(inputFile);
            bfw.write(str);
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
