import java.io.*;
import java.lang.*;
public class zuoye {
    static class homework1 {            //创建一个地址
        private String data=null;       //原始输入数据
                String name=null;       //名字
                String phone=null;      //手机号
                String province=null;   //省或直辖市
                String city=null;       //市或直辖市
                String county="";     //县或区或县级市
                String town="";       //街道或镇或乡
                String address=null;       //详细地址
        private void getphone()         //私有类，用于找手机号
        {
            int i,j,k,d=0;
            String s=data;
            String s1=null;
            while (phone==null)
            {
                i=s.indexOf("1");
                d=d+i;
                k=0;
                for (j=i+1;j<11;j++)
                {
                    if (s.charAt(j)<48||s.charAt(j)>57)
                    {
                        k=1;
                        break;
                    }
                }
                if (k==0)
                {
                    phone=s.substring(i,i+11);
                    s=data.substring(0,d);
                    s1=data.substring(d+11);
                    data=s.concat(s1);
                }
                else
                {
                    s=s.substring(i+1);
                    d++;
                }
            }
        }
        private void getname()                  //私有类，用于查找名字
        {
            int i;
            String s=data;
            i=s.indexOf(",");
            name=data.substring(0,i);
            data=s.substring(i+1);
        }
        private void getaddress()
        {
            String s=data;
            int i,j=-1;
            i=data.indexOf("省");
            if (i!=-1)
            {
                province=data.substring(0,i+1);
                data=s.substring(i+1);
                s=data;
            }
            i=data.indexOf("市");
            city=data.substring(0,i+1);
            data=s.substring(i+1);
            s=data;
            if ((i=data.indexOf("县"))!=-1||(i=data.indexOf("区"))!=-1||(i=data.indexOf("市"))!=-1)
            {
                county=data.substring(0,i+1);
                data=s.substring(i+1);
                s=data;
            }
            if ((i=data.indexOf("镇"))!=-1||(i=data.indexOf("乡"))!=-1||(j=data.indexOf("街道"))!=-1)
            {
                if (j!=-1)
                {
                    i=j+1;
                }
                town=data.substring(0,i+1);
                data=s.substring(i+1);
                s=data;
            }
            address=data;
            if (province==null)
            {
                j=city.length();
                province=city.substring(0,j-1);
            }
        }
        public void getdata ()throws IOException      //提供输入方法
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            System.out.println("Please Enter:");
            str = br.readLine();
            data=str;
        }
        public void dealdata()            //提供处理数据方法（这是作业中要求1）
        {
            getphone();
            getname();
            getaddress();
        }
        public void outputdata()         //提供输出的方法
        {
            System.out.println("{“姓名”“"+name+"”“手机”“"+phone+"”“地址”[“"+province+"”“"+city+"”“"+county);
            System.out.println("”“"+town+"”“"+address+"”]}");
        }
    }
    public static void main(String[] args) throws IOException {
        homework1 a=new homework1();
        a.getdata();
        a.dealdata();
        a.outputdata();
    }
}