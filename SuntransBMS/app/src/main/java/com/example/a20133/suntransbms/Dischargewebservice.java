package com.example.a20133.suntransbms;

import android.os.AsyncTask;
import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by 20133 on 2017/3/17.
 */

class Dischargewebservice extends AsyncTask<Object, Object, Void> {

    private TextView testview11;
    ArrayList<String> list1 = new ArrayList<>();


    public Dischargewebservice(TextView textView11) {
        this.testview11 = textView11;
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
    protected void onPostExecute(Void aVoid) {
        testview11.setText(list1.get(4)+"Vac");

    }

    public void getRemoteInfo() throws Exception{
        String WSDL_URI = "http://www.suntrans.net:8602/WebService.asmx";//wsdl 的uri
        String namespace = "http://www.suntrans.net/";//namespace
        String methodName = "Inquiry_Sub_R";//要调用的方法名称

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
