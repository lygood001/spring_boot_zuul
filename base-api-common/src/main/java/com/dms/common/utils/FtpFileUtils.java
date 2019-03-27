package com.dms.common.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Wtx 2019/1/18
 */
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpFileUtils {

    //ftp ip
    public static String FTP_ADDRESS = "10.133.92.245";
    //post
    public static int FTP_PORT = 8082;
    //user
    public static String FTP_USERNAME = "qm_app";
    //pwd
    public static String FTP_PASSWORD = "dms_5906928";
    //pwd
    public static String TOMCAT_POST = "8081";

    public static String FTP_PATH;

    public static String FTP_HOST;


    public static boolean uploadFile(String originFileName, InputStream input, String FTP_BASEPATH) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// connectionftp
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// login
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH);
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    public String getFTP_ADDRESS() {
        return FTP_ADDRESS;
    }

    public void setFTP_ADDRESS(String FTP_ADDRESS) {
        this.FTP_ADDRESS = FTP_ADDRESS;
    }

    public int getFTP_PORT() {
        return FTP_PORT;
    }

    public void setFTP_PORT(int FTP_PORT) {
        this.FTP_PORT = FTP_PORT;
    }

    public String getFTP_USERNAME() {
        return FTP_USERNAME;
    }

    public void setFTP_USERNAME(String FTP_USERNAME) {
        this.FTP_USERNAME = FTP_USERNAME;
    }

    public String getFTP_PASSWORD() {
        return FTP_PASSWORD;
    }

    public void setFTP_PASSWORD(String FTP_PASSWORD) {
        this.FTP_PASSWORD = FTP_PASSWORD;
    }

    public  String getTomcatPost() {
        return TOMCAT_POST;
    }

    public  void setTomcatPost(String tomcatPost) {
        this. TOMCAT_POST = tomcatPost;
    }

    public  String getFtpPath() {
        return FTP_PATH;
    }

    public  void setFtpPath(String ftpPath) {
        this.FTP_PATH = ftpPath;
    }

    public  String getFtpHost() {
        return FTP_HOST;
    }

    public  void setFtpHost(String ftpHost) {
        this.FTP_HOST = ftpHost;
    }
}
