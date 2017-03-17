package com.example.a20133.suntranstest8;

import android.os.AsyncTask;

import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by 20133 on 2017/3/16.
 */

class QueryAddressTask extends AsyncTask<Object, Object, Void> {


    private TextView resultView1;
    private TextView resultView2;
    private TextView resultView3;
    private TextView resultView4;
    private TextView resultView5;
    private TextView resultView6;
    private TextView resultView7;
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    ArrayList<String> list4 = new ArrayList<>();


    public QueryAddressTask(TextView textView1,TextView textView2,TextView textView3,TextView textView4,TextView textView5,TextView textView6,TextView textView7
                            ){
        super();
        this.resultView1 = textView1;
        this.resultView2 = textView2;
        this.resultView3 = textView3;
        this.resultView4 = textView4;
        this.resultView5 = textView5;
        this.resultView6 = textView6;
        this.resultView7 = textView7;


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
        resultView1.setText(list1.get(7)+"V");
        resultView2.setText(list1.get(8)+"mΩ");
        resultView3.setText(list1.get(9)+"A");
        resultView4.setText(list1.get(10)+"%");
        resultView5.setText(list1.get(11)+"%");
        resultView6.setText(list1.get(12)+"AH");
        resultView7.setText(list1.get(1));

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
                            list1.set(1,gettime);
                        }
                        break;
                    case 2:
                        list3.add(j,soap3.getProperty(j).toString());
                        if(j==1){
                            String gettime = list2.get(1).substring(0,16);
                            gettime = gettime.replace("T"," ");
                            list1.set(1,gettime);
                        }
                        break;
                    case 3:
                        list4.add(j,soap3.getProperty(j).toString());
                        if(j==1){
                            String gettime = list2.get(1).substring(0,16);
                            gettime = gettime.replace("T"," ");
                            list1.set(1,gettime);
                        }
                        break;
                    default:
                        break;
                }

            }

        }
    }
}