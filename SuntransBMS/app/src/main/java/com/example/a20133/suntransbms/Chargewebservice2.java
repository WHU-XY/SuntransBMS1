package com.example.a20133.suntransbms;

import android.os.AsyncTask;
import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by 20133 on 2017/3/18.
 */

class Chargewebservice2 extends AsyncTask<Object, Object, Void> {
    private TextView textview11;
    private TextView textview12;
    private TextView textview13;
    private TextView textview14;
    private TextView textview15;
    private TextView textview16;
    private TextView textview17;
    private TextView textview18;
    private TextView resultView28;
    private TextView resultView29;
    private TextView resultView20;

    ArrayList<String> list1 =new ArrayList<>();

    public Chargewebservice2(TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        this.textview11 = textView11;
        this.textview12 = textView12;
        this.textview13 = textView13;
        this.textview14 = textView14;
        this.textview15 = textView15;
        this.textview16 = textView16;
        this.textview17 = textView17;
        this.textview18 = textView18;

    }

    @Override
    protected Void doInBackground(Object... params) {
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
        textview11.setText(list1.get(4)+"Vac");
        textview12.setText(list1.get(5)+"Aac");
        textview13.setText(list1.get(6)+"W");
        textview14.setText(list1.get(7));
        textview15.setText(list1.get(8)+"KWh");
        textview16.setText(list1.get(9)+"Vdc");
        textview17.setText(list1.get(10)+"Adc");
        textview18.setText("维护");

    }
    public void getRemoteInfo() throws Exception{
        String WSDL_URI = "http://www.suntrans.net:8602/WebService.asmx";//wsdl 的uri
        String namespace = "http://www.suntrans.net/";//namespace
        String methodName = "Inquiry_Pack_R";//要调用的方法名称

        SoapObject request = new SoapObject(namespace, methodName);
        // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
        request.addProperty("BID", 2);
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
        SoapObject soap3 = (SoapObject)soap2.getProperty(0);
        for(int j=0;j<soap3.getPropertyCount();j++){
            list1.add(j,soap3.getProperty(j).toString());
        }


    }

}

