package com.example.a20133.suntransbms;

import android.os.AsyncTask;
import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by 20133 on 2017/3/16.
 */

class Forcastwebservice1 extends AsyncTask<Object, Object, Void> {


    private TextView resultView11;
    private TextView resultView12;
    private TextView resultView13;
    private TextView resultView14;
    private TextView resultView15;
    private TextView resultView16;
    private TextView resultView17;
    private TextView resultView18;
    private TextView resultView19;
    private TextView resultView10;
    private TextView resultView21;
    private TextView resultView22;
    private TextView resultView23;
    private TextView resultView24;
    private TextView resultView25;
    private TextView resultView26;
    private TextView resultView27;
    private TextView resultView28;
    private TextView resultView29;
    private TextView resultView20;
    private TextView resultView31;
    private TextView resultView32;
    private TextView resultView33;
    private TextView resultView34;
    private TextView resultView35;
    private TextView resultView36;
    private TextView resultView37;
    private TextView resultView38;
    private TextView resultView39;
    private TextView resultView30;
    private TextView resultView41;
    private TextView resultView42;
    private TextView resultView43;
    private TextView resultView44;
    private TextView resultView45;
    private TextView resultView46;
    private TextView resultView47;
    private TextView resultView48;
    private TextView resultView49;
    private TextView resultView40;
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    ArrayList<String> list4 = new ArrayList<>();


    public Forcastwebservice1(TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView10,
                              TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView20,
                              TextView textView31, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, TextView textView30,
                              TextView textView41, TextView textView42, TextView textView43, TextView textView44, TextView textView45, TextView textView46, TextView textView47, TextView textView48, TextView textView49, TextView textView40){
        super();
        this.resultView11 = textView11;
        this.resultView12 = textView12;
        this.resultView13 = textView13;
        this.resultView14 = textView14;
        this.resultView15 = textView15;
        this.resultView16 = textView16;
        this.resultView17 = textView17;
        this.resultView18 = textView18;
        this.resultView19 = textView19;
        this.resultView10 = textView10;
        this.resultView21 = textView21;
        this.resultView22 = textView22;
        this.resultView23 = textView23;
        this.resultView24 = textView24;
        this.resultView25 = textView25;
        this.resultView26 = textView26;
        this.resultView27 = textView27;
        this.resultView28 = textView28;
        this.resultView29 = textView29;
        this.resultView20 = textView20;
        this.resultView31 = textView31;
        this.resultView32 = textView32;
        this.resultView33 = textView33;
        this.resultView34 = textView34;
        this.resultView35 = textView35;
        this.resultView36 = textView36;
        this.resultView37 = textView37;
        this.resultView38 = textView38;
        this.resultView39 = textView39;
        this.resultView30 = textView30;
        this.resultView41 = textView41;
        this.resultView42 = textView42;
        this.resultView43 = textView43;
        this.resultView44 = textView44;
        this.resultView45 = textView45;
        this.resultView46 = textView46;
        this.resultView47 = textView47;
        this.resultView48 = textView48;
        this.resultView49 = textView49;
        this.resultView40 = textView40;


    }

    @Override
    protected Void doInBackground(Object... params) {
        // 查询手机号码（段）信息*/
        try {
           getRemoteInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
    @Override
    //此方法可以在主线程改变UI
    protected void onPostExecute(Void avoid) {
        // 将WebService返回的结果显示在TextView中
        resultView11.setText(list1.get(7)+"V");
        resultView12.setText(list1.get(8)+"mΩ");
        resultView13.setText(list1.get(9)+"A");
        resultView14.setText(list1.get(10)+"%");
        resultView15.setText(list1.get(11)+"%");
        resultView16.setText(list1.get(12)+"AH");
        resultView17.setText(list1.get(1));
        resultView21.setText(list2.get(7)+"V");
        resultView22.setText(list2.get(8)+"mΩ");
        resultView23.setText(list2.get(9)+"A");
        resultView24.setText(list2.get(10)+"%");
        resultView25.setText(list2.get(11)+"%");
        resultView26.setText(list2.get(12)+"AH");
        resultView27.setText(list2.get(1));
        resultView31.setText(list3.get(7)+"V");
        resultView32.setText(list3.get(8)+"mΩ");
        resultView33.setText(list3.get(9)+"A");
        resultView34.setText(list3.get(10)+"%");
        resultView35.setText(list3.get(11)+"%");
        resultView36.setText(list3.get(12)+"AH");
        resultView37.setText(list3.get(1));
        resultView41.setText(list4.get(7)+"V");
        resultView42.setText(list4.get(8)+"mΩ");
        resultView43.setText(list4.get(9)+"A");
        resultView44.setText(list4.get(10)+"%");
        resultView45.setText(list4.get(11)+"%");
        resultView46.setText(list4.get(12)+"AH");
        resultView47.setText(list4.get(1));

        resultView18.setText(list1.get(14)+"Vac");
        resultView19.setText(list1.get(15)+"Aac");
        resultView10.setText(list1.get(16)+"AH");
        resultView28.setText(list2.get(14)+"Vac");
        resultView29.setText(list2.get(15)+"Aac");
        resultView20.setText(list2.get(16)+"AH");
        resultView38.setText(list3.get(14)+"Vac");
        resultView39.setText(list3.get(15)+"Aac");
        resultView30.setText(list3.get(16)+"AH");
        resultView48.setText(list4.get(14)+"Vac");
        resultView49.setText(list4.get(15)+"Aac");
        resultView40.setText(list4.get(16)+"AH");


    }

    public void getRemoteInfo() throws Exception{
        String WSDL_URI = "http://www.suntrans.net:8602/WebService.asmx";//wsdl 的uri
        String namespace = "http://www.suntrans.net/";//namespace
        String methodName = "Inquiry_Sub_R";//要调用的方法名称

        SoapObject request = new SoapObject(namespace, methodName);
        // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
        request.addProperty("BID", 1);
//        request.addProperty("userId", "");

        //创建SoapSerializationEnvelope 对象，同时指定soap版本号(之前在wsdl中看到的)
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapSerializationEnvelope.VER12);
        envelope.bodyOut = request;//由于是发送请求，所以是设置bodyOut
        envelope.dotNet = true;//由于是.net开发的webservice，所以这里要设置为true

        HttpTransportSE httpTransportSE = new HttpTransportSE(WSDL_URI);
        httpTransportSE.call(null, envelope);//调用

        // 获取返回的数据
        SoapObject object = (SoapObject) envelope.bodyIn;
        SoapObject soap1 = (SoapObject)object.getProperty(0);
        SoapObject childs1 = (SoapObject)soap1.getProperty(1);
        SoapObject soap2 = (SoapObject)childs1.getProperty(0);


        for(int i=0;i<soap2.getPropertyCount();i++){
            SoapObject soap3 = (SoapObject)soap2.getProperty(i);
            for(int j=0;j<soap3.getPropertyCount();j++){
                switch (i){
                    case 0:
                        list1.add(j,soap3.getProperty(j).toString());

                        if(j==1){
                            String gettime = list1.get(1).substring(0,16);
                            gettime = gettime.replace("T"," ");
                            list1.set(1,gettime);

                        }
                        break;
                    case 1:
                        list2.add(j,soap3.getProperty(j).toString());
                        if(j==1){
                            String gettime = list2.get(1).substring(0,16);
                            gettime = gettime.replace("T"," ");
                            list2.set(1,gettime);
                        }
                        break;
                    case 2:
                        list3.add(j,soap3.getProperty(j).toString());
                        if(j==1){
                            String gettime = list3.get(1).substring(0,16);
                            gettime = gettime.replace("T"," ");
                            list3.set(1,gettime);
                        }
                        break;
                    case 3:
                        list4.add(j,soap3.getProperty(j).toString());
                        if(j==1){
                            String gettime = list4.get(1).substring(0,16);
                            gettime = gettime.replace("T"," ");
                            list4.set(1,gettime);
                        }
                        break;
                    default:
                        break;
                }

            }

        }
    }
}