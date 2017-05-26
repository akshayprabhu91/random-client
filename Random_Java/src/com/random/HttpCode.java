package com.random;

import java.util.ArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpCode {
	public ArrayList<Integer> temp;
	public ArrayList<String> tmpString;
	public String [] tmpArrayString;
	public String url;
	
	public ArrayList<String> httpGetRequest(String url) throws Exception{
		tmpString = new ArrayList();
		
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 200);
		HttpConnectionParams.setSoTimeout(httpParams, 200);
		HttpClient httpclient = new DefaultHttpClient(httpParams);
		HttpGet httpget = new HttpGet(url);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		
		String responseBody = httpclient.execute(httpget, responseHandler);
		httpclient.getConnectionManager().shutdown();
		
		tmpArrayString = responseBody.split("\n");
		
		for (String index : tmpArrayString){
			tmpString.add(index);
		}
		return tmpString;
	}
	
	public ArrayList<Integer> randomNumberOfBaseTen(int totalNumbers,int minNumber, int maxNumber) throws Exception{
		
		temp = new ArrayList();

		String url = "http://www.random.org/integers/?num="+Integer.toString(totalNumbers)+"&min="+Integer.toString(minNumber)+"&max="+Integer.toString(maxNumber)+"&col=1&base=10&format=plain&rnd=new";

		tmpString = this.httpGetRequest(url);
		
		for (String index : tmpString){
			temp.add(Integer.parseInt(index));
		}		
		return temp;
	}
}