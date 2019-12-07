package first.Alipay;
import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "20161017." +
            "00705850";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDlD84gQ0ygo2VPjbfomHiYj4jy1JInZKTa+qcRwiIYJdd7G7vSe0CRZ9jDfuBzESlcEiyOHiqThIQWyg+FtFS0Cbt9UDb3o5V4pS6pC3PasNu6TivSSd4O2t2HYqgvm1Z0XVnOucKnGbISgEU2J+jWvj9sv6QQHFIc/Sbo7ZNbq/uIP2iBppR0dBkiCeDGb8IBWiQXjH0IOWqlwpx6gHFtGYozTKMFx67ztp7Ufhv/GsGChNvrbRyikwIW53O0aU83dXCti/VpaxTinjFaCbuUmiNYvbuv3mdlNBUnbxEXMTY7SMImbVrW7t2bDPsSbpbh74KPLmG3LfLAksMIk3yZAgMBAAECggEBAJLc3lj7LU81VAh8obSExZVzOegPeKG/Op+X47RUFw4KfSzWbEcYdR6FSYqWd4vvLeh1UpHQL5YjeZku9mLQaxp/vvEqlAOUo4oVxmPmDuLhUBAUfK44ZCJ8G1rpW1Iis3yqOaF8opwGspCAI2AEmJnOotWzzZnyvocNnHvtjvRPiou6DCEAalXDuhnpVQGqTam2dUC3axCXUeBf3/3jlK7BqLF87hqYQI8fpZMSc7yFAA4xTKKt10IashYeUuQNHoF8xTJ36zgwkj1fMzoJPoe8PaCvyhDN/8jk90gUkrDAj1kut47Jx3UmjIc7C9Ahex9i3Ul8+sXGB7oEQ92S4nECgYEA/IWaHSTFPrqxXsljub6zPxvq1xNcMtDqXl1XoXSVpdTMeogBdKn6uw/Yh0XpKRLy10GI8oVQKaDscsjEQT5rOk5uUKE0v3N99MPlFoZX+2pvEynFYMS1u0L90KwdsXMzeTSN791+g33J4frKyLYSLsa4U/H580stzg16tS0+920CgYEA6Dd7bw7xHlHKxVO/f2hkRypaKP8dl+nVnaneYENpRAEzBOo8xlziBQH4IIVNhZZEBbMFXLk9+hrCDdKlfzlRQkoaj+ebvzxc2+WRGp/bTER+xx3lfozGFIwYQT8O2ecMsd9dqCJPiJKmv6coab8YDCc+AGaEXoQSun0zLbcfwl0CgYEAnCfGMMV/UBZE/veMut1JnPoXlB69whLdC7OvMAGXVPAt7ovSUqGWkjzvSl+aGrNEBobZOBfmhYelECpE6o+94VWE9ElsBARYXJcTQIWdPLUJsREApKGgPAfmSzdUOVqi9w3fw/f1dzy/LgZXhhzJS7HJZOfbCG9yCNzfB9DOAlUCgYEA1AJjpV+k8COI12PAwFfUxcx7CFby89E/gHSoXIbvQnE93UzmM8x1ZlEH8tkBj+dDL1jkmmVdmkx3wxsAkgkIkVcKrTutzIkV1oXfVsl/9D/M54n6DvIDnprRQjCKJJN32aWu4mSA7JXHu86nbPRUxjPFvaPbUleOqcjIwwIf8tkCgYBHuq1Mv/5kxGHbBS0ggAvLXad2xxA5/TXyJzsMxDq8AgdzJKz+Ou7DiEda5BhGsScRv8WYkmeZ++y3qg+wmmVJ8u9V6B8q6NPBQdexesRoieTMTpW9bPKOR51pk5BL+WbhfOxEs57S8/4dBIii8rRfIkBSeXdwSvC/Vwt29twXyA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5Q/OIENMoKNlT4236Jh4mI+I8tSSJ2Sk2vqnEcIiGCXXexu70ntAkWfYw37gcxEpXBIsjh4qk4SEFsoPhbRUtAm7fVA296OVeKUuqQtz2rDbuk4r0kneDtrdh2KoL5tWdF1ZzrnCpxmyEoBFNifo1r4/bL+kEBxSHP0m6O2TW6v7iD9ogaaUdHQZIgngxm/CAVokF4x9CDlqpcKceoBxbRmKM0yjBceu87ae1H4b/xrBgoTb620copMCFudztGlPN3VwrYv1aWsU4p4xWgm7lJojWL27r95nZTQVJ28RFzE2O0jCJm1a1u7dmwz7Em6W4e+Cjy5hty3ywJLDCJN8mQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}