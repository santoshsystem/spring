package me.conf;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MultiReadRequest extends HttpServletRequestWrapper {

	String _body;
	
	public MultiReadRequest(HttpServletRequest request) throws IOException {
		super(request);
		_body = "";
		 BufferedReader bufferedReader = request.getReader();
		 String line;
		 while ((line = bufferedReader.readLine()) != null){
		 _body += line;	
		 }
	} 
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		//return super.getInputStream();
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(_body.getBytes());
		 return new ServletInputStream() {
		 public int read() throws IOException {
		 return byteArrayInputStream.read();
		 }

		@Override
		public boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setReadListener(ReadListener arg0) {
			// TODO Auto-generated method stub
			
		}
		 };
	}
	
	@Override
	public BufferedReader getReader() throws IOException {
		//return super.getReader();
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}
}
