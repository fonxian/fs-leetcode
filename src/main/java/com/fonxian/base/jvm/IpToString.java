package com.fonxian.base.jvm;

/**
 * @author Michael Fang
 * @since 2020-04-20
 */
public class IpToString {

    public static void main(String[] args) {
        ipstrToint sti=new ipstrToint();
        int ip=0;
        ip=sti.strToint("128.122.22.33");
        if(ip==0)
            System.out.println("无效IP");
        else
            System.out.println(ip);
        intToipstr its=new intToipstr();
        String strip=its.intTostr(ip);
        System.out.println(strip);
    }

}

class ipstrToint{
    public int strToint(String ip){
        String strs[]=ip.split("\\.");//"."这种算是特殊符号需要"\"来转义，"\"自己也要转义，所以这里才有了"\\."
        int ipnum=0;
        for(int i=0;i<strs.length;i++){
            int curnum=Integer.parseInt(strs[i]);
            if(curnum>255||curnum<0)
                return 0;
            ipnum+=curnum;
            if(i<strs.length-1)
                ipnum=ipnum<<8;
        }
        return ipnum;
    }
}
class intToipstr{
    public String intTostr(int ip){
        StringBuffer strip=new StringBuffer();
        for(int i=0;i<4;i++){
            String s=String.valueOf((ip&(255<<(3-i)*8))>>(3-i)*8);
            if(i!=3)
                strip.append(s+".");
            else
                strip.append(s);
        }
        return  strip.toString();
    }
}
